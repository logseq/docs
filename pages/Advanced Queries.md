type:: [[Feature]]
platforms:: [[All Platforms]]
description:: Advanced queries are written with [Datalog](https://en.wikipedia.org/wiki/Datalog) and query the [Datascript](https://github.com/tonsky/datascript) database.

- ## Intro
	- #+BEGIN_NOTE
	  [[Learn Datalog Today]] is a great first reference if you're not familiar with Datalog.
	   If this is your first time looking at an advanced query, first skim our [beginner user resources](((63bc6201-53b1-47a4-834f-83934b69ad49))). Several resources are listed so look ones for that fit your learning style.
	  #+END_NOTE
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
	   :group-by-page? true
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
	  |group-by-page? | whether to group results by page (only applies in list view) | true | true|
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
	  These are special values for a query's `:inputs` key above:
		- #### Special page and block inputs
			- `:current-page` - Sanitized, lower case name of current page the user is in. See [this example](((63b70dc8-58a5-4a43-ae19-28143edb7752)))
			- `:query-page` - Sanitized, lower case name of page that query is in. This is useful when a query is to be displayed in an embedded page and the user doesn't want the query to change pages.
			- `:current-block` - `:db/id` of current block. See [this example](((63bc5e11-24f1-45fd-945d-4a272e5ecf0d)))
			- `:parent-block` - `:db/id` of parent block
		- #### Special date inputs
		  description:: Useful for querying journal pages or blocks relative to today's date
			- `:today` - Today's date. See [this example](((63b70dc8-1d59-4348-9737-e62b17fdabca)))
			- `:yesterday` - Yesterday's date
			- `:tomorrow` - Tomorrow's date
			- `:right-now-ms` - Timestamp for current time
		- #### Relative date inputs
		  description:: Useful for querying journal pages or blocks relative to a specific date
			- Relative date queries are created by combining 3 pieces: a direction (`+` or `-`), and amount (any number `X`), and a unit (`d` for days, `w` for weeks, `m` for months, and `y` for years). *(examples within)*
			  collapsed:: true
				- `:+200d` - 200 days in the future
				- `:-11w` - 11 weeks in the past
				- `:+1m` - 1 month in the future
				- `:-2y` - 2 years in the past
			- `:-Xd` - Date for X number of days before today's date
			- `:-Xw` - Date for X number of weeks before today's date
			- `:-Xm` - Date for X number of months before today's date
			- `:-Xy` - Date for X number of years before today's date
			- `:+Xd` - Date for X number of days after today
			- `:+Xw` - Date for X number of weeks after today
			- `:+Xm` - Date for X number of months after today
			- `:+Xy` - Date for X number of years after today
		- #### Relative timestamp inputs
		  description:: Useful for querying for block attributes that use millisecond timestamps e.g. `:block/created-at`
			- Relative timestamp inputs can be created by adding a **time suffix** to any of the relative date inputs. Multiple **time suffixes** cannot be combined.  The **time suffixes** that are supported are as follows:
				- `-start` - returns the start of the day you are querying for, returning the timestamp for 00:00:00.000.  *(examples within)*
				  collapsed:: true
					- `:+1d-start` will result in the millisecond timestamp for midnight tonight, at 00:00:00.000
					- `:-1d-start` will result in the millisecond timestamp for midnight the night before yesterday, at 00:00:00.000
					- This is functionally equivalent to the **time suffixes** `-00`, `-0000`, `-000000`, and `-000000000`
				- `-end` - returns the end of the day you are querying for, returning the timestamp for 23:59:59:999.  *(examples within)*
				  collapsed:: true
					- `:+1d-end` will result in the millisecond timestamp just before midnight tomorrow night, at 23:59:59.999
					- `:-1d-end` will result in the millisecond timestamp just before midnight last night, at 23:59:59.999
					- This is functionally equivalent to the **time suffix** `-235959999`
				- `-HH` - Specific hour of the day you are querying, in 24 hour time. *(examples within)*
				  collapsed:: true
					- `:+1d-14` will result in the millisecond timestamp for tomorrow, at 2:00:00.000 pm
					- `:-2w-00` will result in the millisecond timestamp 14 days ago, at 00:00:00.000 am
					- `:+1m-23` will result in the millisecond timestamp one month from today, at 11:00:00.000 pm
				- `-HHMM` - Specific hour and minute of the day you are querying, in 24 hour time.  *(examples within)*
				  collapsed:: true
					- `:+1d-1430` will result in the millisecond timestamp for tomorrow, at 2:30:00.000 pm
					- `:-2w-0000` will result in the millisecond timestamp 14 days ago, at 00:00:00.000 am
					- `:+1m-2359` will result in the millisecond timestamp one month from today, at 11:59:00.000 pm
				- `-HHMMSS` - Specific hour, minute, and seconds of the day you are querying for, in 24 hour time.  *(examples within)*
				  collapsed:: true
					- `:+1d-143015` will result in the millisecond timestamp for tomorrow, at 2:30:15.000 pm
					- `:-2w-000000` will result in the millisecond timestamp 14 days ago, at 00:00:00.000 am
					- `:+1m-235959` will result in the millisecond timestamp one month from today, at 11:59:59.000 pm
				- `-HHMMSSmmm` - Specific hour, minute, seconds, and milliseconds of the day you are querying for, in 24 hour time.  *(examples within)*
				  collapsed:: true
					- `:+1d-143015777` will result in the millisecond timestamp for tomorrow, at 2:30:15.777 pm
					- `:-2w-000000000` will result in the millisecond timestamp 14 days ago, at 00:00:00.000 am
					- `:+1m-235959999` will result in the millisecond timestamp one month from today, at 11:59:59.999 pm
				- `-ms` - when querying for dates in the past, it will return the timestamp 00:00:00.000, and when querying for dates in the future, will return the timestamp for 23:59:59.999.  *(examples within)*
				  collapsed:: true
					- `:-1d-ms` will return the timestamp for midnight the night before yesterday, at 00:00:00.000.
						- Functionally equivalent to `:-1d-start`
					- `:+1d-ms` will return the timestamp just before midnight tomorrow night, at 23:59:59.999.
						- Functionallty equivalent to `:+1d-end`
					-
			- It should be noted that most **time suffixes** (all besides `-ms`) can be used in combination with the `:today` special date. *(examples within)*
			  collapsed:: true
				- `:today-start` - returns a timestamp for 00:00:00.000 today
				- `:today-end` - returns a timestamp for 23:59:59.000 today
				- `:today-HH` - returns a timestamp for HH:00:00.000 today
				- `:today-HHMM` - returns a timestamp for HH:MM:00.000 today
				- `:today-HHMMSS` - returns a timestamp for HH:MM:SS.000 today
				- `:today-HHMMSSmmm` - returns a timestamp for HH:MM:SS.mmm today
		- #### Deprecated inputs
		  collapsed:: true
			- Previously we supported different inputs between basic queries and advanced queries. These have now been unified, however we still support the follow queries for the time being. If you are using any of the following, plus upgrade them to the newer syntax mentioned for each item
			- `:Xd` - Date for X number of days before today. **New syntax:** `:-Xd`
			- `:Xd-before` - Date for X number of days before today. See [this example](((63b70dc8-1d59-4348-9737-e62b17fdabca))). **New syntax:** `:-Xd`
			- `:Xd-after` - Date for X number of days after today. **New syntax:** `:+Xd`
			- `:Xd-before-ms` - Timestamp of X days before today. **New syntax:** `:-Xd-ms`
			- `:Xd-after-ms` - Timestamp of X days after today. **New syntax** `:+Xd-ms`
			- `:start-of-today-ms` - Timestamp for beginning of today. **New syntax** `:today-start`
			- `:end-of-today-ms` - Timestamp for end of today. **New syntax** `:today-end`
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
	   :inputs [:-7d :today "datalog"]}
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
	    :inputs [:-2w :today]
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
	    :inputs [:-56d :today]
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
	    :inputs [:today :+10d]
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
	    :inputs [:-7d :today]
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
	    :inputs [:-2m :-1w]
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
	    :inputs [:today :+7d]
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
	- id:: 63bc5e11-24f1-45fd-945d-4a272e5ecf0d
	  18. Query that uses :current-block input
	  #+BEGIN_SRC clojure
	  #+BEGIN_QUERY
	  {:title "Get children blocks of current query block"
	   :inputs [:current-block]
	   :query  [:find (pull ?b [*])
	            :in $ ?current-block
	            :where [?b :block/parent ?current-block]]}
	  #+END_QUERY
	  #+END_SRC
	- 19. Aggregate query
	  #+BEGIN_SRC clojure
	  #+BEGIN_QUERY
	  {:title "Count number of blocks in the current page"
	   :query [:find (count ?b)
	           :in $ ?current-page
	           :where
	           [?p :block/name ?current-page]
	           [?b :block/page ?p]]
	   :inputs [:current-page]}
	  #+END_QUERY
	  #+END_SRC
