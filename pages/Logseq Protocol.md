- Logseq provides a protocol `logseq://` to allow third party applications to invoke actions within Logseq.
- The following urls are supported:
	- `logseq://graph/<graph-name>?<params>`
		- Has optional params of `block-id` and `page`
		- Examples:
			- `logseq://graph/<graph name>` - Opens graph
			- `logseq://graph/<graph name>?page=<page name>` - Opens graph at page
			- `logseq://graph/<graph name>?block-id=<block uuid>` - Opens graph at block
	- `logseq://x-callback-url/quickCapture?<params>`
		- Quick capture for short text and links. Can be added as a bookmark link to modern browser or opened from command line shell
		- Basic usage:
			- Drag the following Share to Logseq" link to your Bookmark bar(cmd+shift+b to toggle bookmark bar on macOS). Then you have a "quick capture" for your Logseq App.
				- <a href="javascript:var d=document,w=window,f='logseq://x-callback-url/quickCapture',l=d.location,e=encodeURIComponent,p='?url=%27+e(l.href)+%27&title=%27+e(d.title)+%27&content=%27+e(w.getSelection?w.getSelection().toString():d.getSelection?d.getSelection():d.selection.createRange().text)+%27&x-source=bm%27;a=function(){l.href=f+p};if(/Firefox/.test(navigator.userAgent))setTimeout(a,0);else{a()}void(0)">Share to Logseq</a>
				- (or open https://jsfiddle.net/andelf/kvm5Le6z/7/ and drag "Share to Logseq" link to bookmark bar)
		- Parameters:
			- `url`: page url
			- `title`: page title
			- `content`: (optional) highlighted text(selection)
			- `append`: (optional, boolean) Append to the end of the page, default to `false`(current editing position)
			- `page`:    (optional) Page name to insert to, use "TODAY" to insert to today page
		- Settings (in `config.edn`):
			- `{time}`: capture time
				- `{date}`: capture date using current date format, use `[[{date}]]` to get a page reference
				- `{text}`: text that users selected before sharing.
				- `{url}`: URL or assets path for media files stored in Logseq.
				- #+BEGIN_TIP
				  Use `[[{date}]]` for a reference to today's journal page
				  #+END_TIP
			- ```edn
			  :quick-capture-templates
			  {:text "[[quick capture]] **{time}**: {text} from {url}"
			   :media "[[quick capture]] **{time}**: {url}"}
			  
			  :quick-capture-options
			  {:insert-today? false
			   :redirect-page? true
			   :default-page "My Captured Page"}
			  ```
-