(ns write-rdf
  "This script converts a subset of a Logseq graph to an rdf file using
https://github.com/rdfjs/N3.js. This script is configurable via `graph-config`
and by default will print a turtle file (.ttl) to the console. By default,
the subset of a graph that is exported to rdf are:
- class pages with properties 'type:: [[Class]]'
- property pages with properties 'type:: [[Property]]'
- class instance pages with properties 'type:: [[X]]' where X are pages with
  'type:: [[Class]]'

All of the above pages can be customized with query config options."
  (:require ["n3" :refer [DataFactory Writer]]
            ["fs" :as fs]
            [clojure.string :as string]
            [datascript.core :as d]
            [logseq.db.rules :as rules]
            [logseq.bb-tasks.nbb.cached-db :as cached-db]
            [nbb.core :as nbb]))

(def graph-config
  "Graph-specific config to define behaviors for this script"
  {;; Required: Base url for all pages in the graph
   :base-url
   "https://docs.logseq.com/#/page/"
   ;; Optional: Rdf format to write to. Defaults to turtle.
   ;; Other possible values - n-triples, n-quads, trig
   :format "turtle"
   ;; Optional: Shortens urls in turtle output
   :prefixes
   {:d "https://docs.logseq.com/#/page/"
    :s "https://schema.org/"}
   ;; Optional: Property used to look up urls of property pages. Defaults
   ;; to :url. For example, in order to resolve the description property,
   ;; the description page has a url property with its full url.
   :url-property :url

   ;; The rest of the config determines what pages in your graph are included in
   ;; the output. All triples/properties of a page are included.
   ;; These config keys are all optional as they have useful defaults.
   ;;
   ;; Optional: Useful to add individual pages pages e.g. class and property pages
   :additional-pages #{"Class" "Property"}
   ;; Optional: Query to fetch all pages that are classes
   ;; Defaults to pages with "type:: [[Class]]"
   :class-query
   '[:find (pull ?b [*])
     :in $ %
     :where
     (page-property ?b :type "Class")]
   ;; Optional: Query to fetch all pages that are properties.
   ;; Defaults to pages with "type:: [[Property]]"
   :property-query
   '[:find (pull ?b [*])
     :in $ %
     :where
     (page-property ?b :type "Property")]
   ;; Optional:: Query to fetch all pages that are instances of classes.
   ;; Defaults to pages with "type:: [[X]]" where X are pages with
   ;; "type:: [[Class]]"
   :class-instances-query
   '[:find (pull ?b2 [*])
     :in $ %
     :where
     (page-property ?b :type "Class")
     [?b :block/original-name ?n]
     (page-property ?b2 :type ?n)]})

(defn- propertify
  [result]
  (map #(-> (:block/properties %)
            (dissoc :title)
            (assoc :block/original-name
                   (or (get-in % [:block/properties :title]) (:block/original-name %))))
       result))

(defn- page-url [page-name config]
  (str (:base-url config) (js/encodeURIComponent page-name)))

(defn- triplify
  "Turns an entity map into a coll of triples"
  [m {:keys [url-property] :as config} property-map]
  (mapcat
   (fn [prop]
     (map #(vector (page-url (:block/original-name m) config)
                   (or (url-property (get property-map prop))
                       (page-url (name prop) config))
                   %)
          (let [v (m prop)]
            ;; If a collection, they are refs/pages
            (if (coll? v) (map #(page-url % config) v) [v]))))
   (keys m)))

(defn- add-classes [db config property-map]
  (->> (d/q (:class-query config)
            db
            (vals rules/query-dsl-rules))
       (map first)
       propertify
       (mapcat #(triplify % config property-map))))

(defn- add-properties [properties config property-map]
  (->> properties
       (mapcat #(triplify % config property-map))))

(defn- add-additional-pages [db config property-map]
  (->> (d/q '[:find (pull ?b [*])
              :in $ ?names %
              :where
              [?b :block/name ?n]
              [(contains? ?names ?n)]]
            db
            (set (map string/lower-case (:additional-pages config)))
            (vals rules/query-dsl-rules))
       (map first)
       propertify
       (mapcat #(triplify % config property-map))))

(defn- add-class-instances [db config property-map]
  (->> (d/q (:class-instances-query config)
            db
            (vals rules/query-dsl-rules))
       (map first)
       propertify
       (mapcat #(triplify % config property-map))))

(defn- create-quads [_writer db config]
  (let [properties (->> (d/q (:property-query config)
                             db
                             (vals rules/query-dsl-rules))
                        (map first)
                        propertify)
        built-in-properties {:block/original-name {:url "https://schema.org/name"}
                             :alias {:url "https://schema.org/sameAs"}}
        property-map (into built-in-properties
                           (map (juxt (comp keyword :block/original-name) identity)
                                properties))]

    (concat
     (add-additional-pages db config property-map)
     (add-classes db config property-map)
     (add-properties properties config property-map)
     (add-class-instances db config property-map))))

(defn- add-quads [writer quads]
  (doseq [[q1 q2 q3]
          (map (fn [q]
                 (map #(if (and (string? %) (string/starts-with? % "http"))
                         (.namedNode DataFactory %)
                         (.literal DataFactory (name %)))
                      q))
               quads)]
    (.addQuad writer (.quad DataFactory q1 q2 q3))))

(defn -main [args]
  (let [writer (Writer. (clj->js {:prefixes (:prefixes graph-config)
                                  :format (:format graph-config)}))
        _ (when (not= 1 (count args))
            (println "Usage: $0 FILE")
            (js/process.exit 1))
        db (cached-db/read-db)
        [file] args]
    (add-quads writer (create-quads writer db graph-config))
    (.end writer (fn [_err result]
                   (println "Writing file" file)
                   (fs/writeFileSync file result)))))

(when (= nbb/*file* (:file (meta #'-main)))
  (-main *command-line-args*))
