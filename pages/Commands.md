type:: [[Feature]]
platforms:: [[All Platforms]] except [[Publish Web]] 
description:: Functionality that can be invoked from any block

- ## Usage
	- Type `/` to kick off #autocompletion and see a list of commands.
- ## Functionality
	- Typing `/` only starts autocompletion when at the start of a new line or after whitespace.
	- query-table:: true
	  query-properties:: [:name :page :description]
	  query-sort-by:: page
	  query-sort-desc:: false
	  #+BEGIN_QUERY
	  {:query (property :type [[Command]])
	  :result-transform (fn [res] (map (fn [m] (assoc-in m [:block/properties :name] (get-in m [:block/page :block/original-name]))) res))
	  :title "List of documented commands"}
	  #+END_QUERY