title:: Query table
type:: [[UI Element]]
description:: Table that displays results from [[Queries]] or [[Advanced Queries]]

- ## Functionality
	- In the upper right, there is a gear icon to select which columns are visible.
	- To the left of the gear icon, is an icon to toggle a view of results from table view to list view, blocks grouped by page.
	  *Note*: This icon is only visible for block queries as page queries can't have a list view.
	- Results are sorted by clicking on a column header. Clicking on the column header to reverse the sort direction. Sort state is saved to the file.
		- **Note**: Sorting can be also be done in a query with the `sort-by` filter or with a result-transform. Sorting in a table takes precedence over sorting in a query.
	- To enable date sorting on values like `Aug 12th, 2022`, add the property and value `:logseq.query/nlp-date:: true` to the query block