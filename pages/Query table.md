title:: Query table
type:: [[UI Element]]
description:: Table that displays results from [[Queries]] or [[Advanced Queries]]

- ## Functionality
	- Results are sorted by clicking on a column header. Clicking on the column header to reverse the sort direction. Sort state is saved to the file.
		- **Note**: Sorting can be also be done in a query with the `sort-by` filter or with a result-transform. Sorting in a table takes precedence over sorting in a query.
	- To enable date sorting on values like `Aug 12th, 2022`, add the property and value `:logseq.query/nlp-date:: true` to the query block