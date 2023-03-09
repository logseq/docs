type:: [[Class]]
description:: A user-facing piece of functionality. This can be a small piece or it can be a big one that consists of subfeatures

- ## Conventions
	- A feature page has the following properties
		- `type` (required) - Set to `[[Feature]]` to identify it as a feature
		- `platforms` (required) - Indicates on what platforms the feature is available
		- `description` (optional) - A brief description of what the feature does
		- `initial-version` (optional) - Logseq version the feature was first introduced
	- A feature page normally contains the following sections:
		- `Usage` (required) - Answers the **how** of a feature. Immediately helps a user use a feature
		- `Functionality` (required) - Answers the **what** of a feature. Enumerates all the behaviors of a feature. Important so a user understands what is intended behavior and what is not (a bug).
		- `Background` (optional) - Answers the **why** of a feature by explaining a feature in depth. Good place to find a feature's use cases.
		- `Additional Links` (optional) - Useful place for listing additional references and related pages.