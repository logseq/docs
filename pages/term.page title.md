title:: custom page title
sample:: click me

- description:
	- the content displayed at the top of a page, used to uniquely identify the page
- produced by:
	- a page is automatically generated with a particular page title when a new page title is either
	- 1) entered into the Search or Create Page box at the upper-left of the Logseq window
	- 2) typed into a block within double brackets—[[new page]]—which makes it into a page reference.
- A page title is a property identified at the top of a file with the following syntax:
	- Markdown: **put as the first block of page**
		-
		  ``` markdown
		  title:: sample page title
		  
		  ```
	- Org mode:
		-
		  ``` org-mode
		  #+TITLE: sample page title
		  ```