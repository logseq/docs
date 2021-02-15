---
title: Publishing
---

## How to publish your knowledge base to Github pages or any hosting server?
- Download the latest publishing [release](https://github.com/logseq/logseq/releases/tag/0.0.6.0) and unzip it.
- Go to the pages that you'd like to deploy to the public, click the right vertical menu, then click "Publish" and select "Publish it when exporting to an HTML file".

- You can also choose to make all the pages public by adding `:all-pages-public? true` to `logseq/config.edn`.

- Update the `logseq/config.edn`, you can configure the home page to be something like this: 
[[https://cdn.logseq.com/%2F8b9a461d-437e-4ca5-a2da-18b51077b5142020_10_02_Screenshot%202020-10-02%2009-14-11%20%2B0800.png?Expires=4755201265&Signature=myAhcN95Rv6u6q6ywW0PwVh~NKDgFC7plh8DXMhfkZ1VSo702cNhWApXLL32pvWKQlHOVNzSSjvwuXshjhiZ-ekR7QshiicZJP3--bhGZ0DHCx8ElZGGeUOol1DTPCXoqdBPuS6WCQEu76DCVhxAIMfAvHAIRIleSDau57TY4STGECb7cHPXBoDw2rVJsnQ9lIVTNf0k4Ola32EopRpjZ1yDlo1uqHHUgmj~RJO-VnzXmz4rGoHJ-kx~PjMJezqBuDfao2RDc5k75otH8EJydVOzVelfp89a4rkCcCjNOt2BgiYw1Bl04Fs~SpIYz-stC88JZnsaJ-WZVt0V7bk11Q__&Key-Pair-Id=APKAJE5CCD6X7MP6PTEA][2020_10_02_Screenshot 2020-10-02 09-14-11 +0800.png]] 

- Go to https://logseq.com, click the user avatar and then click "Export public pages" to download an `index.html` file, put it in your unzipped folder.
- Deploy the folder to your GitHub pages (gh-pages branch) or any server.
## We'll make it much easier for publishing in the future, for example, you can click a "Publish" button which will deploy to your preferred hosting solution (gh pages, netlify, etc.).
