type:: [[Feature]]
platforms:: [[All Platforms]]
description:: The Logseq Export feature allows users to export their data in various formats, including text, HTML, OPML, PNG, EDN, JSON, and standard Markdown. It supports exporting text selections, blocks, individual pages, or the entire graph with customizable options.

## Introduction
	- The Logseq export feature enables users to export selection, a single block or a page, or the entire graph into various formats, such as plain-text, OPML, HTML, or PNG. This feature is designed to enhance the user experience by providing a convenient way to share, backup, or migrate Logseq data to other platforms and applications.
	- Purpose and benefits include improving compatibility with other tools, simplifying data backup and sharing, and providing multiple export options to suit user requirements.
## Usage
	- ### Export scope
		- The export feature offers several methods to access and perform the export operation, allowing users to export content based on their specific needs:
			- **Export a Graph**: Export all pages within the Logseq graph. To export the graph, select the three-dot menu icon in the Logseq interface's top-right corner. From the dropdown menu, select the *Export Graph* option.
			  logseq.order-list-type:: number
			- **Export a Single Page**: Export the content of an individual page. Navigate to the page you intend to export, right-click the page title, and select the **Export Page** option from the context menu.
			  logseq.order-list-type:: number
			- **Export a single block**: Export a block along with its nested blocks. Right-click on a block bullet point and select *Copy/Export as..* from the context menu.
			  logseq.order-list-type:: number
			- **Export selection**: Export the selected text or blocks. Select the desired text or blocks, right-click on the selected content, and choose *Copy/Export as..* from the context menu.
			  logseq.order-list-type:: number
	- ### Export formats and options
		- #### Graph Export
			- **Export as EDN**: Exports the entire graph in the EDN (Extensible Data Notation) format.
			  logseq.order-list-type:: number
			- **Export as JSON**: Exports the entire graph in JSON format.
			  logseq.order-list-type:: number
			- **Export public pages**: Exports only the pages [marked as public](((645a932d-1f6e-423f-8000-23573b9ce02b))) in HTML format.
			  logseq.order-list-type:: number
			- **Export as standard Markdown**: Exports the graph as standard Markdown.
			  logseq.order-list-type:: number
			- **Export as OPML**: Exports the graph in OPML format. Suitable for importing into various outlining and mind-mapping applications.
			  logseq.order-list-type:: number
			- **Export as Roam JSON**: Exports the graph in a Roam Research compatible JSON format.
			  logseq.order-list-type:: number
		- #### Selection, Block, and Page Export
			- **Text**: Exports the content as plain-text, preserving the hierarchical structure of blocks and the configured bullet indentation. The associated options are:
			  logseq.order-list-type:: number
			  id:: 645ace19-afa5-46c6-8d02-7acd49be5947
				- `Indentation style`: Select the preferred indentation style. Options include dashes, spaces, or no-indent.
				- `Remove brackets`: Converts `[[page]]` into `page`.
				- `Remove emphasis`: Strip emphasis formats such as **bold**, *italic*, or ~~strikethrough~~.
				- `Remove #tags`: Remove tags from the exported content.
				- `Newline after block`: Add a newline after each block.
				- `Remove properties`: Exclude block properties from the export.
				- `Level`: Set the maximum depth of nested blocks to include in the export. Options range from 'all' to numbers 1-9.
			- **OPML**: Exports the content in OPML format. All the options for [Text](((645ace19-afa5-46c6-8d02-7acd49be5947))) are applicable here, except for `Indentation style` and `Newline after block`.
			  logseq.order-list-type:: number
			- **HTML**: Exports the content in HTML, retaining the formatting and styles of the original content. All the options for [Text](((645ace19-afa5-46c6-8d02-7acd49be5947))) apply here, except for `Indentation style`, `Newline after block`, and `Remove properties`.
			  logseq.order-list-type:: number
			- **PNG**: Captures the page's appearance or selection as an image. The associated option is `Transparency background`, a checkbox to create a transparent background for the image.
			  logseq.order-list-type:: number
			- The export dialog provides two options for handling the exported content: **Copy to Clipboard** or **Save to File**.
	- Builtin page property `public`:
	  id:: 645a932d-1f6e-423f-8000-23573b9ce02b
		- The `public` page property is a boolean attribute that determines a page's inclusion in an export. When not explicitly set, pages default to being public, meaning they will be included in the export process. To exclude a specific page from the export, assign `false` to the `public` property of that page.
		- On a broader level, you can control the public status of all pages in a graph from the [[Settings]] menu or by adjusting the `:publishing/all-pages-public?` value in the [[config.edn]] file. If this setting is enabled (set to `true`), all pages within the graph, irrespective of their individual `public` property, will be included in the export.