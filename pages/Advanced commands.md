title:: 高级命令

- 输入 `<` 打开高级命令，选择命令后会在块中展开为一个 BEGIN...END 区块。一个块中可以包含多个 BEGIN...END 区块。
- 高级命令列表：
	- `<Quote` - 把文字展示为引用块，并添加缩进和左右边距。
	- `<Src` - 使用 CodeMirror 高亮代码。像这样 `#+BEGIN_SRC clojure` 传递参数可以设置语言，默认语言是 JavaScript。
	- `<Query` - 定义一个 [[Advanced Queries]] 块。未编辑状态下将渲染为查询结果
	- `<Properties`- 定义 [[Block properties]]。每一行都是一个不同的属性。
	- 警告命令会在块中展示一个图标，以引起注意。灵感来自于 [Asciidoctor admonitions](https://asciidoctor.org/docs/user-manual/#admonition)。
		- `<Note`
		- `<Tip`
		- `<Important`
		- `<Caution`
		- `<Warning`
	- `<Example` - 展示一个带有边距和背景的示例块。
	- `<Verse` - 通过保留换行来展示诗歌。
	- `<Comment` - 将注释以内联的形式嵌入到块中。只有当块处于编辑状态时注释才可见。
	-
	  #+BEGIN_COMMENT
	  `<Latex export` - TODO
	  `<Center` - TODO
	  `<Ascii` - TODO
	  `<Export` - TODO
	  #+END_COMMENT