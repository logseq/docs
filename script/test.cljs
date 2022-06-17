(ns test
  (:require [clojure.test :as t :refer [deftest is use-fixtures]]
            [datascript.core :as d]
            [logseq.graph-parser.cli :as gp-cli]
            [logseq.graph-parser.text :as gp-text]
            [logseq.db.rules :as rules]
            [clojure.set :as set]))

(def db-conn (atom nil))
(def all-asts (atom nil))

(defn- setup-graph [f]
  (let [{:keys [conn asts]} (gp-cli/parse-graph ".." {:verbose false :ast true})]
    (reset! db-conn conn)
    (reset! all-asts (mapcat :ast asts)))
  (f))

(use-fixtures :once setup-graph)

(defn- extract-subnodes-by-pred [pred node]
  (cond
    (= "Heading" (ffirst node))
    (filter pred (-> node first second :title))

    ;; E.g. for subnodes buried in Paragraph
    (vector? (-> node first second))
    (filter pred (-> node first second))))

(defn- ast->block-refs [ast]
  (->> ast
       (mapcat (partial extract-subnodes-by-pred
                        #(and (= "Link" (first %))
                              (= "Block_ref" (-> % second :url first)))))
       (map #(-> % second :url second))))

(defn- ast->embed-refs [ast]
  (->> ast
       (mapcat (partial extract-subnodes-by-pred
                        #(and (= "Macro" (first %))
                              (= "embed" (:name (second %)))
                              (gp-text/get-block-ref (str (first (:arguments (second %))))))))
       (map #(-> % second :arguments first gp-text/get-block-ref))))

(deftest no-invalid-block-refs
  (let [block-refs (ast->block-refs @all-asts)]
    (println "Found" (count block-refs) "block refs")
    (is (seq block-refs) "There must be some block-refs to test")
    (is (empty?
         (set/difference
          (set block-refs)
          (->> (d/q '[:find (pull ?b [:block/properties])
                      :in $ %
                      :where (has-property ?b :id)]
                    @@db-conn
                    (vals rules/query-dsl-rules))
               (map first)
               (map (comp :id :block/properties))
               set))))))

(deftest no-invalid-embed-refs
  (let [embed-refs (ast->embed-refs @all-asts)]
    (println "Found" (count embed-refs) "embed block refs")
    (is (seq embed-refs) "There must be some embed-refs to test")
    (is (empty?
         (set/difference
          (set embed-refs)
          (->> (d/q '[:find (pull ?b [:block/properties])
                      :in $ %
                      :where (has-property ?b :id)]
                    @@db-conn
                    (vals rules/query-dsl-rules))
               (map first)
               (map (comp :id :block/properties))
               set))))))

;; run this function with: nbb-logseq -m test/run-tests
(defn run-tests []
  (t/run-tests 'test))
