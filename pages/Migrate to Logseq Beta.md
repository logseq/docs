-
  #+BEGIN_WARNING
  **BACKUP** all your notes somewhere **first** before continue
  #+END_WARNING
- This migration guide is mainly targeted for Logseq users of pre-beta version with Markdown notes
- **Backup(make an extra copy)** of all your old notes first, then:
	-
	  1. Load and open your old graph folder in this new Beta app
	-
	  2. Click the right three dots menu, go to `Export` and select `Convert Markdown headings to unordered lists (# -> -)`
	-
	  3. Above will create a zip file of all your converted new notes under `/journals` and `/pages` folder, extract the zip to your desired location.
	-
	  4. Copy and replace all pages under `/journals` and `/pages` folder back to that same graph folder
	-
	  5. Finally, click the right three dots menu, go to `All graphs` and unlink the graph and open it again to reload the graph
- Tutorial:
  ![migrate.gif](/home/weihua/repo/logseq.com/docs/assets/migrate_1621935713657_0.gif)
- Why & underneath the hood:
	- Previously Logseq use `#` markdown heading as outliner bullets, since beta, we've changed to use more standard `-` unordered list as outliner bullets
	- The converter essentially converts all Markdown headings to unordered lists (`#` -> `-`)
- Further steps you may need:
	- Since Logseq is using `-` unordered list for bullets, `-` will not work as a list item anymore, replace `-` with `*` or `+` if you need it. The converter doesn't convert it automatically because it might break your contents.
- Other noticeable changes:
	- Old syntax of adding property for Markdown is no longer recommanded
	  ``` Markdown
	  ---
	  key: value
	  ---
	  ```
	  Use below new [[term/properties]] syntax instead
	  {{embed ((60ab6f5b-4bdc-4ef0-a0f8-6cad9dcad2b2))}}