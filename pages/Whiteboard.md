type:: [[Feature]]
description:: Put thoughts from your knowledge base as well as new ones next to each other on a spatial canvas together with shapes, drawings, website embeds and connectors
platform:: [[Desktop]]
alias:: Whiteboards

- #+BEGIN_NOTE
  This feature is not available on a stable release yet as it is currently in alpha. It can only be downloaded separately by alpha testers.
  #+END_NOTE
- # Usage
	- [[Whiteboards]] is a toggleable feature that can be activated in [[Settings]] under the `Features` tab.
	  collapsed:: true
		- ![Settings-Feature-Modal.png](../assets/Settings-Feature-Modal_1663842891996_0.png)
	- Once activated the [[Whiteboard]] feature can primarily be reached via the [[Left sidebar]] with a new menu item called `Whiteboards`.
	  collapsed:: true
		- ![CleanShot 2022-09-22 at 13.47.20@2x.png](../assets/CleanShot_2022-09-22_at_13.47.20@2x_1663847562670_0.png){:height 402, :width 326}
	- New whiteboards can currently be created in 3 different ways:
	  collapsed:: true
		- [[Whiteboard/Dashboard]]
			- The tile in the top left of the dashboard grid always allows you to create a new whiteboard.
				- ![CleanShot 2022-09-22 at 13.55.14.gif](../assets/CleanShot_2022-09-22_at_13.55.14_1663847729617_0.gif)
		- [[Create]] Button
			- After clicking the button labeled `Create` you can choose between creating `New page` or ^^New whiteboard^^. Choosing the latter will open a new whiteboard canvas. This should also be possible with a keyboard shortcut like `n``w`.
				- ![CleanShot 2022-09-22 at 13.56.54.gif](../assets/CleanShot_2022-09-22_at_13.56.54_1663847880854_0.gif)
		- [[Search]]
			- After triggering the Search window with `Cmd``K` you can start typing a whiteboard name and select the second entry from the top: `New whiteboard: …`. This will create a new whiteboard canvas with the typed input as the title.
				- ![CleanShot 2022-09-22 at 14.03.19.gif](../assets/CleanShot_2022-09-22_at_14.03.19_1663848305202_0.gif)
	- Once you created a whiteboard you should be presented with an empty canvas. These are some of the things you can do:
	  collapsed:: true
		- You can give your Whiteboard a [[Title]] by clicking in the input field in the top left corner.
			- ![CleanShot 2022-09-22 at 14.24.18.gif](../assets/CleanShot_2022-09-22_at_14.24.18_1663849476516_0.gif)
		- You can use the [[Toolbar]] to interact with the canvas and add things to it. Currently the following things are possible:
			- [[Toolbar/Select]]
				- Select things on the canvas
					- ![CleanShot 2022-09-22 at 16.21.46.gif](../assets/CleanShot_2022-09-22_at_16.21.46_1663856548758_0.gif)
			- [[Toolbar/Move]]
				- Move around the canvas
					- ![CleanShot 2022-09-22 at 16.23.32.gif](../assets/CleanShot_2022-09-22_at_16.23.32_1663856665325_0.gif)
			- [[Toolbar/Draw]]
				- Do freeform pencil drawings on the canvas
					- ![CleanShot 2022-09-22 at 16.27.51.gif](../assets/CleanShot_2022-09-22_at_16.27.51_1663856897270_0.gif)
			- [[Toolbar/Highlight]]
				- Do freeform highlighting on the canvas
					- ![CleanShot 2022-09-22 at 16.30.21.gif](../assets/CleanShot_2022-09-22_at_16.30.21_1663857055477_0.gif)
			- [[Toolbar/Eraser]]
				- Erase any element on the canvas
					- ![CleanShot 2022-09-22 at 16.28.33.gif](../assets/CleanShot_2022-09-22_at_16.28.33_1663856927171_0.gif)
			- [[Toolbar/Connector]]
				- Connect any element on the canvas with a line. Add arrows to signal a direction. Add text on the connector. Can also be used to draw lines that are not connected to anything.
					- ![CleanShot 2022-09-22 at 16.25.12.gif](../assets/CleanShot_2022-09-22_at_16.25.12_1663856800902_0.gif)
			- [[Toolbar/Text]]
				- ![CleanShot 2022-09-22 at 16.31.57.gif](../assets/CleanShot_2022-09-22_at_16.31.57_1663857213717_0.gif)
			- [[Toolbar/Shapes]]
				- Create rectangle, circle and triangle shapes on the canvas
					- ![CleanShot 2022-09-22 at 17.03.28.gif](../assets/CleanShot_2022-09-22_at_17.03.28_1663859040066_0.gif)
			- [[Toolbar/Logseq Portal]]
				- Find existing or create new blocks/pages and place on the canvas
					- Create a new Whiteboard block
						- ![CleanShot 2022-09-22 at 17.07.13.gif](../assets/CleanShot_2022-09-22_at_17.07.13_1663859261512_0.gif)
					- Create a new page
						- ![CleanShot 2022-09-22 at 17.10.29.gif](../assets/CleanShot_2022-09-22_at_17.10.29_1663859469273_0.gif)
					- Find an existing block
						- ![CleanShot 2022-09-22 at 17.11.40.gif](../assets/CleanShot_2022-09-22_at_17.11.40_1663859531156_0.gif)
					- Find an existing page
						- ![CleanShot 2022-09-22 at 17.13.54.gif](../assets/CleanShot_2022-09-22_at_17.13.54_1663859660700_0.gif)
