type:: [[Command]]
description:: Creates collapsible content that is not shown by default. Usually used with [[Flashcards]]

- ## Usage
	- Type `/cloze`.
		- ![2021-07-22 21.53.38.gif](../assets/2021-07-22_21.53.38_1626962063719_0.gif){:height 538, :width 485}
- ## Functionality
	- For example, {{cloze something}}, you can click it to reveal its content. You can have multiple {{cloze clozes}} in a block too.
	- Cloze can contain a cue to help you recall the intended answer during a review.
		- **Syntax**: `{{cloze answer \\ cue}}`.
		- **Examples**:
			- Most apples are {{cloze red \\ color}}.
			- The regular expression {{cloze \\ \\}} matches a backslash.
		- **Note**: If you want to use `\\` in the answer part, append `\\` at the end to be explicit that there is no cue, as in the second example.