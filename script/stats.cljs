(ns stats
  "Print some basic stats"
  (:require [logseq.db.rules :as rules]
            [datascript.core :as d]
            [nbb.core :as nbb]
            [clojure.pprint :as pprint]
            [babashka.cli :as cli]
            [logseq.bb-tasks.nbb.cached-db :as cached-db]))

(defn- run-data-query [db query]
  (let [post-transduce (map first)
        res (d/q (into query [:in '$ '%]) db (vals rules/query-dsl-rules))]
    (into [] post-transduce res)))

(defn -main
  [args]
  (let [options (cli/parse-opts args)
        db (cached-db/read-db)
        res (->>
             (run-data-query db
                             '[:find (pull ?b [*])
                               :where
                               (page-property ?b :type "Feature")])
             (map #(-> (:block/properties %)
                       (assoc :name (:block/original-name %))
                       (dissoc :type))))]
    (if (:expand options)
      (pprint/pprint res)
      (pprint/print-table [:name :platform] res))))

(when (= nbb/*file* (:file (meta #'-main)))
  (-main *command-line-args*))