- # Functionality
	- Logseq [[Whiteboards]] are local-first like the rest of the software.
		- Once you create your first Whiteboard, you will find a new folder in your graphs folder structure called `whiteboards`. All the whiteboards you create will be saved there as `.edn` files. While there is other ways of [[Whiteboard/Deletion]] you can also always delete them through your file system, by removing the respective `.edn` files.
			- ![CleanShot 2022-09-22 at 17.30.29@2x.png](../assets/CleanShot_2022-09-22_at_17.30.29@2x_1663860644176_0.png)
		- Whiteboards can be understood as a special type of pages. You can find them in-app in the [[Whiteboard/Dashboard]] as well as [[All pages]].
	- Currently [[Whiteboard embeds]] only work in rudimentary fashion. We plan to expand this functionality in later versions of [[Whiteboards]].
		- When referencing a [[Whiteboard]] in the outliner by it's [[Title]] you will see Whiteboard icon show up at the front of the link. Hovering that link shows you an abstracted preview of the whiteboard.
			- ![CleanShot 2022-09-22 at 17.44.08.gif](../assets/CleanShot_2022-09-22_at_17.44.08_1663861685052_0.gif)
		- Once you do a [[Page embed]] of a [[Whiteboard]] you will see the abstracted preview of the whiteboard canvas immediately in the block.
			- ![CleanShot 2022-09-22 at 17.49.27.gif](../assets/CleanShot_2022-09-22_at_17.49.27_1663861815781_0.gif)
- # Background
	- What makes Logseq's [[Whiteboards]] unique is the combination of the Outliner with a spatial canvas. Thanks to [[Logseq Portal]]s you will be able to visually group and link different blocks and pages from your knowledge base as well as external media types (YouTube, Images, Websites) and simple shapes. This allows visual thinkers to compose, remix, annotate and relate contents from their knowledge base as well as emerging thoughts in a new way.
- # Additional Links
- TODO [[Jakob]] to fill out this page #docs
	- [[Toolbar]]
	- [[Whiteboard/Object Action Bar]]
	- [[Whiteboard Element]]
	- [[Title]]
	- [[Whiteboard/Quick Add]]
	- [[Whiteboard/Canvas]]
	- [[Whiteboard/Canvas/View]]
	- [[Whiteboard/Dashboard]]
	- [[Context Menu]]
	- [[Whiteboard/Embeds]]