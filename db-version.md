## Description

This page describes DB (database) graph functionality as of April 30th. See [here](https://test.logseq.com/#/) to try the latest stable version. If you're an existing user of Logseq, you'll be interested in [changes with the db version](./db-version-changes.md).

NOTE: While there is an [automated backup](#automated-backup) for DB graphs, we recommend only using DB graphs for testing purposes.

## Overview

* [Nodes](#nodes)
* [Properties](#properties)
* [New Tags](#new-tags)
* [Tag Based Features](#tag-based-features)
  * [Tasks](#tasks)
  * [Journals](#journals)
  * [Queries](#queries)
  * [Cards](#cards)
  * [Assets](#assets)
  * [Templates](#templates)
  * [More New Tags](#more-new-tags)
* [Bulk Actions](#bulk-actions)
* [Views](#views)
  * [Tables](#tables)
* [DB Graph Importer](#db-graph-importer)
* [Automated Backup](#automated-backup)
* [Export and Import](#export-and-import)
  * [Graph Export](#graph-export)
  * [Graph Import](#graph-import)
  * [EDN Data Export](#edn-data-export)
* [Scripting](#scripting)
* [Additional Links](#additional-links)

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
* When a property, new tag, journal or whiteboard are created, they are created as a page.
* Pages are unique as follows:
  * Page names are unique by tag e.g. there can be `Apple #Company` and `Apple #Fruit`.
  * Property names are unique and can have the same names as built-in property names.
  * The uniqueness of these pages should be visible everywhere in the app with icons for page types and the display of a page's tag(s).
* Hovering over a page title shows common features like `Set page property` to add a property to the page.

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
* To navigate between property values across nodes, use the up and down arrow keys.

NOTE: Most shortcuts have a corresponding search command. You can find the command for a given shortcut's keys keybinding by using `Settings > Keymap`, clicking the keystroke filter and typing the keys.

### Configure a Property

Properties are configurable wherever they are used by clicking on its name to display a dropdown menu. Press `Cmd` and click to navigate to a property page. Property icons are set by clicking on the property's default icon to the left of its name. Properties can also be configured by navigating to their page with [Search](https://docs.logseq.com/#/page/search) and then clicking on the `Configure property` button below its name.

Property fields in the dropdown menu:

* `Name`: Name to visually identify the property
* `Property type`: This determines what type a property's property values will have. Once a property is used this field cannot change. If you're unsure of what type to choose, use `Text`. See [property-types](#property-types) for more.
* `Default value`: This sets the default value for a property. See [property-default-values](#property-default-values) for more.
* `Available choices`: This limits a property to only have one of the defined choices. See [property choices](#property-choices) for more.
* `Checkbox state mapping`: For properties that have [property choices](#property-choices), this defines mapping two choices to be checked or unchecked on a checkbox. To enable seeing the checkbox, configure the `Show as checkbox on ...` field.
* `Multiple values`: When selected, a property can have multiple values associated with it. All property types can have multiple values except for checkbox and datetime.
* `UI position`: This determines where the property values are displayed. By default the values are displayed as a row-like block under a block (`Block properties`). You can also choose to display property values at the beginning like task status, under a block like deadline date, or at the end of a block.
* `Hide by default`: When selected, a property won't be visible on any of its blocks by default. But it will be visible if you zoom in on its blocks or display them in the sidebar.
* `Hide empty value`: When selected, a property won't be visible on a block if it is has an empty property value.

Some property fields are only configurable from certain contexts:
* `Show as checkbox on ...`: This appears when clicked from a node or from a tag's `Tag properties`. When selected, a checkbox will show on that node or any node with that tag respectively. For this to take affect, the property must have configured `Checkbox state mapping`.

### Built-in Properties

Logseq uses built-in properties to provide core features. A few of these properties are public and editable by the user. To navigate to a public built-in property use [Search](https://docs.logseq.com/#/page/search). For example, type `status` to go to the `Status` property used by [tasks](#tasks). When on a built-in property page, only some of its property fields are editable as allowing all fields to be edited could break functionality. The property fields that can be edited are its icon, `UI position`, `Hide by default` and `Available choices`.

### Property Types

A property type determines what type a property's property values can have. There are 6 types of property values: Text, Number, Date, Checkbox, Url, and Node. Here is more info on each:

* `Text`: This is the recommended default as it allows for any text and behaves like a block. This means that node references work here and children blocks can be created under the block.
* `Number`: This is for numbers including negative numbers and floats e.g. 3.5. Unlike file graph properties, these are stored as actual numbers. This means that all features and queries that use this property type correctly sort as numbers by default.
* `Date`: This is for dates and is editable with a date picker. When a date property value is used, it correctly links to the journal page. This property type can be used with [repeated nodes](#repeated-tasks-and-nodes).
* `DateTime`: This is for date times and is editable with a datetime picker. See the `Due` property in [cards](#cards) for an example property that uses this. This property type can be used with [repeated nodes](#repeated-tasks-and-nodes).
* `Checkbox`: This is used to set or unset a property value and displays as a checkbox. To engineers this type is known as a boolean.
* `Url`. This limits text to only allow urls e.g. `https.//logseq.com`. This does not behave like `Text` e.g. no referencing or child blocks.
* `Node`: This allows a property value to link to other nodes i.e. pages or blocks. When first configuring this, you are prompted to select a new tag. You can choose to skip a tag if you don't care about limiting the available nodes. When a tag is selected or created, only nodes with that tag will appear as options for the property. For example, if you define the property `Author`, you could create a new tag `#Person` that only allows nodes tagged with `#Person` as values. Also worth noting that tag selection works for all child tags of the chosen new tag. Using the previous example, if `#Actor` is a child of `#Person`, nodes tagged with `#Person` or `#Actor` are allowed values.

### Property Choices

Property choices allow a property to only have one of the defined choices. Only the property types `Text`, `Url` and `Number` support this. From the [configuration dropdown](#configure-a-property), a property choice can be added, deleted and edited to have a required value, an optional description and an optional icon. Drag the choices up and down to order how they appear. For a good example of choices see the `Status` property. A property with property choices can be used with [repeated nodes](#repeated-tasks-and-nodes).

If a property has already been used, it is possible to convert it to use choices. After clicking `Add choice`, a panel displays to convert all existing property values to choices. If a property is using choices, it is possible to stop using choices by deleting them from the property. Caution: deleting a choice from a property also currently deletes the choice from all blocks it is used.

### Property Default Values

Properties can have default values, currently just for the types Text, Number and Checkbox. A property's default value takes effect for these two use cases:
* When a property is added to a node, it defaults to the default value.
* When a property is a tag property for a tag and that tag is added to a node, the node defaults to having the default value for that property.

When using simple queries, properties for the above two use cases will have that default value. When using property choices, one of them can be set as a default value by checking the default choice box in the list of property choices.

## New Tags

NOTE: New tags are currently labeled as tags in the app and should be backwards compatible with the previous tags. These `new tags` are also known as classes, types or supertags. Feedback is welcome on names for `new tags`.

To create your first new tag:
* Open [Search](https://docs.logseq.com/#/page/search) and type `#NAME` where NAME is new tag name.
* A dialog pops up that lets you create and/or add tag properties to the new tag. These tag properties are inherited by every node that uses the new tag.

For example, say we created a new tag `Person` and added `lastName` and `birthday` tag properties to it. Now when `#Person` is added to a block or page, those two properties automatically display and are editable for them. A powerful thing about new tags is that when its tag properties change those changes immediately show up on all [tagged nodes](#tagged-node).

A new tag can have properties on its own page. By default the `Description` property is available for adding a description and `Hide from node` is available to hide the new tag on tagged nodes that float to the far right. To set these properties you must be on the tag's page, hover over the tag's name and click on `Set page property`.

### Create Tags

Ways to create tags:
* Open search and type `#NAME` where `NAME` is the new tag name.
* In any block including a page name, type `#NAME` and press `Enter`. The tag floats to the right of the block.
* In a block type `#NAME` and press `Cmd-Enter`. An inline tag is created.
* Paste text in a block that includes `#NAME`. An inline tag is created for tag `NAME`.
* Configure a `Node` property type to have a new tag config.
* Configure a new tag to have a `Parent`, the new `Parent` value becomes a tag.
* In a block type `#NAME` and press `Esc`. An inline tag is created. Not recommended as it doesn't work for all use cases.
* Convert any page to a tag by clicking on the three dots menu in the upper right corner and clicking `Convert to Tag`.

Any tag can be converted to a page by clicking on the three dots menu and clicking `Convert Tag to Page`.

### Parent Tags

New tags can have a parent tag, defaulting to `Root Tag` when none is specified. Allowing new tags to be related to each other as a parent to child is useful as it allows tags to organized in a hierarchy. This is similar to directories on your computer. When a new tag is used as a parent, you can see the tag hierarchy under it by navigating to the tag's page and seeing a `Children` section.

A powerful feature of using a parent tag is that the new tag inherits the properties from its parent. For example, if we created a new `#Actor`, made its parent `#Person` from above and gave it an additional `actedIn` property. `#Actor` would display 3 properties when used, with two coming from the parent: `lastName`, `birthday` and `actedIn`.

### Configure a New Tag

New tags are configurable from their page. Navigate to their page by using [Search](https://docs.logseq.com/#/page/search) or clicking on their `#` name links. On their page, hover over their name to see the rotating triangle icon to the left. Click on it to see the tag page's properties. Two important properties you'll see for configuring a tag:

* `Parent`: Use this to allow the new tag to inherit its parent's tag properties. By default the parent tag is the `Root Tag` which doesn't have any properties.
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

Tasks are improved from the previous version as they more powerful and customizable. All tasks are blocks with the built-in new tag `#Task`. When a task is created it has the properties `Status`, `Priority`, `Deadline` and `Scheduled`.

#### Create a Task

A new task can be created in a number of ways:
* On a block without a tag, add the `Status` property by typing the status choice e.g. `/todo` or cyling status with `Cmd-Enter`.
* Type text in a block and end it with `#Task`.
* When on the `Task` page, create a new row in the Task table.
* On a block without a tag, add the `Deadline` or `Scheduled` property by typing `/Deadline` or `/Scheduled`.

#### Task Shortcuts

Any block can have a task property value set with a command or a keybinding. The commands start with `Add task` and the keybindings are:

* To set property `Status`, press `p s`.
* To set property `Priority`, press `p p`.
* To set property `Deadline`, press `p d`.

The statuses `Todo`, `Doing` and `Done` can be cycled through with `Cmd-Enter`.

The `/STATUS` commands can set a status where `STATUS` is one of the status choices e.g. `/todo`. Similarly, priority choices can be set with `/PRIORITY` commands. `/Deadline` sets the `Deadline` property. `/Scheduled` sets the `Scheduled` property.

#### Task Status

The status property is probably the most often used task property and thus it has been simplified and made customizable. The `TODO/DOING` and `NOW/LATER` workflows have been merged into `TODO/DOING` and some of the other TODO keywords have been converted to built-in status values. The default built-in values for status are:

* `Backlog`
* `Todo`
* `Doing`
* `In Review`
* `Done`
* `Canceled`

This property keeps a history of status changes for each block. Once this property changes from `Todo` to another status, its history is available by clicking on the task's spent time e.g. `9s` on the right side of a block. This history is queryable through advanced queries.

#### Repeated Tasks and Nodes

Repeating works for tasks as well as for user defined properties. Read to the end to define your own repeated nodes.

Repeated tasks are available on any task that has a `Deadline` (or `Scheduled`) property. When setting the values for these properties in a popup, check `Repeat task` to enable repeating. The datetime interval for repeating is customizable. Click on the number or time interval e.g. `Day` to change it. For dates, the time interval ranges from `Day` to `Year`. For datetimes, the time interval ranges from `Minute` to `Year`.

Once repetition is enabled on a node, it works as follows:
* When `Status` changes to `Done`, the `Status` resets to `Todo`.
* When `Status` changes to `Done`, the `Deadline` (or `Scheduled`) property changes to the current day/time plus the current repeated interval. For example, if it's currently 12:20 and the interval is 1 hr, the new value is 13:20.

To define your own repeated nodes, create a `Date` or `DateTime` property and a property with [property choices](#property-choices) that has `Checkbox state mapping` configured. To configure a node with your user properties, re-read the previous paragraphs replacing `Status`, `Deadline`, `Todo` and `Done` with your properties and checkbox mapping. One additional configuration you'll want to choose in a date/datetime popup is the property dropdown next to `When`.

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

A [(simple) query](https://docs.logseq.com/#/page/queries) and [advanced query](https://docs.logseq.com/#/page/advanced%20queries) have the [new tag](#new-tags) `#Query`. Queries are created in one of the following ways:
* Type the `/Query` command to create a query through the [query builder](https://docs.logseq.com/#/page/query%20builder).
* Type a simple query in a block and then type the `/Query` command to run the query.
* Type the `/Advanced Query` command to create an advanced query.

Like other new tags, go to the `#Query` page to see a table to manage queries. Query results are displayed in a [view](#views).

### Cards

A [(flash)card](https://docs.logseq.com/#/page/flashcards) has the new tag `#Card`. This feature has been re-implemented to use a [new algorithm](https://github.com/open-spaced-repetition/free-spaced-repetition-scheduler).

#### Create Cards
* Tag blocks with `#Card` to create new cards.
* To convert multiple blocks into cards at once, select them, right-click and choose `Make a flashcard`.

#### View Cards
All cards are accessible on the `#Card` page within the `Tagged Nodes` table.
The `Due` column indicates when the next review is scheduled.

#### Review Cards

Select `Flashcards` from the left sidebar to view all cards due for review.
You can rate them using 4 levels to arrange their next review date.

### Assets

An asset has the new tag `#Asset`. Assets are created by dragging and dropping a file onto a block. They can also be batch uploaded by going to the `#Asset` page and clicking the `+` icon from the `Tagged Nodes` table. Asset files are stored under a graph's `assets/` directory. Manage assets from the `#Asset` page's `Tagged Nodes` section. The `Gallery View` is a helpful way to view assets.

### Templates

A template has the new tag `#Template`. A template allows for block(s) and their children to be easily copied. To create a template, write the name of the template in a new block and tag the block with `#Template`. Then add children blocks (however many levels deep) under the template block. To insert a copy of a template, use the `/Template` command.

When creating a template block, there is an optional `Apply template to tags` property to use. This property provides interesting automation whenever a [tagged node](#tagged-node) is created for a configured tag. For example, create a template and configure the property to apply to `#Journal`. Now whenever a journal page is created, the template gets applied at the top of the page. If a tag is configured with multiple templates, the templates are applied in succession. When a tagged node is a block instead of a page e.g. `#Task`, the template is applied as the first child of the block. Templates can apply to built-in and user tags.

### More New Tags

Here are more new tags that are built-in, most of which are created with `/` commands:
* `#Code` - Create a code block with the `/Code block` command or by typing the backtick ` three times.
* `#Quote` - Create a quote block with the `/Quote` command or by typing `>`.
* `#Math` - Create a math block written as LaTeX with the `/Math block` command.
* `#PDF Annotation` - A node with this tag is created each a [pdf is annotated or highlighted](https://docs.logseq.com/#/page/pdf%20highlights).

Like other tags, go to their tag pages to view and manage all of them in one place. Also like other tags, extend any tag by adding more properties to it. For example, add an author property to `#Quote` to optionally add authors to quotes.

## Bulk Actions

Bulk actions are a powerful way to make changes across nodes. When multiple nodes are selected, bulk actions can be taken on them. To select nodes in a block context, use a mouse or the shift + arrow keys. Once nodes are selected, a bulk action header appears above the blocks. The bulk action header can be closed with `Esc`. The following bulk actions are available in the header:
* `Tag`: Click on `#` icon to add/update/remove [new tags](#new-tags) for selected nodes.
* `Copy`: Copy the block or page title of selected nodes.
* `Set Property`: Add or update a [property](#properties) for selected nodes.
* `Unset Property`: Remove a [property](#properties) for selected nodes.
* `Delete`: Click on the trash icon to delete selected nodes.
* `Three dots menu`: Click on the three dots icon to invoke additional actions to apply to selected nodes. These actions mostly consist of ones that are available when right clicking on a block.

Nodes can also be selected and have bulk actions in [tables](#tables).

## Views

Views are a powerful way to visualize a group of nodes in different ways. A view can switch between the following view types: `Table View`, `List View` or `Gallery View`. Most views default to the [Table View](#tables). The `List View` displays nodes in an outliner with nodes grouped by pages. The `Gallery View` is useful for viewing blocks as square tiles, especially for assets.

Views are used in a number of features including queries, (un)linked references, property and tag pages and `All pages`. For all these features except queries, multiple views can be created. Regardless of which view type you're in, a view's header has these common actions from left to right:

* `View name`: A view's name is editable by clicking on it and renaming it. A view can also be deleted from here.
* `New view`: Click on `+` to create a new view. Since a view is fairly customizable, this is useful for creating different views on the same nodes and to view a specific subgroup of nodes with filters.
* `Filter`: Filter nodes by any properties/columns by clicking on the filter icon.
  * Multiple filters can be created and applied.
  * By default, only rows that match all filters display (AND the filters). To match on any filter (OR filters), change the dropdown on the right to `Match any filter`.
  * There are different operators to filter values for every property value type e.g. `Date` and `DateTime`. For example, string values can have `is` or `is not` operators while numbers can also have `<, >, <=, >= and between` operators.
* `Search`: Live search a view by clicking on the magnifying glass icon. This is the only feature that doesn't persist when switching away from a view.
* `View type`: Click on the view type name to switch between different types.
* `Three dots menu`: Click on the three dots menu to invoke additional actions. Some actions are specific to a view type. The following actions are common across view types:
  * `Group by`: Group by a column/property and its values i.e. a different group for each property value. The different groups are vertically stacked.
    * Nodes can be grouped by all property types except for `DateTime`.
    * While each group is displayed as a different view, they all obey the same view-level configuration.
  * `Export EDN`: Exports the currently viewable nodes to your clipboard as [EDN Data](#edn-data-export). The exported nodes are affected by `Search` or `Filter` usage.
* `New node`: Click on the `+` icon to create a new node in the view. Different features will behave differently for this. For example, when clicked from a tag or property page, the new node will have that tag or property added to it.

NOTE: All actions that alter what you see are saved except for `Search`!

### Tables

A table displays a group of nodes as rows and a node's properties as columns. A table behaves like a spreadsheet as table cells are editable by default. A node has the following special columns which are available by default: `Name`, `Created At` and `Updated At`. Tables have the following features:

* `Sort`: Click on a column to sort it by ascending or descending. Multiples sorts can be applied. Click on the sort icon in the header to remove a sort.
* `Columns visibility`: Under the three dots menu, this menu can toggle the visibility of any column.
* `+ New`: At the bottom of the table, this creates a new node, like the `+` icon in the view header.
* Column actions:
  * Click on column(s) and select `Pin` to ensure they appear first.
  * Drag columns to sort their order.
  * Resize columns by dragging the resize handle at a column header's border.
* Bulk actions: When rows in the table are selected, bulk actions appear in the table header. All the bulk actions [described above](#bulk-actions) are available except for the `Three dots menu`.

## DB Graph Importer

The DB Graph Importer converts a file graph to a DB graph. An overview of what it does:
* It imports markdown files.
* All tasks are imported as new [tasks](#tasks). Some task statuses have been remapped to avoid duplicates e.g. `TODO` and `LATER`. The following statuses have been remapped:
  * `LATER` -> `Todo`
  * `IN-PROGRESS` and `NOW` -> `Doing`
  * `WAIT` and `WAITING` -> `Backlog`
* Tags are imported as follows:
  * By default, all tags are imported as [new tags](#new-tags) using the `Import all tags` input. This allows you to use all your tags as you have previously, along with the new capabilities they have.
  * Alternatively you can import only specific tags to [new tags](#new-tags) using the `Import specific tags` input. Tags that aren't specified in this input are then imported as follows:
    * All such tags become pages.
    * Tags in a block are converted to [page references](https://docs.logseq.com/#/page/term%2Fpage%20reference).
    * Tags associated with a page are associated to that page with a `Page Tags` property.
  * Tags are removed from their blocks when the `Remove inline tags` checkbox is checked. This matches the behavior of the DB version.
* Property types are automatically detected for Number, Date, Checkbox, Url, Node and Text. If a property value has two conflicting but compatible types like Number and Text, it will choose the more lenient Text type.

### Importer Todos

There are existing features that have a database equivalent that are still a TODO for the importer:
  * Import assets as `#Asset` and pdf annotations as `#PDF Annotation`
  * Import org mode files
  * Import text files e.g. *.txt or *.edn
  * Import advanced command blocks that begin with `#+BEGIN`
  * Query macros and related query filters that have changed
  * Page and block embeds
  * Import templates

### Convert File Graph to DB graph

* Click on the three dots menu in the upper right corner and select `Import`.
* Click on the `File to DB graph` button.
* This brings up a dialog. For larger graphs it takes longer for the dialog to display.
* The dialog requires you to input a name for your graph.
* The dialog has the following optional inputs:
    1. `Import all tags` - This checkbox convert all existing tags to be [new tags](#new-tags).
    1. `Import specific tags` - This input is an alternative to `Import all tags` in which you only convert specific tags to be [new tags](#new-tags). This is helpful if you don't want most of your existing tags to behave like new tags. You can also convert pages later by right clicking on a page's name.
    1. `Remove inline tags` - This checkbox removes inline tags from block content for any converted tags. This matches the DB graph behavior since all tags are now visible to the right of a block.
    1. `Import additional tags from property values` - This input converts property values for the specified property/properties to the new tags. For example, in the official docs graph the [type property](https://docs.logseq.com/#/page/type) is used this way. This means that all `type` property values like [Feature](https://docs.logseq.com/#/page/feature) on [this page](https://docs.logseq.com/#/page/code%20block) would get converted to a new tag.
    1. `Import tag parents from property values` - This input converts property values for the specified property to be [a parent of a new tag](#parent-tags). For example, in the official docs graph the [parent property](https://docs.logseq.com/#/page/parent) is used this way. This means that all `parent` property values like [Thing](https://docs.logseq.com/#/page/thing) on [this page](https://docs.logseq.com/#/page/feature) would get converted to a new tag.

## Automated Backup

An automated backup of graphs is available by clicking on the upper right three dots menu and selecting `Export Graph`. Within this modal, you can specify a folder (directory) to save backups. A backup folder can be reused across graphs as each graph gets its own folder within a backup folder. After choosing this folder, hourly backups begin. The last 12 backups are saved. This backup feature is currently only for the browser.

## Export and Import

### Graph Export

To export a DB graph, click on the three dots menu in the upper right corner, select `Export graph` and then choose one of the following options:

1. `Export SQLite DB` - Export graph as a [SQLite](https://sqlite.org/) .db file.
2. `Export both SQLite DB and assets` - Export graph as a .zip file containing the DB file and the graph's assets.
3. `Export EDN file` - Export graph as EDN described in [EDN Data Export](#edn-data-export). This is the only export type that fully captures a graph's data and is editable. This export is not yet recommended as the only means to backup a graph.
4. `Export as standard Markdown (no block properties)` - Export graph as standard markdown, not Logseq markdown. Since this export is unlikely to ever export timestamps or all properties, it cannot capture all data in a graph. See the EDN export for an export type that captures all data and is editable.
5. `Export public pages` - Export graph in order to publish it on the web. See https://docs.logseq.com/#/page/publishing for more.
6. `Export debug transit file` - Export graph as a transit file to be shared with the Logseq team for debugging. Any personal sensitive data is removed.

### Graph Import

To import a DB graph, click on the three dots menu in the upper right corner, selecting `Export graph` and then choose one of the following options:

To import the exported .sqlite file, click on the three dots menu in the upper right corner, select `Import` and then choose one of the following options:

1. `SQLite` - Import using the SQLite DB file from export.
2. `File to DB graph` - Import a markdown graph. See the [db graph importer](#db-graph-importer) for more on it.
3. `Debug Transit` - Import a debug transit file from export.
4. `EDN to DB graph` - Import a DB graph that was exported as EDN into a new DB graph.

### EDN Data Export

Exported [EDN data](https://github.com/edn-format/edn) allows any DB graph content to be shared between users as text. With this text, a user can then import it to replicate the same visible and behavioral content including the content's properties and tags. This is important as it gives users control of their content and enables some workflows that aren't possible with file graphs. This feature is available with the following commands:

* `Export block EDN data` - Run this command on the current block to copy it to the clipboard. When this data is imported, it will overwrite the current block.
* `Export page EDN data` - Run this command on the current page to copy it to the clipboard. When this is imported to an existing page, it will append to the existing page.
* `Export graph's tags and properties EDN data` - Run this command to copy the entire graph's tags and properties. This is useful for sharing your workflows with others without sharing your graph-specific data. This is an example of a workflow that was not possible with file graphs.
* `Import EDN data` - Run this command to import any of the above exported data. If importing a block, you must have focus on the block you want to import into.

This feature is also available:
* for the whole graph using the `Export EDN file` and `EDN to DB graph` options described above.
* from any [view](#views) as a header action. For example, go to the `All pages` view and filter it to only export the viewable pages.
* for multiple selected nodes with the `Copy / Export as` modal.

For developers, this shareable EDN data can also be used in scripts to create or modify existing graphs. For example, a page's data could be passed to [this script](https://github.com/logseq/logseq/blob/feat/db/deps/db/script/create_graph.cljs) to create a new DB graph with that page.

## Scripting

DB graphs are scriptable using https://github.com/logseq/nbb-logseq/tree/feat/db. Scripts can both read and _write any_ data in a DB graph. To write your own script, you'll need a package.json and nbb.edn. Use [this example package.json](https://github.com/logseq/publish-spa/blob/feat/db/package.json) and [this example nbb.edn](https://github.com/logseq/publish-spa/blob/feat/db/nbb.edn). Some example scripts:

* https://github.com/logseq/logseq/tree/feat/db/deps/db/script - Scripts to query, validate and create any graph
* https://github.com/logseq/logseq/blob/feat/db/deps/outliner/script/transact.cljs - Script to transact (modify) nodes queried from the commandline
* https://github.com/logseq/logseq/tree/feat/db/scripts/src/logseq/tasks/db_graph - More complex scripts to generate graphs with all property types or with schema.org's ontology. See [this readme](https://github.com/logseq/logseq/tree/feat/db/scripts#nbb-scripts) for using these.

### Modify a DB Graph

On desktop, it is easy to modify an existing DB graph with a script and see the change in Logseq. To do so:

1. Press Cmd-S to persist a graph to `~/logseq/graphs/GRAPH-NAME/db.sqlite`.
2. Modify the db.sqlite with a nbb-logseq script.
3. Update the app to use the modified db.sqlite by using the `Replace graph with its db.sqlite file` dev command.

## Additional Links
* https://github.com/C0ntr0lledCha0s/logseq-template-graph - Example graph with useful properties and tags