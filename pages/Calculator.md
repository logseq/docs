- The built-in calculator is opened by the command `/Calculator`.
- The calculator supports basic operations like `+ - / * ^`  and advanced operations (factorial, modular division, and scientific functions).
- The standard mathematical order of evaluation of operations is followed; parentheses may be used to further specify the order.
- Comments start with `#`. The rest of the line is ignored.
  id:: 62c8421b-d22e-40ce-aead-0b7e9e2951f7
- Values can be assigned to variables for use in further calculations.
- The result of each line is automatically assigned to a variable called `last`, for continuation of calculations.
- The number format of results is controlled using the `:format` directive.
- Results can be shown in a different base using the `:base` directive.
- ## Example calculations
- ```calc
  # Basic arithmetic
  6 * 7
  1 + 2 * (3 - 4)
  (2 + 13) / (17 + 23)
  
  # Powers
  3^3       # 3 cubed
  27^(1/3)  # cube root of 27
  last^2    # square last answer
  
  # Variables
  x = -7
  2 * x^2 + 11 * x - 21
  
  x1 = 4
  x2 = 7
  y1 = 10
  y2 = 4
  m = (y2 - y1)/(x2 - x1)
  
  # Functions
  abs(x1 - x2)
  sqrt(20.25)
  log(1000)
  ln(10)
  exp(1)
  
  # Trig functions
  sin(PI/2)
  cos(PI)
  tan(PI/3)
  asin(-0.5)
  
  # Factorial
  4!              # 4 × 3 × 2 × 1
  10!/(4! * 6!)   # "10 choose 4"
  
  # Modulo (remainder upon division)
  42 mod 5
  42 mod 6
  3.75 mod 1.5
  ```
- ## Scientific functions
- |Function name|Description|
  |--|--|
  |`sqrt`|square root|
  |`log`|common logarithm (base 10)|
  |`ln`|natural logarithm (base _e_)|
  |`exp`|natural exponential, _e_ raised to the specified power|
  |`abs`|absolute value|
  |`sin`|sine (argument in radians)|
  |`cos`|cosine (argument in radians)|
  |`tan`|tangent (argument in radians)|
  |`asin`|inverse sine (arc sine), value in radians|
  |`acos`|inverse cosine (arc cosine), value in radians|
  |`atan`|inverse tangent (arc tangent), value in radians|
- ## Constants
- |Name|Value|Description|
  |--|--|--|
  |`PI`|3.14159265358979323846|the ratio of a circle's circumference to its diameter|
  |`E`|2.71828182845904523536|the base of the natural logarithm `ln` (sometimes called *Euler's number*)|
- ## Number bases
- Numbers may be entered in different number bases by prefixing the number as follows.
- |Base|Prefix|Example|
  |--|--|--|
  |2|`0b`|`0b1110`|
  |8|`0o`|`0o20`|
  |16|`0x`|`0xE`|
- Results may be shown in these bases using the directives `:bin`, `:oct` and `:hex`.
- Results will show all available digits of precision.
- To return to decimal results, use the directive `:dec`.
- ### Example
- ```calc
  0x10 + 0x10			# hex addition; result in decimal
  :hex				# show results in hexadecimal
  
  0xFF * 0b1000
  last / 0o12
  :oct				# show results in octal
  :bin				# show results in binary
  :dec				# and back to decimal
  ```
- ## Result formatting
- Use the `format` (or `fmt`) directive to set the number format used for results:
	- `:format <mode> [parameters]`
- The default format style is `normal`.
- The format styles only apply when results are in decimal.
- |Format style(s)|Parameters|Description|
  |--|--|--|
  |`norm`, `normal`|precision|display up to the specified number of **significant figures** (default 21), switching to scientific notation when needed|
  |`fix`, `fixed`|places (**required**)|display the result **rounded** to specified number of decimal places; use scientific notation when all precision is lost|
  | `sci`, `scientific`|places|display the result in **scientific notation** with specified number of decimal places|
  |`frac`, `fraction`| maximum-denominator |display the result as a **mixed-number**, if its denominator is less than or equal to the maximum denominator (default 4095)|
  |`imp`, `improper`| maximum-denominator |display the result as an **improper fraction**, if its denominator is less than or equal to the maximum denominator (default 4095)|
- ### Mixed numbers
- A mixed number is a way of representing a fraction as a whole number plus a (proper) fraction.  Since the calculator uses plain text, mixed numbers are represented as `a b/c` where `a`, `b` and `c` are positive integers:
	- `a b/c` is equivalent to `a+b/c`
		- e.g. `1 2/3` is the mixed number $1 \frac{2}{3}$
	- `-a b/c` is equivalent to `-(a+b/c)`
		- e.g. `-3 1/4` is the mixed number $-3\frac{1}{4}$
- ### Example
- ```calc
  PI * 4.5^2
  :format fix 5			# round results to 5 decimal places
  :format sci 5			# scientific notation with 5 places
  :format norm 5			# 5 significant figures
  
  1.5*2.4
  :format imp				# improper fraction
  :format frac			# mixed number fraction
  
  2 1/2 * 3 3/8 - 1 1/4	# mixed number arithmetic
  
  3e-4					# denominator too large
  :format imp 10000		# can use higher maximum denominator
  ```