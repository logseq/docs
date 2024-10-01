## Description

This page describes DB (database) graph functionality as of Oct 1st. If you're an existing user of Logseq, you'll be interested in [changes with the db version](./db-version-changes.md).

NOTE: While there is an [automated backup](#automated-backup) for DB graphs, we recommend only using this for testing purposes.

## Overview

* [Nodes](#nodes)
* [Properties](#properties)
* [New Tags](#new-tags)
* [Tag Based Features](#tag-based-features)
  * [Tasks](#tasks)
  * [Journals](#journals)
  * [Queries](#queries)
  * [Cards](#cards)
* [Tables](#tables)
* [DB Graph Importer](#db-graph-importer)
* [Automated Backup](#automated-backup)

## Nodes

A node is a new term for a page or block because the two now behave similarly. Nodes have the following common behaviors:

* Nodes are referenced by using `[[]]`.
* Nodes have a pretty similar editing experience whether changing block content or a page title. In the editing block, properties can be set, `/` commands are available and [new tags](#new-tags) can be set.
* Nodes have `Linked References` and `Unlinked References` sections. Blocks need to be zoomed in to see this.
* Nodes can be favorited. For a zoomed in block, use the `Add to/remove from favorites` command.
* Nodes share the same keybindings for [properties](#property-shortcuts) and blocks e.g. toggling block properties visibility with `Cmd-;`.
* Nodes can be tagged to become a [tagged node](#tagged-node).
* Nodes are embedded with the same `/Node embed` command.
* Nodes are collapsible with an arrow on the left that appears on hover.

Blocks and pages still have some differences that we are hoping to unify like the block view when it is zoomed in.
However, blocks and pages will have some differences as noted in the [pages](#pages) and [blocks](#blocks) sections.

### Pages

Things that are specific to pages:
* Pages have a dedicated view called `All pages`.
* As seen on `All pages`, pages have different page types: `Page, Property, Tag, Journal and Whiteboard`. Think of these as directories on a file system.
* Pages are unique as follows:
  * Page names of type 'page' are unique by tag e.g. there can be `Apple #Company` and `Apple #Fruit`.
  * Property names are unique and can have the same names as built-in property names.
  * Page names of other types are unique for their page type e.g. there can be a `#Journal` and a Journal page.
  * The uniqueness of these pages should be visible everywhere in the app with icons for page types and the display of a page's tag(s).
* Hovering over a page title shows common features like `Set Property` to add a property to the page.

### Blocks

Things that are specific to blocks:
* Blocks are created in a page.
* Tagged blocks a.k.a. blocks with names do not have unique names.

## Properties

### Add and Edit Property Values

Properties can be added to any block or page.

To create your first property:
* Create a new block
* Press `Cmd-p` and type the name of a new property.
    * The keybinding is `Ctrl-alt-p` on Linux and Windows.
    * Alternatively, if your cursor is in the block, type `/pro<ENTER>` to kick off the same `Add new property` command
* Select `Text` as the property type and then type some property value

A property itself can have properties on its property page. By default the `Description` property is available for adding a description to a property.

### Property Shortcuts

* `Cmd-p` is useful for quickly adding properties to a block or a page. You can create or select existing properties from it. Keybinding is `Ctrl-Alt-p` on Linux and Windows.
* `Cmd-j` is useful for quickly editing block or page properties from the keyboard. After pressing `Cmd-j`, choose which property or property value by typing the letters in the bubble next to it e.g. `c` or `ab`.
* `p t` toggles displaying all the current node's properties below it. This is useful to quickly view properties that are hidden or in a different position.
* `p i` opens the icon picker to set an icon for the current node.
* See [task shortcuts](#task-shortcuts) for task specific ones.

NOTE: Most shortcuts have a corresponding search command. You can find the command for a given shortcut's keys keybinding by using `Settings > Keymap`, clicking the keystroke filter and typing the keys.

### Configure a Property

Properties are configurable wherever they are used by clicking on its name to display a dropdown menu. Press `Cmd` and click to navigate to a property page. Property icons are set by clicking on the property's default icon to the left of its name. Properties can also be configured by navigating to their page with [Search](https://docs.logseq.com/#/page/search) and then clicking on the `Configure property` link below its name.

Property fields in the dropdown menu:

* `Name`: Name to visually identify the property
* `Property type`: This determines what type a property's property values will have. Once a property is used this field cannot change. If you're unsure of what type to choose, use `Text`. See [property-types](#property-types) for more.
* `Available choices`: This limits a property to only have one of the defined choices. See [property choices](#property-choices) for more.
* `Multiple values`: When selected, a property can have multiple values associated with it. All property types can have multiple values except for checkbox.
* `UI position`: This determines where the property values are displayed. By default the values are displayed as a row-like block under a block (`Block properties`). You can also choose to display property values at the beginning like task status, under a block like deadline date, or at the end of a block.
* `Hide by default`: When selected, a property won't be visible on any of its blocks by default. But it will be visible if you zoom in on its blocks or display them in the sidebar.

### Built-in Properties

Logseq uses built-in properties to provide core features. A few of these properties are public and editable by the user. To navigate to a public built-in property use [Search](https://docs.logseq.com/#/page/search). For example, type `status` to go to the `Status` property used by [tasks](#tasks). When on a built-in property page, only some of its property fields are editable as allowing all fields to be edited could break functionality. The property fields that can be edited are its icon, `UI position`, `Hide by default` and `Available choices`.

### Property Types

A property type determines what type a property's property values can have. There are 6 types of property values: Text, Number, Date, Checkbox, Url, and Node. Here is more info on each:

* `Text`: This is the recommended default as it allows for any text and behaves like a block. This means that node references work here and children blocks can be created under the block.
* `Number`: This is for numbers including negative numbers and floats e.g. 3.5. Unlike file graph properties, these are stored as actual numbers. This means that all features and queries that use this property type correctly sort as numbers by default.
* `Date`: This is for dates and is editable with a date picker. When a date property value is used, it correctly links to the journal page.
* `DateTime`: This is for date times and is editable with a datetime picker. See the `Due` property in [cards](#cards) for an example property that uses this.
* `Checkbox`: This is used to set or unset a property value and displays as a checkbox. To engineers this type is known as a boolean.
* `Url`: This limits text to only allow urls e.g. `https://logseq.com`. This does not behave like `Text` e.g. no referencing or child blocks.
* `Node`: This allows a property value to link to other nodes i.e. pages or blocks. When first configuring this, you are prompted to select a new tag. You can choose to skip a tag if you don't care about limiting the available nodes. When a tag is selected or created, only nodes with that tag will appear as options for the property. For example, if you define the property `Author`, you could create a new tag `#Person` that only allows nodes tagged with `#Person` as values. Also worth noting that tag selection works for all child tags of the chosen new tag. Using the previous example, if `#Actor` is a child of `#Person`, nodes tagged with `#Person` or `#Actor` are allowed values.

### Property Choices

Property choices allow a property to only have one of the defined choices. Only the property types `Text`, `Url` and `Number` support this. From the [configuration dropdown](#configure-a-property), a property choice can be added, deleted and edited to have a required value, an optional description and an optional icon. Drag the choices up and down to order how they appear. For a good example of choices see the `Status` property.

If a property has already been used, it is possible to convert it to use choices. After clicking `Add choice`, a panel displays to convert all existing property values to choices. If a property is using choices, it is possible to stop using choices by deleting them from the property. Caution: deleting a choice from a property also currently deletes the choice from all blocks it is used.

## New Tags

NOTE: New tags are currently labeled as tags in the app and should be backwards compatible with the previous tags. These `new tags` are also known as classes, types or supertags. Feedback is welcome on names for `new tags`.

To create your first new tag:
* Open [Search](https://docs.logseq.com/#/page/search) and type `#NAME` where NAME is new tag name.
* A dialog pops up that lets you create and/or add tag properties to the new tag. These tag properties are inherited by every node that uses the new tag.

For example, say we created a new tag `Person` and added `lastName` and `birthday` tag properties to it. Now when `#Person` is added to a block or page, those two properties automatically display and are editable for them. A powerful thing about new tags is that when its tag properties change those changes immediately show up on all [tagged nodes](#tagged-node).

A new tag can have properties on its own page. By default the `Description` property is available for adding a description and `Hide from node` is available to hide the new tag on tagged nodes that float to the far right.

### Create Tags

Ways to create tags:
* Open search and type `#NAME` where `NAME` is the new tag name.
* In any block including a page name, type `#NAME` and press `Enter`. The tag floats to the right of the block.
* In a block type `#NAME` and press `Cmd-Enter`. An inline tag is created.
* Paste text in a block that includes `#NAME`. An inline tag is created for tag `NAME`.
* Configure a `Node` property type to have a new tag config.
* Configure a new tag to have a `Parent`, the new `Parent` value becomes a tag.
* In a block type `#NAME` and press `Esc`. An inline tag is created. Not recommended as it doesn't work for all use cases.

### Parent Tags

New tags can have a parent tag, defaulting to `Root Tag` when none is specified. Allowing new tags to be related to each other as a parent to child is useful as it allows tags to organized in a hierarchy. This is similar to directories on your computer. When a new tag is used as a parent, you can see the tag hierarchy under it by navigating to the tag's page and seeing a `Children` section.

A powerful feature of using a parent tag is that the new tag inherits the properties from its parent. For example, if we created a new `#Actor`, made its parent `#Person` from above and gave it an additional `actedIn` property. `#Actor` would display 3 properties when used, with two coming from the parent: `lastName`, `birthday` and `actedIn`.

### Configure a New Tag

New tags are configurable from their page. Navigate to their page by using [Search](https://docs.logseq.com/#/page/search) or clicking on their `#` name links. On their page below their title, two important properties display by default and are editable:

* `Parent`: Use this to allow the class to inherit the parent classes properties. By default the parent tag is the `Root Tag` which doesn't have any properties.
* `Tag Properties`: These tag properties are inherited by every node that uses the new tag. Drag one above or below the other to sort them. These properties will then display sorted on the tagged node.
  * To the right of each tag property there is an optional block for describing the property. This description also shows up on the property's page.

### Tagged Node

A tagged node is a page or block that has a new tag. A tagged node is also known as an object or a new tag instance. There are a couple of ways to create tagged nodes:
* In the current block or page title, type `#` at the end and select a new tag.
* In [Search](https://docs.logseq.com/#/page/search), type `PAGE #TAG` to create a page named `PAGE` with new tag `TAG`.
* In a block after `[[]]`, type `#` and select a new tag. For example `[[block content]]#TAG` links to the block with `block content` and adds `#TAG`. For existing references, a new tag is added to the node. For new references, a new page is created with the new tag.

A tagged node can have multiple new tags. Once a node is tagged it displays all tags' properties as empty off the node in positions configured by each property. The only properties that don't display are ones hidden via `Hide by default`.

A tagged node can have an icon. When it does have an icon, it will appear to the left of its name or in a reference.

## Tag Based Features

The features in this section use [new tags](#new-tags). Each of these features have built-in [tables](#tables) (dashboards) to view and manage them on their tag page!

### Tasks

Tasks are improved from the previous version as they more powerful and customizable. All tasks are blocks with the built-in new tag `#Task`. When a task is created it has the properties status, priority and deadline.

#### Create a Task

A new task can be created in a number of ways:
* Set the status of a block by typing the status choice e.g. `/todo` or cyling status with `Cmd-Enter`.
* Type text in a block and end it with `#Task`.
* When on the `Task` page, create a new row in the Task table.

#### Task Shortcuts

Any block can have a task property value set with a command or a keybinding. The commands start with `Add task` and the keybindings are:

* To set property `status`, press `p s`.
* To set property `priority`, press `p p`.
* To set property `deadline`, press `p d`.

The statuses `Todo`, `Doing` and `Done` can be cycled through with `Cmd-Enter`.

The `/STATUS` commands can set a status where `STATUS` is one of the status choices e.g. `/todo`. Similarly, priority choices can be set with `/PRIORITY` commands. `/Deadline` sets the deadline property.

#### Task Status

The status property is probably the most often used task property and thus it has been simplified and made customizable. The `TODO/DOING` and `NOW/LATER` workflows have been merged into `TODO/DOING` and some of the other TODO keywords have been converted to built-in status values. The default built-in values for status are:

* `Backlog`
* `Todo`
* `Doing`
* `In Review`
* `Done`
* `Canceled`

#### Customizing Tasks

Since tasks are powered by properties and [new tags](#new-tags), they can be customized in a number of ways. Some parts of a task can't be customized because tasks are built into core features like the [Query Builder](https://docs.logseq.com/#/page/query%20builder) and queries on today's journal. Here are ways to customize tasks:

1. The `Status` property choices can be customized by going to the `Status` page with [Search](https://docs.logseq.com/#/page/search). From the property's [configuration dropdown](#configure-a-property) edit the name and icon of built-in choices. You can add new choices but not delete the built-in ones.
2. Task properties can be configured by going to the property's page. From this page you can configure its icon or the ui position via the [configuration dropdown](#configure-a-property).
3. `#Task` can be configured to have additional properties from the new tag's [page](#configure-a-new-tag).
4. Custom types of tasks can be created by creating a new tag that has `#Task` as the [parent tag](#parent-tags). For example, create a `#ProjectTask` from [Search](https://docs.logseq.com/#/page/search) and configure it to have `Task` as the parent. Then add a property on the `project` property on `#ProjectTask`. You now have a task for projects!

### Journals

A journal page has the [new tag](#new-tags) `#Journal`. Like tasks, journals can be customized by adding properties to its tag. For example, navigate to the `#Journal` page and add a property. This property now shows up on all journals!

Journals are automatically created for the current day in the Journals view. There are a couple of ways to create a journal:
* Natural language that autocompletes within `[[]]` can reference specific days e.g. `[[Today]]`. A specific day this week, last week or next week can be described e.g. `[[This Friday]]`, `[[Last Friday]]` or `[[Next Friday]]`.
* Use the `/Date picker` command to insert a specific date. The date picker is keyboard friendly as arrow keys change calendar days and `Tab` focuses the input. The input takes natural language e.g. `next week` and converts it to a date. See [the library we use](https://github.com/wanasit/chrono#readme) for other natural language examples.
* Properties with the :date property type e.g. `Deadline` create journals for their property values.
* When on a journal day, create a journal for the next day or previous day by using the keybindings `g n` or `g p` respectively.

### Queries

A [query](https://docs.logseq.com/#/page/queries) and [advanced query](https://docs.logseq.com/#/page/advanced%20queries) have the [new tag](#new-tags) `#Query`. Queries are created in one of the following ways:
* Type the `/Query` command to create a query through the [query builder](https://docs.logseq.com/#/page/query%20builder).
* Type a simple query in a block and then type the `/Query` command to run the query.
* Type the `/Advanced Query` command to create an advanced query.

Like other new tags, go to the `#Query` page to see a table to manage queries. Query results are displayed with the new [tables](#tables).

### Cards

A [(flash)card](https://docs.logseq.com/#/page/flashcards) has the new tag `#Card`. This feature has been re-implemented to use a [new algorithm](https://github.com/open-spaced-repetition/free-spaced-repetition-scheduler).

#### Create Cards
* Tag blocks with `#Card` to create new cards.
* To convert multiple blocks into cards at once, select them, right-click and choose `Make a flashcard`.

#### View Cards
All cards are accessible on the `#Card` page within the tagged-nodes table.
The `Due` column indicates when the next review is scheduled.

#### Review Cards

Select `Flashcards` from the left sidebar to view all cards due for review.
You can rate them using 4 levels to arrange their next review date.

## Tables

A table displays a group of nodes as rows and a node's properties as columns. A table behaves like a spreadsheet as table cells are editable by default. A node has the following special columns which are available by default: `Name`, `Created At` and `Updated At`. Tables have the following features:
* Sort rows by any column, ascending or descending.
* Filter rows by multiple columns by clicking on the filter icon. For columns with a specific property type e.g. :number and :date, there are specific filters for that type.
* Hide columns by clicking on the three dots menu and selecting `Columns visibility`.
* Drag columns to sort their order.
* Switch between `Table View` and `List View` by selecting one in the table's header. The `List View` displays nodes in an outliner with nodes grouped by pages.
* Resize columns by dragging the resize handle at a column header's border.
* Click on the magnifying glass icon to live search a table. This is the only feature that doesn't persist when switching away from a table.

A powerful new feature of tables is the ability to create a table view. This is currently enabled for tag pages. To use it, click the `+` icon in the upper left to create a new tab in the table. Click on the tab's header to rename or delete this new view. Within this view, all of the above persisting features will save!

Tables are currently found on new tag pages, property pages, query results and the `All Pages` view.

## DB Graph Importer

The DB Graph Importer converts a file graph to a DB graph. Currently it imports markdown files and assets like images. Import of org mode files will be added later. For blocks the importer converts all uses of [new tags](#new-tags) to [page references](https://docs.logseq.com/#/page/term%2Fpage%20reference) because ~~tags are now used for new tag features while page references handle inline referencing functionality~~ this behavior is still WIP. For pages the importer imports the previous tags to a `Page Tags` property. If you'd like some previous tags to behave like new tags, you can specify them in the first optional input. Using this option also results in those converted tags not being imported as `Page Tags`. The importer also provides two options to convert property related pages to new tags.

All tasks are imported as new [tasks](#tasks). Some task statuses have been remapped to avoid duplicates e.g. `TODO` and `LATER`. The following statuses have been remapped:

* `LATER` -> `Todo`
* `IN-PROGRESS` and `NOW` -> `Doing`
* `WAIT` and `WAITING` -> `Backlog`

### Convert File Graph to DB graph

* Click on the three dots menu in the upper right corner and select `Import`.
* Click on the `File to DB graph` button.
* This brings up a dialog. For larger graphs it takes longer for the dialog to display.
* The dialog requires you to input a name for your graph. On desktop this new graph will be located under `~/logseq/graphs/GRAPH-NAME` so it is ok to give it the same name it currently has.
* The dialog has the following optional inputs:
    1. `Tags to import ...` - This input converts any of your old tags to the [new tags](#new-tags). This is helpful if you've been using a particular tag like a new tag. You can also convert pages later by right clicking on a page's name.
    2. `Properties whose values are imported as new tags` - This input converts property values for the specified property to the new tags. For example, in the official docs graph the [type property](https://docs.logseq.com/#/page/type) is used this way. This means that all `type` property values like [Feature](https://docs.logseq.com/#/page/feature) on [this page](https://docs.logseq.com/#/page/code%20block) would get converted to the new tag.
    3. `Properties whose values are imported as parents of ...` - This input converts property values for the specified property to be [a parent of a new tag](#parent-tags). For example, in the official docs graph the [parent property](https://docs.logseq.com/#/page/parent) is used this way. This means that all `parent` property values like [Thing](https://docs.logseq.com/#/page/thing) on [this page](https://docs.logseq.com/#/page/feature) would get converted to the new tag.

## Automated Backup

An automated backup of graphs is available by clicking on the upper right three dots menu and selecting `Export Graph`. Within this modal, you can specify a folder to save backups. A backup folder can be reused across graphs as each graph gets its own folder within a backup folder. After choosing this folder, hourly backups begin. The last 12 backups are saved. This backup feature is currently only for the browser.