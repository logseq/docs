title:: Global config.edn
type:: [[Feature]]
platform:: [[Desktop]]
description:: Version of [[config.edn]] that applies to all graphs
initial-version:: 0.8.6

## Usage
	- To edit your global config.edn, open the Settings panel >  `General`  tab and click the edit button for this file.
	- Alternatively, edit the global config file at  `~/.logseq/config/config.edn` .
	- Any options that are valid in the local config.edn are valid for global config.edn.
## Functionality
	- Global config.edn applies to all graphs. This is useful for functionality that you want to have across graphs like shortcuts, query views, query result transforms, macros, etc.
	- Global config.edn supports all the config options that config.edn supports.
	- Global config.edn can be edited outside Logseq and the effects will take place in a few seconds.
	- Local config.edn overrides config keys that are present in a global config.edn. However, if the config is a map, the local config option is merged over the global config option.
		- Here's an example of how merging maps works:
		  
		  
		  ```
		  ;; global config
		  		  {:shortcuts {:ui/toggle-theme "t z" :ui/toggle-brackets "t t"}}}
		  		  ;; local config
		  		  {:shortcuts {:ui/toggle-brackets "t b"}}
		  
		  		  ;; resulting config
		  		  {:shortcuts {:ui/toggle-theme "t z"
		     :ui/toggle-brackets "t b"}}
		  ```
		- In this example, the user has global shortcuts and then is able add to them and override specific ones for a specific graph