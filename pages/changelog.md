- [[Oct 23rd, 2021]]
  id:: 45fc2d43-4154-4f20-ad60-c3039e35256d
  **Beta 0.4.5**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.4.5
	- [[Features]]
		- `All pages` support batch delete, search, journals filter and remove orphaned pages
			- ![CleanShot 2021-10-23 at 00.06.33.png](../assets/CleanShot_2021-10-23_at_00.06.33_1634918821593_0.png)
		- Persist right sidebar state
		- `custom.js` support
			- See more at https://github.com/logseq/logseq/pull/2943
	- [[Fixed issues]]
		- Both `Copy as` and `Export page` should be fast now
		- Marking task from "Now" to "Done" lost tracking time duration data
		- Timetracking for now->later on repeated task
		- Timetracking support seconds now
		- Logbook related issues
	- [[Enhancement]]
		- Smooth transition for left sidebar
		- Make [[DWIM]] optional
			- See more at https://github.com/logseq/logseq/issues/2958#issuecomment-945761631
- [[Oct 12th, 2021]]
  id:: 14cbc67d-695a-48b3-8d33-ddf936977d43
  **Beta 0.4.4**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.4.4
	- [[Fixed issues]]
		- Can't open graph on Linux
		- Performance degradation
		- Favorite when renaming page's title
		- Undo need multiple steps (inserting new block)
		- Recent not working
		- Url can include `{` and `}` now
- [[Oct 11th, 2021]]
  id:: 2c01a84b-d944-4755-bed4-6ff079465567
  **Beta 0.4.3**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.4.3
	- [[Features]]
		- Left sidebar!  🌈  🌈
			-
			  <div style="position: relative; padding-bottom: 93.02325581395348%; height: 0;"><iframe src="https://www.loom.com/embed/5fd05d33377c4254b4ee4b6aae5b193d" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe></div>
			-
		- Select multiple blocks to `copy block refs` and `cycle todos`
	- [[Thanks]]
		- [[Ed]]
			- The beautiful https://logseqweekly.com/! Don't forget to subscribe!
				- > With the rapid development of the app and new features/improvements, I created this Weekly Summary to help community members keep up with everything being thought of, created and shared by other fellow Logseq users.
		- [[Mispille]]
			- Awesome proposal to tagging Logseq's issues on GitHub!
				- This proposal is at https://docs.google.com/spreadsheets/d/10-LplNuMo2MUy67lt-WX1z1x50L1pY4bSLPIob1eHRQ/edit?usp=sharing!
		- [[llcc]]
			- [[DWIM]] (do what I mean) for `Enter` key when editing.  
			  Context-awareness of `Enter` key makes editing more easily.
		- [[Devon Zuegel]]
			- Consolidate shortcut docs
		- [[hyrijk]]
			- Fix: plugin api moveBlock not working
		- [[Tomas Vik]]
			- Enhance: pretty print pages-metadata.edn
	- [[Fixed issues]]
		- Data loss when dragging blocks to empty pages
		- Create today's journal when the corresponding file doesn't exist yet
		- Broken block references
			- Remove blank line for some blocks when outputting to md/org
		- Importing from Roam has issues with illegal filenames (Windows)
		- Flashcards wrong number during the review
		- Page rename doesn't work for case-sensitive pages
		- Respect the original page's name in the block content
		- Flashcards don't work when publishing
		- A block can be collapsed only when it has children or its body is not empty
		- Display the edit icon only for the embedded parent block
		- Sanitize html for security (plugins)
		- Disable nested queries (page crash)
		- Support raw path under win32 that includes backslash for local pdf files
		- Goto pdf highlights not working sometimes
		- Markdown footnote definition not working when re-index or refresh
		- preferredThemeMode doesn't work (plugins API)
	- [[Enhancement]]
		- Click title to rename a page
		- Open the first block when opening a new page by Mod+o
		- Many UX enhancements
- [[Changelog_07_09]]
- [[Changelog_06]]
- [[Changelog 2020]]