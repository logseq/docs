# Alias Limitations in Logseq

Aliases in Logseq allow pages and blocks to be referenced by multiple names. Below are limitations observed directly from the codebase implementation:

## 1. Alias Resolution
- Alias resolution mainly occurs when accessing pages: if a name matches an alias, Logseq tries to redirect to the source page of the alias (`get-alias-source-page`).
- Redirection can be ignored in some routes (using the `ignore-alias?` parameter).
- Alias matching is exact and case-sensitive; there is no partial or fuzzy matching.
- Aliases are only resolved if explicitly defined in the page/block properties.

## 2. Scope and Propagation
- Aliases are properties of pages or blocks, not global.
- An alias is only recognized within the current repository context.
- There is no automatic update of aliases in backlinks or references when renaming pages.
- When adding aliases to a page, the system can merge existing and new aliases, but always explicitly.

## 3. Editing, Updating, and Synchronization
- Renaming a page does not automatically update aliases pointing to it.
- The `add-aliases-to-properties` function only adds explicitly listed aliases, with no advanced deduplication beyond case-insensitive comparison.
- There is no automatic propagation of alias changes to other blocks or pages that reference them.

## 4. Search, Links, and Backlinks
- Alias search depends on specific properties (`:alias`), and backlinks may not work correctly if the alias is not properly registered.
- References and links may not resolve if the alias is not unique or if there are name conflicts.
- Aliases are not considered in all search operations, only in specific code contexts.

## 5. Export and Plugins
- Exports (e.g., Markdown, OPML) may not preserve aliases.
- Plugins and integrations may not support aliases, as this depends on how each one reads properties.

## 6. Special Characters and Formatting
- Aliases with special characters, spaces, or emojis may not work correctly in all contexts.
- It is recommended to avoid reserved names or system keywords as aliases.

## 7. Technical and Performance Limitations
- Excessive use of aliases can impact performance, especially in large databases.
- There is no support for nested or recursive aliases.

---

**References**: These limitations were identified from the analysis of the functions `get-alias-source-page`, `get-redirect-page-name`, `add-aliases-to-properties`.
