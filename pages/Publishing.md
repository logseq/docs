type:: [[Feature]]
platforms:: [[Desktop]]
description:: This feature publishes a graph as a [[Publish Web]], single page application (SPA).

- ## Usage
	- [[Publishing (Desktop App Only)]] is a tutorial to publish your first graph.
	- An alternative to publishing from the menu is running the command `Export public graph pages as html`.
- ## Functionality
	- Publishing permissions are per page, depending on whether the page is "public".
		- By default no pages are public. Individual pages can be marked as public with the property `publish:: true`.
		- Alternatively, in [[Settings]] all pages can be made public by default and then the property `publish:: false` can be used to make specific pages private.
	- All published pages are displayed in a read-only mode.
	- Published apps can read user configuration from [[config.edn]], [[custom.css]] and [[export.css]]. [[custom.css]] and [[export.css]] are optional.
	- ### Available Features
	  id:: 63595c2e-2383-42d4-ad20-5647758a7337
	  collapsed:: true
		- Most features in a [[Publish Web]] app should work e.g. page [[Search]], block links and page links. Anything that involves editing won't work of course since the app is read-only.
		- query-table:: true
		  query-properties:: [:page :platforms :initial-version]
		  #+BEGIN_QUERY
		  {:title "These features are not available in a Publish Web App"
		   :query [:find (pull ?p [*])
		                :where
		                (page-property ?p :type "Feature")
		                (or
		                     ;; Hardcode not Publish Web values for now as not didn't work here
		                     (page-property ?p :platforms "Desktop")
		                     ;; All mentions of both of these in platform is to mention it as an exception
		                     ;; Can create a different property value if this becomes too cumbersome
		                     (and (page-property ?p :platforms "All Platforms")
		                              (page-property ?p :platforms "Publish Web")))]}
		  #+END_QUERY
		- Some features that aren't available do have workarounds. For example, applying a [[Custom theme]] is a common request. Since themes are plugins, they do not just work as plugins are [[Desktop]] only. You can workaround this with this example custom.css
		  ```css
		  // This uses the logseq-dev-theme but the url can be changed to any theme's github url
		  @import url("https://cdn.jsdelivr.net/gh/pengx17/logseq-dev-theme@main/custom.css");
		  ```
	- ### Available Urls
		- A [[Publish Web]] app's routes (urls) start with `/#/`. The most common routes are:
			- For pages - `/#/page/:NAME` e.g. https://docs.logseq.com/#/page/Contents
			- For heading blocks in a page - `/#/page/:NAME/block/:HEADING-CONTENT` e.g. https://docs.logseq.com/#/page/publishing/block/available%20urls
				- This allows for linking to headings in a page. The link is a case insensitive version of the first line of the heading content. For example, the heading title `## FAQ` is translated to `#/page/:NAME/block/faq`.
				- This behaves similarly to headings in a github markdown page e.g. https://github.com/logseq/logseq/blob/master/README.md#credits
			- For referenced blocks - `#/page/:BLOCK-ID` e.g. https://docs.logseq.com/#/page/60ab6f5b-4bdc-4ef0-a0f8-6cad9dcad2b2.
				- **Note**: This only works for _referenced_ blocks. If a block is not referenced elsewhere than its id is temporary and will change on a subsequent publish.
		- See [routes.cljs](https://github.com/logseq/logseq/blob/master/src/main/frontend/routes.cljs) for other possible routes.
- ## Additional Links
	- https://github.com/logseq/publish-spa - Github action and CLI to publish a graph as a SPA
	- https://github.com/pengx17/logseq-publish - Popular github action to publish a graph as a SPA
	- https://github.com/sawhney17/logseq-schrodinger - Plugin to export Logseq pages to Hugo