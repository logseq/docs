type:: [[Feature]]
platforms:: [[All Platforms]] except [[Publish Web]]
description:: Describes Undo and Redo behavior and modes.

- ## Introduction
	- The Logseq Undo and Redo feature allows users to revert or reapply changes made during their editing sessions. It aims to enhance the user experience by providing a convenient way to correct mistakes and explore alternative edits.
	- Purpose and benefits include providing context for previous operations, supporting page-only mode, allowing unlimited Undo and Redo history, and restoring cursor state.
- ## Usage
	- Keyboard shortcuts:
		- Undo: Press `mod` + `z` (`mod` is "Control" on Windows/Linux, "Command" on macOS).
		- Redo: Press `mod` + `Shift` + `z`.
	- Undo and Redo behavior in different scenarios:
		- Text input: Undoing and redoing typed text. For example, typing 'text 1' and then undoing it will remove 'text 1' from the page, while redoing it will make 'text 1' reappear.
		- Page navigation: Navigate to the corresponding pages on undo, including navigating back to the last page visited. For instance, after creating a new page and navigating to it, pressing undo will bring you back to the previous page.
		- Page renaming: Preserving Undo and Redo actions for renamed pages and navigating to the page on undo. For example, renaming a page and then undoing the rename action will return to the original page name, while redoing it will apply the new name again.
		- Working with blocks: Undoing and redoing block operations, such as creating, editing, indenting, and deleting blocks.
		- Restoring the right sidebar: Restoring both the route and blocks in the right sidebar to provide context for any previous operations and reduce the risk of undoing something users haven't noticed.
	- The Undo and Redo feature works seamlessly with other Logseq features, such as creating, renaming, and navigating pages.
- ## Functionality
	- Restoring UI state: Restores the route and blocks in the right sidebar to provide context for any previous operations.
	- Page-only mode: Supports page-only mode (mod+shift+p and search toggle Undo and Redo mode).
	- Unlimited Undo and Redo history: Allows Undo and Redo history to grow without limitations.
	- Cursor state restoration: Restores the cursor state after undoing or redoing an action.
	- Interaction with other Logseq features: The Undo and Redo feature works seamlessly with other Logseq features, such as creating, renaming, and navigating pages.
- ## Limitations and Known Issues
	- Support for flashcards: Currently, the Undo and Redo behavior for flashcards is unavailable.
	- Support for editing in page/block preview: Currently, the Undo and Redo behavior for page/block preview is unavailable.
	- Behavior when working with external files and syncing: The behavior of Undo and Redo when working with external files or syncing with external services may differ.
	- Performance impact with extensive Undo and Redo history: A significant Undo and Redo history might impact performance, although this is not confirmed.
	- Any other limitations or issues: Future updates might address the current limitations and improve the Undo and Redo functionality.