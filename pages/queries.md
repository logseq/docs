- **What are "Queries"?**
  created_at:: 1609230242742
  updated-at:: 1609247076654
	- Queries are for asking questions from your knowledge base and the outside world (in the coming weeks).
	  updated-at:: 1609231528688
	  created_at:: 1609230243642
	  [:div [:img {:src "https://cdn.logseq.com/%2F5ff0a01d-47d4-487d-b346-4a43ded21ad02020_12_29_photo-1444703686981-a3abbc4d4fe3.jpeg?Expires=4762830816&Signature=h~yT-Tq1VtBtEm09Z78eT5kkEbQGUVG-VBEDuGLgykW8vb~AkZNuoRNmwL-fcHgnG8HdYBhqXeJowN9q3my4UN1bxiJtAXl0dAEjmWAqpbedH9PPdyz2tZXcuPxwdk5wICFLrB~0VWMwV02LFZEKkgPYGhkUU8oakBphifgvTdYPKLQG95FTJh9kg7GhV5ZCc1Q3JrOlLGG2fuUObf1opScwbNbEdsQStO8Ou12AaTPccAmpxAJVuut-jZ9pRvdsa00X962QD9c67BEw1SfhKEcChNIbdp~44ltuRj1Bvc1Bs2ezKupQ1sWFD5BG97UEA7GuOyANjPC331ShW8aHSQ__&Key-Pair-Id=APKAJE5CCD6X7MP6PTEA"}]]
	  [:div.text-sm "By " [:a {:href "https://unsplash.com/photos/oMpAz-DN-9I" :target "_blank"} "Greg Rakozy"]]
