title:: Query table/function
type:: [[Feature]]
platforms:: [[All Platforms]]
description:: This runs custom transformations on a query table's results, usually to calculate aggregations
initial-version:: 0.2.6

## Usage
	- First, create a query table like this:
	  query-table:: true
	  {{query (property type book)}}
	  Then, create functions by typing `/function` in a child block under the query table.
	  
	  For example:
		- How many books? `{{function (sum :qty)}}`
			- Answer: {{function (sum :qty)}}
		- What's the average price? `{{function (average :price)}}`
			- Answer: {{function (average :price)}}
		- How much does it cost to buy all of them? `{{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}`
			- Answer: {{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}
## Functionality
	- This macro works with results of simple [[Queries]] or [[Advanced Queries]].
	- This macro supports the following aggregate functions:
		- `{{function (sum :property)}}`
		- `{{function (average :property)}}`
		- `{{function (min :property)}}`
		- `{{function (max :property)}}`
		- `{{function (count :property)}}`
		- #+BEGIN_NOTE
		  The property to be used in the function must be a keyword, a keyword has a `:` at the beginning.
		  For example, `:price` is a keyword while `price` is not.
		  #+END_NOTE
		- An argument can also be a custom [[Clojure]] function like :result-transform in [[Advanced Queries]]. The custom function binds the query result to the symbol `result`. For example:
			- `{{function (sum (map (fn [x] (* (:price x) (:qty x))) result))}}`