-
  #+BEGIN_CAUTION
  Logseq plugin system is currently work-in-progress. Use with caution~
  #+END_CAUTION
- This guide will walk you through creating a simple Hello World plugin for Logseq.
## Preparations
	- Right now plugin development needs the Logseq desktop app, get the latest one here: https://github.com/logseq/logseq/releases.
	- Click the three-dots menu, go to `Settings` and turn on `Developer Mode`. After that, there will be a `plugins` button inside the menu. Click it to go to the plugin list page.
## Project Bootstrap
	- Create a folder called `logseq-hello-world` and a `package.json` inside.
	- There are three required fields: `name`, `main`, and `logseq`. Leave `name` to `logseq-hello-world` and change `main` to `index.html`. The `logseq` is for plugin configuration. For now just set it to an empty object `{}`. It will look like this:
	-
	  ```json
	  {
	    "name": "logseq-hello-world",
	    "version": "1.0.0",
	    "main": "index.html",
	    "logseq": {}
	  }
	  ```
	- Create an `index.html` as the entry point for our plugin. Usually you'd like to use some front-end build tool to bundle assets for you. For simplicity's reason we just use a single html file in this guide.
## Build the Exciting Plugin!
	- Copy the code below to your index.html:
	-
	  ``` html 
	  <!DOCTYPE html>
	  <html lang="en">
	    <head>
	      <meta charset="UTF-8" />
	      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
	      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	      <title>Logseq Hello World</title>
	      <script src="https://cdn.jsdelivr.net/npm/@logseq/libs/dist/lsplugin.user.min.js"></script>
	    </head>
	    <body>
	      <script>
	        // Write our code here!
	      </script>
	    </body>
	  </html>
	  ```
	- For a *real* project you'd better install the plugin sdk by running `npm install @logseq/libs`. For our purpose a script tag will do, which will load a global `logseq` object.
	- Replace the comment will the code below:
	-
	  ```javascript
	  logseq.ready(() => {
	    logseq.App.showMsg("Hello World Logseq!");
	  }).catch(console.error);
	  ```
	- The code should be self-explanatory: It registers a callback function to show a message when the Logseq app is ready.
## Run the Plugin
	- In the plugin list page, click `Load unpacked plugin` and choose the `logseq-hello-world` folder. A "Hello World Logseq!" message will show immediately and every time the app launches. Congratulations on writing your first Logseq plugin!
## Next Steps
	- Learn from many plugin samples:
	  https://github.com/logseq/logseq-plugin-samples
	- Ask questions and discuss on Discord: https://discord.com/channels/725182569297215569/752845167030960141
	- The plugin architecture:
	  https://whimsical.com/logseq-plugins-draft-wip-B2iSbFBuWx1S4E4CkJed9y
	- Read the Plugin API documentation: TODO