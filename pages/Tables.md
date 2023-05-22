Tables in Logseq are our first versioned component, accepting props to control the output. The original version of tables, which supports multi-line markdown tables and query results, is version 1. A second verison is currently in beta testing, and can be activated by giving a markdown table or query element the prop: `logseq.table.version:: 2`

- ## Props
- Logseq tables now render differently depending on the block-level props. The default values for these props can also be set in your `config.edn` as top level keys.
- ### logseq.table.version
	- The `logseq.table.version` prop determines the version of the table. It can take one of two possible values:
		- `1` (default) - version 1 displays the standard table with no customizations
		- `2` - version 2 displays a table with dynamic widths to better fit content, with customizations available via props
- ### logseq.table.hover
	- The `logseq.table.hover` prop configures the hover effect of the table. It accepts the following values:
		- `cell` (default) - hovering over a cell will highlight just the cell you are interacting with
		- `row` - hovering over a cell will highlight the entire row of the cell you are interacting with
		- `col` - hovering over a cell will highlight the entire column of the cell you are interacting with
		- `both` - hovering over a cell will highlight the entire row and the entire column of the cell you are interacting with
		- `none` - hovering over a cell will not cause a change in visual appearance
- ### logseq.table.compact
	- The `logseq.table.compact` prop decides whether to show a compact version of the data. The possible values are:
		- `false` (default) - table data will be shown with standard padding for laid back consumption
		- `true` - table data will be shown with minimal padding to fit as much information on the screen as densely as possible
- ### logseq.table.headers
	- The `logseq.table.headers` prop adjusts the casing that should be applied to the header columns. You can set it to one of the following options:
		- `none` (default) - use the name of the column exactly as found in the source data
		  collapsed:: true
			- `exAMpLE header` becomes `exAMpLE header`
		- `uppercase` - transform the entire name of the column to uppercase letters
		  collapsed:: true
			- `exAMpLE header` becomes `EXAMPLE HEADER`
			  id:: 646bc966-3e91-4ce7-b17a-3446ea28a996
		- `capitalize` - transform the entire name of the column to have each word capitalized
		  collapsed:: true
			- `exAMpLE header` becomes `Example Header`
		- `capitalize-first` - transform the entire name of the column to lowercase letters, and capitalize only the first letter of the column name
		  collapsed:: true
			- `exAMpLE header` becomes `Example header`
		- `lowercase` - transform the entire name of the column to lowercase letters
		  collapsed:: true
			- `exAMpLE header` becomes `example header`
- ### logseq.table.borders
	- The `logseq.table.borders` prop allows you to define whether or not the table should have borders between all cells and rows. It can be either:
		- `true` (default) - show borders between all of the cells
		- `false` - do not show borders between any of the cells
- ### logseq.table.stripes
	- The `logseq.table.stripes` prop decides whether or not the table should have alternately colored table rows. The available options are:
		- `false` (default) - all rows will have a uniform background color
		- `true` - rows will have alternating background colors
- ### logseq.table.max-width
	- The `logseq.table.max-width` prop specifies the maximum width (in rems) that should be applied to each column. It accepts any number, with a default value of `30`.
		- `30` (default) - do not allow table columns to exceed 30 rems
		- `any number` - limit the maximum size of table columns to this many rems
- ### logseq.color
	- The `logseq.color` prop sets the color accent of the table. The following colors are available:
		- `crimson`
		- `red`
		- `tomato`
		- `orange`
		- `amber`
		- `green`
		- `grass`
		- `teal`
		- `blue`
		- `purple`
		- `indigo`
		- `violet`
		- `plum`
		- `pink`
		-