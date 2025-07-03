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
* The application performance is better - loading faster, handling larger graphs and large tables. See https://github.com/logseq/logseq/pull/11774 for latest details.
* On desktop, the graph cache directory `~/.logseq/graphs/` has moved to `~/logseq/graphs`. See [DB Graph Directories](#db-graph-directories) for how they are used for DB graphs.
* Plugins can be used from the web. For security reasons only [plugins configured with no "effect"](https://github.com/logseq/marketplace#how-to-submit-your-plugin) are usable. We will gradually open up effect plugins to certified/trustworthy plugins.
* On browser, multiple tabs can be opened and kept in sync, even when offline. Syncing between tabs _does not_ require a sync server.
* The visibility of left sidebar items are configurable. To configure, hover over the `Navigations` header and click on the filter icon to open a dropdown for toggling visibility of sidebar items.

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
* Markdown syntax for blocks e.g. a heading or quote is no longer visible or editable. Removing a block's heading is done by right-click on a block and choosing the crossed out H icon.
* Slides have been removed as a feature and we can support it as 3rd party plugin.

WIP changes:
* RTC a.k.a. DB version sync will be enabled later.
* Add back support for dynamic variables.
* Whiteboards are disabled for now and will be enabled later.

Miscelleanous changes:
* Scripts using [nbb-logseq](https://github.com/logseq/nbb-logseq) can read and write graphs. Previously with file graphs, scripts could only read graphs.
* Embedded pages and blocks look almost the same as other nodes. The main indicator of an embed will be an icon to the left of the block.
* Default date picker now has an input for typing a date in natural language.
* There is no re-index like in file graphs.
* For browsers, currently only one tab can be open. This is a limitation we hope to remove later.
* `All Pages` screen is renamed to `Pages`. Also it can toggle between table and list view.
* New commands:
  * Run the command `Customize appearance` to display a modal of appearance related settings.
  * Commands from [property shortcuts](./db-version#property-shortcuts).
  * Commands from [edn data export](./db-version.md#edn-data-export).
  * For developers, there are `Validate current graph` and `Garbage collect graph` commands.

### Changes by Feature

#### Pages
* Page properties are no longer set by using the first block of a page. Rather, a page property is [set the same way a block property is](./db-version.md#add-and-edit-property-values) - by editing from the page title (block content).
* `#` and `/` are disallowered characters for page names.

#### Tags
* Tags have [a lot of new functionality](./db-version.md#new-tags).
* When a tag is added on a block, it now displays to the right of the block. To inline a tag like before, press `Cmd-Enter` in the tag dropdown.

#### Tasks

* Using terms from the [previous tasks](https://docs.logseq.com/#/page/tasks), a task marker, priority, deadline and scheduled are respectively now `Status`, `Priority`, `Deadline` and `Scheduled` properties on a task.
* Logbook timestamps have been replaced with Status change history.
* Tasks are no longer created by typing keywords like `TODO` but instead with commands like '/todo'.
* Read more about the [new tasks](./db-version.md#tasks).

#### Assets
* Assets can have custom user properties.
* Assets are blocks and thus can show their linked references when zoomed in on the asset block.
* Assets are resized by hovering over them and then dragging the left-right arrows that are visible over the scrollbars.
* Pdf annotations are visible under an asset block by default. Previously this view was in a separate page and required clicking in the pdf viewer.

#### Queries

* Read more about the [new queries](./db-version.md#queries).
* [Simple queries](https://docs.logseq.com/#/page/queries)
  * Simple queries are created via the `/Query` command and not the `{{query}}` macro. This means that user macros cannot be used to create specialized queries.
  * Simple queries can have titles.
  * When using the query builder, the resulting query's text is not meant to be easily read as internal ids are used for some concepts e.g. properties.
  * The query builder's queries run against all [nodes](./db-version.md#nodes) instead of forcing the user to choose between blocks or pages.
  * Query filter changes:
    * These previous query filters will no longer work and should be manually converted:
      * `(page-tags)` -> `(tags)`
      * `(page-property)` -> `(property)`
      * `(priority A)` -> `(priority high)`
    * The `all-page-tags` and `sort-by` query filters no longer exists. Sorting is done via the table component.
* [Advanced queries](https://docs.logseq.com/#/page/advanced%20queries)
  * Advanced queries are now edited in a code block which means queries are syntax highlighted.
  * Some old advanced queries will no longer work and need to be rewritten. For engineers, compare the [db graph `schema`](https://github.com/logseq/logseq/blob/feat/db/deps/db/src/logseq/db/frontend/schema.cljs) vs the [file graph `schema`](https://github.com/logseq/logseq/blob/feat/db/deps/db/src/logseq/db/file_based/schema.cljs).
  * The attribute `:block/content` was renamed to `:block/title`. If used in an advanced query including in config.edn's `:default-queries`, change it to use `:block/title` e.g. `[?b :block/content "content"]` -> `[?b :block/title "content"]`
  * The task related properties `:block/marker`, `:block/priority`, `:block/deadline` and `:block/scheduled` have been respectively renamed to `:logseq.property/status`, `:logseq.property/priority`, `:logseq.property/deadline` and `:logseq.property/scheduled`. These properties should be queried via rules like `property` e.g. `(property :logseq.property/deadline ...)`.
  * These advanced query options are deprecated: :title, :group-by-page? and :collapsed?.
* Since block timestamps are available, they display in table view where possible.

#### Namespaces
* Creating namespaces through `/` in `[[]]` should work as before e.g. `[[foo/bar/baz]]` creates the hierarchy of `foo` > `bar` > `baz`. Unlike before, the reference will turn into `[[baz]]` after it is created.
* Pages can edit their namespace explicitly by going to the `Library` page and moving it under the desired parent namespace. Previously managing a namespace could only be done by renaming a namespace.
* The `Hierarchy` section displays above a namespaced page's blocks. It displays as a collapsible tree as this allows for viewing large namespaces more easily.
* Namespaced pages no longer have their namespace embedded in their page name. The big advantage of this is that renaming any part of the namespace does not affect all the pages under a namespace.
* The macro `{{namespace}}` is deprecated. Use the Library feature instead.

#### User Config

* A graph's config.edn, custom.js and custom.css files are only editable within Logseq from `Settings`.
* The following config.edn options are no longer used by any graphs: `:ref/linked-references-collapsed-threshold`.
* The following config.edn options are no longer used: `:block-hidden-properties, :default-templates, :favorites, :hidden, :ignored-page-references-keywords, :journals-directory, :pages-directory, :preferred-format, :preferred-workflow, :whiteboards-directory, :feature/enable-block-timestamps?, :file/name-format, :file-sync/ignore-files, :journal/file-name-format, :journal/page-title-format, :logbook/settings, :org-mode/insert-file-link?, :property/separated-by-commas, :property-pages/enabled?, :property-pages/excludelist, :srs/initial-interval, :srs/learning-fraction` in DB graphs. See [this code](https://github.com/logseq/logseq/blob/b0a255f96bfd512d5b87acca52c8d9f958c6a593/deps/common/src/logseq/common/config.cljs#L124-L157) for more details.

#### Search
* When search modal first opens, recently updated pages display at the top.
* Tags can be created from the modal as described in [new tags](./db-version.md#new-tags).

#### DB Graph Directories

* Graphs have a convention of `~/logseq/graphs/GRAPH-NAME` where `GRAPH-NAME` is the graph name.
* Inside a graph directory:
    * `db.sqlite` - Stores all your graph's data including user configs.
    * `assets/` - Stores assets like before.
* `logseq/` inside a directory no longer exists.

## File Graph Changes

* File graphs are no longer supported in browser.
* There is no longer a [conversion feature for filename formats](https://docs.logseq.com/#/page/filename%20format)
* Attribute changes:
  * The attribute `:block/content` was renamed to `:block/title`. If used in an advanced query including in config.edn's `:default-queries`, change it to use `:block/title` e.g. `[?b :block/content "content"]` -> `[?b :block/title "content"]`
  * The attribute `:block/original-name` was renamed to `:block/title`. If used in an advanced query including in config.edn's `:default-queries`, change it to use `:block/title` e.g. `[?b :block/original-name "name"]` -> `[?b :block/title "name"]`
  * The attribute `:block/journal?` no longer exists. If used in an advanced query including in config.edn's `:default-queries`, change it to use `:block/type` e.g. `[?p :block/journal? true]` -> `[?p :block/type "journal"]`
  * The attribute `:block/left` no longer exists and has been replaced by `:block/order`. It is not recommended to write queries with this attribute.
