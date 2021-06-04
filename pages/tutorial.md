---
title: 开始
---

- hi，欢迎来到 logseq！
  heading:: true
-
  > Logseq是一个隐私第一、开源的知识共享和管理平台。
- 一些有用的技巧：
  id:: 60293d41-1351-40ed-aa00-0e0c12be1175
  - 单击块即可编辑。
    按 `Enter` 键新增块。
    按 `Shift+Enter` 在当前块中新增新行。
    输入 `/` 显示所有命令。
    输入 `[[` 引用一个页面或者创建一个页面。
    输入 `((` 引用一个块。
    按 `Tab` 缩进块 `Shift+Tab` 取消缩进块。
    输入 `/Draw` 可以画图。
    输入 `<` 显示更多的格式化命令（例如 quotes 和 tips）。
  - 点击右下角的帮助按钮可以看到更多的快捷键。
- 开始
  heading:: true
- **1. 让我们创建一个页面** - 名字是 [[How to Take Notes]]。 输入 `[[]]` 引用一个页面或者创建一个新页面。 你也可以通过搜索框创建一个新页面。
  - 单击即可打开页面，按住`Shift` 单击在右侧栏打开！在页面底部，可以看到 _已关联引用_ 和 _未关联引用_ - 每一次你在 Logseq 中想到它。
- **2. 引用一个块** - 在 [[How to Take Notes]] 页面中， 按住 `Shift` 单击页面或者单击块前面的小圆点可以在右侧栏打开它们。在右边栏做出更改，引用它们的地方会同步更新。
  - ((60293d41-1351-40ed-aa00-0e0c12be1175)) 这是一个块引用。
  - ((60293d41-2c37-43f2-aa0e-4e0ad8e38531)) : 这是另一个块引用。
- **3. 嵌入块** - 引用还不够用！ 我不想看到和编辑任何快！ 你可以输入 `/` 然后选择 `Block Embed` 嵌入一个块（包含其子块）：
  - {{embed ((6018cc98-67a8-4eb2-bfd7-2affe517a7c7)) }}
- **4. 嵌入页面** - 如果我想嵌入一整个页面呢？输入 `/` 可以看到另一个选项 - `Page Embed` :
  - {{{embed [[How to Take Notes]] }}}
- **5. 使用标签** - 使用标签可以把页面和块进行分类，单击标签即可以看到这些标签下的块和页面！
  - 看一下这个 #dummy 标签。
    id:: 60293d41-2c37-43f2-aa0e-4e0ad8e38531
- **6. 管理你的任务和待办事项** - Logseq 待办事项支持 todo/doing/done 状态和优先级吗?
  - 可以，在块编辑状态下，按下 `Ctrl/Cmd + Enter` 可以循环切换待办事项的状态，或者输入 `/` 并输入关键字选择转态或优先级（A/B/C）。
  - NOW [#A] 一个关于 "How to Take Notes" 的虚拟教程
  - DONE 创建 Logseq 入门教程
    done:: 1622784127683
    todo:: 1612237041309
  - CANCELED [#C] 写一个超过 1000 个块的页面
- **7. 欣赏你的第二大脑吧** - 在你创建并连接一些页面和想法之后，可以看到你的数字大脑正在成长。
  - 单击右侧栏的图谱可以查看
- 更进一步?
  heading:: true
  - [:a {:href "https://twitter.com/EdTravelling" :target "_blank"} "@EdTravelling"] 发布了一个很棒的视频, 介绍了如何在你的 Github 仓库中安装 Logseq和其他的一些特性，例如查看图谱。

    [:div.videoWrapper.mb-4
          [:iframe
           {:allowFullScreen "allowfullscreen"
            :allow
            "accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
          :frameBorder "0"
          :src "https://www.youtube.com/embed/Vw-x7yTTO0s"
          :height "367"
          :width "653"}]]
  - 这个精心制作的 [[Glossary]] 可能会有帮助。
  - 在右侧栏查看完整的文档 ->
