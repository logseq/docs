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
:author: [[sönke ahrens]]
:publication date: february 21, 2017
:created_at: 1609233078964
:last_modified_at: 1609246163003
:END:
#### [[How to solve it]]
:PROPERTIES:
:type: [[book]]
:author: [[g polya]] [[john h conway]]
:created_at: 1609233053383
:last_modified_at: 1609233075686
:END:
## `Properties` can be used for selecting specific blocks.
:PROPERTIES:
:created_at: 1609233183055
:last_modified_at: 1609233190917
:END:
### For example, let's query all the blocks with the property "type" and the value "book" #examples #books  
:PROPERTIES:
:created_at: 1609233197980
:last_modified_at: 1609233317859
:END:
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
