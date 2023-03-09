(ns query
  "Some docs specific queries"
  (:require [logseq.db.rules :as rules]
            [datascript.core :as d]
            [nbb.core :as nbb]
            [clojure.pprint :as pprint]
            [clojure.set :as set]
            [clojure.string :as string]
            [babashka.cli :as cli]
            [goog.string :as gstring]
            [logseq.graph-parser.util.db :as db-util]
            [logseq.graph-parser.property :as gp-property]
            [logseq.bb-tasks.nbb.cached-db :as cached-db]))

(defn- run-data-query [db {:keys [query result-transform inputs] :as options}]
  (let [post-transduce (map first)
        has-inputs? (and (contains? (set query) :in) inputs)
        res (apply d/q
              (if has-inputs? query (into query [:in '$ '%]))
              db
              (cond-> [(vals rules/query-dsl-rules)]
                      has-inputs?
                      (into (map #(db-util/resolve-input db % {}) inputs))))]
    (cond->> (into [] post-transduce res)
             result-transform
             ((fn [x] (eval (list result-transform x))))
             (:sort-by options)
             (sort-by (:sort-by options)))))

(defn- propertify
  [result]
  (map #(-> (:block/properties %)
            (assoc :name (:block/original-name %))
            (dissoc :type))
       result))

 (defn print-table
   [rows & {:keys [fields]}]
   (if fields (pprint/print-table fields rows) (pprint/print-table rows))
   (println "Total:" (count rows)))

(def queries
  {:features
   {:query '[:find (pull ?b [*])
             :where
             (page-property ?b :type "Feature")]
    :columns [:name :platforms]
    :sort-by :name
    :result-transform propertify}
   :ui-elements
   {:query '[:find (pull ?b [*])
             :where
             (page-property ?b :type "UI Element")]
    :columns [:name]
    :sort-by :name
    :result-transform propertify}
   :classes
   {:query '[:find (pull ?b [*])
             :where
             (page-property ?b :type "Class")]
    :columns [:name]
    :result-transform propertify}
   :properties
   {:query '[:find ?p
             :where
             [_ :block/properties ?p]]
    :result-transform (fn [res]
                        (->> (map keys res)
                             (apply concat)
                             set
                             ((fn [x]
                                (set/difference
                                 x
                                 (gp-property/hidden-built-in-properties)
                                 (gp-property/editable-built-in-properties))))
                             ;; remove extended properties that can't be accessed in scripts
                             (remove #(string/starts-with? (name %) "card-"))
                             sort
                             (map #(hash-map :name %))))}
   :recent-pages
   {:query '[:find (pull ?b [*])
             :in $ % ?start ?end
             :where
             [?b :block/name]
             [?b :block/updated-at ?timestamp]
             [(>= ?timestamp ?start)]
             [(<= ?timestamp ?end)]]
    :inputs [:-1w-ms :end-of-today-ms]}
   :tasks
   {:query '[:find (pull ?b [* {:block/page [:block/original-name]}])
             :where
             (task ?b #{"TODO" "DOING"})
             (page-ref ?b "docs")]
    :sort-by :page
    :result-transform (fn [res]
                        (map #(hash-map :task (:block/content %)
                                        :page (get-in % [:block/page :block/original-name])) res))}})

(defn -main
  [args]
  (let [options (cli/parse-opts args)
        db (cached-db/read-db)
        {:keys [columns] :as query-map}
        (or (get queries (keyword (first args)))
            (throw (ex-info (gstring/format "No query '%s' found. Valid queries are %s"
                                            (first args) (vec (keys queries)))
                            {})))
        res (run-data-query db query-map)]
    (if (:expand options)
      (pprint/pprint res)
      (if columns
        (print-table res :fields columns)
        (print-table res)))))

(when (= nbb/*file* (:file (meta #'-main)))
  (-main *command-line-args*))
