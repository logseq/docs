- [[Jul 19th, 2021]]
  id:: 60f57103-7fe8-4b83-b497-f3576672d30b
  **Beta 0.2.6**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.6
	- [[Demo]] on query tables
	  #+BEGIN_TIP
	  You can press `t w` to adjust the width so that it's easy to see the Gif as below.
	  #+END_TIP
		- ![2021-07-19 21.19.52.gif](../assets/2021-07-19_21.19.52_1626701017883_0.gif)
	- [[Thanks]]
		- [[Sebastian Bensusan]]
			- [[Calculator]] supports negative numbers 🪄
	- [[Fixed issues]]
		- Can't drag the desktop app when scrolling down a bit
		- Can't go back to global search after searching in a specific page
		- Catch error when rendering image with wrong metadata
		- Don't show properties in block references
		- Don't show built-in properties in search results
		- Autocomplete shortcut config
		- Block timestamps in the code block
	- [[Features]]
		- [[Query/table/function]] ✨✨✨
			- How to create a function below the query table? #card
				- Firstly, you have a query like this: 
				  query-table:: true
				  query-properties:: [:block :author :publication-date :price :qty :updated-at]
				  {{query (property type book)}} 
				  Then, you can create functions (by trigger `/function`) as this query block's children.
				  
				  For example:
					- How many books? `{{function (sum :qty)}}`
						- Answer: {{function (sum :qty)}}
					- What's the average price? `{{function (average :price)}}`
						- Answer: {{function (average :price)}}
					- How much does it cost to buy all of them? `{{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}`
						- Answer: {{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}
			- What features does it support?
				-
				  #+BEGIN_NOTE
				  The property to be used in the function must be a keyword, a keyword has a `:` at the beginning.
				  For example, `:price` is a keyword while `price` is not.
				  #+END_NOTE
				- Aggregations including sum/average/min/max/total
					- `{{function (sum :property)}}`
					- `{{function (average :property)}}`
					- `{{function (min :property)}}`
					- `{{function (max :property)}}`
					- `{{function (total :property)}}`
				- [[Clojure]] function!
				  The function takes the query result and bind it to the symbol `result` for usage.
					- `{{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}`
	- [[Enhancement]]
		- [[Queries/table]]
			- Click to open a block in the right sidebar
			- Human-readable block timestamps
			- Add sorts by any property
			- Add custom properties support
- [[Jul 14th, 2021]]
  **Beta 0.2.5**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.5
	- [[Thanks]]
		- [[Devon Zuegel]]
			- WYSIWYG headers + CSS cleanup
		- [[Peng Xiao]]
			- Clear data-active-keystroke when blur
		- [[Michael Schmidt-Korth]]
			- Updates to keyboard shortcut wording
	- [[Fixed issues]]
		- Pages or even the whole graph can be deleted when re-index
			- Introduced by the release `0.2.4` which was deleted to avoid more data loss
		- Block reference gets lost on alt-dragged blocks after re-index
		- Bring block timestamps back, you can enable it in the settings page
			- It'll add both `created-at` and `updated-at` properties.
		- Preserve the block properties order
		- Publishing supports subpath now
		- Previous page are not removed in the graph view
		- Can't delete selected blocks when zoom in
		- Don't show the collapse arrow when there's no block title or children blocks
		- Fix light theme colors
		- Hide :collapsed property when editing
		- Org mode image rendering
	- [[Features]]
		- Finally, we can render queries as tables! 🎉 [[Queries/table]]
			- {{query (property type book)}}
			  query-table:: true
			- {{query (page-property tags)}}
	- [[Enhancement]]
		- [[Publishing]]
			- Disable edit-mode
			- Remove access to settings on the exported site
			- Do not export pages with "public:: false" option when all pages are set public from the config
			- You can set all pages as public in the settings page
		- [[All pages]] support sorted by page's name, links, created at and updated at
			- ![CleanShot 2021-07-14 at 22.49.17.png](../assets/CleanShot_202021-07-14_20at_2022.49.17_1626274169623_0.png)
- [[Jul 9th, 2021]]
  **Beta 0.2.3**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.3
	- [[Thanks]]
		- [[Peng Xiao]]
			- Various UI improvements & refactoring
			- Improve cursor style with block reference
			- New page preview for page autocomplete
			  collapsed:: true
			  ![page-search-preview.gif](../assets/page-search-preview_1625811143112_0.gif)
			- `shift+enter` to open autocomplete item in sidebar
			- Fix sidebar not able to resize and draggle issue
			- Fix custom css not work when switching graphs
		- [[Michael Schmidt-Korth]]
			- Fix privacy term links not working for electron
		- [[bensu]]
			- Enhance scrolling into moving blocks behavior
	- [[Fixed Issues]]
		- Fix open file externally with relative paths
	- [[Features]]
		- Graph display is completely revamped
			- Webgl rendering thousands of nodes instantly for large repo
			- Better nodes filtering and searching
			- Various UX improvements
			- demo
			  collapsed:: true
			  ![graph-revamp.gif](../assets/graph-revamp_1625810222843_0.gif)
		- New block level export (export to plain text or opml)
		  collapsed:: true
		  ![block-export.gif](../assets/block-export_1625810930779_0.gif)
	- [[Enhancement]]
		- Enhanced document mode experience (`t d` to toggle, use `shift+enter` to create new block inside document mode)
		  collapsed:: true
		  ![document-mode.gif](../assets/document-mode_1625821426981_0.gif)
		- New frameless design and UI polish for mac desktop app on Mac
		- Enhance Mldoc ast types for link reference
		- Bundle assets for desktop app to eliminate outbound network requests
		- Add global shortcuts for moving backward`ctrl/cmd [` and forward`ctrl/cmd ]`
		  id:: 60e80f8d-f130-4925-ad22-474977a1f56d