- ## Additional Links
	- For beginner users
	  id:: 63bc6201-53b1-47a4-834f-83934b69ad49
		- https://qwxlea.github.io/#/page/datalog%2Fintro%20to%20datalog - Beginner friendly intro to datalog
		- [[Learn Datalog Today]] - User-friendly, interactive datalog tutorial
		- https://mschmidtkorth.github.io/logseq-msk-docs/#/page/queries%2Fadvanced%20queries%2Ftutorial - Advanced query line by line explanations
		- https://max-datom.com/ - fun, interactive datalog tutorial
		- https://bgrolleman.gitlab.io/logseq_publish_toolsontech/#/page/logseq%2Fadvanced%20queries - Some useful tips on advanced queries
		- https://mschmidtkorth.github.io/logseq-msk-docs/#/page/queries%2Fadvanced%20queries - More useful tips on advanced queries
	- For advanced users a.k.a. engineers
		- https://siferiax.github.io/#/page/logseq%2Fadvanced%20queries - Query references for more advanced concepts
		- [Datomic query documentation](https://docs.datomic.com/query.html) - Thorough reference for datomic dialect of Datalog. Explains most datalog concepts well
		- https://nextjournal.com/try/learn-xtdb-datalog-today/learn-xtdb-datalog-today - Interactive datalog tutorial for engineers
		- [Datascript's intro docs](https://github.com/tonsky/datascript/wiki/Getting-started)
		- [Logseq's database schema](https://github.com/logseq/logseq/blob/master/deps/db/src/logseq/db/schema.cljs)
