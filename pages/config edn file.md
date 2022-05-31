title:: config.edn

- Most of the `Settings` you've toggled in UI will be stored in `logseq/config.edn` file inside your graph folder
- Some of the advanced or experimental setting options can also be set in this file directly.
- A clean raw version of `config.edn` can be found [here](https://raw.githubusercontent.com/logseq/logseq/master/templates/config.edn)
- More information about specific config keys:
	- `:editor/extra-codemirror-options` - These can be any of the options [documented here](https://codemirror.net/doc/manual.html#config)
		- To customize a codemirror theme, select one [from this list](https://codemirror.net/theme/). For example, if you choose blackboard configure it with:
		  ```clojure
		   :editor/extra-codemirror-options   {:theme "blackboard"}
		  ```
		- In custom.css, add the following:
		  ```css
		  @import "https://codemirror.net/theme/blackboard.css";
		  ```