type:: [[Feature]]
platform:: [[Desktop]]
description:: Graphs can be published as a read-only single page web application. This application is referred to as a [[Publish Web]] app.

- ## Usage
	- [[Publishing (Desktop App Only)]] is a helpful tutorial to publishing your first graph.
	- An alternative to publishing from the menu is running the command `Export public graph pages as html`.
- ## Functionality
	- Publishing permissions are per page, depending on whether the page is "public".
		- By default no pages are public. In [[Settings]], this can be toggled to have all pages public.
		- Alternatively, individual pages can be marked as public with the property `publish:: true`.
	- All published pages are displayed in a read-only mode.
	- Published apps should read user configuration in [[config.edn]] and [[custom.css]].
	- Most features in a [[Publish Web]] app should work e.g. page [[Search]], block links and page links.
		- If you're unsure if a [[Feature]] supports [[Publish Web]] , check what platform value it has.
		- For example, [[Custom theme]] on a published app is common request. Since themes are plugins, they do not just work as plugins are [[Desktop]] only. You can workaround this with this example custom.css
		  ```css
		  // This uses the logse-dev-theme but the url can be changed to any theme's github url
		  @import url("https://cdn.jsdelivr.net/gh/pengx17/logseq-dev-theme@main/custom.css");
		  ```
- ## Additional Links
	- https://github.com/pengx17/logseq-publish - Popular approach to publishing graphs on github
	- https://github.com/sawhney17/logseq-schrodinger - Plugin to export Logseq pages to Hugo