- Hiccup is a domain-specific language for generating HTML used mostly in Clojure community.
- Check out [this](https://medium.com/makimo-tech-blog/hiccup-lightning-tutorial-6494e477f3a5) tutorial for a quick introduction.
- You can embed Hiccup inside block same as if you want to embed HTML.
- Example:
	- [:h2 {:style {:color "red"}} "h2 title"]
	    [:p "Hello " [:em "World!"]]