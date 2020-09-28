---
title: Tutorial
---

## This is a 10 minutes tutorial on how to use Logseq, let's go!
:PROPERTIES:
:background_color: rgb(38, 76, 155)
:END:
##
#+BEGIN_TIP
Type `Enter` to create a new block.
Type `Shift+Enter` to create a new line.
Type `/` to show all the commands.
Type `[[` to reference or create a new page.
Type `((` to reference a block on any page.
Type `Tab` to indent and `Shift+Tab` to unindent block.
Click the help button at the bottom right to see more keybindings. 
#+END_TIP
## 1. Let's create a page [[How to take dummy notes?]]. You can click it to go to that page, or you can `Shift+Click` to open it in the right sidebar! Now you should see both _Linked References_ and _Unlinked References_.
## 2. Let's reference some blocks on [[How to take dummy notes?]], you can `Shift+Click` any block reference to open it in the right sidebar. Try making 
some changes on the right sidebar, those referenced blocks will be changed too!
### ((5f713e91-8a3c-4b04-a33a-c39482428e2d)) : This is a block reference.
### ((5f713ea8-8cba-403d-ac00-9964b1ec7190)) : This is another block reference.
## 3. I don't want to just reference the block title, how about embedding the whole block with it's children?
### {{{embed ((5f713e91-8a3c-4b04-a33a-c39482428e2d)) }}}
## 4. What if I want to embed the whole page? Here you go:
### {{{embed [[How to take dummy notes?]] }}}
## 5. Do you support tags?
### Of course, this is a #dummy tag.
## 6. Do you support tasks like todo/doing/done and priorities?
### Yes!
### NOW A dummy tutorial on [[How to take dummy notes?]]
### LATER Watch Ed's video on how to install logseq app on your GitHub repo and other cool features like graph view.

[:div.videoWrapper
        [:iframe
         {:allowfullscreen "allowfullscreen"
          :allow
          "accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
          :frameborder "0"
          :src "https://www.youtube.com/embed/Vw-x7yTTO0s"
          :height "367"
          :width "653"}]]
