type:: [[Feature]]
platforms:: [[All Platforms]]

- ## Usage
	- Search pages, blocks, files and commands by clicking on the search bar in the top left or press `Cmd-k` (macOS)/`Ctrl-k` (Windows and Linux).
		- While in the search modal, type `/` to start setting a filter for pages, blocks, file or commands. Press `Esc` to unset the current filter.
		- Pressing `Enter` will search a result. Pressing `Shift-Enter` will open the search result in the sidebar.
		- Pressing `Cmd-Enter` (macOS)/`Ctrl-Enter` (Windows and Linux) will move the search to the sidebar.
		- Creates pages or whiteboards from this modal by typing a new unique string and pressing `Enter`.
	- When in a page, search blocks within a page by running the command `Search in the current page` or press `Cmd-Shift-k` (macOS) or `Ctrl-Shift-k` (Windows and Linus).
- ## Functionality
	- Page search can find any page under `journals` or `pages`.
	- Block search _only_ finds blocks within pages. It does not find blocks _anywhere_ else in the app e.g. linked references, sidebar, settings, etc.
	- On [[Desktop]], there is full text search which searches across multiple blocks and also matches on search terms that are out of order.
	- By default, search removes accents from results e.g. `räämat` -> `raamat`. This feature can be turned off by setting the `:feature/enable-search-remove-accents?` option to `false` in [[config.edn]] . After toggling this feature, please run the command `Rebuild search index`.
	- Search functionality is powered by a search index. If the index is ever out of date or seems buggy, run the command `Rebuild search index`.
