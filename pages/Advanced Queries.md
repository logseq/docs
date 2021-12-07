- The database that Logseq use is [Datascript](https://github.com/tonsky/datascript), which is an immutable in-memory database and [Datalog](https://en.wikipedia.org/wiki/Datalog) query engine in Clojure and ClojureScript.
- Logseq's database schema:
  https://github.com/logseq/logseq/blob/master/src/main/frontend/db_schema.cljs
- Please check _Learn Datalog Today_ [^1] and _Datomic query syntax_ [^2] first if you're not familiar with Datalog.
- **Some tips**
  created_at:: 1609244703085
  updated-at:: 1609244703085
  #+BEGIN_TIP
  1. Page names are stored as lower case in the database.
  #+END_TIP
- The query format is something like this:
  created_at:: 1609244764756
  updated-at:: 1609246099894
  #+BEGIN_EXAMPLE
  {:title  [:h2 "Your query title"]
   :query  [:find (pull ?b [*])
          :where ...]
   :inputs [...]
   :view             (fn [query-result] [:div ...])
   :result-transform (fn [query-result] ...)
   :collapsed? true}
  #+END_EXAMPLE

  | Name             | Description                      | Default | Optional |
  |------------------|----------------------------------|---------|----------|
  | title            | query title, supports hiccup     |         | true     |
  | query            | datascript query                 |         | false    |
  | inputs           | query inputs                     |         | true     |
  | view             | (fn [query-result] hiccup)       |         | true     |
  | collapsed?       | Whether to collapse the result   | false   | true     |
  | result-transform | (fn [query-result] do something) |         | true     |
- **Examples**
    - 1. Get all tasks
      created_at:: 1609232063516
      updated-at:: 1609245970090

      #+BEGIN_SRC clojure
      #+BEGIN_QUERY
      {:title "All tasks"
       :query [:find (pull ?b [*])
             :where
             [?b :block/marker ?m]
             [(not= ?m "nil")]]}
      #+END_QUERY
      #+END_SRC
    - 2. Get all tasks with a tag "project"
      #+BEGIN_SRC clojure
      #+BEGIN_QUERY
      {:title "All todos with tag project"
       :query [:find (pull ?b [*])
             :where
             [?p :block/name "project"]
             [?b :block/ref-pages ?p]]}
      #+END_QUERY
      #+END_SRC
    - 3. Blocks in 7ds with a page reference of datalog
      #+BEGIN_SRC clojure

      #+BEGIN_QUERY
      {:title "Blocks in 7ds with a page reference of datalog"
       :query [:find (pull ?b [*])
             :in $ ?start ?today ?tag
             :where
             [?b :block/page ?p]
             [?p :page/journal-day ?d]
             [(>= ?d ?start)]
             [(<= ?d ?today)]
             [?b :block/ref-pages ?rp]
             [?rp :block/name ?tag]]
       :inputs [:7d-before :today "datalog"]}
      #+END_QUERY
      #+END_SRC
    - 4. All TODOs
      #+BEGIN_SRC clojure
      #+BEGIN_QUERY
      {:title "TODO"
       :query [:find (pull ?b [*])
             :where
             [?b :block/marker ?marker]
             [(= "TODO" ?marker)]]}
      #+END_QUERY
      #+END_SRC
    - 5. All the tags specified in the front matter (tags: tag1, tag2)
      #+BEGIN_SRC clojure
      #+BEGIN_QUERY
      {:title "All page tags"
      :query [:find ?tag-name
            :where
            [?tag :block/name ?tag-name]]
      :view (fn [tags]
            [:div
             (for [tag (flatten tags)]
               [:a.tag.mr-1 {:href (str "/page/" tag)}
                (str "#" tag)])])}
      #+END_QUERY
      #+END_SRC
    - 6. All pages have a "programming" tag
      #+BEGIN_SRC clojure
      #+BEGIN_QUERY
      {:title "All pages have a *programming* tag"
       :query [:find ?name
             :in $ ?tag
             :where
             [?t :block/name ?tag]
             [?p :page/tags ?t]
             [?p :block/name ?name]]
       :inputs ["programming"]
       :view (fn [result]
             [:div.flex.flex-col
              (for [page result]
                [:a {:href (str "/page/" page)} (clojure.string/capitalize page)])])}
      #+END_QUERY
      #+END_SRC
    - 7. Get all the blocks with the property "type" and the value "programming_lang"
      #+BEGIN_SRC clojure

      #+BEGIN_QUERY
      {:title [:h2 "Programming languages list"]
       :query [:find (pull ?b [*])
             :where
             [?b :block/properties ?p]
             [(get ?p :type) ?t]
             [(= "programming_lang" ?t)]]
       }
      #+END_QUERY
      #+END_SRC
    - 8. All todos tagged using current page
      #+BEGIN_SRC clojure

      #+BEGIN_QUERY
      {:title "All todos tagged using current page"
       :query [:find (pull ?b [*])
             :in $ ?current-page
             :where
             [?p :block/name ?current-page]
             [?b :block/marker ?marker]
             [?b :block/ref-pages ?p]
             [(= "TODO" ?marker)]]
       :inputs [:current-page]}
      #+END_QUERY
      #+END_SRC
    - 9. Tasks made active in the last 2 weeks
      #+BEGIN_SRC clojure

      #+BEGIN_QUERY
      {:title "🟢 ACTIVE"
        :query [:find (pull ?h [*])
                :in $ ?start ?today
                :where
                [?h :block/marker ?marker]
                [?h :block/page ?p]
                [?p :page/journal? true]
                [?p :page/journal-day ?d]
                [(>= ?d ?start)]
                [(<= ?d ?today)]
                [(contains? #{"NOW" "DOING"} ?marker)]]
        :inputs [:14d :today]
        :result-transform (fn [result]
                            (sort-by (fn [h]
                                       (get h :block/priority "Z")) result))
        :collapsed? false}
      #+END_QUERY
      #+END_SRC
    - 10. Tasks referencing due dates in the past
      #+BEGIN_SRC clojure

      #+BEGIN_QUERY
       {:title "⚠️ OVERDUE"
        :query [:find (pull ?h [*])
                :in $ ?start ?today
                :where
                [?h :block/marker ?marker]
                [?h :block/ref-pages ?p]
                [?p :page/journal? true]
                [?p :page/journal-day ?d]
                [(>= ?d ?start)]
                [(<= ?d ?today)]
                [(contains? #{"NOW" "LATER" "TODO" "DOING"} ?marker)]]
        :inputs [:56d :today]
        :collapsed? false}
      #+END_QUERY
      #+END_SRC
    - 11. Tasks referencing due dates up to 10 days ahead
      #+BEGIN_SRC clojure

      #+BEGIN_QUERY
          {:title "📅 NEXT"
        :query [:find (pull ?h [*])
                :in $ ?start ?next
                :where
                [?h :block/marker ?marker]
                [?h :block/ref-pages ?p]
                [?p :page/journal? true]
                [?p :page/journal-day ?d]
                [(> ?d ?start)]
                [(< ?d ?next)]
                [(contains? #{"NOW" "LATER" "DOING" "TODO"} ?marker)]]
        :inputs [:today :10d-after]
        :collapsed? false}
      #+END_QUERY
      #+END_SRC
    - 12. Tasks from last week which are still outstanding (may slip soon!)
      #+BEGIN_SRC clojure

      #+BEGIN_QUERY
         {:title "🟠 SLIPPING"
        :query [:find (pull ?h [*])
                :in $ ?start ?today
                :where
                [?h :block/marker ?marker]
                [?h :block/page ?p]
                [?p :page/journal? true]
                [?p :page/journal-day ?d]
                [(>= ?d ?start)]
                [(<= ?d ?today)]
                [(contains? #{"NOW" "LATER" "TODO" "DOING"} ?marker)]]
        :inputs [:7d :today]
        :result-transform (fn [result]
                            (sort-by (fn [h]
                                       (get h :block/created-at)) result))
        :collapsed? true}
      #+END_QUERY
      #+END_SRC
    - 13. Tasks created more than 1 week ago, less old than 2 months but still outstanding
      #+BEGIN_SRC clojure

      #+BEGIN_QUERY
      {:title "🔴 STALLED"
        :query [:find (pull ?h [*])
                :in $ ?start ?today
                :where
                [?h :block/marker ?marker]
                [?h :block/page ?p]
                [?p :page/journal? true]
                [?p :page/journal-day ?d]
                [(>= ?d ?start)]
                [(<= ?d ?today)]
                [(contains? #{"NOW" "LATER" "TODO" "DOING"} ?marker)]]
        :inputs [:56d :8d]
        :result-transform (fn [result]
                            (sort-by (fn [h]
                                       (get h :block/created-at)) result))
        :collapsed? true}
       ]}
      #+END_QUERY
      #+END_SRC
    - 14. Next 7 days' deadline or schedule
       ((60531c23-238e-4748-9b19-27088f9c3771))
      #+BEGIN_SRC clojure
      #+BEGIN_QUERY
      {:title "next 7 days' deadline or schedule"
        :query [:find (pull ?block [*])
                :in $ ?start ?next
                :where
                (or
                  [?block :block/scheduled ?d]
                  [?block :block/deadline ?d])
                [(> ?d ?start)]
                [(< ?d ?next)]]
        :inputs [:today :7d-after]
        :collapsed? false}
      #+END_QUERY
      #+END_SRC
- **Resources**
    - [^1]: [Learn Datalog Today](http://www.learndatalogtoday.org/)  is an interactive tutorial designed to teach you the Datomic dialect of Datalog.
    - [^2]: [[https://docs.datomic.com/query.html][Datomic query documentation]]
