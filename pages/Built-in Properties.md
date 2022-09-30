description:: There are built-in in properties that control Logseq functionality. Most of the these properties are hidden from the user but a few are user editable. These property names are reserved for Logseq and thus _must_ not be used as a user property.

- Legend for properties below:
  * (1) and (N) indicate how many values you may define, one and multiple values respectively.
  * (page) and (block) indicates a property is a page property or block property only. Otherwise a property can be both a page property and block property.
- Editable properties
	- `icon` (1) (page) - define icon identifier for a page.
	- `title` (1) (page) - overrides the title of a page to be different from the file name.
	- `tags` (N) - get listed in their own section "Pages tagged with X" below a page.
	- `template` (1) - designates a page/block as a template.
	- `template-including-parent` (1) - specifies whether the parent level content of the selected block should be included when using a template. previously called `include-parent`
	- `alias` (N) - define synonyms for a page.
	- `filters` (N) (page) - store selected filters for linked references on page-level. object with booleans
	- `public` (1) (page) - defines whether a page should be included in an export. boolean
	- `exclude-from-graph-view` (1) (page) - defines whether a page should be excluded in global graph view. boolean
- Hidden properties
	- `collapsed` (1) (block) - specifies whether a block is collapsed.
	- `id` (1) (block) - specifies a block id.
	- `created-at` (1) (block) - deprecated property that defines the created date/time stamps in [Unix time](https://en.wikipedia.org/wiki/Unix_time)
	- `updated-at` (1) (block) - deprecated property that defines the updated date/time stamps in [Unix time](https://en.wikipedia.org/wiki/Unix_time). previously `last-modified-at`
	- `query-table` (1) (block) - marks a query to be shown as the table view.
	- `query-properties` (N) (block) - properties user has chosen to see in query table.
	- `query-sort-by` (1) (block) - property by which to sort query table
	- `query-sort-desc` (1) (block) - property sort direction. boolean where true is descending
	- See `hidden-built-in-properties` in https://github.com/logseq/logseq/blob/master/deps/graph-parser/src/logseq/graph_parser/property.cljs for the full list.