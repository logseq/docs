- [[Sep 29th, 2021]]
  id:: 3c12d46c-cd46-4225-83d8-9f660d525216
  **Beta 0.4.2**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.4.2
	- [[Features]]
		- Add a shortcut `Cmd+Shift+y` to insert youtube timestamp
		- Add `(sample n)` to pick random query results
			- For example:
			  query-table:: false
			  {{query (and [[card]] (sample 2))}}
	- [[Thanks]]
		- [[Alexander Wang]]
			- Some YouTube videos cannot be played without referer
		- [[clark-cui]]
			- Javascript code enhancement
	- [[Fixed issues]]
		- Broken advanced commands triggered by `<`
		- Can't edit embed blocks
		- Remove `:` from bak file names (windows reserved chars)
		- Highlight not working in org mode
		- Don't trigger commands auto-complete when paste
		- Two of the same query with mixed syntax causes hanging
		- Correct position of query command hint
		- Cloze not shown
	- [[Enhancement]]
		- Smooth transition for the right sidebar
		- Unify both block and page export
		- Better bottom actions on Web mobile
- [[Sep 23rd, 2021]]
  id:: 3f1db344-81af-4f15-8fe2-36e03e0cf279
  **Beta 0.4.1**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.4.1
	- [[Thanks]]
		- [[llcc]]
			- fix(logbook): Adjust orders of timestamps and logbook
			- enhance: start a newline to insert src, properties, etc.
			- fix: extra empty line if SCHEDULED and DEADLINE exist
		- [[angusiguess]]
			- Emit image links as image embeds rather than as html links
	- [[Fixed issues]]
		- Can't edit code block #Codemirror
		- Review cards button not working
		- Search not working when publishing
		- Smooth auto-complete for `/` commands
		- Cards command not working in commands palette
		- `Ctrl/Cmd+l` (insert link) doesn't work on Web
		- block reference with a deadline has a redundant new line
	- [[Enhancement]]
		- Display query examples when invoking /query
		- Don't group by pages if there's `:result-transform`
	- New [[Configuration]] option `:shortcut/doc-mode-enter-for-new-block?`
		- By default, pressing `Enter` in the document mode will create a new line.
		  Set this to `true` so that it's the same behaviour as the usual outliner mode.
- [[Sep 22nd, 2021]]
  id:: 614b36ce-adeb-423d-8b04-3aaac9086268
  **Beta 0.4.0**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.4.0
	- [[Features]]
		- Fullscreen image support
			- ![CleanShot 2021-09-22 at 21.47.58.png](../assets/CleanShot_202021-09-22_20at_2021.47.58_1632318493346_0.png)
	- [[Thanks]]
		- [[Devon Zuegel]]
			- A bunch of tiny tweaks like making capitalization consistent, making a dropdown slightly more readable, and refactoring the code that adds the Help links to the sidebar.
			- Button styles for spaced repetition cards
		- [[ranfdev]]
			- Animate editor modals
		- [[woodwm]]
			- Update the version of KaTex from `0.11.1` to `0.13.8`
				- Which supports more environments like `split` and `equation `
		- [[Alex]]
			- Document mod-c/copy current block ref
	- [[Fixed issues]]
		- Can't parse encrypted graphs
		- Open the last block when inserting template blocks
		- Open the previous block when deleting selected blocks
		- App crashes with segment fault
		- Clear text selection when blocks are selected
		- Wrong GitHub release url for some plugins
	- [[Enhancement]]
		- Search UX improvement
			- <div style="position: relative; padding-bottom: 89.33002481389578%; height: 0;"><iframe src="https://www.loom.com/embed/b7c234535aa8439398a97c595f46f46c" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe></div>
			-
		- Performance improvement for pages with a lot of linked references.
		  A new option `:ref/linked-references-collapsed-threshold` was added to control when to collapse all the linked references. The default value is `50`.
		- Save database cached files to a new directory called `logseq/bak` when logseq detect file modifications from the disk
			- This fixed some issues when using Logseq with other editors like Emacs, Obsidian, etc.
		- Disable git auto commit by default
		  `Git` caused some trouble when using with some sync services like iCloud/OneDrive/Dropbox, if you encountered any issues related to Git, you're encouraged to disable the git auto commit on `Settings > Version Control`.
			- ![CleanShot 2021-09-22 at 21.41.41.png](../assets/CleanShot_202021-09-22_20at_2021.41.41_1632318112920_0.png)
		- Support hh:mm:ss youtube timestamp format
		- Use `Ctrl(Cmd)+k` for searching and `Ctrl(Cmd)+l` for inserting a link
		-
