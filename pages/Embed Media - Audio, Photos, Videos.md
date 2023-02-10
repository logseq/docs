- Logseq lets you embed, preview, and play back a variety of media in a number of ways.
-
- For the most part, there are three ways that you can embed media (with `examples`):
	- 1. Using Markdown: `![](Link-To-File)`
	- 2. Using HTML elements: `<element src="Link-To-File"></element>`
	- 3. Using [[Hiccup]] ClojureScript: `[:element :src "Link-To-File"}]`
-
- The source link to file will vary depending on whether you're embedding a local asset (a file on your computer) or an asset stored on an online server.
	- **For online assets:** Copy the URL of the media, making sure that the file name and extension is included.
		- ex: `https://www.mysite.com/file.mp3`
	- **For local assets:** Copy your file path (including the file name and extension). You may also need to add `file:///` at the beginning.
		- ex: `C:/Users/user/Videos/file.mp4`
-
- Here's a detailed breakdown of the variety of ways you can embed audio, video, and images to your Logseq pages:
-
- # Markdown Method
	- The Markdown method is the easiest to implement. It involves embedding media in the following way:
	- ```markdown
	  - ![](Link-To-File)
	  ```
	-
	- ## Examples
	- ### Here is how you could use the Markdown method to embed a picture file found online:
		- ![](https://logseq.github.io/screenshots/1.png){:height 452, :width 785}
		- ```markdown
		  - ![](https://logseq.github.io/screenshots/1.png)
		  ```
	-
	- ### Markdown method -> embed a video file in your assets folder
		- ```markdown
		   - ![](../assets/video.mp4)
		  ```
	-
	- ### Markdown method -> embed a song saved on your PC:
		- ![](file:///C:/Users/user/Music/Mix.wav)
		- ```markdown
		  - ![](file:///C:\Users\user\Music\Mix.wav)
		  ```
		- OR
		- ```markdown
		  - ![](file:///C:/Users/user/Music/Mix.wav)
		  ```
		- #+BEGIN_TIP
		  Include `file:///` at the start of the file path
		  #+END_TIP
-
- # HTML Elements Method
	- The HTML element method is perfect for those comfortable with the markup language. It provides a wider variety of controls and attributes for your media compared to the Markdown method. For instance, you could show/hide playback controls, loop the media, set the size, add CSS classes, etc. Make sure to consult documentation on `<video>`, `<audio>`, and `<img>` HTML tags to learn which options are available for each media type.
	-
	- The HTML method involves embedding media in the following way:
	- ```html
	  <element src="Link-To-File"></element>
	  ```
	-
	- ## Examples
	- ### HTML method -> embed an audio file hosted online:
		- <audio controls src="https://www.kozco.com/tech/piano2-CoolEdit.mp3">  </audio>
		- ```html
		  <audio controls src="https://www.kozco.com/tech/piano2-CoolEdit.mp3">  </audio>
		  ```
	-
	- ### HTML method -> embed a video file found online:
		- <video controls>  <source src="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4">  </video>
		- ```html
		  <video controls>  <source src="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4">  </video>
		  ```
	-
	- ### HTML method -> embed a picture saved on your computer:
		- ```html
		  @@html: <img src="C:/Users/user/Pictures/sunset.jpg"> @@
		  ```
		- OR
		- ```html
		  @@html: <img src="C:\Users\user\Pictures\sunset.jpg"> @@
		  ```
		- #+BEGIN_TIP
		  If you're embedding an **image** using the HTML method, make sure to include `@@html:` at the start and `@@` at the end
		  #+END_TIP
-
- # [[Hiccup]] ClojureScript Method
	- The [[Hiccup]] ClojureScript method is similar to the HTML method, but the markup tends to be more condensed.
	- It involves embedding media in the following way:
	- ```clojurescript
	  [:element :src "Link-To-File"}]
	  ```
	-
	- ## Examples
	- ### Hiccup method -> embed a sound file hosted online:
		- [:audio {:controls true :src "https://www.kozco.com/tech/piano2-CoolEdit.mp3"}]
		- ```clojurescript
		  [:audio {:controls true :src "https://www.kozco.com/tech/piano2-CoolEdit.mp3"}]
		  ```
	-
	- ### Hiccup method -> embed a GIF found online:
		- [:img {:src "https://i.imgur.com/iYo6B6S.gif"}]
		- ```clojurescript
		  [:img {:src "https://i.imgur.com/iYo6B6S.gif"}]
		  ```
	-
	- ### Hiccup method -> embed a video clip stored on your computer:
		- ```clojurescript
		  [:video {:controls true :src "C:/Users/user/Downloads/video.webm"}]
		  ```
		- #+BEGIN_TIP
		  For local files that use the Hiccup method: Always use forward slashes `/` in the file path
		  #+END_TIP
-
- # BONUS: Video Macros
	- If you don't have access to a video file's URL, not to stress! Logseq has a macro which can embed video from third-party video hosting services like YouTube and Vimeo. If you're embedding from YouTube, there's even a macro for timestamps.
	-
	- Here are the steps to use it:
		- 1. Type the slash `/` command followed by `Embed Video URL`
		- 2. Select the command
		- 3. Paste the URL inside the `{{video }}` macro
		- 4. To add YouTube timestamps:
			- a. Play the video to the desired position.
			- b. Pause and create a new line.
			- c. Type the slash `/` command followed by `Embed YouTube timestamp`
	-
	- ## Example
		- {{video https://www.youtube.com/watch?v=SUOdfa3MucE}}
			- {{youtube-timestamp 0}} - A timestamp
			- {{youtube-timestamp 271}} - Another timestamp
		- ```
		  - {{video https://www.youtube.com/watch?v=SUOdfa3MucE}}
		  	- {{youtube-timestamp 0}} - A timestamp
		  	- {{youtube-timestamp 271}} - Another timestamp
		  ```
-
- # Useful Plugins for Media
	- **[Media Timestamp](https://github.com/sethyuan/logseq-plugin-media-ts/blob/master/README.en.md) by sethyuan:** generates timestamps for video files, audio files, and Bilibili video
	- **[Get YouTube Captions](https://github.com/briansunter/logseq-get-youtube-captions) by briansunter:** extracts auto-generated captions from YouTube video and can even add clickable timestamps
	- **[Areas](https://github.com/bsongOT/logseq-plugin-areas) by bsongOT:** draw areas in an image and link those areas to other Logseq pages and blocks
	- **[logseq-localassets-plugin](https://github.com/hkgnp/logseq-localassets-plugin) by hkgnp:** makes embedding local files easier by opening a file explorer window to select your files. It can even embed links to folders.
	- **[media controls](https://github.com/stefanbuck/logseq-media-controls) by stefanbuck:** adds playback speed control and skip forward / backward to videos, audio, and YouTube videos
