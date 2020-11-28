---
title: Block properties
---

## Properties are key-value pairs associated with a block.
## A Properties section can be defined:
### by selecting the command `<Properties`
### by right clicking the left dot and clicking `Add a property`.
## Usage Example:
### Let's add two books:
#### [[How to take smart notes]]
:PROPERTIES:
:type: [[book]]
:author: [[Sönke Ahrens]]
:publication date: February 21, 2017
:END:
#### [[How to solve it]]
:PROPERTIES:
:type: [[book]]
:author: [[G Polya]] [[John H Conway]]
:END:
## `Properties` can be used for selecting specific blocks.
### For example, let's query all the blocks with the property "type" and the value "book"
#+BEGIN_SRC clojure
#+BEGIN_QUERY
{:title [:h2 "My books"]
 :query [:find (pull ?b [*])
         :where
         [?b :block/properties ?p]
         [(get ?p "type") ?t]
         [(= "[[book]]" ?t)]]
 }
#+END_QUERY
#+END_SRC
####
#+BEGIN_QUERY
{:title [:h2 "My books"]
 :query [:find (pull ?b [*])
         :where
         [?b :block/properties ?p]
         [(get ?p "type") ?t]
         [(= "[[book]]" ?t)]]
 }
#+END_QUERY
## **Resources**
### 1. [[https://orgmode.org/guide/Properties.html][Org-mode properties]]
