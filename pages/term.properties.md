id:: 60a78c12-4e12-4d81-a33f-9f63695aaf32
type:: [[Feature]]
alias:: Block properties
platform:: [[All Platforms]]
description:: Annotate any block or page with multiple pairs of values e.g. `rating:: 8` or `name:: foo`.

- ## Usage
	- Property naming rules:
	  collapsed:: true
		- collapsed:: true
		  1. Properties are valid for alphanumeric characters and some special characters. When a property is invalid, it is not saved as a valid property and an error message explains what is a valid property name:
			- `Property name begins with a non-numeric character and can contain alphanumeric characters and . * + ! - _ ? $ % & = < >. If -, + or . are the first character, the second character (if any) must be non-numeric.`
		- 2. Properties are case insensitive and lower cased. For example, property names `platform`, `Platform` or `PLATFORM` are all the same as `platform`.
		- 3. Properties with a  `_`  character are renamed to  `-` e.g. `done_at` is renamed to `done-at`. This rename is done so that users don't have to think about the difference between `_` and `-`.
	- To enter a property, type `::` to autocomplete a property name. After entering a property name, autocomplete a property value that is _specific_ to that property. To see this in action, [see this demo](https://www.loom.com/share/27804e1bcd7b4e4bbf71ec14956c42fe).
	- Markdown:
	  {{embed ((60ab6f5b-4bdc-4ef0-a0f8-6cad9dcad2b2))}}
	- org-mode:
	  {{embed ((60ab7357-2744-42bc-a8fd-a9c8db3051df))}}
- ## Functionality
	- _Page properties_ are defined by putting them into the first block of the page (_frontmatter_).
	- _Block properties_ are defined by putting them into any other block.
	- Any page or block can have multiple pairs of properties.
	- Property values are primarily used for linking to other pages in the following ways:
	  collapsed:: true
		- TODO Update this section for 0.8.8 #docs
		- When a property value matches an existing page title, Logseq will automatically create a link to that page
		- When a property contains commas (`,`), any values are going to be automatically linked:
		  ```
		  parts:: motor, steering wheel, tyres
		  ```
		- When a property contains references, (`[]`), any values are going to be automatically linked:
		  ```
		  parts:: [[motor]], steering wheel, tyres
		  ```
		- To prevent values from being auto-linked, wrap _all_ values within quotes (`"`) - for example, `parts:: "[[motor]], steering wheel, tyres"`
		  You cannot quote (unlink) _parts_ (items) of a list property, e.g. `parts:: [[motor]], "steering wheel, tyres"` is not going to prevent values from being linked.
	- **Configuration** in [[config.edn]]
		- Properties have their own pages by default. To disable this, `:property-pages/enabled? false`
		- Property values identify page references with the standard `[[]]` and `#` characters. To have certain properties identify page references by comma separation, use `:property/separated-by-commas`.
		- TODO Add #docs for other property related configs
- ## Background
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
	- **Properties** have multiple use cases including:
		- Selecting (querying) specific pages/blocks:
			- For example, let's query all the blocks with the property `type` and the value `book`: #examples #books
			  collapsed:: true
			  {{query (property type book)}}
			- Or we can use [[Advanced Queries]]:
			  collapsed:: true
				- #+BEGIN_SRC clojure
				   #+BEGIN_QUERY
				   {:title [:h2 "My books"]
				    :query [:find (pull ?b [*])
				   :where
				   [?b :block/properties ?p]
				   [(get ?p :type) ?t]
				   [(= "[[book]]" ?t)]]}
				   #+END_QUERY
				   #+END_SRC
				- #+BEGIN_QUERY
				  {:title [:h2 "My books"]
				   :query [:find (pull ?b [*])
				  :where
				  [?b :block/properties ?p]
				  [(get ?p :type) ?t]
				  [(= "[[book]]" ?t)]]}
				  #+END_QUERY
		- author: [[george polya]]
		  title: Mathematics and Plausible Reasoning
		  published: 2009
		- TODO Finish explaining this section #docs
- ## Additional Links
	- [[Built-in Properties]]