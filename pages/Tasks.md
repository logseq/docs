type:: [[Feature]]
alias:: Todos
platforms:: [[All Platforms]]

- ## Usage
	- Logseq comes with two built-in flavors to mark your block with built-in workflow marker keywords and manage your tasks:
	  + `LATER` -> `NOW` -> `DONE` flavor (default)
	  + `TODO` -> `DOING` -> `DONE` flavor
	  + You can toggle between those two flavors in the settings page
	- There are two ways to attach workflow markers to your task block:
		- when editing the block, press `Ctrl/Cmd+enter` to cycle through the workflow markers
		- type these commands directly (eg `/LATER`) anywhere in the block, or manually write the keyword at the start of the block (eg `LATER do grocery`)
		- Some examples:
		  todo:: 1621908710666
			- LATER do grocery
			- NOW play with Logseq
			- DONE watch Doctor Who
				- (_this is how `DONE` renders_)
	- In addition to the workflows described above, there's also `CANCELED`/`CANCELLED`, `IN-PROGRESS`,  and `WAIT`/`WAITING` markers which can be typed directly.
		- Some examples:
			- CANCELLED the boring thing
				- (_this is how `CANCELLED` renders_)
			- IN-PROGRESS the fun thing
			- WAIT the slow thing
	- Once the block has been created, if it shows an empty tick-box at the start of the block you can manually click on that box to get it to change to `DONE`, which can be rather satisfying to do.
- ## Functionality
	- ### Priorities
		- Logseq comes with three optional, built-in priorities that can be set with commands (`/A`, `/B`, `/C`):
			- type:: [[Command]]
			  name:: A
			  description:: Highest priority
			- type:: [[Command]]
			  name:: B
			  description:: Mid level priority
			- type:: [[Command]]
			  name:: C
			  description:: Lowest priority
			- Example:
				- LATER [#A] big important and urgent thing
				- LATER [#C] the lower priority thing
			- Again, these can either be added by using the commands (typing `/A`), or manually added by writing `[#A]` at the start of the block after the marker.
	- ### Deadline and Scheduled
		- There are two commands for setting dates on a block:
			- type:: [[Command]]
			  name:: Deadline
			  description:: Type command `/Deadline` to choose a deadline date for a block
				- eg: finish reading 1984 by 29th of May
				  DEADLINE: <2021-05-29 Sat>
			- type:: [[Command]]
			  name:: Scheduled
			  description:: Type command `/Scheduled` to setup a scheduled date for a block
				- eg: send John a birthday card Monday
				  SCHEDULED: <2021-05-31 Mon>
		- Both of the above commands work on regular blocks too, not just tasks.
		- Both of the above commands default to displaying blocks that are coming up soon. You can configure how soon with `:scheduled/future-days`  in [[config.edn]].
		- Both of above commands support to mark the task as repeated:
		  after typing the command and click `Add repeater` in the date picker
			- eg: daily exercise routine at 7am
			  SCHEDULED: <2021-05-26 Wed 7:00 .+1d>
     			- You can change the repeater kind to:
				- `.+`: It'll repeat from the last time you marked the block done.
				- `++`: It'll keep it on the same day of the week.
				- `+`: It'll repeat in X y/m/w/d/h from when you originally scheduled it.
	- ### Time tracker
	  id:: 60af74c1-62f8-434a-827c-abc6d2a71734
		- {{embed ((60acdeba-b3fd-4f90-ab54-3093caa4d5fa))}}
		- you can toggle this off by [[setting/enable timetracking]]
