---
title: Changelog
---

## [[Feb 14th, 2021]] 
:PROPERTIES:
:id: 60292a79-59c5-41fd-aa05-3c5f1e1b4908
:END:
**Version 0.0.8**
### [[Thanks]]
#### [[Lupin]] support both Images and [[Time Spaced  Repetition]] (by [[akhater]])
https://github.com/akhater/Lupin
#### Fix of bug "TODO mobile bar shortcut only works when called in the beginning of the line" (#1283) (by [[akhater]])
#### Continue improvements on encryption (by [[kanru]])
#### Using Logseq with Todoist and Google Calendar (by [[WilliamDurin]])
https://github.com/WilliamDurin/todoist2logseq
https://github.com/WilliamDurin/gcal2logseq
### [[Fixed issues]]
#### Fix block references count not working
#### Fix block references auto-complete not working
#### Fix wrong prompts when the file is only edited by logseq
#### Allow ~-~ inside file name
#### Fix relative asset path
#### Fix fuzzy search causing freezes/lag
#### Display the main menu dots on mobile
#### Importing roam's code blocks
#### Don't jump to new journal when in editing mode
#### And other fixes
### [[Enhancement]]
#### Better Undo && Redo
#### Faster full-text search
#### Add built-in pages such as TODO keywords and priorities
## [[Feb 5th, 2021]] 
**Version 0.0.7**
[[Desktop app]] download link:
https://github.com/logseq/logseq/releases/tag/0.0.7
### [[特色功能]]
#### 1. Auto-update support for desktop app #experiment
#### 2. Add both `data-refs` and `data-href` attributes to [make css more power](https://discuss.logseq.com/t/propositions-to-empower-css-mods/289/1)
### [[Thanks]]
#### German translation by [[rcvd]]
#### A forked cljs-time by [[rainmote]]
#### Add TODO and "/" shortcuts to mobile bar, by [[akhater]]
#### [Create Build LogSeq Desktop for windows on Ubuntu](https://github.com/logseq/logseq/blob/master/docs/Build%20LogSeq%20Desktop%20for%20windows%20on%20Ubuntu.md), by [[akhater]] #doc
#### [CSS mod colorful indentation lines](https://discuss.logseq.com/t/css-mod-colorful-indentation-lines/229), by [[cannibalox]] #css
#### [CSS mod custom columns/cards view (kanban)](https://discuss.logseq.com/t/css-mod-custom-columns-cards-view-kanban/228), by [[cannibalox]] #css
#### [Glossary - draft work in progress](https://discuss.logseq.com/t/glossary-draft-work-in-progress/196), by [[Cobblebot]] #doc
#### Awesome video by [[Santi Younger]] [[Videos]] 
{{youtube https://www.youtube.com/watch?v=jovMt17_Vd4&ab_channel=SantiYounger}}
### [[Fixed Issues]] 
Some highlights:
#### Relative file path issue, local images should be displayed well on GitHub now
#### Don't display properties in the block breadcrumbs
#### Head's background color is not rendered
#### `/draw` not working well with GitHub repos
### [[Enhancement]]
#### Display a loading button when importing files from the disk
#### Display a warning box if there're multiple files with the same `title` attribute
#### UI improvements
## [[Feb 2nd, 2021]] 
**Version 0.0.6**
[[Desktop app]] download link:
https://github.com/logseq/logseq/releases/tag/0.0.6
### [[Fixed Issues]]
#### Fix assets can't be opened if there're non-ascii chars
#### Add slide support to desktop app
#### Fix footnotes not working
For example:
Here's a simple footnote,[^1] and here's a longer one.[^bignote]

[^1]: This is the first footnote.

[^bignote]: Here's one with multiple paragraphs and code.
#### Fix both preferred workflow and preferred format settings not working
#### Fix `/` commands list is empty
#### Add windows menubar
## [[Jan 31st, 2021]] 
**Version 0.0.5.3**
[[Desktop app]] download link: https://github.com/logseq/logseq/releases/tag/0.0.5.3
### [[Fixed issues]]
#### Fix daily journals can't be created automatically
#### Fix Inline tags can't be clickable
#### Fix recent pages can't be open in the main view
#### Fix block references not updated when the source text changed
#### Fix can't found code-editor.js on desktop by [[rainmote]]
## [[Jan 29th, 2021]] 
**Version 0.0.5.2**
### [[Desktop app]] 🥳🥳🥳
Some highlights:
#### 1. Logseq will load new files automatically, no need to reload yourself anymore
#### 2. There's no need to always asking for the directory write permission every time when you open the app
#### 3. Drag && drop any files (in editing mode), you can click the link to open the file with the system default app
## [[Jan 12th, 2021]]
**Version 0.0.5.1**
### [[特色功能]]
#### 1. **Local images support!**
`Notice:` it only supports local file storage.
You can copy and paste any pictures to a page, those pictures will be stored in the folder `assets/`.
##### We'll support more kinds of files soon, e.g. pdf, epub, mp3, etc.
#### 2. Added `page` query.
For example: (page "Page Alias"):
{{query (page "Page Alias")}}
#### [main.js](/assets/pages_changelog_1611805815460_0.js)
####
### [[Enhancement]]
#### 1. **Much stable Undo && Redo**
`Notice`: It could be slow with page that has many blocks.
There's a bug with block timestamps enabled, so we disabled it temporally.
#### 2. `Ctrl+s` to save and push to GitHub
#### 3. Add `git-auto-push` to settings page, you can disable the auto push and type `Ctrl+s` to push yourself :)
#### 4. Add page title when searching blocks
#### 5. Add an option to disable the journals and set a default home page
### [[Fixed Issues]]
#### 1. Remove duplicate blocks in references
#### 2. Properties not working well when enter at the start
#### 3. Can't enter to create a new block at the end of code
#### 4. Fixed `Scheduled` not working sometime
#### 5. Unique constraint issue when loading files
#### 6. Fix `all-page-tags` query
#### 7. Page refs in properties should be counted too
#### 8. Codemirror not working well with block timestamps
#### 9. Do not push local repo when switching repos
#### 10. Many other bugs on GitHub.
### [[Thanks]]
#### 1. [kanru](https://github.com/logseq/logseq/pull/1073) is adding encryption support for GitHub Repos.
#### 2. [karlicoss](https://github.com/logseq/logseq/pull/1076) add filetags support for org mode and fixed some issues.
#### 3. [kailes](https://github.com/logseq/logseq/pull/1074) found and fixed a tricky issue when upgrading to latest shadow-cljs.
