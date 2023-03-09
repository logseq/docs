title:: plugins.edn
type:: [[Feature]]
platforms:: [[Desktop]]
description:: Global file that provides a list of a user's current [[Plugins]] 
initial-version:: 0.8.9

- ## Usage
	- plugins.edn is automatically kept up to date when installing, updating or removing a plugin.
	- To install another user's plugins, run the command  `Install plugins from plugins.edn` or choose the 3 dot menu in the plugins dashboard. Click  `Install`
	- plugins.edn is located at `~/.logseq/config/plugins.edn`. Editing the file directly is not necessary for its functionality to work.
	- [Initial release demo](https://www.loom.com/share/200a0abb096444d1a9e56e826fa06fb0)
- ## Functionality
	- To try another user's plugins:
		- Back up your plugins and their preferences:
		  collapsed:: true
			- Back up your plugins. If you have plugins.edn, save a copy of that file. If you don't have a plugins.edn, move ~/.logseq/plugins to ~/.logseq/plugins.bak
			- If you want to back up your plugin preferences: move ~/.logseq/settings to ~/.logseq/settings.bak
		- Download a plugins.edn you want to try, for example [this Logseq developer's plugins.edn](https://github.com/cldwalker/logseq-config/blob/main/config/plugins.edn), and move it to `~/.logseq/config/plugins.edn`.
		- Run the command  `Install plugins from plugins.edn`  or choose the 3 dot menu in the plugins dashboard. Click  `Install`.
	- plugins.edn file is described for developers at https://github.com/logseq/logseq/blob/master/src/main/frontend/schema/handler/plugin_config.cljc