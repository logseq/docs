type:: [[Feature]]
platforms:: [[All Platforms]] except [[Publish Web]]
description:: Run ClojureScript in a block using [sci](https://github.com/babashka/sci)

- ## Usage
	- Type `<Src`, add `cljs :results` and then evaluate any amount of ClojureScript code in that block.
	- For example, in Markdown this looks like
	  #+BEGIN_EXAMPLE
	  ```cljs :results
	  (inc 1)
	   ```
	  #+END_EXAMPLE
	  
	  and produces a result div below it with answer `2`.
- ## Functionality
	- The code in a source block evaluates when the block is no longer in edit mode. Upon evaluation, a results panel display below the block.
	- If the result of the block has the `^:hiccup` metadata flag, the result renders as [[Hiccup]] html. This can be used to build a bare bones UI in the results.
		- For example,
		  #+BEGIN_EXAMPLE
		  ```cljs :results
		  ^:hiccup [:div {:style {:color "blue"}} "Woot"]
		  ```
		  #+END_EXAMPLE
		  
		  produces a blue colored "Woot".
		- See https://github.com/logseq/logseq/pull/7287 for a more interesting example
	- The binding `block` is the current block as a map. To see an example of this, enable `Developer mode` in Settings, right click on a block and choose `(Dev) Show block data`.
		- TODO Document developer mode #docs
	- Errors aren't user friendly and just report in the js console for now.