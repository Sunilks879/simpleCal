package com.cts;
/*
Using Junit 5
 */

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class CalculatorRestControllerTest {

    private CalculatorRestController calculatorRestController;

    @BeforeEach
    public void setUp() throws Exception {
        calculatorRestController = new CalculatorRestController();
    }

    @Test
    @DisplayName("Addition of 2 +ve Numbers")
    public void add_positive_number() throws Exception {
        int num1=10;
        int num2=15;
        int addition = calculatorRestController.add(num1,num2);
        Assertions.assertEquals(addition,25);
    }

}