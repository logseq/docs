title:: config.edn
type:: [[Feature]]
platform:: [[All Platforms]]
description:: Local config file, `logseq/config.edn`, is the main configuration file for a graph

- ## Usage
	- To edit this file, open the [[Settings]] panel > General tab and click the edit button for this file.
	- Alternatively, edit your graph's config file located at `logseq/config.edn`.
	- Some options are editable via the UI from other tabs in Settings.
- ## Functionality
	- See the [config.edn template](https://github.com/logseq/logseq/blob/master/templates/config.edn) for documentation on all config options.
	- See [[Basic settings]] for config options that have a UI.
	- This file can be edited outside Logseq and the effects will take place in a few seconds.
	- Config options are validated when a user saves the file. Errors are displayed for invalid config options.
	- Config options can be autocompleted after pressing `:`.
	- ### Specific config options:
		- `:editor/extra-codemirror-options` (map) - These can be any of the options [documented here](https://codemirror.net/doc/manual.html#config)
		  collapsed:: true
			- To customize a codemirror theme, select one [from this list](https://codemirror.net/5/demo/theme.html). For example, if you choose blackboard configure it with:
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
		- `:query/result-transforms` (map) - Define result transforms for use with [[Advanced Queries]] . Map of keywords to fns. Example:
		  collapsed:: true
			- ```edn
			  ;; Define in config.edn
			   :query/result-transforms
			   {:sort-by-priority
			    (fn [result] (sort-by (fn [h] (get h :block/priority "Z")) result))}
			  
			  ;; In an advanced query
			  {:query ...
			   :result-transform :sort-by-priority}
			  ```