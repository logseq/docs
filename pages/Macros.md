type:: [[Feature]]
platforms:: [[All Platforms]]
description:: Provides a way to write and maintain reusable text. This text can render as html and can invoke some other features

- ## Usage
	- ### Creating a macro
		- Open the [[config.edn]] file.
		- Scroll down to the `:macros` section. Inside the curly brackets, add your macro's name in curly brackets followed by the text template, e.g.:
		- ```edn
		  :macros {
		  "foo" "Hello $1"
		  }
		  ```
		- For readability, use a line break to separate each macro
	- ### Using a Macro
		- In Logseq, type the macro name as the first word wrapped in curly braces e.g. the `foo` macro is typed as `{{foo}}`
- ## Functionality
	- Macros can have arguments with numbered dollar variables. For example, the `hello` macro defined as `"Hello $1 and $2!"` in config.edn has two arguments. In Logseq, it's invoked  with comma delimited arguments like  `{{hello foo, bar}}`. This results in `Hello foo and bar!`
	- Macros can render the html in them. HTML can be specified as [hiccup](https://github.com/weavejester/hiccup#syntax) or as raw html. For example, the `mark` macro defined as `"[:mark \"$1\"]"` or as `"<mark>$1</mark>"` in config.edn and invoked as `{{mark hi}}` in Logseq renders as {{mark hi}}
	- Macros can invoke logseq commands like [[Query]] . For example, the `query-done` macro defined as `"{{query (and (task done) $1)}}"` in config.edn and invoked as `{{query-done "changelog"}}` in Logseq renders as  {{query-done "changelog"}}
	- Macros can't be used to invoke advanced queries.
	- To supercharge your macros, you can pair them with slash [[Commands]]. Check out [this forum post](https://discuss.logseq.com/t/macros-and-commands-lets-share/9565) to see an example.
	- If you are having issues with unwanted line breaks appearing in Logseq when invoking multiple macros on the same line, you may need to add `div.macro { display: inline-block; }` to `custom.css` ([see issue in GitHub](https://github.com/logseq/logseq/issues/8623))