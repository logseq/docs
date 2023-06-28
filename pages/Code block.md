type:: [[Feature]]
platforms:: [[All Platforms]]
description:: Renders a block of code with [[Codemirror]] support for a variety of languages

## Usage
	- Type the `/Code block` command and then select a language from the dropdown.
		- type:: [[Command]]
		  name:: Code block
		  description:: User-friendly way to create a code block
	- Alternatively, you can type 3 backticks, the name of the language and then press `Enter`.
	- An example code block looks like:
	  ```clojure
	  (println "WOOT!")
	  ```
## Functionality
	- This feature provides support for languages through [CodeMirror's modes](https://codemirror.net/5/mode/index.html)
- ## Additional Links
	- See [[Calculator]] and [[ClojureScript Eval in a Block]] features which rely on code blocks