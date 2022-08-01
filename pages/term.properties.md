id:: 60a78c12-4e12-4d81-a33f-9f63695aaf32
type:: term
name:: i'm a page property
alias:: Block properties
click:: click me to edit

- **Description**
	- Properties are key-value pairs that allow you to annotate a block or page.
	- _Page properties_ are defined by putting them into the first block of the page (_frontmatter_).
	- _Block properties_ are defined by putting them into any other block.
	- Any page or block can have multiple pairs of properties.
	- Property values are primarily used for linking to other pages in the following ways:
	  collapsed:: true
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
- **Usage**
	- To enter a property, type `::` to autocomplete a property name. After entering a property name, autocomplete a property value that is _specific_ to that property. To see this in action, [see this demo](https://www.loom.com/share/27804e1bcd7b4e4bbf71ec14956c42fe).
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
	  collapsed:: true
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
	  collapsed:: true
		- For example, let's query all the blocks with the property `type` and the value `book`: #examples #books
		  collapsed:: true
		  {{query (property type book)}}
		- Or we can use [[Advanced Queries]]:
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
	- Providing common attributes to your pages/block - for example, you could have a template `Book` and a list of attributes you want to define for each book:
	  ```
	  author: [[george polya]]
	  title: Mathematics and Plausible Reasoning
	  published: 2009
	  ```
- **Built-in Properties**
	- There are built-in in properties that control Logseq functionality. Most of the these properties are hidden from the user but a few are user editable. These property names are reserved for Logseq and thus _must_ not be used as a user property. The number in brackets indicates how many values you may define.
	- Editable properties
		- `icon` (1) define icon identifier for a page.
		- `title` (1) overrides the title of a page to be different from the file name.
		- `tags` (N) get listed in their own section "Pages tagged with X" below a page.
		- `template` (1) designates a page as a template.
		- `template-including-parent` (1) (in previous versions `include-parent`) specifies whether the parent level content of the selected block should be included when using a template.
		- `alias` (N) define synonyms for a page.
		- `filters` (N, object with booleans) store selected filters for linked references on page-level.
		- `public` (boolean) defines whether a page should be included in an export.
		- `exclude-from-graph-view` (boolean) defines whether a page should be excluded in global graph view.
		- `filetags` - [org-mode only property](https://orgmode.org/manual/Tag-Inheritance.html) to add to a file's tags
		- `macro` - [org-mode only property](https://orgmode.org/manual/Macro-Replacement.html) to define [[Macros]] in a file
	- Hidden properties
		- `collapsed` (1) specifies whether a block is collapsed.
		- `id` (1) specifies a block id.
		- `created-at` (1) and `updated-at` (in previous versions `last-modified-at`) (1) define the date/time stamps in [Unix time](https://en.wikipedia.org/wiki/Unix_time); block-level only.
		- `parent` (1) references the parent block (could be a page).
		- `query-table` (1) will mark a query to be shown as the table view.
		- `query-properties` (N) stores a user's custom properties to be shown for a query table.
		- See `hidden-built-in-properties` in https://github.com/logseq/logseq/blob/master/deps/graph-parser/src/logseq/graph_parser/property.cljs for the full list.