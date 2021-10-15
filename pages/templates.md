- You can make a block and its children as template for reuse purpose.
- For example, let's create a meeting note template block as below for reuse:
	- MEETING TITLE
	  author:: logseq
	  project:: to-be-filled
	  tag:: to-be-filled
	  template:: meeting
		- <%today%>
		- [[Meeting Tasks]]
			-
			-
			-
		- discussion
		- related notes of same project
		  {{query (property project change-me-later)}}
- There're two ways to make above block and its children as template:
	-
	  1. You can right click the block dot and click "Make template" to give it a name:
	  ![template.gif](../assets/template_1621928689810_0.gif)
	-
	  2. Or you can add [[term/properties]] of `template` with its name directly:
	  ![template2.gif](../assets/template2_1621928922947_0.gif)
- To use the template, simply type `/Template` command and choose the name of template:
  ![template3.gif](../assets/template3_1621929392325_0.gif)
- other resources to learn how to template:
	- [[Cobblebot]] contributed this wonderful [tutorial from forum](https://discuss.logseq.com/t/templates-how-to-create-edit-and-insert/200)
	- this great video from [[OneStutteringMind]] also shows how to use templates (note the property syntax in this video is no longer used, check [[term/properties]] for latest syntax)
	  {{youtube https://www.youtube.com/watch?v=l4keRsRFnuc}}
- [[Dynamic Variables]] support
  id:: 60311eda-b6f7-4779-8187-8830545b3a64
	- **Notice:** [[Macros]] support dynamic variables too
	- **Syntax:** `<% something %>`
	- **Supported variables:**
		- `today` => `[[Today's journal page]]`
		- `yesterday` => `[[Yesterday's journal page]]`
		- `tomorrow` => `[[Tomorrow's journal page]]`
		- `time` => `Current time`, e.g. 22:44
		- `current page` => `[[Current page]]`
		- [Natural language date](https://github.com/wanasit/chrono)
		  id:: 60312078-ae36-4395-bdfb-747304b80c03
		  `Last Friday` => `[[Feb 12th, 2021]]`
			-
			  #+BEGIN_QUOTE
			  - Today, Tomorrow, Yesterday, Last Friday, etc
			  - 17 August 2013 - 19 August 2013
			  - This Friday from 13:00 - 16.00
			  - 5 days ago
			  - 2 weeks from now
			  - Sat Aug 17 2013 18:40:39 GMT+0900 (JST)
			  - 2014-11-30T08:15:30-05:30
			  #+END_QUOTE
			  Examples from https://github.com/wanasit/chrono
- [:code "template-including-parent:: false"] is a template property to indicate whether to include the top level content of selected block template
	- example:
	  id:: 60a790f8-d187-499a-b2e2-73bf137356dd
		- i'm included by default in template-example-1
		  id:: 60a79104-bd2b-486c-bb9e-9d264650ce1f
		  template:: template-example-1
			- line1
				- line2
		- i'm not included because of including-parent setting
		  template:: template-example-2
		  template-including-parent:: false
			- line1
				- line2
