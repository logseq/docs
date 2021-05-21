---
title: Templates
---

- **How to use it?**
  {{embed ((60311d25-f0c8-45af-a54f-e5e7d11bdf8d)) }} 
  https://discuss.logseq.com/t/templates-how-to-create-edit-and-insert/200
- [[Dynamic Variables]] support
  id:: 60311eda-b6f7-4779-8187-8830545b3a64
  - **Notice:** [[Macros]] support dynamic variables too
  - **Syntax:** `<% something %>`
  - **Supported variables:**
    - `today` => `[[Today's journal page]]`
    - `yesterday` => `[[Yesterday's journal page]]`
    - `tomorrow` => `[[Tomorrow's journal page]]`
    - `time` => `Current time`, e.g. 22:44
    - `current page` => `[[Current page]]`
    - [Natural language date](https://github.com/wanasit/chrono)
      id:: 60312078-ae36-4395-bdfb-747304b80c03
      `Last Friday` => `[[Feb 12th, 2021]]`
      -
        #+BEGIN_QUOTE
        - Today, Tomorrow, Yesterday, Last Friday, etc
        - 17 August 2013 - 19 August 2013
        - This Friday from 13:00 - 16.00
        - 5 days ago
        - 2 weeks from now
        - Sat Aug 17 2013 18:40:39 GMT+0900 (JST)
        - 2014-11-30T08:15:30-05:30
        #+END_QUOTE
        Examples from https://github.com/wanasit/chrono
### Examples
id:: 60a790f8-d187-499a-b2e2-73bf137356dd
  - template example 1
    template:: template-example-1
    id:: 60a79104-bd2b-486c-bb9e-9d264650ce1f
    - line1
      - line2
  - template example 2
    template:: template-example-2
    including-parent:: false
line1
line2