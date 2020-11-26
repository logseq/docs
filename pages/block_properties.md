---
title: Block properties
---

## Properties are key-value pairs associated with an block.
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
## `Properties` can be used for building the queries you'd like.
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
