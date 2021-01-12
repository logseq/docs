---
title: Changelog
---

## [[Jan 12th, 2021]]
**Version 0.0.5.1**
### [[Features]]
#### 1. **Local images support!**
`Notice:` it only supports local file storage.
You can copy and paste any pictures to a page, those pictures will be stored in the folder `assets/`.
##### We'll support more kinds of files soon, e.g. pdf, epub, mp3, etc.
#### 2. Added `page` query.
For example: (page "Page Alias"):
{{query (page "Page Alias")}}
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
