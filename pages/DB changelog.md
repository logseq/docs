## Beta 2.0.2 [[Oct 7th, 2026]]
id:: 6ac64cef-100d-4cc6-add7-eb20df7aeec1
Desktop app and Android App download link: <https://github.com/logseq/logseq/releases/tag/2.0.2>,
iOS testflight: https://testflight.apple.com/join/eBcJ9Hpc,
Web app: https://app.logseq.com/
	- [[Features]]
		- Gallery cards can now use URL properties as covers.
		- Added a "Clear heading" slash command.
		- Improved video embeds, with resizable desktop players and clickable YouTube timestamps.
	- [[Thanks]]
		- **Special thanks to our community PR contributors!** Your fixes, performance improvements, translations, and careful reviews helped make this beta better. Contributors include [@yuxi-liu-wired](https://github.com/yuxi-liu-wired), [@ChipNowacek](https://github.com/ChipNowacek), [@Mancn-Xu](https://github.com/Mancn-Xu), [@hahaArthur17](https://github.com/hahaArthur17), [@maksym-dilanian](https://github.com/maksym-dilanian), [@qwist1233-cpu](https://github.com/qwist1233-cpu), and many others.
		- **A heartfelt thank-you to everyone testing the DB beta.** Your bug reports, reproduction steps, feedback, and retesting of fixes have been invaluable. Thank you for helping us improve Logseq with your real-world graphs and workflows!
	- [[Fixed issues]]
		- **1. Preserve unsaved edits:** Save pending text before following page or block references, switching blocks, or setting Deadline/Scheduled. Pasting multiple blocks no longer lets a stale editor buffer erase the first pasted title.
		- **2. Restore deleted content with undo/redo:** Restore deleted blocks and pages that reference each other, along with property schemas and values. Undoing block moves now preserves their original order and nested structure.
		- **3. Keep block trees intact when copying or moving:** Selecting an ancestor together with its descendants no longer pulls grandchildren out of their subtree. Copy/paste preserves the original child blocks, and embed actions operate on the embed rather than its source.
		- **4. Keep graph and asset downloads running:** One failed asset download no longer stops the remaining asset queue or fails the graph download. Sync also keeps property-value replacements together instead of splitting them across requests.
		- **5. Fix Windows installation:** Fix the NSIS installer crash affecting Windows 11 24H2 and newer, so the desktop app can be installed normally.
		- **6. Improve file-to-DB import fidelity:** Preserve headings, icons, journal timestamps, and PDF annotation identities/order. Asset links in property values are converted into asset references, and same-title classes and properties remain distinct.
		- **7. Correct scheduled dates and repeating tasks:** Deadline/Scheduled repeats now advance in the local calendar. Monthly repeats no longer drift permanently after a shorter month; date filters use local days, and clearing dates removes stale journal references.
		- **8. Prevent query errors from crashing the graph:** Incomplete query syntax, invalid regular expressions, and query-function rendering errors are isolated. Query-builder filters again show property/tag names and include custom Status and Priority choices.
		- **9. Fix property editing and choice selection:** Selected node values remain visible in property pickers, choice identities resolve consistently, and configuration toggles save the newly selected value. Empty multi-value slots and date values can be cleared without errors.
		- **10. Restore readable search results and references:** Resolve UUID references in search titles, breadcrumbs, and nested page references. References to deleted nodes remain visible as broken links, and opening search no longer clears its results.
		- **11. Restore settings and HTML publishing:** Settings can be saved when config.edn is missing or invalid, and the first export.css edit creates the file correctly. HTML exports no longer open as a blank page and honor the configured home page.
		- **12. Make desktop editing and keyboard input reliable:** Clicks during scrolling now open the editor. A click after Escape or Shift+Up/Down keeps the newly opened editor, and fixes cover international dead-key input and IME confirmation in search.
		- **13. Fix Android popup and layout issues:** Nested popups reuse the presented native sheet, sheet dismissal avoids re-entry, and the layout respects the status-bar safe area. Mobile cloud-graph download and sync triggers work again.
	- [[Enhancement]]
		- **Faster startup and smoother editing:** Improved desktop startup, journal loading, large-page rendering, table scrolling, and search, with fewer unnecessary updates while typing.
		- **Better everyday workflows:** Improved flashcard practice, date and repeating-task handling, international keyboard input, plugin APIs, CLI behavior, and translations.