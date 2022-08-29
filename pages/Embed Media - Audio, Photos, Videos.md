- ## Audio
	- Using [[Hiccup]] or HTML embedding, it's possible to embed audio to your page and play it back.
		- [:audio {:controls true :src "https://www.kozco.com/tech/piano2-CoolEdit.mp3"}]
	- ### Embedding an audio file on your PC (using [[Hiccup]])
		- To preview audio saved on your computer, type or copy-paste the following Hiccup ClojureScript, replacing the source `src` in "quotation marks" with the filepath and file name:
		  ```
		  [:audio {:controls true :src "file:C://Users/USERNAME/Folder/audio.ogg"}]
		  ```
		  #+BEGIN_TIP
		  Make sure to include the `file:` at the start and to use forward slashes `/`
		  #+END_TIP
		  #+BEGIN_TIP
		  You can also access other [HTML attributes for the audio tag](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/audio) (see the markup for the `controls` attribute in the above example)
		  #+END_TIP
	- ### Embedding an audio file on your PC (using "/Embed HTML")
		- If you are familiar with HTML markup and [prefer using `<audio>` tags](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/audio), you can leverage Logseq's HTML embed feature to preview audio saved on your computer. To do so, type or copy-paste the following line, replacing the source `src` in "quotation marks" with the filepath and file name:
		  ```
		  @@html: <audio controls><source src="file:C://Users/USERNAME/Folder/audio.ogg" type="audio/ogg"></audio>@@
		  ```
		  #+BEGIN_TIP
		  Make sure to include the `file:` at the start and to use forward slashes `/`
		  #+END_TIP
	- ### Embedding audio from a URL (using [[Hiccup]])
		- To preview audio stored online, type or copy-paste the following Hiccup ClojureScript, replacing the source `src` in "quotation marks" with the actual URL:
		  ```
		  [:audio {:controls true :src "https://www.website.com/audio-file.wav"}]
		  ```
			- Example:
			  [:audio {:controls true :src "https://www.kozco.com/tech/piano2-CoolEdit.mp3"}]
			  ```
			  [:audio {:controls true :src "https://www.kozco.com/tech/piano2-CoolEdit.mp3"}]
			  ```
			  #+BEGIN_TIP
			  You can also access other [HTML attributes for the audio tag](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/audio) (see the markup for the `controls` attribute in the above example)
			  #+END_TIP
	- ### Embedding audio from a URL (using "/Embed HTML")
		- If you are familiar with HTML markup and [prefer using `<audio>` tags](https://www.w3schools.com/html/html5_audio.asp), you can leverage Logseq's HTML embed feature to preview audio stored online. To do so, type or copy-paste the following line, replacing the source `src` in "quotation marks" with the actual URL:
		  ```
		  @@html: <audio controls><source src="https://www.website.com/audio-file.wav" type="audio/wav"></audio>@@
		  ```
			- Example:
			  @@html: <audio controls><source src="https://www.kozco.com/tech/piano2-CoolEdit.mp3" type="audio/mpeg"></audio>@@
			  ```
			  @@html: <audio controls><source src="https://www.kozco.com/tech/piano2-CoolEdit.mp3" type="audio/mpeg"></audio>@@
			  ```
- ## Photos, Images, GIFs
	- To embed images, you can either:
		- Copy-paste them into Logseq (which will duplicate the file into your Logseq's graph's folder in the `Assets` on your PC), OR
		- Point the photos to a particular path on your computer storage or online storage.
	- ### Embedding Images
		- To preview an image saved on your computer, type or copy-paste the following, replacing the filepath in (parenthesis) with the appropriate one:
		  `![optional: add a name](C://Users/USERNAME/Folder/image.gif)`

		  #+BEGIN_TIP
		  Make sure to include the `!` at the start.
		  #+END_TIP

		  #+BEGIN_TIP
		  	  You can specify the image size using `{:height --, :width --}` → Example:  `![label](image.gif){:height 418, :width 699}`
		   #+END_TIP
		- ### Embedding images from a URL
			- To preview am image from the internet, copy its link (with the file name and filepath) and paste it into Logseq. The image should automatically appear when you hit Enter.
				- For example:
				- ![](https://logseq.github.io/screenshots/1.png){:height 469, :width 819}
				  ```
				  https://logseq.github.io/screenshots/1.png
				  ```
				  #+BEGIN_TIP
				  You can specify the image size by formatting the image link as such: `![](https://logseq.github.io/screenshots/1.png){:height 469, :width 819}`
				   #+END_TIP
- ## Videos
	- You can also easily embed and play back video files by using the `{{video }}` command, and pasting the link to the file inside the brackets after `video`:
		- Example: `{{video file:C://Users/USERNAME/Folder/video.mp4}}` or `{{video https://www.website.com/video-file.webm}}`
	- You can also access `{{video }}` by typing the slash `/` command and typing `Embed Video URL`
	- Using the above method results in videos that autoplay, and may produce black bars for videos with unusual sizing. To mitigate this and access more advanced functions for video playback, you can use `/Embed HTML` or [[Hiccup]] to embed videos. Here are the steps for Hiccup:
	- ### Embedding a video file
		- To preview a video saved on your computer, type or copy-paste the following Hiccup ClojureScript, replacing the source `src` in "quotation marks" with the filepath and file name:
		  ```
		  [:video {:controls true :src "file:C://Users/USERNAME/Folder/video.mp4"}]
		  ```
		  #+BEGIN_TIP
		  Make sure to include the `file:` at the start and to use forward slashes
		  #+END_TIP
		  #+BEGIN_TIP
		  You can also access other [HTML attributes for the video tag](https://www.w3schools.com/tags/tag_video.asp) (see the markup for the `controls attribute` in the above example)
		  #+END_TIP
		- ### Embedding a videos from a URL
			- To preview videos stored online, type or copy-paste the following Hiccup ClojureScript, replacing the source `src` in "quotation marks" with the actual URL:
			  ```
			  [:video {:controls true :src "https://www.website.com/video-file.webm"}]
			  ```
			- Example:

			   [:video {:controls true :src "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"}]
			   ```
			   [:video {:controls true :src "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"}]
			   ```
			   #+BEGIN_TIP
			   You can also access other [HTML attributes for the video tag](https://www.w3schools.com/tags/tag_video.asp) (see the markup for the `controls` attribute in the above example)
			   #+END_TIP
		- ### Embedding videos from YouTube
			- Type the slash `/` command and type `Embed YouTube Video`
			- Select the command and paste the URL inside the `{{youtube }}` command
				- Example:
				   ```
				   {{youtube https://www.youtube.com/watch?v=SUOdfa3MucE}}
				   ```
				   {{youtube https://www.youtube.com/watch?v=SUOdfa3MucE}}
			- To add timestamps, play the video, pause, create a new line. Type the slash `/` command and type `Embed YouTube timestamp`
				- Here is an example (click on the timestamp to jump to this position in the video): {{youtube-timestamp 369}}
				- See the timestamps embed in action here (skip to 0:42 seconds):
				   <div style="position: relative; padding-bottom: 80.35714285714286%; height: 0;"><iframe src="https://www.loom.com/embed/995d6755b29c48c6b610646736aa5049" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe></div>
		- ### Embedding videos from Vimeo
			- Type the slash `/` command and type `Embed Vimeo video`
			- Select the command and paste the URL inside the `{{vimeo }}` command.
				- Example:
				   {{vimeo https://player.vimeo.com/video/535982936}}
				   ```
				   {{vimeo https://player.vimeo.com/video/535982936}}
				   ```
