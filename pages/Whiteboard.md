type:: [[Feature]]
description:: Put thoughts from your knowledge base as well as new ones next to each other on a spatial canvas together with shapes, drawings, website embeds and connectors. Built on a fork of [tldraw](https://github.com/tldraw/tldraw).
platform:: [[Desktop]]
alias:: Whiteboards

- #+BEGIN_NOTE
  This feature is currently in **beta** and only accessible for [Open Collective Sponsors](https://opencollective.com/logseq/contribute/sponsors-21163).
  #+END_NOTE
- # Usage
	- [[Whiteboards]] is a toggleable feature that can be activated in [[Settings]] under the `Features` tab.
	  collapsed:: true
		- ![CleanShot 2022-11-25 at 12.34.56@2x.png](../assets/CleanShot_2022-11-25_at_12.34.56@2x_1669376306119_0.png)
	- Once activated the [[Whiteboard]] feature can primarily be reached via the [[Left sidebar]] with a new menu item called `Whiteboards`.
	  collapsed:: true
		- ![CleanShot 2022-09-22 at 13.47.20@2x.png](../assets/CleanShot_2022-09-22_at_13.47.20@2x_1663847562670_0.png){:height 402, :width 326}
	- New whiteboards can currently be created in 3 different ways:
	  collapsed:: true
		- [[Whiteboard/Dashboard]]
		  collapsed:: true
			- The tile in the top left of the dashboard grid always allows you to create a new whiteboard.
			  collapsed:: true
				- ![CleanShot 2022-09-22 at 13.55.14.gif](../assets/CleanShot_2022-09-22_at_13.55.14_1663847729617_0.gif)
		- [[Create]] Button
		  collapsed:: true
			- After clicking the button labeled `Create` you can choose between creating `New page` or ==`New whiteboard`==. Choosing the latter will open a new whiteboard canvas. You can also create a new whiteboard with the keyboard shortcut `n w`.
			  collapsed:: true
				- ![CleanShot 2022-09-22 at 13.56.54.gif](../assets/CleanShot_2022-09-22_at_13.56.54_1663847880854_0.gif)
				  id:: 6380a818-1a69-46f1-85f0-2b86fcba9b70
		- [[Search]]
		  collapsed:: true
			- After triggering the Search window with `Cmd + k`, you can start typing a whiteboard name. Next, select the second entry from the top starting with `New whiteboard: `. This creates a new whiteboard canvas with the typed input as the title.
			  collapsed:: true
				- ![CleanShot 2022-09-22 at 14.03.19.gif](../assets/CleanShot_2022-09-22_at_14.03.19_1663848305202_0.gif)
	- Once you've created a whiteboard, you get an empty [[Whiteboard/Canvas]]. These are some of the things you can do:
		- You can give your Whiteboard a [[Title]] by clicking in the input field in the top left corner.
		  collapsed:: true
			- ![CleanShot 2022-09-22 at 14.24.18.gif](../assets/CleanShot_2022-09-22_at_14.24.18_1663849476516_0.gif)
			  id:: 6380a818-a9dc-45ac-934b-fc3064509304
		- You can use the [[Toolbar]] to interact with the canvas and add elements like blocks, pages, and images to it. You can also directly draw on the canvas. These are the current [[Tools]] :
		  id:: 6380b0a1-0bce-4ecc-b373-fee87e6e9519
			- [[Select]]
			  collapsed:: true
				- Select elements on the canvas
					- ![CleanShot 2022-09-22 at 16.21.46.gif](../assets/CleanShot_2022-09-22_at_16.21.46_1663856548758_0.gif)
			- [[Move]]
			  collapsed:: true
				- Move around the canvas
				  collapsed:: true
					- ![CleanShot 2022-09-22 at 16.23.32.gif](../assets/CleanShot_2022-09-22_at_16.23.32_1663856665325_0.gif)
			- [[Portal]]
			- [[Pencil]]
			- [[Highlight]]
			- [[Eraser]]
			- [[Connector]]
			- [[Text]]
			- [[Shapes]]
				- [[Circle]]
				- [[Rectangle]]
				- [[Triangle]]
		- You can drag and drop [[Pages]] and [[Blocks]] from both sidebars to the canvas to create [[Page and block embeds]] . Dropping images from your local filesystem is also supported. You can also select a particular block of text, and then drag it to the canvas to create a new block.
		- Embeds can also be created by copy pasting block references, images and urls. Depending on the domain and the structure of the url, a special [[Whiteboard/Object]] might be created. [[Whiteboards]] currently support [[Youtube videos]] and [[Tweets]]. The rest will be embedded as an iFrame object.
- # Functionality
	- Logseq [[Whiteboards]] are local-first like the rest of the software.
	  collapsed:: true
		- When you create your first Whiteboard, a new folder titled `whiteboards` is added to your graph folder. All the whiteboards you create are saved in the `whiteboards` folder as `.edn` files. While there are other ways to [delete whiteboards]([[Whiteboard/Deletion]]), you can also directly delete them from your file system by removing the respective `.edn` files.
			- ![CleanShot 2022-09-22 at 17.30.29@2x.png](../assets/CleanShot_2022-09-22_at_17.30.29@2x_1663860644176_0.png)
		- Whiteboards are a special type of page. You can find them in-app in the [Whiteboards dashboard]([[Whiteboard/Dashboard]]) and [[All pages]] overview.
	- A Whiteboard has a [[Whiteboard/Canvas]]. On that canvas, you can create any of the objects (shapes) in [[Whiteboard/Object]].
	- Currently, there's limited support for [[Whiteboard embeds]]. We plan to expand this functionality in later versions of [[Whiteboards]].
	  collapsed:: true
		- When referencing a [[Whiteboard]] in the outliner by its [[Title]], you will see a Whiteboard icon show up at the front of the link. Hovering that link shows you an abstracted preview of the whiteboard.
			- ![CleanShot 2022-09-22 at 17.44.08.gif](../assets/CleanShot_2022-09-22_at_17.44.08_1663861685052_0.gif)
		- Once you do a [[Page embed]] of a [[Whiteboard]], you will see the abstracted preview of the whiteboard canvas directly in the block.
			- ![CleanShot 2022-09-22 at 17.49.27.gif](../assets/CleanShot_2022-09-22_at_17.49.27_1663861815781_0.gif)
	-
- # Background
	- What makes Logseq's [[Whiteboards]] unique is the combination of the Outliner with a spatial canvas. Thanks to [[Logseq Portals]], you will be able to visually group and link different blocks and pages from your knowledge base as well as external media types (YouTube, Images, Websites) and simple shapes. This allows visual thinkers to compose, remix, annotate and relate contents from their knowledge base as well as emerging thoughts in a new way.