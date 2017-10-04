package com.cts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {
    @Test
    public void contextLoads() {
    }

    private CalculatorRestController calculatorRestController;
    @Autowired
    private MathOperator mathOperator;

    @Before
    public void setUp() throws Exception {
        calculatorRestController = new CalculatorRestController(mathOperator);
    }

    /**
     * Addition
     *
     * @throws Exception
     */
    @Test
    public void add_numbers() throws Exception {
        long result = 10 + 15 + 10;
        assertEquals(result, calculatorRestController.add(10, 15, 10));
        result = 10;
        assertEquals(result, calculatorRestController.add(10));
        result = 10 + 23 + (-1) + 16;
        assertEquals(result, calculatorRestController.add(10, 23, -1, 16));
        result = (-10) + 10;
        assertEquals(result, calculatorRestController.add(-10, 10));
    }

    /**
     * Subtraction of +ve numbers
     *
     * @throws Exception
     */
    @Test
    public void subtract_numbers() throws Exception {
        long result = 100 - 34 - (-17) - 4;
        assertEquals(result, calculatorRestController.subtract(100, 34, -17, 4));
        result = 0;
        assertEquals(result, calculatorRestController.subtract(0, 0));
    }

//    /**
//     * Reversing a String
//     *
//     * @throws Exception
//     */
//    @Test
//    public void reverse_single_string() throws Exception {
//        String strToRev = "Sunil";
//        String strRev = calculatorRestController.reverse(strToRev);
//        assertEquals(strRev, "linuS");
//    }
//
//    /**
//     * Reversing a String with Space
//     *
//     * @throws Exception
//     */
//    @Test
//    public void reverse_string_with_space() throws Exception {
//        String strToRev = "Sunil KS";
//        String strRev = calculatorRestController.reverse(strToRev);
//        assertEquals(strRev, "SK linuS");
//    }

    /**
     * Multiplication of numbers
     *
     * @throws Exception
     */
    @Test
    public void multiply_number() throws Exception {
        long result = 100 * 34 * -17 * 4;
        assertEquals(result, calculatorRestController.multiply(100, 34, -17, 4));
        result = 100 * 0;
        assertEquals(result, calculatorRestController.multiply(100, 0));
    }


    /**
     * Division by Zero exception
     *
     * @throws Exception
     */
    @Test
    public void divideByZero_Exception() throws Exception {
        try {
            calculatorRestController.divide(12, 0);
            fail("Expected this to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // This is what we expect
        }
    }

    /**
     * Division of numbers
     *
     * @throws Exception
     */
    @Test
    public void divide_number() throws Exception {
        long result = 100 / 3 / 2;
        assertEquals(result, calculatorRestController.divide(100, 3, 2));
        result = 0;
        assertEquals(result, calculatorRestController.divide(0, 1));
        result = -12 / -6;
        assertEquals(result, calculatorRestController.divide(-12, -6));
        result = -17;
        assertEquals(result, calculatorRestController.divide(-17, 1));
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testPower() throws Exception {
        long result = Double.valueOf(Math.pow(12.0, 3.0)).longValue();

        assertEquals(result, calculatorRestController.pow(12, 3));

        result = Double.valueOf(Math.pow(Math.pow(12.0, 3.0), 4.0)).longValue();
        assertEquals(result, calculatorRestController.pow(12, 3, 4));

        result = Double.valueOf(Math.pow(Math.pow(12.0, -3.0), 4.0)).longValue();
        try {
            calculatorRestController.pow(12, -3, 4);
            fail("Expected this to throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // This is what we expect
        }
    }
}
