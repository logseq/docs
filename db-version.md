## Description

This is a brief description of DB graph functionality as of July 12th.

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

## Classes

To create your first class:
* Press `cmd-k` and then type `#NAME` where NAME is the name of the Class
* A dialog pops up that lets you create and/or add properties to the class. 


Classes are configurable by navigating to their page e.g. via `cmd-k` or clicking on their `#` name. Then click on the `Configure` link above its name.

Class fields in the Configure modal:
* Parent class: Use this to allow the class to inherit the parent classes properties. By default the parent class is the `Root class` which doesn't have any properties.
* Class properties: Add or remove existing properties to associate them with a class

TODO:
- Root class
- More about inheritance
- Drag n drop
- Tags vs classes