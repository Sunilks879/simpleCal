package com.cts;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CalculatorRestControllerUnitTest {

    private CalculatorRestController calculatorRestController;

    @Before
    public void setUp() throws Exception {
        calculatorRestController = new CalculatorRestController();
    }

    /**
     * Addition of 2 +ve numbers
     *
     * @throws Exception
     */
    @Test
    public void add_positive_number() throws Exception {
        int num1 = 10;
        int num2 = 15;
        int addition = calculatorRestController.add(num1, num2);
        assertEquals(addition, 25);
    }

    /**
     * Addition of +ve number with -ve number
     *
     * @throws Exception
     */
    @Test
    public void add_positive_and_negative_number() throws Exception {
        int num1 = 10;
        int num2 = -15;
        int addition = calculatorRestController.add(num1, num2);
        assertEquals(addition, -5);
    }

    /**
     * Addition of -ve numbers
     *
     * @throws Exception
     */
    @Test
    public void add_negative_number() throws Exception {
        int num1 = -1;
        int num2 = -2;
        int addition = calculatorRestController.add(num1, num2);
        assertEquals(addition, -3);
    }

    /**
     * Subtraction of +ve numbers
     *
     * @throws Exception
     */
    @Test
    public void subtract_positive_number() throws Exception {
        int num1 = 10;
        int num2 = 15;
        int subtract = calculatorRestController.subtract(num1, num2);
        assertEquals(subtract, -5);
    }

    /**
     * Subtraction of -ve numbers
     *
     * @throws Exception
     */
    @Test
    public void subtract_negative_number() throws Exception {
        int num1 = -6;
        int num2 = -5;
        int subtract = calculatorRestController.subtract(num1, num2);
        assertEquals(subtract, -1);
    }

    /**
     * Subtraction of -ve number with +ve number
     *
     * @throws Exception
     */
    @Test
    public void subtract_negative_number_with_positive_number() throws Exception {
        int num1 = -6;
        int num2 = 5;
        int subtract = calculatorRestController.subtract(num1, num2);
        assertEquals(subtract, -11);
    }

    /**
     * Subtraction of +ve number with -ve number
     *
     * @throws Exception
     */
    @Test
    public void subtract_positive_number_with_negative_number() throws Exception {
        int num1 = 6;
        int num2 = -5;
        int subtract = calculatorRestController.subtract(num1, num2);
        assertEquals(subtract, 11);
    }

    /**
     * Reversing a String
     *
     * @throws Exception
     */
    @Test
    public void reverse_single_string() throws Exception {
        String strToRev = "Sunil";
        String strRev = calculatorRestController.reverse(strToRev);
        assertEquals(strRev, "linuS");
    }

    /**
     * Reversing a String with Space
     *
     * @throws Exception
     */
    @Test
    public void reverse_string_with_space() throws Exception {
        String strToRev = "Sunil KS";
        String strRev = calculatorRestController.reverse(strToRev);
        assertEquals(strRev, "SK linuS");
    }

    /**
     * Multiplication of +ve numbers
     *
     * @throws Exception
     */
    @Test
    public void multiply_positive_number() throws Exception {
        int num1 = 6;
        int num2 = 5;
        int multiply = calculatorRestController.multiply(num1, num2);
        assertEquals(multiply, 30);
    }

    /**
     * Multiplication of -ve numbers
     *
     * @throws Exception
     */
    @Test
    public void multiply_negative_number() throws Exception {
        int num1 = -6;
        int num2 = -5;
        int multiply = calculatorRestController.multiply(num1, num2);
        assertEquals(multiply, 30);
    }

    /**
     * Multiplication of -ve number with +ve number
     *
     * @throws Exception
     */
    @Test
    public void multiply_negative_number_with_positive_number() throws Exception {
        int num1 = -6;
        int num2 = 5;
        int multiply = calculatorRestController.multiply(num1, num2);
        assertEquals(multiply, -30);
    }

    /**
     * Multiplication of a number with Zero
     *
     * @throws Exception
     */
    @Test
    public void multiply_number_with_zero() throws Exception {
        int num1 = 12;
        int num2 = 0;
        int multiply = calculatorRestController.multiply(num1, num2);
        assertEquals(multiply, 0);
    }


    /**
     * Division by Zero exception
     *
     * @throws Exception
     */
    @Test
    public void divideByZero_Exception() throws Exception {
        int num1 = 12;
        int num2 = 0;
        int division = 0;
        try {
            calculatorRestController.divide(num1, num2);
        } catch (IllegalArgumentException e) {
            assertEquals(division, 0);
        }
    }

    /**
     * Division of +ve numbers
     *
     * @throws Exception
     */
    @Test
    public void divide_positive_number() throws Exception {
        int num1 = 12;
        int num2 = 6;
        int division = calculatorRestController.divide(num1, num2);
        assertEquals(division, 2);
    }

    /**
     * Division of -ve numbers
     *
     * @throws Exception
     */
    @Test
    public void divide_negative_number() throws Exception {
        int num1 = -12;
        int num2 = -6;
        int division = calculatorRestController.divide(num1, num2);
        assertEquals(division, 2);
    }
    /**
     * Division of +ve number with -ve number
     *
     * @throws Exception
     */
    @Test
    public void divide_positive_number_with_negative_number() throws Exception {
        int num1 = 12;
        int num2 = -6;
        int division = calculatorRestController.divide(num1, num2);
        assertEquals(division, -2);
    }
}