type:: [[Feature]]
alias:: Todos
platforms:: [[All Platforms]]

- ## Usage
	- Logseq comes with two built-in flavors to mark your block with built-in workflow mark keywords and manage your tasks:
	  + `LATER` -> `NOW` -> `DONE` flavor (default)
	  + `TODO` -> `DOING` -> `DONE` flavor 
	  + You can toggle between those two flavors in setting page
	- There are two ways to attach workflow mark to your task(block)
		- when editing the block, press `Ctrl/Cmd+enter` to cycle through the workflow mark
		- type these mark as command directly, eg `/LATER` `/NOW` `/DONE` `/TODO` etc..
		- Some examples:
		  todo:: 1621908710666
			- LATER do grocery
			- NOW play with Logseq
			- DONE watch Doctor Who
- ## Functionality
	- ### Priorities
		- Logseq comes with three built-in priority mark to help you manage with task priorities
			- {{embed ((60ac5b08-d4bb-49de-b415-e63fcf29c59f)) }}
			- Example:
				- LATER [#A] research balalah is a top priority
				- LATER [#C] do grocery has lowest priority
	- ### Deadline and Scheduled
		- You can leverage command `/Deadline` to setup a deadline for any block
			- eg: finish reading 1984 by 29th of May
			  DEADLINE: <2021-05-29 Sat>
		- You can leverage command `/Scheduled` to setup a schedule for a block
			- eg: send John a birthday card Monday
			  SCHEDULED: <2021-05-31 Mon>
		- Both of the above commands work on blocks, not just tasks.
		- Both of the above commands default to displaying blocks that are coming up soon. You can configure how soon with `:scheduled/future-days`  in [[config.edn]].
		- Both of above commands support to mark the task as repeated:
		  after typing the command and click `Add repeater` in the date picker
			- eg: daily exercise routine at 7am
			  SCHEDULED: <2021-05-26 Wed 7:00 .+1d>
	- ### Time tracker
	  id:: 60af74c1-62f8-434a-827c-abc6d2a71734
		- {{embed ((60acdeba-b3fd-4f90-ab54-3093caa4d5fa))}}
		- you can toggle this off by [[setting/enable timetracking]]