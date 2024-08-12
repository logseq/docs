## Description

This is a description of DB graph functionality as of Aug 12th.

NOTE: There is currently no automated graph backup for the DB version. Recommend only using this for testing purposes.

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

New tags can have a parent tag. By default new tags have the `Root tag` as a parent. Allowing new tags to have or be a parent is useful as it allows tags to organized in a hierachy. This is similar to directories on your computer or the previous namespace feature. A powerful feature of using a parent tag is that the new tag inherits the properties from its parent. For example, if we created a new `#Actor`, made its parent `#Person` from above and gave it an additional `actedIn` property. `#Actor` would display 3 properties when used, with two coming from the parent: `lastName`, `birthday` and `actedIn`.

### Configure a New Tag

New tags are configurable by navigating to their page e.g. via `cmd-k` or clicking on their `#` name. Then click on the `Configure` link above its name.

In the Configure modal:
* Parent tag: Use this to allow the class to inherit the parent classes properties. By default the parent tag is the `Root tag` which doesn't have any properties.
* Properties: Below `Parent tag`, you can add or remove existing properties to associate them with a new tag. These properties can be sorted by dragging one above or below the other. These properties will then display sorted when a new tag is used on a block or page.

## Convert File Graph to DB graph

To convert your file graph to a DB graph:

* Click on the three dots menu in the upper right corner and select `Import`.
* Click on the `File to DB graph` button.
* This brings up a dialog. For larger graphs it takes longer for the dialog to display.
* The dialog requires you to input a name for your graph. On desktop this new graph will be located under `~/logseq/graphs/GRAPH-NAME` so it is ok to give it the same name it currently has.
* The dialog has the following optional inputs:
    * `Tags to import ...` - This input converts any of your old tags to the [new tags](#new-tags). This is helpful if you've been using a particular tag like a new tag. You can also convert pages later by right clicking on a page's name.
    * `Properties whose values are imported as new tags` - This input converts property values for the specified property to the new tags. For example, in the official docs graph the [type property](https://docs.logseq.com/#/page/type) is used this way. This means that all `type` property values like [Feature](https://docs.logseq.com/#/page/feature) on [this page](https://docs.logseq.com/#/page/code%20block) would get converted to the new tag.
    * `Properties whose values are imported as parents of ...` - This input converts property values for the specified property to be [a parent of a new tag](#parent-tags). For example, in the official docs graph the [parent property](https://docs.logseq.com/#/page/parent) is used this way. This means that all `parent` property values like [Thing](https://docs.logseq.com/#/page/thing) on [this page](https://docs.logseq.com/#/page/feature) would get converted to the new tag.