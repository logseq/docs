title:: What is indentation and why does it matter?

- Indentation is one of the fundamental concept in Logseq (and outliners in general). It's the feature that allows block references and queries to work. In other words: indentation helps you to find stuff in Logseq.
- The idea of indentation is simple: anytime you hit the `Tab` key, the block your cursor is in moves to the right. Indenting a block _nests_ it under the block above, creating a parent-child relationship:
	- ![parent-child-example-letters.png](../assets/parent-child-example-letters_1641572097841_0.png)
	  id:: 63343e47-f553-4858-9238-4f2e6688f919
- Let's walk through the example step-by-step:
  id:: 63343e47-2e33-4c6d-ad9a-daf2459c8b77
	- Block **A** is a parent block; **B** and **C** are _children_ of **A**; block **D** is a _grandchild_ of **A**.
	- Block **B** is a _child_ of **A** and it's in the same _branch_ as blocks **C** and **D**.
	- Block **C** is a _child_ of **A** and the _parent_ of **D**.
- Why is this important? As we've discussed in the previous lessons, Logseq is a networked note-taking tool that works with links. We also discussed that Logseq has no hierarchy, which is actually nuanced. As you've probably deduced by now, hierarchy in Logseq happens at the block level.
- By associating blocks, you create a branch that you can navigate. Let's turn the example above into links and navigate to the linked references of block **D,** which we'll name _Child **D**_:
	- ![child-d-path.png](../assets/child-d-path_1641572255030_0.png)
- By going to the page of _Child **D**_, we can see this hierarchy it's in: first up is _Parent and child **C**_ and then _Parent **A**_.
- By clicking on one of the parents, the whole branch becomes visible:
	- ![child-d-branch.png](../assets/child-d-branch_1641572326932_0.png)
- That's the basics of indentation! It's not much more complex than this, but it opens up a world of possibilities.