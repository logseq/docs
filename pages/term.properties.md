type:: term
name:: i'm a page property
click:: click me to edit
id:: 60a78c12-4e12-4d81-a33f-9f63695aaf32

- description:
	- a user defined dictionary consists of multiple pairs key and value which is used to annotate a block or a page
	- page property should always be defined frontmatter (aka `first block of the page`)
	- when a property value match some page title, Logseq will automatically create link to that page
- produced by:
	- a page can have many pairs of properties as long as they're in first block of that page
	- each block can also have many pairs of properties (except for those first block, which will be served as page properties)
	- Markdown:
	  {{embed ((60ab6f5b-4bdc-4ef0-a0f8-6cad9dcad2b2))}}
	- org-mode:
	  {{embed ((60ab7357-2744-42bc-a8fd-a9c8db3051df))}}
- example:
	- I'm an apple block with below custom properties
	  color:: red
	  origin:: Spain
	  id:: 60a78e9e-59dc-40ab-9a01-5317dc09365f
	- this **first block** of this page serves an example for **page property**