description:: Advanced queries are written with [Datalog](https://en.wikipedia.org/wiki/Datalog) and query the [Datascript](https://github.com/tonsky/datascript) database. [[Learn Datalog Today]] is a great first reference if you're not familiar with Datalog.

- ## Advanced Query Shape
	- An advanced query looks like this:
	  updated-at:: 1609246099894
	  created-at:: 1609244764756
	  #+BEGIN_EXAMPLE
	  {:title  [:h2 "Your query title"]
	   :query  [:find (pull ?b [*])
	            :where ...]
	   :inputs [...]
	   :view (fn [query-result] [:div ...]) ;; or :keyword from config.edn
	   :result-transform (fn [query-result] ...) ;; or :keyword from config.edn
	   :collapsed? true
	  :rules [...]}
	  #+END_EXAMPLE
	  
	  | Name             | Description                      | Default | Optional |
	  |------------------|----------------------------------|---------|----------|
	  | title            | query title, supports hiccup     |         | true     |
	  | query            | datascript query or simple query |         | false    |
	  | inputs           | query inputs, can be multiple values                     |         | true     |
	  | view             | fn or keyword      |         | true     |
	  | collapsed?       | whether to collapse the result   | false   | true     |
	  | result-transform | fn or keyword |         | true     |
	  | rules                | list of rules to apply to query | | true |
	- **Query Tips**
	  updated-at:: 1609244703085
	  created-at:: 1609244703085
	  #+BEGIN_TIP
	  1. `?b` and `?p` are special symbols in queries that must be used with blocks and pages.
	  2. Page names are stored as lower case in the database.
	  3. Most simple query operators are available as [rules](https://docs.datomic.com/on-prem/query/query.html#rules) in queries
	  4. Titles can be be hiccups or double-quoted strings. For example, if you want to put custom macros into the query title, you can write something like `"{{poem foo,bar}}"`.
	  #+END_TIP
	- ### Query Inputs
	  These are special values for a query's `:inputs` key above
		- `:today` - today's date for use with rules like `between`. See [example below](((63b70dc8-1d59-4348-9737-e62b17fdabca)))
		- `:yesterday` - yesterday's date
		- `:tomorrow` - tomorrow's date
		- `:Xd-before` - Date for X number of days before today. See [example below](((63b70dc8-1d59-4348-9737-e62b17fdabca)))
		- `:Xd-after` - Date for X number of days after today.
		- `:current-page` - Reference to current page block. See [example below](((63b70dc8-58a5-4a43-ae19-28143edb7752)))
- ## Query Examples
	- 1. Get all tasks
	  created_at:: 1609232063516
	  updated-at:: 1609245970090
	  
	  #+BEGIN_SRC clojure
	  #+BEGIN_QUERY
	  {:title "All tasks"
	   :query [:find (pull ?b [*])
	           :where
	           [?b :block/marker _]]}
	  #+END_QUERY
	  #+END_SRC
	- 2. Get all tasks with a tag "project"
	  #+BEGIN_SRC clojure
	  #+BEGIN_QUERY
	  {:title "All blocks with tag project"
	   :query [:find (pull ?b [*])
	           :where
	           [?p :block/name "project"]
	           [?b :block/refs ?p]]}
	  #+END_QUERY
	  #+END_SRC
	- id:: 63b70dc8-1d59-4348-9737-e62b17fdabca
	  3. Blocks in 7ds with a page reference of datalog
	  #+BEGIN_SRC clojure
	  
	  #+BEGIN_QUERY
	  {:title "Journal blocks in last 7 days with a page reference of datalog"
	   :query [:find (pull ?b [*])
	           :in $ ?start ?today ?tag
	           :where
	           (between ?b ?start ?today)
	           (page-ref ?b ?tag)]
	   :inputs [:7d-before :today "datalog"]}
	  #+END_QUERY
	  #+END_SRC
	- 4. All TODO tasks
	  #+BEGIN_SRC clojure
	  #+BEGIN_QUERY
	  {:title "TODO tasks"
	   :query [:find (pull ?b [*])
	           :where
	           (task ?b #{"TODO"})]}
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
	           [:a.tag.mr-1 {:href (str "#/page/" tag)}
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
	         [?p :block/tags ?t]
	         [?p :block/name ?name]]
	   :inputs ["programming"]
	   :view (fn [result]
	         [:div.flex.flex-col
	          (for [page result]
	            [:a {:href (str "#/page/" page)} (clojure.string/capitalize page)])])}
	  #+END_QUERY
	  #+END_SRC
	- 7. Get all the blocks with the property "type" and the value "programming_lang"
	  #+BEGIN_SRC clojure
	  
	  #+BEGIN_QUERY
	  {:title [:h2 "Programming languages list"]
	   :query [:find (pull ?b [*])
	           :where
	           (property ?b :type "programming_lang")]}
	  #+END_QUERY
	  #+END_SRC
	- id:: 63b70dc8-58a5-4a43-ae19-28143edb7752
	  8. TODO tasks tagged using current page
	  #+BEGIN_SRC clojure
	  
	  #+BEGIN_QUERY
	  {:title "All tasks tagged using current page"
	   :query [:find (pull ?b [*])
	         :in $ ?current-page
	         :where
	         [?p :block/name ?current-page]
	         [?b :block/refs ?p]
	         (task ?b #{"TODO"})]
	   :inputs [:current-page]}
	  #+END_QUERY
	  #+END_SRC
	- 9. Active tasks from the last 2 weeks
	  #+BEGIN_SRC clojure
	  
	  #+BEGIN_QUERY
	  {:title "🟢 ACTIVE"
	    :query [:find (pull ?b [*])
	            :in $ ?start ?today
	            :where
	            (task ?b #{"NOW" "DOING"})
	            (between ?b ?start ?today)]
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
	    :query [:find (pull ?b [*])
	            :in $ ?start ?today
	            :where
	            (task ?b #{"NOW" "LATER" "TODO" "DOING"})
	            (between ?b ?start ?today)]
	    :inputs [:56d :today]
	    :collapsed? false}
	  #+END_QUERY
	  #+END_SRC
	- 11. Tasks referencing due dates up to 10 days ahead
	  #+BEGIN_SRC clojure
	  
	  #+BEGIN_QUERY
	      {:title "📅 NEXT"
	    :query [:find (pull ?b [*])
	            :in $ ?start ?next
	            :where
	            (task ?b #{"NOW" "LATER" "TODO" "DOING"})
	            (between ?b ?start ?next)]
	    :inputs [:today :10d-after]
	    :collapsed? false}
	  #+END_QUERY
	  #+END_SRC
	- 12. Tasks from last week which are still outstanding (may slip soon!)
	  #+BEGIN_SRC clojure
	  
	  #+BEGIN_QUERY
	     {:title "🟠 SLIPPING"
	    :query [:find (pull ?b [*])
	            :in $ ?start ?today
	            :where
	            (task ?b #{"NOW" "LATER" "TODO" "DOING"})
	            (between ?b ?start ?today)]
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
	    :query [:find (pull ?b [*])
	            :in $ ?start ?today
	            :where
	            (task ?b #{"NOW" "LATER" "TODO" "DOING"})
	            (between ?b ?start ?today)]
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
	- 15. Query with rules as input
	  #+BEGIN_SRC clojure
	  #+BEGIN_QUERY
	  {:title "Blocks containing TODO that are not tasks"
	   :query [:find (pull ?b [*])
	           :in $ ?query %
	           :where
	           (block-content ?b ?query)
	           (not-task ?b)]
	           :inputs ["TODO"
	                    [[(not-task ?b)
	                      (not [?b :block/marker _])]]]}
	  #+END_QUERY
	  #+END_SRC
	- 16. Query with rules via :rules
	    ``` clojure
	  #+BEGIN_QUERY
	  {:title "Blocks that start with an https link"
	   :query [:find (pull ?b [*])
	           :in $ %
	           :where (starts-with ?b "https://")]
	   :rules [[(starts-with ?b ?substr)
	           [?b :block/content ?content]
	           [(clojure.string/starts-with? ?content ?substr)]]]}
	  #+END_QUERY
	  ```
	- 17. Query that uses simple query
	  #+BEGIN_SRC clojure
	  #+BEGIN_QUERY
	  {:title "DOING tasks with priority A"
	   :query (and (todo DOING) (priority A))
	   :collapsed? true}
	  #+END_QUERY
	  #+END_SRC
- ## Additional Links
	- https://max-datom.com/ and https://nextjournal.com/try/learn-xtdb-datalog-today/learn-xtdb-datalog-today are two interactive tutorials.
	- [Datomic query documentation](https://docs.datomic.com/query.html) - Thorough reference for datomic dialect of Datalog. Explains most datalog concepts well.
	- [Datascript's intro docs](https://github.com/tonsky/datascript/wiki/Getting-started)
	- [Logseq's database schema](https://github.com/logseq/logseq/blob/master/deps/db/src/logseq/db/schema.cljs)
	- https://bgrolleman.gitlab.io/logseq_publish_toolsontech/#/page/logseq%2Fadvanced%20queries - Some useful tips
	- https://mschmidtkorth.github.io/logseq-msk-docs/#/page/queries%2Fadvanced%20queries - More useful tips