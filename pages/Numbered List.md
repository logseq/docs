type:: [[Feature]]
platforms:: [[All Platforms]]
description:: Provides numbered (ordered) lists with each list item being a block.
initial-version:: 0.9.5

## Usage
	- A numbered list can be started in a couple ways:
		- Type `1. ` in a block
		  logseq.order-list-type:: number
		- Press `t n` when focused on a block
		  logseq.order-list-type:: number
		- Type the `/Number list` command in a block
		  logseq.order-list-type:: number
	- Block(s) can be toggled in/out of a numbered list in the following ways:
		- Press `t n` when focused on a block
		  logseq.order-list-type:: number
		- Type the `/Number list` command in a block
		  logseq.order-list-type:: number
		- Select multiple blocks, right click and select `Toggle number select`
		  logseq.order-list-type:: number
		- Select multiple blocks and press `t n`
		  logseq.order-list-type:: number
		- Type the `/Number children` command in a parent block to have all of its children blocks toggled
		  logseq.order-list-type:: number
	- Press `Enter` on a numbered block to create a new numbered block with the number automatically incremented.
	- A numbered list can be stopped at any time by pressing `backspace` on an empty block or by using one of the above toggle options.
- ## Functionality
	- Blocks that are dragged into a numbered list are turned into a numbered block.
	- A numbered block when copied and pasted remains a numbered block.
	- ### Limitations
		- A numbered list is not currently saved in a [standard ordered list format](https://daringfireball.net/projects/markdown/syntax#list).
		- See https://github.com/logseq/logseq/pull/9141#issuecomment-1517108026 for ux limitations.