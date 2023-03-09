(ns schema
  "Enforce schema constraints on page types"
  (:require [clojure.test :refer [deftest is]]
            [logseq.graph-validator.state :as state]
            [logseq.db.rules :as rules]
            [datascript.core :as d]))

(defn- get-property-names-for-type [type']
  (->> (d/q '[:find (pull ?b [:block/properties])
              :in $ ?type %
              :where (page-property ?b :type ?type)]
            @state/db-conn
            type'
            (vals rules/query-dsl-rules))
       (map (comp :block/properties first))
       (mapcat keys)
       set
       ;; Remove built ins
       ((fn [x] (apply disj x [:id :title :alias :tags :type])))))

(defn- get-properties-for-type [type']
  (->> (d/q '[:find (pull ?b [:block/properties])
              :in $ ?type %
              :where (page-property ?b :type ?type)]
            @state/db-conn
            type'
            (vals rules/query-dsl-rules))
       (map (comp :block/properties first))))

(deftest feature-schema
  (is (= #{:platforms :description :initial-version}
         (get-property-names-for-type "Feature"))
      "Features should only have theses properties")

  (let [props (get-properties-for-type "Feature")]
    (is (empty? (remove :platforms props))
        "All features should have a :platforms property")))
