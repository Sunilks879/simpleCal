# simpleCal
Simple application which has basic calculator functionality like Add, Subtract, Multiplication, Division and Power.
All the API take multiple parameter. We can pass any number of paramaters
```
For E.g: public long add(@RequestParam long... operands){ }
```
When invoked from jUnit we can pass 
```
add(10, 15, 10) or add(-10, 10) or add(10, 23, -1, 16)
```

## Unit test
Unit tests are written and is available in CalculatorApplicationTests.java

## Integration Test
Itegration test cases for few only has been written, and are available in CalculatorRestControllerIntegrationTest.java
