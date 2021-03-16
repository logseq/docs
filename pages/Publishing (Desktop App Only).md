---
title: Publishing (Desktop App Only)
---

## To provide the best publishing experience, Logseq at this moment only supports publishing on the desktop app.
## How to publish?
### Click the page titles that you wish to publish, select "Publish it for export" in the right pop-up menu. You can also choose to make all the pages public by adding `:all-pages-public? true` to `logseq/config.edn`.
### Click the top-right three-dots and select "Export public pages". Then select a folder, and Logseq will export all the files needed for publishing there.
### The exported assets basically make up a web application, when runs Logseq with your public pages, in read-only mode. After exporting, if you are on Linux-like environment, you can `cd` into the export folder and run `python -m SimpleHTTPServer`. Voilà, you can now visit the published graph at localhost:8000 in your browser.
### Of course publishing your beautiful graph on localhost only is not that fun. Since we have all the assets now, publish them on platforms like Github Pages and Vercel is straightforward. Below is a video tutorial on how to publish Logseq pages to Github Pages.
## [[TODO: video tutorial]]
