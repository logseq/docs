---
title: Tips and Tricks
---

- **How to escape formatting?** #card
  id:: 5fc3be83-7f22-4488-b3ec-cfabb0639b3b
  card-last-interval:: 4
  card-repeats:: 2
  card-ease-factor:: 2.7
  card-next-schedule:: 2021-10-15T12:21:18.187Z
  card-last-reviewed:: 2021-10-11T12:21:18.188Z
  card-last-score:: 5
	- `snake_case_text` will be displayed as snake_case_text by default, to display it as `snake_case_text`, you can escape some string using `\`, for example `snake\_case\_text` will be displayed as snake\_case\_text.
- **How to review a page instead of a block using SRS [[Flashcards]] ?** #card
  card-last-interval:: 4.14
  card-repeats:: 1
  card-ease-factor:: 2.6
  card-next-schedule:: 2021-10-03T18:35:04.144Z
  card-last-reviewed:: 2021-09-29T15:35:04.144Z
  card-last-score:: 5
	- You can embed a page in a #card block. For example:
	  card-last-interval:: 4.14
	  card-repeats:: 1
	  card-ease-factor:: 2.6
	  card-next-schedule:: 2021-10-03T18:35:23.173Z
	  card-last-reviewed:: 2021-09-29T15:35:23.173Z
	  card-last-score:: 5
	  `{{embed [[term/alias]]}}`
	  {{embed [[term/alias]]}}