type:: [[Feature]]
platforms:: [[All Platforms]]
description:: The Logseq Export feature allows users to export their data in various formats, including text, HTML, OPML, PNG, EDN, JSON, and standard Markdown. It supports exporting text selections, blocks, individual pages, or the entire graph with customizable options.

- ## Introduction
	- The Logseq export feature enables users to export selection, a single block or a page, or the entire graph into various formats, such as plain-text, OPML, HTML, or PNG. This feature is designed to enhance the user experience by providing a convenient way to share, backup, or migrate Logseq data to other platforms and applications.
	- Purpose and benefits include improving compatibility with other tools, simplifying data backup and sharing, and providing multiple export options to suit user requirements.
- ## Purpose and Benefits
	- **Cross-platform Compatibility**: The export feature allows for better integration with other tools by supporting common file formats such as plain text, OPML, HTML, EDN, JSON, and standard Markdown. This cross-platform compatibility makes it easier to migrate data or use your Logseq content in different applications.
	- **Data Backup**: The export feature provides an efficient way to create backups of your Logseq graph. Regular backups can help prevent data loss and ensure data integrity.
	- **Flexible Sharing Options**: Exporting allows you to share your Logseq content with others in a format they can easily view or import into other tools. It also enables you to present your content in various formats suitable for different contexts, such as exporting a block to an image.
	- **Customization**: The export feature offers numerous options to customize the exported content, such as defining the  scope of export {{cloze selection, a single block, a page, or the entire graph}}, choosing the export format, and selecting specific options related to each format. This flexibility allows users to tailor the export process to their specific needs.
- ## Export Scopes
	- **Export a [[Graph]]**: This option enables the export of all pages within the Logseq graph. To do so, navigate to the three-dot menu icon in the Logseq interface's top-right corner, select the *Export Graph* option from the dropdown menu, and then choose your preferred format.
	  logseq.order-list-type:: number
	- **Export a Single Page or a [[whiteboard]]**: This scope allows for exporting the content of an individual page. To use this option, open the page you intend to export, right-click the page title, and select the *Export* option from the context menu. You can then choose the desired format and options for the export.
	  logseq.order-list-type:: number
	- **Export a Single [[Block]]**: This option enables the export of a single block along with its nested blocks. To do this, right-click on the bullet point of the block you wish to export and select *Copy/Export as...* from the context menu. You can then select the desired format and options.
	  logseq.order-list-type:: number
	- **Export Selection**: This scope allows you to export the selected text or blocks. To use this feature, highlight the desired text or blocks, right-click on the selection, and choose *Copy/Export as...* from the context menu. You can then specify the desired format and options for the export.
	  logseq.order-list-type:: number
- ## Export Formats
	- ### Graph Export
	  Exports the entire graph in the following formats:
		- **EDN**: Export the graph in Extensible Data Notation format.
		- **JSON**: Export the graph in standard JSON format.
		- **Standard Markdown**: Export the graph in Standard Markdown format.
		  #+BEGIN_NOTE
		  Block [[properties]] will not be included in standard markdown exports.
		  #+END_NOTE
		- **OPML**: Export the graph in OPML format, suitable for various outlining and mind-mapping applications.
		- **Roam JSON**: Export the graph in Roam Research compatible format.
		- **HTML**:  Export the graph in HTML format.
	- ### Content-Specific Export
	  Exports a selection, block, page, or whiteboard. The following formats are available:
		- **Text**: Exports the content as plain text, maintaining the hierarchical structure of blocks and the bullet indentation.
		- **OPML**: Exports content in the OPML format.
		- **HTML**: Exports content in HTML format, preserving the original content's formatting and styles.
		- **PNG**: Captures the appearance of a page, selection, or a [[whiteboard]] as an image.
- ## Export Options
  Depending on the export format, several options are available:
	- #### Text, OPML, and HTML Options
		- **Removal of brackets**: Converts `[[page]]` into `page`.
		- **Removal of emphasis**: Strips emphasis formats such as **bold**, *italic*, or ~~strikethrough~~.
		- **Removal of #tags**: Removes #tags from the exported content.
		- **Block depth level**: Sets the maximum depth of nested blocks to include in the export. Options range from *all* to numbers 1-9.
	- #### Text-Specific Options
		- **Indentation style**: Selects the preferred indentation style. Options include dashes, spaces, or no-indent.
		- **Newline after block**: Adds a newline after each block.
		- **Removal of properties**: Excludes block properties from the export.
	- #### HTML-Specific Option
		- **Include properties**: Option to include block properties in the export.
	- #### PNG-Specific Option
		- **Transparent background**: This option removes the background color from the exported content, making it see-through.
	- After choosing the export format and options, users can *copy* the exported content to the clipboard or *save* it to a file.
- ## Configuration Options
  Logseq provides a range of configuration options and page properties to customize the export process, including settings at both the graph and page levels.
	- ### Graph-Level Configuration
		- #### [[Settings]] Menu
			- Under the *Editor* tab in the [[Settings]] menu, you will find the option "*Set pages to public by default*". When this setting is enabled (default), all pages within the graph will be considered public and included in the export unless the page's `public` property is explicitly set to `false`.
			- If this setting is disabled,  all pages will be private and not included in the export unless the page's `public` property is explicitly set to `true`.
			- This setting corresponds to the `:publishing/all-pages-public?` option in the [[config.edn]] file.
	- ### Page-Level Configuration
		- #### Public Page Property
			- The `public` page property is a boolean attribute that can be set for individual pages to determine their inclusion in an export. It overrides the default setting in the [[Settings]] menu. For example, if a page's `public` property is set to `true`, it will be included in the export even if the "*Set pages to public by default*" setting is disabled.
	- The interplay between the graph-level configuration and page-level properties can significantly affect the outcome of your export process. Therefore, reviewing these settings before performing an export is crucial to ensure they align with your specific needs.