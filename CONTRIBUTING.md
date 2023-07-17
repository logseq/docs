Thanks for your interest in contributing! :heart: :man_dancing: :woman_dancing:

## What to contribute

Fixes and small changes are great. Logseq has a large number of features so new
docs for undocumented features are much appreciated. See [this
section](#documenting-a-feature) on documenting a new feature. We also keep a
[live list of documentation tasks](https://docs.logseq.com/#/page/docs) that we
could use help with. Feel free to ask questions on Github or the Discord
`#documentation` channel if attempting one of these tasks. If you are making
large changes to the documentation, please open an issue to discuss them first.

We also have [documentation tasks](https://github.com/orgs/logseq/projects/5/views/1?filterQuery=label%3Adocumentation) outside this repository that could use help.

### Documenting a Feature

A feature page has a specific format as described in
https://docs.logseq.com/#/page/Feature. Use the `Feature` template when starting
a new page. Please fill in as many of the properties and headers as you can.
If you only know enough to fill in parts of a page, that's fine. Just add a
`TODO Write Something Descriptive Here #docs` with what's left to do.

### What not to Contribute

* Tutorials on how to do X
  * Reach out to Ramses on https://discuss.logseq.com/c/docs/18 or on Discord if interested in contributing one.
* Changes to how pages are organized or formatted
  * These pages are organized with a fairly specific ontology as they are translated to RDF.
* Changes to our `TODO ... #docs` tasks
  * Unless you're finishing one of these, please leave these alone as we are using them to track our progress.

## How to Contribute

For minor fixes like typos, feel free to just [edit a
file in Github](https://docs.github.com/en/repositories/working-with-files/managing-files/editing-files).

For any other contribution it helps to make changes locally so you see you can how it looks in Logseq. In order to do this you should:

1. Ensure you have [git](https://git-scm.com/downloads) installed.
2. Fork and Clone THIS REPO. The upstream should be set to the FORKED REPO. If you need more information on what this means, read:
* [About forks](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/about-forks)
* [Cloning and forking repositories from GitHub Desktop](https://docs.github.com/en/desktop/contributing-and-collaborating-using-github-desktop/adding-and-cloning-repositories/cloning-and-forking-repositories-from-github-desktop)
3. Add the cloned local repo (of your FORKED REPO) to Logseq via the `Add new graph` button on the top left dropdown menu. Select the directory where you cloned the repo.
4. Create a branch off of master. The following two commands create a branch called `branch-name` and navigates onto it.

```git
git branch branch-name
git checkout branch-name
```
5. Make your edits and confirm they look good in Logseq. Then, commit them using `git commit -m "message"` and `git push` and submit a pull request onto GitHub!
  * For submitting a pull request, check: [Creating a pull request from a fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request-from-a-fork)

For more info, see [this guide on working with pull
requests](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request-from-a-fork).
