type:: [[Feature]]
platform:: [[All Platforms]]

- ## Usage
	- Search for pages and full text search for blocks is available by clicking on the search bar at the top or press `Cmd-k`.
	- To search blocks within a page, run the command `Search in the current page` or press `Cmd-shift-k`.
	- Pages can also be created from search by typing a new unique string and pressing `Enter`.
- ## Functionality
	- Page search can find any page under `journals` or `pages`.
	- Block search _only_ finds blocks within pages. It does not find blocks _anywhere_ else in the app e.g. linked references, sidebar, settings, etc.
	- By default, search removes accents from results e.g. `räämat` -> `raamat`. This feature can be turned off by setting the `:feature/enable-search-remove-accents?` option to `false` in [[config.edn]] . After toggling this feature, please run the command `Rebuild search index`.
	- Search functionality is powered by a search index. If the index is ever out of date or seems buggy, run the command `Rebuild search index`.
- TODO More specific name for this feature #docs
	- Possible names include Global search, quick search, general search, omni search, search or create