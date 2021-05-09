---
title: Block properties
---

- Properties are key-value pairs associated with a block.
  created_at:: 1609337544932
  last_modified_at:: 1609337544932
- A Properties section can be defined:
    - by selecting the command `<Properties`
    - by right clicking the left dot and clicking `Add a property`.
- Usage Example:
    - Let's add two books:
        - [[How to take smart notes]]
          type:: [[book]]
          author:: [[sönke ahrens]]
          publication_date:: [[february 21, 2017]]
          created_at:: 1609233078964
          last_modified_at:: 1609337624066
          id:: 5fec89e0-b3ea-4d90-ba98-40d2503f7500
        - [[How to solve it]]
          type:: [[book]]
          author:: [[george polya]]
          created_at:: 1609233053383
          last_modified_at:: 1609337985298
          id:: 5fec89e0-2b4b-4829-9697-00c139165e59
- `Properties` can be used for selecting specific blocks.
  created_at:: 1609233183055
  last_modified_at:: 1609233190917
    - For example, let's query all the blocks with the property "type" and the value "book" #examples #books
      created_at:: 1609337879435
      last_modified_at:: 1609337879435
      {{query (property type book)}}
        - Or, we can use the [[Advanced Queries]]:
          created_at:: 1609337897497
          last_modified_at:: 1609337897497
          
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
        -
          created_at:: 1609337407330
          last_modified_at:: 1609337407330
          #+BEGIN_QUERY
          {:title [:h2 "My books"]
           :query [:find (pull ?b [*])
                 :where
                 [?b :block/properties ?p]
                 [(get ?p "type") ?t]
                 [(= "[[book]]" ?t)]]
           }
          #+END_QUERY
- **Resources**
    - 1. [Org-mode properties](https://orgmode.org/guide/Properties.html)