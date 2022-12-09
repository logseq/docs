type:: [[Feature]]
platform:: [[All Platforms]]
description:: Provides keyboards shortcuts for running core commands and actions. Shortcuts can be customized through user configuration.

- ## Usage
	- **How to setup custom keyboard shortcuts?**
		- To add custom shortcuts, you can navigate to the shortcuts page with `g s`. Press the blue button corresponding to a given shortcut and a modal should pop up. Press the keybinding you want and then press `Save`. The shortcuts will be saved to your graph's [[config.edn]].
		- Alternatively, you can add/modify the `:shortcuts` section in [[config.edn]], for example, then refresh Logseq.
		  #+BEGIN_EXAMPLE
		  :shortcuts {:ui/toggle-theme "mod+c mod+t"}
		  #+END_EXAMPLE
		  To have shortcuts that work across all graphs, put the shortcuts in [[Global config.edn]].
- ## Functionality
	- **Which shortcuts can be customized?**
	  Type `g s` to see the full list of shortcuts by categories. The default shortcuts are [here](https://github.com/logseq/logseq/blob/master/src/main/frontend/modules/shortcut/config.cljs).
	- When the editor is not focused, Logseq recognizes key combos which are multiple letters pressed sequentially. The three letters used for key combos are:
		- `g` for Go e.g. `g s` goes to the
		- `t` for Toggle e.g. `t r` toggles the right sidebar
		- `n` for New e.g. `n w` creates a new whiteboard
	- Use this syntax when configuring shortcuts by hand:
		- `+` means keys pressing simultaneously eg: `ctrl+shift+a`
		- ` ` empty space between keys means key chords
			- eg: `t t`
			- eg: `mod+c mod+t`
		- `mod` means
			- `ctrl` for Linux and Windows
			- `cmd` for Macos
		- you can define multiple bindings for one action
			- eg: `:editor/down ["ctrl+j" "down"]`
		- Example of a vim-like shortcut setup:
		  collapsed:: true
			- ``` clojure
			  :shortcuts
			   {:editor/new-block "enter"
			   :editor/new-line "shift+enter"
			   ;; remap insert-link to something else to avoid conflicts
			   :editor/insert-link "ctrl+shift+k"
			   :editor/up ["ctrl+k" "up"]
			   :editor/down ["ctrl+j" "down"]
			   :editor/left ["ctrl+h" "left"]
			   :editor/right ["ctrl+l" "right"]
			   :editor/open-edit ["i" "enter"]
			   :editor/backspace ["ctrl+d" "backspace"] 
			   :date-picker/complete ["enter"]
			   :date-picker/prev-day ["ctrl+h" "left"]
			   :date-picker/next-day ["ctrl+l" "right"]
			   :date-picker/prev-week ["ctrl+k" "up"]
			   :date-picker/next-week ["ctrl+j" "down"] 
			   :auto-complete/prev ["ctrl+k" "up"]
			   :auto-complete/next ["ctrl+j" "down"]
			   :auto-complete/complete ["ctrl+l" "enter"]}
			  ```
- ## Background
	- > People come to Logseq from different operating systems, use different keyboard layouts and languages, and have different preferences. Customizable keyboard shortcuts is the only way to make everybody happy. - [[Cobblebot]] [discussion](https://discuss.logseq.com/t/customizable-keyboard-shortcuts/146)