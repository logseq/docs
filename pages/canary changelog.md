---
title: Canary Changelog
---

- [[Apr 30th, 2021]]
  Canary Version 0.0.1
  Desktop app download link:
  https://github.com/logseq/logseq/releases/tag/0.0.1

  Logseq Canary is for early adopters and developers to test new features and APIs without affecting the stable working environment. It will be installed as a separate app besides the stable one.

  #+BEGIN_WARNING
  To play it safe, we recommend using new content only with the canary app. If you want to try it with existing content, do remember to back up first in case of data loss or corruption.
  #+END_WARNING
    - This is the first canary release, introducing the big refactoring of Logseq. The rationale behind the refactoring is detailed here [[The Refactoring Of Logseq]]. Overall, it makes the code simpler and more robust, fixes some long-standing issues along the way and paves the way for upcoming features.
    - [[Enhancement]]
        - A refactored core that is simpler and more robust.
        - A much better undo/redo experience.
        - Better keyboard navigation:
            - ![](https://user-images.githubusercontent.com/45989292/116767907-a44f2080-aa65-11eb-9cc3-e2ed34e4b6aa.gif)
            - We've made most of above shortcuts customizable as well. If you don't like arrow keys, you can change it. Also for navigation keys in auto-completion, search, and more.
              Check [[Custom keyboard shortcuts]] for more details!
        - Markdown improvements:
            - The grammar of properties changes as below while staying the same in Org mode:
              #+BEGIN_QUOTE
              title
              property-1:: value-1
              property-2:: value-2
              body
              #+END_QUOTE
            - Support unordered list as headings
            - Support headings as top-level blocks, with convenient /h1 ~ /h6 commands
