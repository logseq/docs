type:: [[Feature]]
platforms:: [[All Platforms]] except [[Publish Web]]
description:: Describes copy and the difference between formatted and raw paste

- ## Usage
	- To copy, press the standard key e.g. `Cmd-C` on a mac.
	- To invoke a formatted paste, press the standard key e.g. `Cmd-v` on a mac.
	- To invoke a raw paste, add the `shift` key to your paste combo e.g. `Cmd-shift-v` on a mac.
- ## Functionality
	- A raw paste inserts all copied text into the current block. It does not attempt _any_ formatting. It can replace text that is selected
	- Enhanced paste (the default paste) does a number of things including:
		- If HTML is detected in the copy, pastes the html
		- Pasting a group of logseq blocks recreates the original ones, including their nested structure. The only difference being that id properties are stripped to give the pasted blocks their own identity
		- Handles some video urls like `youtube.com` ones by wrapping them in a video macro
		- Always pastes a file when detected if `:editor/preferred-pasting-file? true` is in [[config.edn]]
		- Some smart behavior when text is selected e.g. when a url is selected, a paste will wrap the url as a markdown link and the pasted as its title
		- [foo](https://github.com/logseq/logseq/issues/8981)