- The built-in calculator is opened by the command `/Calculator`.
- The calculator supports basic operations like `+ - / * ^`  and a number of mathematical operations.
- The standard mathematical order of evaluation of operations is followed; parentheses may be used to further specify the order.
- Comments start with `#`. The rest of the line is ignored.
  id:: 62c8421b-d22e-40ce-aead-0b7e9e2951f7
- Values can be assigned to variables for use in further calculations.
- The result of each line is automatically assigned to a variable called `last`, for continuation of calculations.
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
  pi = 4*atan(1)
  sin(pi/2)
  cos(pi)
  tan(pi/3)
  asin(-0.5)
  ```
- ## Supported functions
- |Function name|Description|
  |--|--|
  |sqrt|square root|
  |log|common logarithm (base 10)|
  |ln|natural logarithm (base _e_)|
  |exp|natural exponential, _e_ raised to the specified power|
  |abs|absolute value|
  |sin|sine (argument in radians)|
  |cos|cosine (argument in radians)|
  |tan|tangent (argument in radians)|
  |asin|inverse sine (arc sine), value in radians|
  |acos|inverse cosine (arc cosine), value in radians|
  |atan|inverse tangent (arc tangent), value in radians|