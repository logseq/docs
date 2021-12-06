# How to Embed Audio, Photos, and Videos
- 
## Audio
- Using [[Hiccup]], it is possible to embed audio to your page and play it back.
- 
- [:audio {:controls true :src "https://www.kozco.com/tech/piano2-CoolEdit.mp3"}]
- 
### Embedding audio from your computer's filesystem (Windows)
- To preview audio saved on your computer, type or copy-paste the following Hiccup ClojureScript, replacing the source `src` in "quotation marks" with the filepath and file name:
	- `[:audio {:controls true :src "file:C://Users/USERNAME/Folder/audio.ogg"}]`
- Make sure to include the `file:` at the start and to use forward slashes `/`.
- 
### Embedding audio from an online URL
- To preview audio stored online, type or copy-paste the following Hiccup ClojureScript, replacing the source `src` in "quotation marks" with the actual URL:
	- `[:audio {:controls true :src "https://www.website.com/audio-file.wav"}]`
		- For example: `[:audio {:controls true :src "https://www.kozco.com/tech/piano2-CoolEdit.mp3"}]` 🡒 [:audio {:controls true :src "https://www.kozco.com/tech/piano2-CoolEdit.mp3"}]
- 
## Photos, Images, GIFs
- To embed images, you can either:
	- Copy-paste them into Logseq (which will duplicate the file into your Logseq's graph's folder in the `Assets` on your PC), OR
	- Point the photos to a particular path on your computer storage or online storage.
- 
### Embedding photos from your computer's filesystem (Windows)
- To preview an image saved on your computer in Logseq, type or copy-paste the following, replacing the filepath in (parenthesis) with the appropriate one:
- `![optional: add a name](C://Users/USERNAME/Folder/image.gif){:height 418, :width 699}` 
- Make sure to include the `!` at the start.
- 
- OPTIONAL: You can also add some sizing using {:height --, :width --}. 
	- For example: `![image.png](C://Users/USERNAME/Folder/image.gif){:height 418, :width 699}` 
- 
### Embedding images from an online URL
- To preview am image from the internet, copy its link (with the file name and filepath) and paste it into Logseq. The image should automatically appear when you hit Enter.
	- For example: `https://logseq.github.io/screenshots/1.png`
	- ↓
	- https://logseq.github.io/screenshots/1.png
- 
## Videos
- Using [[Hiccup]] and certain slash commands, it is possible to embed video to your page and play it back.
- 
### Embedding videos from your computer's filesystem (Windows)
- To preview a video saved on your computer, type or copy-paste the following Hiccup ClojureScript, replacing the source `src` in "quotation marks" with the filepath and file name:
	- `[:video {:controls true :src "file:C://Users/USERNAME/Folder/video.mp4"}]`
- Make sure to include the `file:` at the start and to use forward slashes.
- 
### Embedding videos from an online URL
- To preview audio stored online, type or copy-paste the following Hiccup ClojureScript, replacing the source `src` in "quotation marks" with the actual URL:
	- `[:video {:controls true :src "https://www.website.com/video-file.webm"}]`
		- For example: `[:video {:controls true :src "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"}]` 
		- ↓ 
		- [:audio {:controls true :src "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"}]
- 
### Embedding videos from YouTube
- Type the slash `/` command and type `Embed YouTube Video`
- Select the command and paste the URL inside the `{{youtube }}` command.
	- For example: `{{youtube https://www.youtube.com/watch?v=SUOdfa3MucE}}`
- Hit enter to see the video
- To add timestamps, play the video, pause, create a new line. Type the slash `/` command and type `Embed YouTube timestamp`
- See the timestamps embed in action here (skip to 0:42 seconds):
	- 
	 <div style="position: relative; padding-bottom: 80.35714285714286%; height: 0;"><iframe src="https://www.loom.com/embed/995d6755b29c48c6b610646736aa5049" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;"></iframe></div>
- 
### Embedding videos from Vimeo
- Type the slash `/` command and type `Embed Vimeo Video`
- Select the command and paste the URL inside the `{{vimeo }}` command.
	- For example: `{{vimeo https://vimeo.com/535982936}}`
- If this doesn't work, you can also copy the Vimeo Video's embed URL and paste it inside Logseq.
	- See this in action here:
	- [:video {:controls true :src "https://user-images.githubusercontent.com/55474996/144936496-c3952929-e2c5-47f6-a041-3c63b2f64ea9.mp4"}]