- [[Sep 15th, 2021]]
  id:: c66501ed-6d79-4a12-83d2-040da508697b
  **Beta 0.3.9**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.9
	- [[Features]]
		- [[Plugins]] Marketplace for testing!
			- <div style="position: relative; padding-bottom: 80.35714285714286%; height: 0;"><iframe src="https://www.loom.com/embed/995d6755b29c48c6b610646736aa5049" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe></div>
			-
			- Notice it's only enabled in developer mode.
			- ![CleanShot 2021-09-15 at 22.36.18.png](../assets/CleanShot_202021-09-15_20at_2022.36.18_1631716586756_0.png)
		- [[Youtube timestamp]] support
			- https://user-images.githubusercontent.com/9002575/133096658-67e3d6da-4444-4c06-b904-823e2206fd71.gif
			- How to use it?
			- 1. Embed a youtube video using `/Embed Youtube Video`
				- E.g. {{youtube https://www.youtube.com/watch?v=Ja78yU_xSkk&ab_channel=ShuOmi}}
			- 2. Watch the video and type `/Embed Youtube Timestamp`.
				- e.g. You can click the timestamp to jump to the corresponding position in the video.
					- Youtube timestamp:
					  #+BEGIN_EXAMPLE
					  {{youtube-timestamp 113}} Alias
					  #+END_EXAMPLE
					- {{youtube-timestamp 113}} Alias
					- {{youtube-timestamp 173}} PDF highlights
					- {{youtube-timestamp 206}} SRS cards
		- [[Queries]] add `namespace` support
			- {{query (namespace [[term]])}}
	- [[Thanks]]
		- [[Gustavo Santos]]
			- Set aria-checked to "true" if toggle is on
	- [[Debugging]]
		- Add instruments for changes that can't be saved to disk
	- [[Fixed issues]]
		- Code block not saved
		- Commands palette not work
		- Can't change the case of a page name
		- Edit icon should open the current block instead of the embedded block
		- Don't add new space when embedding a page or a block
		- Latex export block command shortcut gives error because of missing space
		- Git not included on Windows
		- Link title not working when copy as html
		- Don't overwrite today's journal page if synced file is empty or its content equals to the default journal template
			- To avoid file overwritten.
	- [[Enhancement]]
		- Auto focus the input box after typing /link
		- Remove the plus icon for switching graphs
		- Add both Cmd+! and Cmd+Shift+p to configurable shortcuts
- [[Sep 11th, 2021]]
  id:: cd5be27c-e2d6-4145-8c06-ed6ace8171df
  **Beta 0.3.8**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.8
	- [[Features]]
		- Page history support reverting back
		  collapsed:: true
			- <div style="position: relative; padding-bottom: 109.11016949152543%; height: 0;"><iframe src="https://www.loom.com/embed/5c21a8a3470c4fd7bb9190a188d88b71" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe></div>
			-
	- [[Thanks]]
		- [[llcc]]
			- more consistent with orgmode style
			- support recording in repeated block // cleanup unused namespaces
			- remove empty properties drawer
			- fix(clock): duplicate clock-in log twice
			- fix(timestamp): remove old SCHEDULED/DEADLINE timestamp
			- fix: org-styled link embedded-page rendering
			- fix: src block with header arguments
			- enhance: jump out of the ending curly brackets when embedding page or block
		- [[Sebastian Bensusan]]
			- calc: understand percentages
				- ```calc
				  100 * 20%
				  ```
		- [[Jiang Hailong]]
			- Linked reference is not refresh after file altering
		- [[Tiago Devezas]]
			- Translated both shortcuts and settings to pt-PT
		- [[DarshanSudhakar]]
			- Fixing typo  for the tooltip 'Block reference'
	- [[Fixed issues]]
		- dragging blocks to update notes does not synchronize updates to the notes file in real time
		- disable cut selections for blocks in the query result
		- data-refs / data-refs-self regression
		- local asset image can't be rendered with web nfs
		- wrong signature for Mac M1
		- git config core.safecrlf false on windows
		- add ignore-files to avoid repeated notifications
		- spent hours for logbook
		- display logbook for scheduled tasks
		- disable page/block auto-complete once the cursor went outside
		- commands panel aren't accessible sometimes
		- failed to remove invalid .git file
		- don't add new space when embedding a page or a block
		- click the edit icon should open the block which has the embedded block or page
	- [[Enhancement]]
		- detect file changes when starting the desktop app
		- add alerts before both refresh and re-index
- [[Sep 1st, 2021]]
  **Beta 0.3.7**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.7
	- [[Features]]
		- `cmd(ctrl)+shift+p` for command palette
		  ![command-palette-demo.gif](../assets/command-palette-demo_1630478135142_0.gif)
		- Better workflow to resolve "The file has been modified on your local disk" alert.
		  When Logseq detects filed modified on your disk and diverged from your actual Logseq page content, it'll prompt you to choose which one would you like to keep.
		  ![diff-demo.gif](../assets/diff-demo_1630479484172_0.gif)
		- Better task management & timetracking with logbook [[Clocking]] support for both org-mode and markdown [[Thanks]] to [[llcc]]
			- Automatic clock in when you switch task status to [[NOW]] or [[DOING]]
			- Automatic clock out when tasked is marked as [[DONE]] or [[LATER]]
			- Minimal interval for clocking is one minute
			- ![image.png](../assets/image_1630480711363_0.png)
			- DONE demo task 1
			  :LOGBOOK:
			  CLOCK: [2021-09-01 Wed 15:15]--[2021-09-01 Wed 15:15] =>  00:00
			  CLOCK: [2021-09-01 Wed 15:16]--[2021-09-01 Wed 15:17] =>  00:01
			  CLOCK: [2021-09-01 Wed 15:35]--[2021-09-01 Wed 15:36] =>  00:01
			  :END:
		- [[Zotero]] adds overwrite mode which will **delete** and recreate existing Zotero page instead of append duplicate item to same page. Do **backup** first! Make sure it's OK to delete and recreate the page!
	- [[Enhancement]]
		- Drawer logbook display & ui, hide logbook by default
		- Better time tracking with logbook history
		- Display loading when invoking commands like git push
		- Display orphan pages by default
	- [[Fixed Issues]]
		- Tag with brackets but without spaces creates an extra page
		- Base64 image link not displayed
		- [[Zotero]] page with attachment filename with comma caused blank screen
		- Up/down key jump cursor incorrectly from sidebar to main panel
		- Setting panel not closed properly and reopen after other commands
- [[Aug 27th, 2021]]
  id:: fd6a5fdc-3e47-4399-aaeb-6297be9f2285
  **Beta 0.3.6**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.6
	- [[Features]]
		- Page version history support, your notes are much safer now!
			- <div style="position: relative; padding-bottom: 99.52830188679246%; height: 0;"><iframe src="https://www.loom.com/embed/62fe1f6026ce4966bc88b3f3663e1649" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe></div>
			  [:div.mb-4]
			- Automatic backup with Git
				- You can disable the auto git commit on the settings page
				- Type `c` to commit with your custom message
			- Ability to run any raw Git commands like `git push`
				- The shortcut is `Cmd+!` or `Alt+!`
		- Replace block reference with either text or block embed
		- `Cmd+c Cmd+c` to clear the right sidebar
		- `Alt+shift+j` to open today in sidebar
		- `g h` to go to home
	- [[Thanks]]
		- [[llcc]]
			- Drawers support
				- Document: https://orgmode.org/manual/Drawers.html
				- ![130644716-e60cd222-e506-4087-a431-0312fcaa59d9-1.gif](../assets/130644716-e60cd222-e506-4087-a431-0312fcaa59d9-1_1630062791302_0.gif)
			- Remove extra line between title and body
			- Remove extra line when deadline or scheduled added
		- [[AlexRoar]]
			- Graph antialiasing and labels dark style
		- [[Peng Xiao]]
			- [[Codemirror]] add `protobuf` mode
		- [[raphaelporsche]]
			- Remove extra whitespace in src-block-command
	- [[Fixed issues]]
		- File changes from the disk are not refreshed immediately in logseq
		  id:: 6128c366-714f-4be9-90b5-e959b35c136f
		- Avoid false alert of "the file has been modified from the disk..."
		- Cards preview crash
		- Advanced query went error after editing with block properties
		- Block being referenced has no indication of it being a block ref
		- /scheduled doesn't work well if the content has extra spaces
		- [[Parser]]
			- Fix markdown link label
				- ![CleanShot 2021-08-27 at 18.52.03.png](../assets/CleanShot_202021-08-27_20at_2018.52.03_1630061543729_0.png)
			- Fix org mode `:tag:` issue
		- [[PDF]]
			- Incorrect url of pdf asset
		- [[Zotero]]
			- Imported url attachment open link
	- [[Enhancement]]
		- Add breadcrumbs for srs cards
			- ![CleanShot 2021-08-27 at 18.57.58.png](../assets/CleanShot_202021-08-27_20at_2018.57.58_1630061886121_0.png)
		- Persistent "Copy As" options
		- Display a warning for the demo graph
- [[Aug 20th, 2021]]
  **Beta 0.3.5**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.5
	- [[Fixed issues]]
		- Fix app crashes on Mac
	- [[Features]]
		- Codemirror support both sparql and turtle modes
- [[Aug 19th, 2021]]
  id:: 611e698b-c30b-4b51-be56-703524d963a6
  **Beta 0.3.4**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.4
	- [[Thanks]]
		- [[Peng Xiao]]
			- Several UI issues
			- Make new block button more easily clickable
		- [[Michael Schmidt-Korth]]
			- Improve UI and make button & toggle interactivity on hover
			- UI fix for setting windows
		- [[Tiago Devezas]]
			- Add Portuguese translation
	- [[Fixed Issues]]
		- Export textarea background for dark theme
		- Zotero export format issues
		- Several pdf UX issues
		- Disabling journals in setting not working
		- Fail to load when refreshing with invalid block refs
		- Block id loss for references by file altering
		- Markdown links without extension does not work
	- [[Enhancement]]
		- Parsing speed up by leveraging web workers. Adding or reindexing large graph is now much faster!
		- Ability to edit SRS cards during the review
		- Add disable spellcheck option setting for desktop app.
		- Make local pdf asset file as relative path in pdf hls annotation file
		- Add [[Zotero]] `Linked Attachment Base Directory` setting for users with Zotfile workflow and using relative attachment links
		- Improved `open` button to open [[Zotero]] attachment file using relative link instead of absolute link. This needs user to setup `Zotero data directory` for imported attachment or `Linked Attachment Base Directory` for linked attachment and re-import the [[Zotero]] item.
	- [[Features]]
		- Support markdown url link format `[Link caption](<url>)`. Note in this format, url can contain white spaces without the need of encoding
		- [[Zotero]] setting profile support. In a multi-device or multi-user scenario, user can add different [[Zotero]] setting profile for each without overriding existing [[Zotero]] settings.
- [[Aug 11th, 2021]]
  id:: 5473b972-e358-46eb-ae13-fa2ae1dd41bb
  **Beta 0.3.3**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.3
	- [[Thanks]]
		- [[ingepettersen]]
			- Add Norwegian (bokmål) translation
		- [[Michael Schmidt-Korth]]
			- CSS-changeable max-width in wide mode
		- [[Peng Xiao]]
			- Fixed several UI issues
	- [[Fixed issues]]
		- Serious bug in naming the journal md files
		- Page auto-complete search can clear the editing block
		- Inconsistent timestamps on pages
		- Failed to drag or paste images
		- Page blank with invalid block ids
		- PDF links can't be opened
		- Can't jump to highlights when enlarging the pdf viewer
		- `<Center` command
		  collapsed:: true
			- #+BEGIN_CENTER
			  Center text
			  #+END_CENTER
		- Widen mode width is too large
		- Blank white screen after updating to 0.3.2
		- Resize image
		- Simple queries not working in config.edn
		- Rename page case only
	- [[Enhancement]]
		- Copy selected blocks as text/HTML/OPML
			- ![CleanShot 2021-08-12 at 20.35.13.png](../assets/CleanShot_202021-08-12_20at_2020.35.13_1628771729434_0.png)
		- Add spellcheck toggle in Settings/editor
		- [[PDF highlights]] (works only on the desktop app at the moment)
			- Linked references for highlights
				- ![2021-08-12 20.38.29.gif](../assets/2021-08-12_20.38.29_1628771939188_0.gif)
			- Direct Zotero(including zotfile) attachments support! No need to copy the PDFs into Logseq
				- ![2021-08-12 20.37.27.gif](../assets/2021-08-12_20.37.27_1628771876729_0.gif)
			- Support external PDFs outside `/assets`
			- Support external PDFs with http links
				- For example, `![PDF name](http://www.africau.edu/images/default/sample.pdf)`
				- ![2021-08-12 20.41.20.gif](../assets/2021-08-12_20.41.20_1628772138272_0.gif)
		- A `+` button at the end of the page to quick insert a block
		- Settings options are separated into groups
			- ![CleanShot 2021-08-12 at 20.42.41.png](../assets/CleanShot_202021-08-12_20at_2020.42.41_1628772170222_0.png)
- [[Aug 6th, 2021]]
  id:: f3b8092e-ab5c-42c9-883c-81ae055b051d
  **Beta 0.3.2**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.2
	- [[Features]]
		- 📚 [[PDF highlights]]
			- Brought to you by [[Charlie]]!
			- Demo GIF
				- ![2021-08-06 21.46.20.gif](../assets/2021-08-06_21.46.20_1628257857150_0.gif)
			- {{embed [[PDF highlights]] }}
	- [[Thanks]]
		- [gombiuda](https://github.com/gombiuda)
			- Hide specific block properties [[Configuration]]
				- **How to use it?**
					- Add something like `:block-hidden-properties #{:created-at :updated-at}` to your config.edn.
		- [[Peng Xiao]]
			- Hide the bullet when the block content is hr (default mode)
	- [[Fixed issues]]
		- Templates nesting not working
		- Date format crashes when reindex
		- Markdown produced even when set to org-mode
		- Don't treat hex colors as pages
		- Alias parsing
		- Markdown image link
		- Daily Notes Loading & Scrolling Issue with New Blank Daily Note
		- block ref style issue
	- [[Enhancement]]
		- [[Zotero]]
			- Add always use citekey as page title option
			- Allow extra tags for imported pages
- [[Aug 3rd, 2021]]
  id:: 5522d7d5-2c1a-4d97-9c0d-5d4a74d29bd4
  **Beta 0.3.1**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.1
	- The existing backend code is open sourced on GitHub, it's mostly for people who'd like to host the GitHub integration themselves.
	  collapsed:: true
	  https://github.com/logseq/deprecated-github-backend
		- Notice that we have no plan to open source the future backend for both data safety and business considerations.
	- [[Configuration]]
		- `default-templates` support named template for new journal pages
			- For example, you can create a template named `my-template`, and change the `default-template` part in`config.edn` to:
			  collapsed:: true
			  `:default-templates {:journals "my-template"}`
			- [[Breaking Changes]]
				- #+BEGIN_WARNING
				  The jounnals `default-templates` only supports the template name now.
				  #+END_WARNING
		- `:ui/show-empty-bullets?`
		  collapsed:: true
			- If you want to show the empty bullets in the default mode (instead of document mode), add this to `config.edn`:
			  `:ui/show-empty-bullets? true`
	- [[Thanks]]
		- [[Michael Schmidt-Korth]]
			- Incredible unofficial Logseq documentation https://mschmidtkorth.github.io/logseq-msk-docs/
			  collapsed:: true
				- ![CleanShot 2021-08-03 at 22.29.27.png](../assets/CleanShot_202021-08-03_20at_2022.29.27_1628000972724_0.png)
	- [[Fixed issues]]
		- Block gets removed on new line when preview (only for the new generated journal page)
		- Page blank when clicking page name in the query result
		- Add page title property when renaming a page that include Windows reserved chars
		- [[Zotero]]
			- Remove key from page title
			- PDF attachment link not working
		- [[Query table]]
			- Click shouldn't open the page in the right sidebar (shift need to be pressed too)
		- [[Parser]]
			- Some files might have wrong indentation at the beginning
		- [[Publishing]]
			- Static export fails silently if asset is missing
	- [[Enhancement]]
		- Performance should be much better when editing long pages
		- Jump to alias's source page when searching
		- [[Zotero]]
			- Separate abstract note into another block
- [[Jul 30th, 2021]]
  id:: f65e2408-643d-43af-9320-57f1076847d5
  **Beta 0.3.0**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.3.0
	- [[Features]]
		- [[Zotero]] integration! 🎉 🎉 #Academic
			- By [[Weihua]] and [[Junyu]]
			- {{embed ((6103e488-22d4-4751-b27a-69b278067c26))}}
		- Support `==` for highlight in Markdown
	- [[Thanks]]
		- [[Peng Xiao]]
			- `/Embed Twitter` support!
				- E.g. `{{tweet https://twitter.com/logseq/status/1420968129987969026}} ` will displayed as:
					- {{tweet https://twitter.com/logseq/status/1420968129987969026}}
		- [[Julio Navarro]]
			- fix: after renaming a page, going back should not goto the original page
	- [[Fixed issues]]
		- Broken block references after refreshing
		- Page references not working as linked ref in page's properties
		- Backspace will remove the whole block when block timestamps was enabled
		- Can't load files named with `x.y.z.md` as namespace pages
			- This bug can result in page corruption! You're encouraged to upgrade to the latest release or use any releases before `0.2.8`
		- Some javascript files can't be loaded for subpath publishing
		- Block reference count doesn't work properly when zoom-in
		- Can't copy && paste multiple blocks
		- URL in page metadata should not be treated as page reference
		- Alias can't be redirected after deleting the page
		- Images support `webp` format
		- Right Click 'Make a Card' on Windows App does not work
		- Home page blank with some custom date formats
		- Block references no longer show the references element
		- Redirect to the new page when page property title changed
	- [[Enhancement]]
		- Group blocks query result by same path
		- [[Query table]] persists sort options (sort-by, desc/asc)
		- "Copy as" support both `remove [[]]` and `remove emphasis`
		- Don't parse quoted string as page references for properties
		- Property value wrapped by `""` will not be treated as page references
		- Add a `:breadcrumb-show?` option for custom queries to hide breadcrumbs. #option
			- The value should be `false`
	- [[Deprecated]]
		- Block timestamps was deleted to avoid countless rare cases
- [[Jul 26th, 2021]]
  id:: 4d0c3c40-a21d-41f2-8c89-091aec2a416a
  **Beta 0.2.10**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.10
	- [[Features]]
		- Block level html export
			- You can right click the left bullet, click `Export` and select `HTML`
				- ![CleanShot 2021-07-26 at 23.20.16.png](../assets/CleanShot_202021-07-26_20at_2023.20.16_1627312832871_0.png){:height 522, :width 401}
	- [[Thanks]]
		- [[Sebastian Bensusan]]
			- fix(calc): don't show errors for empty lines
		- [[ruffnex]]
			- add mhchem plugin #latex
	- [[Fixed issues]]
		- App crashing when auto-complete some page references
		- Display an error when the file or graph directory was deleted
		- `.recycle` pages should be ignored
		- Copy && paste not working well on Windows
		- Org-mode id links
	- [[Enhancement]]
		- Long pages should be loading faster
		- Query results support both nested children and breadcrumbs
		- File watcher is more efficient, it also reduces CPU usage
		- Both `^^` and `__` can be autopaired when there's selected text
		- Jump to the end of `[[page reference]]` if chose to not show double brackets
- [[Jul 23rd, 2021]]
  id:: 48e76d46-3419-455c-84a0-349b80e369b8
  **Beta 0.2.8**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.8
	- [[Fixed issues]]
		- Query table properties are not displayed
		- Can't edit code block
		- App frozen when export a block to either Markdown or OPML
		- Wrong blocks order in presentation mode
		- App crashes for some pages due to wrong parsing
	- [[Enhancement]]
		- Don't hide both the first and the last empty bullets
- [[Jul 22nd, 2021]]
  id:: 2397b650-2828-48f9-b51e-320565c847fb
  **Beta 0.2.7**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.7
	- [[Features]]
		- **Cards**  🎉 🎉  #Academic
			- By [[Zhiyuan]]
			- [[Demo]]
				- ![2021-07-22 22.28.02.gif](../assets/2021-07-22_22.28.02_1626964258528_0.gif)
				- You can use `/cards` to create specific collections instead of all of the cards
					- ![2021-07-22 22.36.17.gif](../assets/2021-07-22_22.36.17_1626964656345_0.gif)
			- {{embed [[Cards]]}}
	- [[Thanks]]
		- [[Peng Xiao]]
			- Fix cursor state sometimes not cleared correctly
		- [[Michael Schmidt-Korth]]
			- Add additional date formats (Europe/India)
	- [[Fixed issues]]
		- Org mode title not parsed if file-level property block exist in file
		- Deleted page shall not show up in search
		- Query: sum supports float string
		- Click outside doesn't clear selections
		- Can't select Up using shortcut
	- [[Enhancement]]
		- Hide bullets when the block is empty (non-editing mode)
		- Copy includes block references and embeds
- [[Jul 19th, 2021]]
  id:: 60f57103-7fe8-4b83-b497-f3576672d30b
  **Beta 0.2.6**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.6
	- [[Demo]] on query tables
	  #+BEGIN_TIP
	  You can press `t w` to adjust the width so that it's easy to see the Gif as below.
	  #+END_TIP
		- ![2021-07-19 21.19.52.gif](../assets/2021-07-19_21.19.52_1626701017883_0.gif)
	- [[Thanks]]
		- [[Sebastian Bensusan]]
			- [[Calculator]] supports negative numbers 🪄
	- [[Fixed issues]]
		- Can't drag the desktop app when scrolling down a bit
		- Can't go back to global search after searching in a specific page
		- Catch error when rendering image with wrong metadata
		- Don't show properties in block references
		- Don't show built-in properties in search results
		- Autocomplete shortcut config
		- Block timestamps in the code block
	- [[Features]]
		- [[Query table/function]]
			- How to create a function below the query table? #card
			  card-last-interval:: 11.2
			  card-repeats:: 3
			  card-ease-factor:: 2.8
			  card-next-schedule:: 2021-10-22T16:19:30.719Z
			  card-last-reviewed:: 2021-10-11T12:19:30.719Z
			  card-last-score:: 5
				- Firstly, you have a query like this:
				  query-table:: true
				  query-properties:: [:block :author :publication-date :price :qty :updated-at]
				  {{query (property type book)}}
				  Then, you can create functions (by trigger `/function`) as this query block's children.
				  
				  For example:
					- How many books? `{{function (sum :qty)}}`
						- Answer: {{function (sum :qty)}}
					- What's the average price? `{{function (average :price)}}`
						- Answer: {{function (average :price)}}
					- How much does it cost to buy all of them? `{{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}`
						- Answer: {{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}
			- What features does it support?
				- #+BEGIN_NOTE
				  The property to be used in the function must be a keyword, a keyword has a `:` at the beginning.
				  For example, `:price` is a keyword while `price` is not.
				  #+END_NOTE
				- Aggregations including sum/average/min/max/total
					- `{{function (sum :property)}}`
					- `{{function (average :property)}}`
					- `{{function (min :property)}}`
					- `{{function (max :property)}}`
					- `{{function (total :property)}}`
				- [[Clojure]] function!
				  The function takes the query result and bind it to the symbol `result` for usage.
					- `{{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}`
	- [[Enhancement]]
		- [[Query table]]
			- Click to open a block in the right sidebar
			- Human-readable block timestamps
			- Add sorts by any property
			- Add custom properties support
- [[Jul 14th, 2021]]
  **Beta 0.2.5**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.5
	- [[Thanks]]
		- [[Devon Zuegel]]
			- WYSIWYG headers + CSS cleanup
		- [[Peng Xiao]]
			- Clear data-active-keystroke when blur
		- [[Michael Schmidt-Korth]]
			- Updates to keyboard shortcut wording
	- [[Fixed issues]]
		- Pages or even the whole graph can be deleted when re-index
			- Introduced by the release `0.2.4` which was deleted to avoid more data loss
		- Block reference gets lost on alt-dragged blocks after re-index
		- Bring block timestamps back, you can enable it in the settings page
			- It'll add both `created-at` and `updated-at` properties.
		- Preserve the block properties order
		- Publishing supports subpath now
		- Previous page are not removed in the graph view
		- Can't delete selected blocks when zoom in
		- Don't show the collapse arrow when there's no block title or children blocks
		- Fix light theme colors
		- Hide :collapsed property when editing
		- Org mode image rendering
	- [[Features]]
		- Finally, we can render queries as tables! 🎉 [[Query table]]
			- {{query (property type book)}}
			  query-table:: true
			- {{query (page-property tags)}}
	- [[Enhancement]]
		- [[Publishing]]
			- Disable edit-mode
			- Remove access to settings on the exported site
			- Do not export pages with "public:: false" option when all pages are set public from the config
			- You can set all pages as public in the settings page
		- [[All pages]] support sorted by page's name, links, created at and updated at
			- ![CleanShot 2021-07-14 at 22.49.17.png](../assets/CleanShot_202021-07-14_20at_2022.49.17_1626274169623_0.png)
- [[Jul 9th, 2021]]
  **Beta 0.2.3**
  Desktop app download link: https://github.com/logseq/logseq/releases/tag/0.2.3
	- [[Thanks]]
		- [[Peng Xiao]]
			- Various UI improvements & refactoring
			- Improve cursor style with block reference
			- New page preview for page autocomplete
			  collapsed:: true
			  ![page-search-preview.gif](../assets/page-search-preview_1625811143112_0.gif)
			- `shift+enter` to open autocomplete item in sidebar
			- Fix sidebar not able to resize and draggle issue
			- Fix custom css not work when switching graphs
		- [[Michael Schmidt-Korth]]
			- Fix privacy term links not working for electron
		- [[bensu]]
			- Enhance scrolling into moving blocks behavior
	- [[Fixed Issues]]
		- Fix open file externally with relative paths
	- [[Features]]
		- Graph display is completely revamped
			- Webgl rendering thousands of nodes instantly for large repo
			- Better nodes filtering and searching
			- Various UX improvements
			- demo
			  collapsed:: true
			  ![graph-revamp.gif](../assets/graph-revamp_1625810222843_0.gif)
		- New block level export (export to plain text or opml)
		  collapsed:: true
		  ![block-export.gif](../assets/block-export_1625810930779_0.gif)
	- [[Enhancement]]
		- Enhanced document mode experience (`t d` to toggle, use `shift+enter` to create new block inside document mode)
		  collapsed:: true
		  ![document-mode.gif](../assets/document-mode_1625821426981_0.gif)
		- New frameless design and UI polish for mac desktop app on Mac
		- Enhance Mldoc ast types for link reference
		- Bundle assets for desktop app to eliminate outbound network requests
		- Add global shortcuts for moving backward`ctrl/cmd [` and forward`ctrl/cmd ]`
		  id:: 60e80f8d-f130-4925-ad22-474977a1f56d