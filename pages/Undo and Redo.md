type:: [[Feature]]
platforms:: [[All Platforms]] except [[Publish Web]]
description:: Allows users to revert or reapply changes made during their editing sessions. It also enhances the user experience by providing a convenient way to correct mistakes and explore alternative edits.

- ## Usage
	- Keyboard shortcuts:
		- Undo: Press `mod` + `z` (`mod` is "Control" on Windows/Linux, "Command" on macOS).
		- Redo: Press `mod` + `Shift` + `z`.
	- Undo and Redo Modes
		- The functionality offers two modes: `page only` and `global` (default).
		- To switch between modes, open the commands palette with `mod` + `Shift` + `P` (`mod` is "Control" on Windows/Linux, "Command" on macOS), and select the `Toggle undo redo mode (global or page only)` option.
	- Undo and Redo behavior in different scenarios:
		- **Text input**: Undoing and redoing typed text.
		- **Page navigation**: Navigate to the corresponding pages on undo, including navigating back to the last page visited.
		- **Page renaming**: Preserving Undo and Redo actions for renamed pages and navigating to the page on undo.
		- **Block operations**: Undoing and redoing block operations, such as creating, editing, indenting, and deleting blocks.
- ## Functionality
	- By default with global mode, undos and redos occur across pages so an undo or redo will navigate you to the edited page.
	- With page-only mode, undo and redos are limited to the current page. Pages need to be navigated to by the user in order to undo/redo them.
	- Restores the route and blocks in the right sidebar to provide context for any previous operations.
	- Allows Undo and Redo history to grow without limitations.
	- Restores the cursor state after undoing or redoing an action.
	- Works seamlessly with other Logseq features, such as creating, renaming, and navigating pages.
	- ### Limitations and Known Issues
		- Currently unavailable for flashcards and page/block preview.
		- Undo and Redo behavior may differ when working with external editors or syncing, which may affect the availability or reliability of Undo and Redo actions.
		- A significant Undo and Redo history might impact performance, although this is not confirmed.
		- Future updates might address the current limitations and improve the Undo and Redo functionality.