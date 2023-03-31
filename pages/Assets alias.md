type:: [[Feature]]
platforms:: [[Desktop]]
initial-version:: unreleased

- #+BEGIN_NOTE
  It's not supported yet.
  This only works on the desktop app at the moment.
  #+END_NOTE
- **What are assets?**
	- Some resources like images, audio, PDF documents, etc. They're stored by default in the ` /assets` directory.
- **Problem**
	- You don't want to store images or PDF files inside the default `/assets` directory, you want to store them outside the current graph's directory, for example, you're using Zotero to manage those files.
- **Advantages of assets alias?**
	- You can have multiple `alias`.
	- Each alias could point to a different directory, you can also specify the accepted file extensions for  any alias.
	- Files will be stored in the corresponding directory when dragging or copy them to Logseq.
- **How to use?**
	- a. enable this feature in the settings modal.
	  ![CleanShot 2022-10-12 at 15.38.03@2x.png](../assets/CleanShot_2022-10-12_at_15.38.03@2x_1665560368311_0.png){:height 224, :width 441}
	- b. specify an external alias directory and give it a name (alias). You can add more directories later.
	  ![CleanShot 2022-10-12 at 15.41.46@2x.png](../assets/CleanShot_2022-10-12_at_15.41.46@2x_1665560569831_0.png){:height 167, :width 439}
	- c. now if there's an image file `test.png` in the selected directory, you can access this file by `alias` name that starts with `@`, for example, `@Pictures/test.png`.
	  ![CleanShot 2022-10-12 at 15.53.20@2x.png](../assets/CleanShot_2022-10-12_at_15.53.20@2x_1665561216083_0.png)
	- d. (optional) You can specify `acceptable file extensions`  to be allowed for each asset alias, for example, you can add both `jpg` and `png` for `@Pictures`.  
	  ![CleanShot 2022-10-12 at 15.59.11@2x.png](../assets/CleanShot_2022-10-12_at_15.59.11@2x_1665561566668_0.png){:height 201, :width 557}
-