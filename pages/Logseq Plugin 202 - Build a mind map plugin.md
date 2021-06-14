- In [[Logseq Plugin 101]] we demonstrated how to get started developing Logseq plugins. To recap, the simple steps are:
	- download the latest Logseq app
	- turn on developer mode
	- build a normal web app with JavaScript, HTML & CSS, plus the Logseq plugin sdks: @logseq/libs
	- install the app on the plugins page
- In this guide, we will dive deeper by building a more *real-world* plugin - a mind map app that turns your Logseq page into a beautiful mind map graph.
- The finished code is at https://github.com/logseq/logseq-plugin-samples/tree/master/logseq-mind-mapping. The simplify, in this guide we will only show the most essential part of the code.
## Some Background
	- To build more sophisticated plugins for Logseq, it's better for us to understand a little bit how it works. Currently, each plugin runs in an iframe separate from the main Logseq app. The main app provides some APIs (such as operations on the block, getting app settings) through the SDK to the plugins. The iframe serves as the plugin's UI and can be shown or hidden through related APIs. What's more, the main Logseq app provides ways to *inject* UI elements such as icons or buttons to some specific positions in the main app.
	- That's all, let's get started!
## Preparations
	- As we do in [[Logseq Plugin 101]], create a project folder contains a package.json, which contains three required fields: `name`, `main` and `logseq`.
	- In our `index.html` we need to add the scripts that we need:
	-
	  ```html 
	    <script src="https://cdn.jsdelivr.net/npm/@logseq/libs/dist/lsplugin.user.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/regenerator-runtime"></script>
	    <script src="https://cdn.jsdelivr.net/npm/mind-elixir/dist/mind-elixir.js"></script
	  ```
	- The `@logseq/libs` should be obvious. We will use async/await in our JavaScript, hence the regenerator-runtime is needed. Finally, we load the wonderful mind-elixir library to actually draw our mind map.
## Build the Map
	- The first line should be familiar now:
	-
	  ```js
	  logseq.ready(createModel(), main).catch(console.error)
	  ```
	- We register a function `main` to run when the main app is ready. But what's the `createModel` function? Let's see its content:
	-
	  ```js
	  function createModel() {
	    return {
	      openMindMap() {
	        logseq.showMainUI();
	      },
	    };
	  }
	  ```
	- It just returns an object, which contains a method to open the plugin's UI (main UI). *Model* is an important concept in Logseq plugin development. We will later inject a button (or some other UI) into the main app as a template string. Because functions like event handlers can not be passed through string, we need a place for them. And that's what *model* is for. Besides creating them on ready, we can also add the model using the`logseq.provideModel` API.
	- Let's add to the `main` function:
	-
	  ``` js
	    logseq.App.onPageHeadActionsSlotted(({ slot }) => {
	      logseq.provideUI({
	        key: "hook-ui-page-file-mounted",
	        slot,
	        template: `
	            <a data-on-click="openMindMap" 
	               style="opacity: .5; position: relative; top: -3px; padding-right: 8px;"
	               title="Open Mind Mapping Canvas">
	              <i class="iconfont icon-mind-map" style="font-size: 17px;"></i>
	            </a>
	          `,
	      });
	    });
	  
	  ```
	- This code just adds a button in the page head to open our mind map. Notice the `openMindMap` will be called on our `model`.
	- Next, let's build up the UI:
	-
	  ``` js
	    const root = document.querySelector("#app");
	    const displayMap = document.createElement("div");
	    displayMap.classList.add("mind-display", "hidden");
	    root.append(displayMap);
	  ```
	- Because the plugin's UI runs in a separate iframe, we can do anything we want here, without affecting the main APP's UI. Because the map hasn't been built, we will hide it first.
	- Next, we'd like to get all the blocks from the current page. But here's a problem: we don't know if the page is visible or not! Luckily the `logseq.on(ui:visible:changed)` API call will let us register a callback when the visibility of the page has changed.
	-
	  ``` js
	   logseq.on("ui:visible:changed", async ({ visible }) => {
	      if (!visible) {
	        displayMap.classList.add("hidden");
	        displayMap.innerHTML = "";
	        return;
	      }
	  
	    // TODO: build the map! 
	  })
	  ```
	- If the page is hidden, we will hide the map too. If it's visible, we shall build the map:
	-
	  ``` js
	   const blocks = await logseq.Editor.getCurrentPageBlocksTree();
	   initMindMap(displayMap, blocks);
	  ```
	- `logseq.Editor` includes APIs to interact with the Logseq editor and `getCurrentPageBlocksTree` is a powerful one to get back all the blocks of the current page as a tree structure. The tree of blocks is a fundamental data structure of Logseq, with which you can do many powerful things in your plugin.
	- After we get back the blocks tree, we just walk the whole tree and use the elixir-mind APIs to build a connected mind map. The details are not relevant here and are therefore left out. Feel free to check the finished code. Also, load the plugin in your Logseq app and enjoy the beautiful mind map generating from your pages!
## Conclusion
	- In this guide, we walk through building a simple but powerful mind map plugin for Logseq. While the plugin APIs are still work-in-progress, they can already do many powerful things. We invite you to hack them with your imagination. Feedbacks are super welcomed - we will improve the plugin APIs through listening to your voices!