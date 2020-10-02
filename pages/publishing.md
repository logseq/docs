---
title: Publishing
---

## How to public your knowledge base to github pages or any hosting server?
- Download the [release](https://github.com/logseq/logseq/releases) and unzip it.
- Go to the pages that you'd like to deploy to the public, click the right vertical menu, then click "Make it public".
[[https://cdn.logseq.com/%2F8b9a461d-437e-4ca5-a2da-18b51077b5142020_10_02_Screenshot%202020-10-02%2009-10-50%20%2B0800.png?Expires=4755201069&Signature=gHK--2vj82UBcL-QaGHq7DwPe8XWObEzULYbLS4LWvTMpy8R8ONstFI1SCOai3YjqkPlY~4omT9LTClNcj~QKSPbK6cVX0ShU4rTXtwFc5GfHo9F-P6g7yEsyDMxhC0S5-Bg9NRpPt9MJCjoAfGIqI1jUjyW3ZSMMhj~XpiVElQrC5YlJiaY43pfSK-FUTYW9c7JVlfLMBLFGtbTJpyOtocbiZNEtuRsIF7Zpr~J17PE0nJzTUdoTgM1tuX8~EkTFiPp77iZlBt4832MTaDDSxsp0DXJGC4Ixij8oueU1cZVgBS0RN21qrTjDyx4RIEnXoE4ZWyJNK-2cxA463E8Lg__&Key-Pair-Id=APKAJE5CCD6X7MP6PTEA][2020_10_02_Screenshot 2020-10-02 09-10-50 +0800.png]] 

- You can also choose to make the all the pages public by adding `:all-pages-public? true` to `logseq/config.edn`.

- Update the `logseq/config.edn`, you can configure the home page to be something like this: 
[[https://cdn.logseq.com/%2F8b9a461d-437e-4ca5-a2da-18b51077b5142020_10_02_Screenshot%202020-10-02%2009-14-11%20%2B0800.png?Expires=4755201265&Signature=myAhcN95Rv6u6q6ywW0PwVh~NKDgFC7plh8DXMhfkZ1VSo702cNhWApXLL32pvWKQlHOVNzSSjvwuXshjhiZ-ekR7QshiicZJP3--bhGZ0DHCx8ElZGGeUOol1DTPCXoqdBPuS6WCQEu76DCVhxAIMfAvHAIRIleSDau57TY4STGECb7cHPXBoDw2rVJsnQ9lIVTNf0k4Ola32EopRpjZ1yDlo1uqHHUgmj~RJO-VnzXmz4rGoHJ-kx~PjMJezqBuDfao2RDc5k75otH8EJydVOzVelfp89a4rkCcCjNOt2BgiYw1Bl04Fs~SpIYz-stC88JZnsaJ-WZVt0V7bk11Q__&Key-Pair-Id=APKAJE5CCD6X7MP6PTEA][2020_10_02_Screenshot 2020-10-02 09-14-11 +0800.png]] 

- Go to https://logseq.com, click the user avatar and then click "Publishing" to download an `index.html` file, put it in your unzipped folder.
- Deploy the folder to your github pages (gh-pages branch) or any server.
## We'll make it much easier for publishing in the future, for example, you can click a "Publish" button which will deploy to your preferred hosting solution (gh pages, netlify, etc.).
