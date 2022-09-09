alias:: page alias
example:: above is markdown example
type:: [[Feature]]

- description:
	- an alternate page ID or page title
	- page references with the alias will automatically redirect to the original page
	- TODO Describe alias limitations #docs
- produced by:
	- a page title can be given aliases by adding frontmatter(aka `first block of any page`) to the page properties
		- Markdown:
		  ``` markdown
		  alias:: page1, page2
		  ```
		- org-mode:
		  ``` org-mode
		  #+ALIAS: page1, page2
		  ```