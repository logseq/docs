---
title: Advanced commands
---

## Advanced commands start with `<` and when selected expand a BEGIN...END section inside a block. There can be multiple BEGIN...END sections in a block.
## List of advanced commands:
### `<Quote` - Displays text as quoted by indenting text and giving it left and right margins.
### `<Src` - Syntax highlights code text using CodeMirror. Passing an argument to the block e.g. `#+BEGIN_SRC clojure` sets the language. Default language is javascript.
### `<Query` - Defines a block for [[高级查询]]. Block renders query results when not being edited.
### `<Latex export` - TODO
### `<Properties`- Defines [[块属性]]. Each line is a different property.
### Admonition commands display an icon next to a block to call attention to it for a specific purpose. These are inspired by [Asciidoctor admonitions](https://asciidoctor.org/docs/user-manual/#admonition).
#### `<Note`
#### `<Tip`
#### `<Important`
#### `<Caution`
#### `<Warning`
### `<Example` - Displays text as an example with white space preservation and a different colored background.
### `<Export` - TODO
### `<Verse` - Displays text that are for poetry by preserving newlines.
### `<Ascii` - TODO
### `<Center` - TODO
### `<Comment` - Inlines a comment in a block. Comment is only visible when the block is being edited.