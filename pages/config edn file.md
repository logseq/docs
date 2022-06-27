title:: config.edn

- Most of the `Settings` in the UI are stored in your graph's `logseq/config.edn` file. Configuration/setting changes can be made by directly editing this file.
- See the [config.edn template](https://github.com/logseq/logseq/blob/master/templates/config.edn) for documentation on most config options.
- More information about specific config options:
	- `:editor/extra-codemirror-options` (map) - These can be any of the options [documented here](https://codemirror.net/doc/manual.html#config)
	  collapsed:: true
		- To customize a codemirror theme, select one [from this list](https://codemirror.net/theme/). For example, if you choose blackboard configure it with:
		  ```clojure
		   :editor/extra-codemirror-options   {:theme "blackboard"}
		  ```
		- In custom.css, add the following:
		  ```css
		  @import "https://codemirror.net/theme/blackboard.css";
		  ```
	- `:query/views` (map) - Define views for use in advanced queries. Map of keywords to fns.
	  collapsed:: true
		- This is an example view:
			- ```clojure
			  :query/views
			   {:pprint (fn [r] [:pre.code (pprint r)])}
			  ```
		- Refer to it in a query as `:view :pprint`.
	- `:query/result-transforms` (map) - Define result transforms for use in advanced queries. Map of keywords to fns.