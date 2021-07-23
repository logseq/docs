id:: 60a78c12-4e12-4d81-a33f-9f63695aaf32
type:: term
name:: i'm a page property
alias:: Block properties
click:: click me to edit

- **Description**
	- Properties are key-value pairs that allow you to annotate a block or page
	- _Page properties_ are defined by putting them into the first block of the page (_frontmatter_)
	- _Block properties_ are defined by puttin them into any other block
	- When a property value matches an existing page title, Logseq will automatically create a link to that page
	- When a property contains commas (`,`), any values are going to be automatically linked:
	  ```
	  parts:: motor, steering wheel, tyres
	  ```
	- When a property contains references, (`[]`), any values are going to be automatically linked:
	  ```
	  parts:: [[motor]], steering wheel, tyres
	  ```
	-
	  #+BEGIN_TIP
	  To prevent values from being auto-linked, wrap _all_ values within quotes (`"`) - for example, `parts:: "[[motor]], steering wheel, tyres"`
	  You cannot quote (unlink) _parts_ (items) of a list property, e.g. `parts:: [[motor]], "steering wheel, tyres"` is not going to prevent values from being linked.
	  #+END_TIP
- **Usage**
	- A page can have many pairs of properties (the collection is a user-defined dictionary) as long as they are in first block of that page
	- Each block can also have many pairs of properties (except for the first block, which will be served as page properties)
	- Markdown:
	  {{embed ((60ab6f5b-4bdc-4ef0-a0f8-6cad9dcad2b2))}}
	- org-mode:
	  {{embed ((60ab7357-2744-42bc-a8fd-a9c8db3051df))}}
- **Examples**
	- I'm an apple block with below custom properties
	  id:: 60a78e9e-59dc-40ab-9a01-5317dc09365f
	  color:: red
	  origin:: Spain
	- this **first block** of this page serves an example for **page property**
	- let's add two more books:
		- [[How to take smart notes]]
		  updated-at:: 1609337624066
		  created-at:: 1609233078964
		  type:: [[book]]
		  author:: [[sönke ahrens]]
		  publication_date:: [[february 21, 2017]]
		  price:: 10
		  qty:: 1
		- [[How to solve it]]
		  updated-at:: 1609337985298
		  created-at:: 1609233053383
		  type:: [[book]]
		  author:: [[george polya]]
		  price:: 20
		  qty:: 2
- **Properties** have two use cases
	- Selecting (querying) specific pages/blocks:
		- For example, let's query all the blocks with the property `type` and the value `book`: #examples #books
		  collapsed:: true
		  {{query (property type book)}}
		- Or we can use [[Advanced Queries]]:
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
		- Providing common attributes to your pages/block - for example, you could have a template `Book` and a list of attributes you want to define for each book:
		  ```
		  author: [[george polya]]
		  title: Mathematics and Plausible Reasoning
		  published: 2009
		  ```
