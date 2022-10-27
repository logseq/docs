id:: 60a78c12-4e12-4d81-a33f-9f63695aaf32
type:: [[Feature]]
alias:: Block properties
platform:: [[All Platforms]]
description:: Annotate any block or page with multiple pairs of values e.g. `rating:: 8` or `name:: foo`.

- ## Usage
	- Property naming rules:
	  collapsed:: true
		- 1. Properties are valid for alphanumeric characters and some special characters. When a property is invalid, it is not saved as a valid property and an error message explains what is a valid property name:
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
	- Properties with no value are not visible or queryable e.g. `property:: `
	- ### Property values
	  id:: 6356e902-3b7b-4cb2-8c3e-6a904c813c40
		- Property values can be a mix of almost any text, links, page links and tags. This means you can write like anywhere else in Logseq:
		  collapsed:: true
		  ```
		  description:: [[Logseq]] is the fastest #triples #[[text editor]]
		  ```
		  
		  The pages `Logseq,`, `triples` and `text editor` are all linked property values through the `description` property.
			- The exception to "any text" is that properties are currently embedded in their block and delimited by newlines. Since their delimiter is a newline, a property value can't have newlines.
		- Built-in properties `alias` and `tags` also have an additional way of recognizing pages through comma separation:
		  collapsed:: true
		  ```
		  tags:: motor, steering wheel
		  ```
		  Pages `motor` and `steering wheel` are linked property values through the `tags` property. See the configuration section below to enable this behavior for specific properties.
		- To prevent a property value from having any links, wrap it within quotes (`"`):
		  collapsed:: true
		  ```
		  description:: "[[Logseq]] is the fastest #triples #[[text editor]]"
		  ```
	- ### Configuration in [[config.edn]]
		- `:property-pages/enabled?` - Boolean which determines if properties have their own pages. This is enabled by default
		- `:property-pages/exclude-list` - Specific properties to exclude from having property pages
		- `:property/separated-by-commas` - Properties that also identify page references with comma separated values like `:tags` e.g. `tags:: foo, bar`
		- `:ignored-page-references-keywords` - Properties that do not allow page referencing. Avoids the need to have to quote the property values with `""` every time
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