- **How to write queries?**
  created_at:: 1609231967174
  updated-at:: 1609251558592
  id:: 5feb30e3-fedc-4c2a-aa03-b44020c21c68
	- There're two kinds of queries:
	  created_at:: 1609237373442
	  updated-at:: 1609244684831
	  1. Simple queries by using `{{query }}`, the format is something like this:
	   #+BEGIN_EXAMPLE
	   {{query Something you're looking for}}
	   #+END_EXAMPLE
	   You can type `/query` to create a simple query.
	  2. [[Advanced Queries]]
- **Query Operators **
  These three operators can be applied around any query filters.
	- **and**
	  created_at:: 1609237410438
	  updated-at:: 1609242191381
	  Examples:
	  #+BEGIN_EXAMPLE
	  (and [[page 1]] [[page 2]])
	  #+END_EXAMPLE
	  
	  #+BEGIN_EXAMPLE
	  (and (task now later done) [[page]])
	  #+END_EXAMPLE
	- **or**
	  created_at:: 1609237412110
	  updated-at:: 1609242378334
	  Examples:
	  #+BEGIN_EXAMPLE
	  (or [[page 1]] [[page 2]])
	  #+END_EXAMPLE
	- **not**
	  created_at:: 1609237413167
	  updated-at:: 1609243244686
	  Examples:
	  #+BEGIN_EXAMPLE
	  (not [[page 1]] [[page 2]])
	  #+END_EXAMPLE
- **Query filters**
  updated-at:: 1609237391135
  id:: 62967225-37d9-46b7-859f-92e0311ab4be
  created-at:: 1609237391135
  Most filters apply to blocks. Some filters only apply to pages.
   The following page-only filters cannot be mixed with block filters: `page`,  `page-property`, `page-tags` and `all-page-tags`.
	- **between**
	  updated-at:: 1609243879053
	  created-at:: 1609237415572
	  The format `(between start end)` will only support blocks on the journal pages.
	  
	  There're several built-in symbols:
	   1. `today|yesterday|tomorrow|now`
	   2. `+|-` number `y|m|w|d|h|min`
	  
	  Examples:
	  #+BEGIN_EXAMPLE
	  (between -7d +7d)
	  (between -2w today)
	  
	  #+END_EXAMPLE
	- **Page**
	  Examples: [[questions]]
	  {{query (page "term/alias")}}
	- **property** [[Block properties]]
	  updated-at:: 1609247365218
	  created-at:: 1609237428110
	  id:: 634f6c68-28b3-46c4-85a3-4d1e951194d8
		- This filter matches against any pages or tags in a property value. For the example `type:: [[book]]`, `(property type book)` would match. For the example `description:: I liked this #book and #movie`, `(property description book)` or `(property description movie)` would match. However, `(property description liked)` would not match as "liked" is not a page or tag.
		- Example:
			- {{query (property type book)}}
	- **Full-text query**
	  #+BEGIN_NOTE
	  It's only enabled on the desktop app at the moment.
	  #+END_NOTE
	  Examples:
	  #+BEGIN_QUERY
	  {:title "Query: \"alias\""
	  :query "alias"
	  :collapsed? true}
	  #+END_QUERY
	- **task** (used to be `todo`)
	  created_at:: 1609237429937
	  updated-at:: 1609242962513
	  Examples:
	  #+BEGIN_EXAMPLE
	  (task now)
	  (task now later)
	  #+END_EXAMPLE
	- **priority**
	  created_at:: 1609237434982
	  updated-at:: 1609242958502
	  Examples:
	  #+BEGIN_EXAMPLE
	  (priority a)
	  (priority a b c)
	  #+END_EXAMPLE
	- **page-property**
	  created_at:: 1609237443550
	  updated-at:: 1609243687213
	  Example:
	  {{query (page-property related "Block embed")}}
	- **page-tags**
	  created_at:: 1609237445606
	  updated-at:: 1609243746666
	  Example:
	  {{query (page-tags embed)}}
	- **all-page-tags**
	  created_at:: 1609237447926
	  updated-at:: 1609243762970
	  Example:
	  {{query (all-page-tags)}}
	- **sort-by**
	  updated-at:: 1609243222016
	  created-at:: 1609237456009
	  This filter provides a default sort for a block or page. Note that `created-at` and `updated-at` only work for pages.
	  
	  Format: `(sort-by property-name order)` or `(sort-by property-name)`
	  `key`: Can be any user property as well as built-in properties `created-at`  and `updated-at`.
	  `order`: `desc` or `asc`, omit means `desc`.
	  #+BEGIN_EXAMPLE
	  (and (task now later) (sort-by created-at desc))
	  #+END_EXAMPLE
- **More query examples**
  created-at:: 1609232210837
  updated-at:: 1609243310412
	- 1. Find the blocks containing page "tag1"
	  created-at:: 1609232870139
	  updated-at:: 1609233755992
	  #+BEGIN_EXAMPLE
	  {{query [[tag1]]}}
	  #+END_EXAMPLE
	  {{query [[tag1]]}}
	- 2. Find the blocks containing both `tag1` and `tag2`
	  created-at:: 1609233702047
	  updated-at:: 1609233790865
	  #+BEGIN_EXAMPLE
	  {{query (and [[tag1]] [[tag2]])}}
	  #+END_EXAMPLE
	  {{query (and [[tag1]] [[tag2]])}}
	- 3. Find the blocks containing either `tag1` or `tag2`
	  created-at:: 1609233864422
	  updated-at:: 1609233864422
	  #+BEGIN_EXAMPLE
	  {{query (or [[tag1]] [[tag2]])}}
	  #+END_EXAMPLE
	  {{query (or [[tag1]] [[tag2]])}}
	- 4. Find the blocks containing `tag2` but not `tag1`
	  created-at:: 1609234732407
	  updated-at:: 1609236840152
	  {{query (and [[tag2]] (not [[tag1]]))}}
	- 5. Find journal blocks created between [[Dec 5th, 2020]] to [[Dec 7th, 2020]]
	  created-at:: 1609242222695
	  updated-at:: 1609242323029
	  {{query (between [[Dec 5th, 2020]] [[Dec 7th, 2020]] )}}