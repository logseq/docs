type:: [[Feature]]
platforms:: [[All Platforms]] except [[Web]] and [[Publish Web]] 
description:: Paid feature that provides encrypted synchronization of graphs between devices.

- #+BEGIN_NOTE
  This feature is in BETA.
  #+END_NOTE
- ## Usage
	- See [this tutorial](https://blog.logseq.com/how-to-setup-and-use-logseq-sync/) for setting up and using sync.
	- It's currently available for all *active* Open Collective contributors ($5 or $15 per month).
	- **Do not** use this feature with any other third party sync service like iCloud, Syncthing, or Dropbox.
	- If you experience issues, check [This FAQ](https://discuss.logseq.com/t/im-using-logseq-sync-what-should-i-do-if-i-am-experiencing-sync-issues/13599). If the FAQ doesn't help, feel free to ping the team for attention on the [`beta-sync` channel](https://discord.com/channels/725182569297215569/1013467386130747522) of [Discord](https://discord.gg/KpN4eHY).
- ## Functionality
	- Syncs up to 10 graphs between Logseq Desktop, Android, and iOS.
	- Syncing is a choice that is made per graph and thus allows for some graphs to be local only.
	- Each graph is encrypted with a password.
	- Sync automatically happens in the background. Click on the cloud icon and the `Sync now` button to force a sync.
- ## FAQ
	- **Question**: Can I use Sync with git?
		- This isn't recommend unless you are pretty familiar with git. If you have auto-commit enabled you are likely to run into issues. `logseq/graphs-txid.edn` should not be checked into git.
	- **Question:** Can I use Sync with other users?
		- This isn't supported yet.
	- **Question:** Are my notes encrypted and what encryption technology do you use?
		- Yes, your graph is end-to-end encrypted.
		- All the files, including the assets such as pictures, videos, and PDFs, are encrypted using the [age](https://age-encryption.org/) encryption.
	- **Question:** Are file names and paths encrypted?
		- Yes.
	- **Question**: Where is my encrypted data stored?
		- Your encrypted data is stored on [AWS](https://aws.amazon.com/).
	- **Question:** Some files didn't download to my device, what should I do?
		- First, make sure you're using the latest release.
		- Usually, it's because each operating system has its file and folder name limitations. You can check [[Logseq file and folder naming rules]] to get more details. We suggest you upgrade the filename format first, you can do it in `Settings` -> `Advanced` -> `Filename format` -> `Edit` and follow the instructions in the popup.
			- ![CleanShot 2022-11-06 at 23.07.43.png](../assets/CleanShot_2022-11-06_at_23.07.43_1667747274130_0.png)
			-