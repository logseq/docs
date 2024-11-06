## Description

This page describes changes for existing Logseq features on the [database version](https://github.com/logseq/logseq/pull/9858). Some of these changes may change depending on user feedback.

## Overview

* [Changes for All Graphs](#changes-for-all-graphs)
* [DB Graph Changes](#db-graph-changes)
* [File Graph Changes](#file-graph-changes)

## Changes for All Graphs

The following changes affect both file and the new db graphs:
* To simplify editor `/` commands, [Commands](https://docs.logseq.com/#/page/commands) and [Advanced Commands](https://docs.logseq.com/#/page/advanced%20commands) are merged together under `/`.
* A good amount of the UI is rewritten to use [shadcn](https://github.com/shadcn-ui/ui). This means a more beautiful, consistent and powerful UI!
* The application performance is better - loading faster and handling larger graphs. For DB graphs, our last performance test exercised 30k+ pages.
* On desktop, the graph cache directory `~/.logseq/graphs/` has moved to `~/logseq/graphs`. See [DB Graph Directories](#db-graph-directories) for how they are used for DB graphs.

## DB Graph Changes

High level changes:
* Blocks and pages are united as [nodes](./db-version.md#nodes). They are referenced as `[[]]` and blocks no longer use `(())` for referencing.
* Properties have a lot more functionality with the [new properties](./db-version.md#properties)!
* Previous tags should behave like before that an inline tag is entered using `Cmd-Enter`.
    * NOTE: Pressing enter on a `#` input triggers a powerful [new tags](./db-version.md#new-tags) feature.
* All blocks and pages have created-at and updated-at timestamps! With this built-in dimension of time, time powered features are possible.
*  The [previous tables](https://docs.logseq.com/#/page/tables) including version 2 are replaced by a shadcn based table. The new tables have inline editing like spreadsheets by default. See [here](./db-version.md#tables) for more.
* Flashcards have been re-implemented with [a new algorithm](https://github.com/open-spaced-repetition/free-spaced-repetition-scheduler). It isn't compatible with the previous flashcards so none of the properties and srs data from the previous version is imported.
* Markdown is the only supported format. Org mode file graphs will be able to convert to DB graphs.
* Zotero integration isn't planned to be a built-in feature and will hopefully be moved to a plugin.
* A few [Advanced Commands](https://docs.logseq.com/#/page/advanced%20commands) are available. More may become available as requested. The available commands are:
  * `>Query` is now `/Advanced Query`
  * `>Src` is now `/Code block`
  * `>Quote` is `/Quote`
* Code blocks, quote blocks and math blocks [have tags](./db-version.md#more-new-tags). Since properties are not are a part of the block content, properties can more naturally be added to these blocks.
* Pdf annotations [have a tag](./db-version.md#more-new-tags). This allows annotations to be viewed across pdfs and to have custom views of annotations while using the pdf viewer.

WIP changes:
* Query filters are likely to be changed.
* Whiteboards are disabled for now and will be enabled later.
* Exports to more formats including markdown.
* Sync and RTC will be enabled later.

Miscelleanous changes:
* Embedded pages and blocks look almost the same as other nodes. The main indicator of an embed will be an icon to the left of the block.
* Default date picker now has an input for typing a date in natural language.
* There is no re-index like in file graphs.
* For browsers, currently only one tab can be open. This is a limitation we hope to remove later.
* `All Pages` view can toggle between table and list view.
* Run the command `Customize appearance` to display a modal of appearance related settings.

### Changes by Feature

#### Pages
* Page properties are no longer set by using the first block of a page. Rather, a page property is [set the same way a block property is](./db-version.md#add-and-edit-property-values) - by editing from the page title (block content).
* `#` and `/` are disallowered characters for page names.

#### Tags
* Tags have [a lot of new functionality](./db-version.md#new-tags).
* When a tag is added on a block, it now displays to the right of the block. To inline a tag like before, press `Cmd-Enter` in the tag dropdown.

#### Tasks

* Using terms from the [previous tasks](https://docs.logseq.com/#/page/tasks), a task marker, priority and deadline are respectively now `Status`, `Priority` and `Deadline` properties on a task.
* [Scheduled](https://docs.logseq.com/#/page/tasks/block/deadline%20and%20scheduled) has been deprecated.
* Recurring tasks aren't ported and are a TODO.
* Logbook timestamps have been deprecated.
* Read more about the [new tasks](./db-version.md#tasks).

#### Assets
* Assets can have custom user properties.
* Assets are blocks and thus can show their linked references when zoomed in on the asset block.
* Assets are resized by hovering over them and then dragging the left-right arrows that are visible over the scrollbars.

#### Queries

* Read more about the [new queries](./db-version.md#queries).
* [Simple queries](https://docs.logseq.com/#/page/queries)
  * Simple queries are created via the `/Query` command and not the `{{query}}` macro This means that user macros cannot be used to create specialized queries.
  * Simple queries can now have titles.
  * Some old simple queries for tasks will no longer work and must be manually converted e.g. `(priority A)` -> `(priority high)`.
  * The `sort-by` query filter no longer exists. Sorting is done via the table component.
  * When using the query builder, the resulting query's text is not meant to be easily read as internal ids are used for some concepts e.g. properties.
* [Advanced queries](https://docs.logseq.com/#/page/advanced%20queries)
  * Advanced queries are now edited in a code block which means queries are syntax highlighted.
  * Some old advanced queries will no longer work and need to be rewritten. For engineers, see [this file](https://github.com/logseq/logseq/blob/feat/db/deps/db/src/logseq/db/frontend/schema.cljs) and compare `schema` with `schema-for-db-based-graph` to see what has changed.
  * These advanced query options are deprecated: :title, :group-by-page? and :collapsed?.
* Since block timestamps are available, they display in table view where possible.

#### Namespaces
* Creating namespaces through `/` in `[[]]` should work as before e.g. `[[foo/bar/baz]]` creates the hierarchy of `foo` > `bar` > `baz`. Unlike before, the reference will turn into `[[baz]]` after it is created.
* Namespaced pages no longer have their namespace embedded in their page name. The big advantage of this is that renaming any part of the namespace does not affect all the pages under a namespace.
* Pages can manage their namespace explicitly by using the `Parent` property. Previously managing a namespace could only be done by renaming a namespace. Using a property allows for easier management of namespace relationships.
* The `Hierarchy` section is called `Children` for DB graphs. It now displays as a collapsible tree as this allows for viewing large namespaces more easily.
* Children pages like `baz` above link back to its parent(namespace) with the `Parent` property.
* The macro `{{namespace}}` is TODO.

#### User Config

* A graph's config.edn, custom.js and custom.css files are only editable within Logseq from `Settings`.
* The following config.edn options are no longer used: `:block-hidden-properties, :favorites, :hidden, :ignored-page-references-keywords, :preferred-format, :preferred-workflow, :feature/enable-block-timestamps?, :file/name-format, :org-mode/insert-file-link?, :property/separated-by-commas, :property-pages/enabled?, :property-pages/excludelist`. See [this code](https://github.com/logseq/logseq/blob/043927031e11053a837d8289e3334368e6647bea/src/main/frontend/handler/common/config_edn.cljs#L89-L115) for more details.

#### DB Graph Directories

* Graphs have a convention of `~/logseq/graphs/GRAPH-NAME` where `GRAPH-NAME` is the graph name. 
* Inside a graph directory:
    * `db.sqlite` - Stores all your graph's data including user configs.
    * `assets/` - Stores assets like before.
* `logseq/` inside a directory no longer exists.
* It's still a TODO to sync markdown files to these graph directories.

## File Graph Changes

* There is no longer a [conversion feature for filename formats](https://docs.logseq.com/#/page/filename%20format)
* The attribute `:block/journal?` no longer exists. If used in an advanced query including in config.edn's `:default-queries`, change it to use `:block/type` e.g. `[?p :block/journal? true]` -> `[?p :block/type "journal"]`