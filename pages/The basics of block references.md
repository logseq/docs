- ## What are block references?
	- Because everything is a block in Logseq, our notes become extremely versatile. Not only can we link to pages, we can also link to blocks and even show their contents directly when linking to them. How? Using block references.
	- Block references are like windows to other parts of your graph. In Logseq, blocks are floating around freely, not bound by any folders. To link together content, every block in Logseq has an address—and this address lets us do lots of cool stuff.
	- Just like we can reference a page by placing its name between [[double brackets]], we can reference a block by using `((double parenthesis))` and placing its address in between. The main difference between a page reference (link) and a block reference is that block references show the contents of the block directly. You can recognize a block reference the underline*:
		- ![referenced-block.png](../assets/referenced-block_1642512193246_0.png)
		  _* Depending on the Logseq theme you're using, block references may show differently._
	- Why would you bother referencing blocks instead of copying over their contents? The reason is simple: to reduce duplicate content. Many people use block references to quickly reuse content from their graph.
	- Whenever you reference a block, the counter to the right of the original block will run up. This number indicates how many times the block has been referenced in the graph:
		- ![block-reference-counter.png](../assets/block-reference-counter_1642512271281_0.png)
	- By clicking on a block reference counter, the block and all of its references will open below
	- Now that you know the basics of block references, let's see how to create them.
	  id:: 62bc803c-960a-4f6c-837b-9974c037fc6a
- ## How to reference blocks
	- There are four ways to reference blocks:
		- Copying their address
		- Click-dragging them
		- Searching for them
		- In an alias
	- Let's have a look at each separately.
	- ### Copy the block ref
		- The easiest way to reference a block is by having it in front of you. Simply `Right-Click` on the bullet of the block you want to reference, and click `Copy block ref` to copy its address (including double parentheses) to your clipboard:
			- ![copy-block-ref.png](../assets/copy-block-ref_1642512411639_0.png)
		- You can also select multiple blocks and copy all of their addresses (again, including double parentheses) to your clipboard:
			- ![copy-block-refs.png](../assets/copy-block-refs_1642512432708_0.png)
	- ### Click-drag blocks
		- A second way to reference a block when it's in front of you is by clicking and holding the bullet of a block with your mouse. Then, holding the `Option` key (macOS) or `Alt` key (Windows/Linux), you'll see a green icon with a + sign appears under your cursor. This means you're referencing the block.
		- Now, drag the block (while still holding `Option` or `Alt`) to the position where you want to drop the reference:
			- ![drag-block-ref.gif](../assets/drag-block-ref_1642512518077_0.gif)
	- ### Search for the block
	  collapsed:: true
		- Searching for a block is possible in a two ways: using the top search bar or with inline search.
		- **Using the search bar**
		  collapsed:: true
			- Whenever you type something in the top search bar (shortcut: `Cmd-k` on Mac and `Ctrl-k` on Windows/Linux), Logseq will search both for pages and blocks. You can recognize the blocks in the search results by the letter `B` (for **B**lock) in front of it:
				- ![search-result-block.png](../assets/search-result-block_1642512704980_0.png)
		- **Using inline search**
		  collapsed:: true
			- Whenever you type `((` and text, you start searching your entire graph. By typing words that are mentioned in the block you're looking for, you refine your search. Hit `Enter` when you've found the block to pull its address between the parentheses. Tada! You've just done the fastest block search possible in Logseq:
				- ![block-ref-inline-search.png](../assets/block-ref-inline-search_1642512632441_0.png)
	- ### Link to blocks using an alias
		- Finally, we can use good ol' links to target a specific block. But, instead of using `[[double brackets]]`, we need to use the alias/external link (see the article [[Aliases and external links]] for more info):
			- `[link text](((block-address)))`
		- Between the single `[brackets]` you place the label text for the link. Between the `(single parentheses)`, you put the block address (including `((double parentheses))`). Now, by clicking the link you're taken to the block (zoomed in view).