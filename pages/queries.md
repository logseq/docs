---
title: Queries
---

## **What are "Queries"?**
:PROPERTIES:
:created_at: 1609230242742
:last_modified_at: 1609247076654
:END:
### Queries are for asking questions from your knowledge base and the outside world (in the coming weeks).
:PROPERTIES:
:last_modified_at: 1609231528688
:created_at: 1609230243642
:END:
[:div [:img {:src "https://cdn.logseq.com/%2F5ff0a01d-47d4-487d-b346-4a43ded21ad02020_12_29_photo-1444703686981-a3abbc4d4fe3.jpeg?Expires=4762830816&Signature=h~yT-Tq1VtBtEm09Z78eT5kkEbQGUVG-VBEDuGLgykW8vb~AkZNuoRNmwL-fcHgnG8HdYBhqXeJowN9q3my4UN1bxiJtAXl0dAEjmWAqpbedH9PPdyz2tZXcuPxwdk5wICFLrB~0VWMwV02LFZEKkgPYGhkUU8oakBphifgvTdYPKLQG95FTJh9kg7GhV5ZCc1Q3JrOlLGG2fuUObf1opScwbNbEdsQStO8Ou12AaTPccAmpxAJVuut-jZ9pRvdsa00X962QD9c67BEw1SfhKEcChNIbdp~44ltuRj1Bvc1Bs2ezKupQ1sWFD5BG97UEA7GuOyANjPC331ShW8aHSQ__&Key-Pair-Id=APKAJE5CCD6X7MP6PTEA"}]]
[:div.text-sm "By " [:a {:href "https://unsplash.com/photos/oMpAz-DN-9I" :target "_blank"} "Greg Rakozy"]]
##
#+BEGIN_NOTE
Both `created_at` and `last_modified_at` are disabled temporarily, we'll add both back later.
#+END_NOTE
## **How to write queries?**
:PROPERTIES:
:created_at: 1609231967174
:last_modified_at: 1609251558592
:id: 5feb30e3-fedc-4c2a-aa03-b44020c21c68
:END:
### There're two kinds of queries:
:PROPERTIES:
:created_at: 1609237373442
:last_modified_at: 1609244684831
:END:
1. Simple queries by using `{{query }}`, the format is something like this:
 #+BEGIN_EXAMPLE
 {{query Something you're looking for}}
 #+END_EXAMPLE
 You can type `/query` to create a simple query.
2. [[Advanced Queries]]
## **Simple Queries filters**
:PROPERTIES:
:created_at: 1609237391135
:last_modified_at: 1609237391135
:END:
### **and**
:PROPERTIES:
:created_at: 1609237410438
:last_modified_at: 1609242191381
:END:
Examples:
#+BEGIN_EXAMPLE
(and [[page 1]] [[page 2]])
#+END_EXAMPLE

#+BEGIN_EXAMPLE
(and (todo now later done) [[page]])
#+END_EXAMPLE
### **or**
:PROPERTIES:
:created_at: 1609237412110
:last_modified_at: 1609242378334
:END:
Examples:
#+BEGIN_EXAMPLE
(or [[page 1]] [[page 2]])
#+END_EXAMPLE
### **not**
:PROPERTIES:
:created_at: 1609237413167
:last_modified_at: 1609243244686
:END:
Examples:
#+BEGIN_EXAMPLE
(not [[page 1]] [[page 2]])
#+END_EXAMPLE
### **between**
:PROPERTIES:
:last_modified_at: 1609243879053
:created_at: 1609237415572
:END:
The format `(between start end)` will only support blocks on the journal pages.
`(between created_at|last_modified_at start end)` support blocks on all the pages, you need to enable [[block timestamps]] to have those timestamps for new blocks.

There're several built-in symbols:
 1. `today|yesterday|tomorrow|now`
 2. `+|-` number `y|m|w|d|h|min`

Examples:
#+BEGIN_EXAMPLE
(between -7d +7d)
(between -2w today)
(between created_at -7d 7d)
(between last_modified_at -7d 7d)
#+END_EXAMPLE
### **Page**
Examples: [[questions]]
{{query (and (page "Page Alias"))}}
### **property** [[Block properties]]
:PROPERTIES:
:created_at: 1609237428110
:last_modified_at: 1609247365218
:END:
Examples:
{{query (property type book)}}

### **Full-text query**
Examples:
{{query "alias"}}
### **todo**
:PROPERTIES:
:created_at: 1609237429937
:last_modified_at: 1609242962513
:END:
Examples:
#+BEGIN_EXAMPLE
(todo now)
(todo now later)
#+END_EXAMPLE
### **priority**
:PROPERTIES:
:created_at: 1609237434982
:last_modified_at: 1609242958502
:END:
Examples:
#+BEGIN_EXAMPLE
(priority a)
(priority a b c)
#+END_EXAMPLE
### **page-property**
:PROPERTIES:
:created_at: 1609237443550
:last_modified_at: 1609243687213
:END:
Example:
{{query (page-property related "Block embed")}}
### **page-tags**
:PROPERTIES:
:created_at: 1609237445606
:last_modified_at: 1609243746666
:END:
Example:
{{query (page-tags embed)}}
### **all-page-tags**
:PROPERTIES:
:created_at: 1609237447926
:last_modified_at: 1609243762970
:END:
Example:
{{query (all-page-tags)}}
### **sort-by**
:PROPERTIES:
:created_at: 1609237456009
:last_modified_at: 1609243222016
:END:
Format: `(sort-by key order)` or `(sort-by key)`
`key`: `created_at`  | `last_modified_at`
`order`: `desc` or `asc`, omit means `desc`.
#+BEGIN_EXAMPLE
(and (todo now later) (sort-by created_at desc))
#+END_EXAMPLE
## **More query examples**
:PROPERTIES:
:created_at: 1609232210837
:last_modified_at: 1609243310412
:END:
### 1. Find the blocks containing page "tag1"
:PROPERTIES:
:created_at: 1609232870139
:last_modified_at: 1609233755992
:END:
#+BEGIN_EXAMPLE
{{query [[tag1]]}}
#+END_EXAMPLE
{{query [[tag1]]}}
### 2. Find the blocks containing both `tag1` and `tag2`
:PROPERTIES:
:created_at: 1609233702047
:last_modified_at: 1609233790865
:END:
#+BEGIN_EXAMPLE
{{query (and [[tag1]] [[tag2]])}}
#+END_EXAMPLE
{{query (and [[tag1]] [[tag2]])}}
### 3. Find the blocks containing either `tag1` or `tag2`
:PROPERTIES:
:created_at: 1609233864422
:last_modified_at: 1609233864422
:END:
#+BEGIN_EXAMPLE
{{query (or [[tag1]] [[tag2]])}}
#+END_EXAMPLE
{{query (or [[tag1]] [[tag2]])}}
### 4. Find the blocks containing `tag2` but not `tag1`
:PROPERTIES:
:created_at: 1609234732407
:last_modified_at: 1609236840152
:END:
{{query (and [[tag2]] (not [[tag1]]))}}
### 5. Find journal blocks created between [[Dec 5th, 2020]] to [[Dec 7th, 2020]]
:PROPERTIES:
:created_at: 1609242222695
:last_modified_at: 1609242323029
:END:
{{query (between [[Dec 5th, 2020]] [[Dec 7th, 2020]] )}}
### 6. Find all the blocks created today (you need to enable [[block timestamps]] before using this query)
:PROPERTIES:
:created_at: 1609235122723
:last_modified_at: 1609249085047
:END:
#+BEGIN_EXAMPLE
{{query (between created_at today tomorrow)}}
#+END_EXAMPLE
