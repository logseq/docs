title:: Logseq 插件 101

-
  #+BEGIN_CAUTION
  Logseq 插件系统还在开发中，请谨慎使用~
  #+END_CAUTION
- 这篇指南将带你创建一个 Hello World 插件
## 准备工作
	- 目前开发插件需要 Logseq 桌面版，下载最新版： https://github.com/logseq/logseq/releases
	- 单击右上角的三个点，打开`设置`并开启`开发者模式`。然后菜单里会出现`插件`按钮，单击打开插件页面。
## 项目引导
	- 创建一个文件夹 `logseq-hello-world`，并在里面创建一个`package.json`文件。
	- 三个必填字段：`name`， `main`， 和 `logseq`。保持 `name` 不变，`main` 更改为 `index.html`。`logseq` 字段用于配置插件。目前设置为空对象 `{}` 即可。像这样：
	-
	  ```json
	  {
	    "name": "logseq-hello-world",
	    "version": "1.0.0",
	    "main": "index.html",
	    "logseq": {}
	  }
	  ```
	- 创建一个 `index.html` 作为插件入口。通常来说，可以使用一些前端构建工具来打包前端资源。在这个指南中为了简单起见，我们仅使用单 html 文件。
## 创建令人激动的插件！
	- 复制下面的代码到 index.html 中：
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
	- 在*真正*的项目中，最好使用 `npm install @logseq/libs` 命令来安装插件依赖包。就我们的目的而言，一个 script 标签就足够，它将会加载一个全局的 `logseq` 对象。
	- 用下面的代码替换注释：
	-
	  ```javascript
	  logseq.ready(() => {
	    logseq.App.showMsg("Hello World Logseq!");
	  }).catch(console.error);
	  ```
	- 这个代码会自动执行：当 Logseq 准备好后，它会注册一个展示消息的回调函数。
## 运行插件
	- 在插件页面，单击 `Load unpacked plugin`，然后选择 `logseq-hello-world` 文件夹。"Hello World Logseq!" 将立即显示并且每次软件启动时也会显示。恭喜你完成了第一个插件的开发！
## 下一步
	- 从更多的插件实例中学习：
	  https://github.com/logseq/logseq-plugin-samples
	- 在 Discord 讨论和提问：https://discord.com/channels/725182569297215569/752845167030960141
	- 插件架构：
	  https://whimsical.com/logseq-plugins-draft-wip-B2iSbFBuWx1S4E4CkJed9y
	- 插件 API 文档：TOOD