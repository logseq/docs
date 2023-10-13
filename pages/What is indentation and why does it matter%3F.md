title:: Using Indentation

- Indentation is an important visual representation in Logseq (and outliners in general). It allows an view of a hierarchical section of your graph on a page. Representing hierarchies (mind maps, file directories, taxonomies, course prerequisites, org charts, etc) is an important visual tool. Logseq's indentation allows for this type of on-page presentation.
- Indenting is simple: anytime you hit the `Tab` key, the block your cursor is in moves to the right. Indenting a block _nests_ it under the block above, creating a parent-child relationship (a link):
	- ![parent-child-example-letters.png](../assets/parent-child-example-letters_1641572097841_0.png)
- Let's walk through the structure:
	- Block **A** is a parent block; **B** and **C** are _children_ of **A**; block **D** is a _grandchild_ of **A**.
	- Block **B** is a _child_ of **A** and it's in the same _branch_ as blocks **C** and **D**.
	- Block **C** is a _child_ of **A** and the _parent_ of **D**.
- Why is this important? As we've discussed in the previous lessons, Logseq is a networked note-taking tool that works with links. Again, it's a [graph](https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)). Graphs can contain hierarchies. A hierarchy is one type of a graph. Indentation allows us to quickly and visually create a small hierarchical section of your graph on a page.
- By indenting blocks, you create a branch that you can navigate. Let's turn the example above into links and navigate to the _**Linked references**_ section of the page of _Child **D,**_ created for block **D**:
	- ![child-d-path.png](../assets/child-d-path_1641572255030_0.png)
- By going to the page of _Child **D**_, we can see this hierarchy as it's composed on this documentation page: first up is _Parent and child **C**_ and then _Parent **A**_.
- By clicking on one of the parents, the whole branch becomes visible:
	- ![child-d-branch.png](../assets/child-d-branch_1641572326932_0.png)
- Click again on one of the parents, and you will end up on that parent's page, again showing the composed hierarchy in the _**Linked Reference**_ section.
- That's the basics of indentation! It's not much more complex than this, but it opens up a world of possibilities.
