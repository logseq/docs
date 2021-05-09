---
title: Custom keyboard shortcuts
---

-
  > People come to Logseq from different operating systems, use different keyboard layouts and languages, and have different preferences. Customizable keyboard shortcuts is the only way to make everybody happy. - [[Cobblebot]] 
  https://discuss.logseq.com/t/customizable-keyboard-shortcuts/146
- **How to add custom keyboard shortcuts?**
  To add custom shortcuts, you can add/modify the `:shortcuts` section in config.edn, for example:
  #+BEGIN_EXAMPLE
  :shortcuts {:ui/toggle-theme "mod+c mod+t"}
  #+END_EXAMPLE
- **Which shortcuts could be customized?**
  The default shortcuts are here:
  https://github.com/logseq/logseq/blob/master/src/main/frontend/keyboards.cljs#L36
- **What syntaxes do the shortcuts support?**
  Logseq is using [Mousetrap](https://github.com/ccampbell/mousetrap) to manage keyboard shortcuts.
  Check [this](https://craig.is/killing/mice#api.bind) for the specific bind syntaxes that mousetrap support.