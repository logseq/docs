id:: 60a78c12-4e12-4d81-a33f-9f63695aaf32
type:: term
name:: i'm a page property
alias:: Block properties
click:: click me to edit

- description:
	- a user defined dictionary consists of multiple pairs key and value which is used to annotate a block or a page
	- page property should always be defined frontmatter (aka `first block of the page`)
	- when a property value match some page title, Logseq will automatically create link to that page
- produced by:
	- a page can have many pairs of properties as long as they're in first block of that page
	- each block can also have many pairs of properties (except for those first block, which will be served as page properties)
	- Markdown:
	  {{embed ((60ab6f5b-4bdc-4ef0-a0f8-6cad9dcad2b2))}}
	- org-mode:
	  {{embed ((60ab7357-2744-42bc-a8fd-a9c8db3051df))}}
- examples:
	- I'm an apple block with below custom properties
	  id:: 60a78e9e-59dc-40ab-9a01-5317dc09365f
	  color:: red
	  origin:: Spain
	- this **first block** of this page serves an example for **page property**
	- let's add two more books:
		- [[How to take smart notes]]
		  type:: [[book]]
		  author:: [[sönke ahrens]]
		  publication_date:: [[february 21, 2017]]
		  created_at:: 1609233078964
		  last_modified_at:: 1609337624066
		- [[How to solve it]]
		  created_at:: 1609233053383
		  last_modified_at:: 1609337985298
		  type:: [[book]]
		  author:: [[george polya]]
- `Properties` can be used for selecting specific blocks.
  created_at:: 1609233183055
  last_modified_at:: 1609233190917
	- For example, let's query all the blocks with the property "type" and the value "book" #examples #books
	  created_at:: 1609337879435
	  last_modified_at:: 1609337879435
	  {{query (property type book)}}
	- Or we can use [[Advanced Queries]]
	-
	  #+BEGIN_SRC clojure
	  	  	  #+BEGIN_QUERY
	  	  	  {:title [:h2 "My books"]
	  	  	   :query [:find (pull ?b [*])
	  	  	         :where
	  	  	         [?b :block/properties ?p]
	  	  	         [(get ?p :type) ?t]
	  	  	         [(= "[[book]]" ?t)]]}
	  	  	  #+END_QUERY
	  	  	  #+END_SRC
		-
		  #+BEGIN_QUERY
		  {:title [:h2 "My books"]
		   :query [:find (pull ?b [*])
		         :where
		         [?b :block/properties ?p]
		         [(get ?p :type) ?t]
		         [(= "[[book]]" ?t)]]}
		  #+END_QUERY