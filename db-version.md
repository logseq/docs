## Description

This is a description of DB graph functionality as of Aug 21st.

NOTE: There is currently no automated graph backup for the DB version. Recommend only using this for testing purposes.

## Overview

* [Nodes](#nodes)
* [Properties](#properties)
* [New Tags](#new-tags)
* [Tasks](#tasks)
* [DB Graph Importer](#db-graph-importer)

## Nodes

Pages or blocks are now called nodes because the two behave more similarly. A block can be named like a page when it is used with a new tag e.g. the block `Inception #Movie` has Inception as the block name. This block name can then be referenced e.g. `[[Inception]]`. Blocks also have a Linked References section like pages. You can see this by zooming into a block or clicking on a block link. Blocks and pages still have some differences that we are hoping to unify like their name and property display and editing as well as the blocks under a page/block.

## Properties

### Add and Edit Property Values 

Properties can be added to any block or page.

To create your first property:
* Create a new block
* Press `cmd-p` and type the name of a new property
* Select `Text` as the property type and then type some property value

`cmd-p` is useful for quickly adding properties to a block or a page. You can create or select existing properties from it.

`cmd-j` is useful for quickly editing block or page properties from the keyboard. After pressing `cmd-j`, choose which property or property value by typing the letters in the bubble next to it e.g. `c` or `ab`.

### Configure a Property

Properties are configurable from any block or page they appear on by clicking on its name. Alternatively, navigate to any property with `cmd-k` and then click on `Configure` above its name.

Property fields in the Configure modal:

* Name: Name to visually identify the property
* Icon: Choose one and it will appear wherever its name appears
* Schema type: There are 7 types of properties: Text, Number, Checkbox, Url, Page, Date and Object. If you're unsure of what type to choose, use Text as it behaves like a block.
* Multiple values: When selected, a property can have multiple values associated with it. All property types can have multiple values except for checkbox.
* Available choices: Use this to limit a property to specific values. Once a choice is defined, a user can only select from one of the defined choices. Each choice has a value, a description and an optional icon.
* UI position: This determines where the property values are displayed. By default the values are displayed as a row-like block under a block (`Block properties`). You can also choose to display property values at the beginning like task status, under a block like deadline date, or at the end of a block.
* Hide by default: When selected, a property won't be visible on any of its blocks by default. But it will be visible if you zoom in on its blocks or display them in the sidebar.
* Description: A description for the property that is mainly displayed on the property's page


TODO:
- Built in properties and what can be modified
- Property types
- Drag and drop
- Querying
- idents?

## New Tags

NOTE: New tags are currently labeled as tags in the app and do not behave like the previous tags. These `new tags` are also known as classes, types or supertags. Feedback is welcome on names for `new tags`.

To create your first new tag:
* Press `cmd-k` and then type `#NAME` where NAME is new tag name.
* A dialog pops up that lets you create and/or add properties to the new tag. 

For example, say we created a new tag `Person` and added `lastName` and `birthday` properties to it. Now when `#Person` is added to a block or page, those two properties automatically display and are associated to it. A useful thing about new tags is that when its properties change those changes are immediately made to all tagged blocks and pages.

### Parent Tags

New tags can have a parent tag, defaulting to `Root tag` when none is specified. Allowing new tags to be related to each other as a parent to child is useful as it allows tags to organized in a hierarchy. This is similar to directories on your computer or the previous namespace feature. When a new tag is used as a parent, you can see the tag hierarchy under it by navigating to the tag's page and seeing a `Child tags` section.

A powerful feature of using a parent tag is that the new tag inherits the properties from its parent. For example, if we created a new `#Actor`, made its parent `#Person` from above and gave it an additional `actedIn` property. `#Actor` would display 3 properties when used, with two coming from the parent: `lastName`, `birthday` and `actedIn`.

### Configure a New Tag

New tags are configurable by navigating to their page e.g. via `cmd-k` or clicking on their `#` name. Then click on the `Configure` link above its name.

In the Configure modal:
* Parent tag: Use this to allow the class to inherit the parent classes properties. By default the parent tag is the `Root tag` which doesn't have any properties.
* Properties: Below `Parent tag`, you can add or remove existing properties to associate them with a new tag. These properties can be sorted by dragging one above or below the other. These properties will then display sorted when a new tag is used on a block or page.

## Tasks

Tasks are improved from the previous version as they more powerful and customizable. All tasks are blocks with the built-in new tag `#Task`. When a task is created it has the properties status, priority and deadline.

### Create a Task

A new task can be created in a number of ways:
* Set the status of a block i.e. by typing `/STATUS` where `STATUS` is one of the status values e.g. `/todo`.
* Type text in a block and end it with `#Task`.
* When on the `Task` page, create a new row in the Task table.

### Task Shortcuts

Any block can have a task property value set with a command or a keybinding. The commands start with `Add task` and the keybindings are:

* To set property `status`, press `p s`.
* To set property `priority`, press `p p`.
* To set property `deadline`, press `p d`.

### Task Status

The status property is probably the most often used task property and thus it has been simplified and made customizable. The `TODO/DOING` and `NOW/LATER` workflows have been merged into `TODO/DOING` and some of the other TODO keywords have been converted to built-in status values. The default built-in values for status are:

* `Backlog`
* `Todo`
* `Doing`
* `In Review`
* `Done`
* `Canceled`

## DB Graph Importer

The DB Graph Importer converts a file graph to a DB graph. Currently it imports markdown files and assets like images. Import of org mode files will be added later. For blocks the importer converts all uses of [new tags](#new-tags) to [page references](https://docs.logseq.com/#/page/term%2Fpage%20reference) because ~~tags are now used for new tag features while page references handle inline referencing functionality~~ this behavior is still WIP. For pages the importer imports the previous tags to a `pageTags` property. If you'd like some previous tags to behave like new tags, you can specify them in the first optional input. Using this option also results in those converted tags not being imported as `pageTags`. The importer also provides two options to convert property related pages to new tags.

All tasks are imported as new [tasks](#tasks). Since tasks only have statuses for the one default workflow, the following statuses from alternate workflows have been remapped as follows:

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
