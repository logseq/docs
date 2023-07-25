type:: [[Feature]]
platforms:: [[All Platforms]]
description:: Write and render math using https://katex.org/ syntax

## Usage
	- Inline math is written in a block by wrapping text with `$`. For example:
		- #+BEGIN_EXAMPLE
		  $\ce{Hg^2+ ->[I-] HgI2 ->[I-] [Hg^{II}I4]^2-}$
		  #+END_EXAMPLE
		  becomes
		  $\ce{Hg^2+ ->[I-] HgI2 ->[I-] [Hg^{II}I4]^2-}$
	- Multi-line math is written in a block by wrapping text with `$$`. For example:
		- #+BEGIN_EXAMPLE
		  $$
		  \frac{1}{\Bigl(\sqrt{\phi \sqrt{5}}-\phi\Bigr) e^{\frac25 \pi}} = 1+\frac{e^{-2\pi}}
		  {1+\frac{e^{-4\pi}} {1+\frac{e^{-6\pi}} {1+\frac{e^{-8\pi}} {1+\cdots} } } }
		  $$
		  #+END_EXAMPLE
		  becomes
		  $$
		  \frac{1}{\Bigl(\sqrt{\phi \sqrt{5}}-\phi\Bigr) e^{\frac25 \pi}} = 1+\frac{e^{-2\pi}}
		  {1+\frac{e^{-4\pi}} {1+\frac{e^{-6\pi}} {1+\frac{e^{-8\pi}} {1+\cdots} } } }
		  $$
## Functionality
	- For documentation of what is supported, see https://katex.org/docs/supported.html and https://katex.org/docs/support_table.html.
	- In addition to math support, chemistry support is provided by the [mchem package](https://github.com/KaTeX/KaTeX/tree/main/contrib/mhchem).
## Additional Links
	- https://github.com/xyhp915/logseq-extensions-plus - Plugin that provides physics support for katex