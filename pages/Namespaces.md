type:: [[Feature]]
platforms:: [[All Platforms]] 
description:: Used to group a set of related pages

-
- Namespaces can be used to **avoid name conflicts** and **build hierarchical page relationships**.
- A page can be placed in a namespace by putting the namespace and a slash in the page's title.
	- For example, to put this page in the `Important Features` namespace, you would title it `Important Features/Namespaces`
-
- Namespaces can be stacked: `Important Features/Very Important Features/Namespaces`
- Pages in a namespace are automatically backlinked to the namespace's page.
	- In our above example where we name this page `Important Features/Namespaces`, the page would be automatically backlinked to `Important Features`, and show up in the linked references section at the bottom.
	- In the above multilevel namespace example, `Namespaces` would be backlinked to `Very Important Features`, and `Very Important Features` would be backlinked to `Important Features`.
-
- ## Example: Hierarchical Relationships
	- Suppose you have a `[[Recipes]]` page, but you have so many recipes that it's inconvenient to put them all on a single page.
	- You might still want to index all of them on one page. While doing so manually is possible, if you create a new page and forget to link it, it could be hard to find later.
	- Instead, putting them in the `Recipes` namespace will automatically backlink them to the `Recipes` page, so that you never lose them. Naming your pages like `Recipes/Pho` and `Recipes/Chicken Noodle Soup` will backlink both of these to `Recipes.`
	- If you wish to further organize your notes, this backlinking occurs at every namespace level.
		- Suppose you wanted to sort your recipes by category, and put pho and chicken noodle soup in the soup category.
		- You could title them `Recipes/Soup/Pho` and `Recipes/Soup/Chicken Noodle Soup`. Then, `Pho` and `Chicken Noodle Soup` would be backlinked to `Soup`, and `Soup` would be backlinked to `Recipes`.
-
- ## Example: Avoiding Name Conflicts
	- Logseq will not let you name two pages the exact same thing.
	- If you want two pages with the same name, they must be in different namespaces to prevent a conflict.
	- For example, suppose you want to keep separate notes on airbrushing for model painting and airbrushing for baking. You could name them `Model Painting/Airbrushing` and `Baking/Airbrushing` to make them distinguishable.