type:: [[Feature]]
platform:: [[All Platforms]] except [[Publish Web]]
description:: Provides encrypted synchronization of graphs between devices.

- #+BEGIN_NOTE
  This feature is in BETA.
  #+END_NOTE
- ## Usage
	- See [this tutorial](https://blog.logseq.com/how-to-setup-and-use-logseq-sync/) for setting up and using sync.
	- **Do not** use this feature with any other third party sync service like iCloud, Syncthing, or Dropbox.
- ## Functionality
	- Syncing is a choice that is made per graph and thus allows for some graphs to be local only.
	- Each graph is encrypted with a password.
	- Sync automatically happens in the background. Click on the cloud icon to force a sync.
- ## FAQ
	- **Question**: Can I use Sync with git?
		- This isn't recommend unless you are pretty familiar with git. If you have auto-commit enabled you are likely to run into issues. `logseq/graphs-txid.edn` should not be checked into git.
	- **Question:** Can I use Sync with other users?
		- This isn't supported yet.
	-
