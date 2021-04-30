---
title: Canary Changelog
---

## [[Apr 30th, 2021]]
Canary Version 0.0.1
Desktop app download link:

Logseq Canary is for early adopters and developers to test new features and APIs without affecting the stable working environment. It will be installed as a separate app besides the stable one.

#+BEGIN_QUOTE
To play it safe, we recommend using new content only with the canary app. If you want to try it with existing content, do remember to back up first in case of data loss or corruption.
#+END_QUOTE
### This is the first canary release, introducing the big refactoring of Logseq. The rationale behind the refactoring is detailed here [[The Refactoring Of Logseq]]. Overall, it makes the code simpler and more robust, fixes some long-standing issues along the way and paves the way for upcoming features.
### [[Enhancement]]
#### A refactored core that is simpler and more robust.
#### A much better undo/redo experience.
#### Better keyboard navigation:
![2021-04-30 21.10.23.gif](../assets/2021-04-30_21.10.23_1619788837457_0.gif)
#### Markdown improvements:
##### The grammar of properties changes as below while staying the same in Org mode:
#+BEGIN_QUOTE
title
property-1:: value-1
property-2:: value-2
body
#+END_QUOTE
##### Support unordered list as headings
##### Support headings as top-level blocks, with convenient /h1 ~ /h6 commands
