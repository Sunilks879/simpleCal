package com.cts;

import com.cts.exception.DivisionByZeroException;
import com.cts.exception.NegativePowerException;
import com.sun.org.apache.xpath.internal.operations.Div;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorRestControllerTest {

    private CalculatorRestController calculatorRestController;

    @MockBean
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
    @org.junit.Test
    public void add_numbers() throws Exception {
        Mockito.when(mathOperator.add(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(35L);
        long result = 10 + 15 + 10;
        assertEquals(result, calculatorRestController.add(10, 15, 10));
        result = 10;
        Mockito.when(mathOperator.add(Mockito.anyLong())).thenReturn(10L);
        assertEquals(result, calculatorRestController.add(10));
        Mockito.when(mathOperator.add(Mockito.anyLong(), Mockito.anyLong())).thenReturn(0L);
        result = (-10) + 10;
        assertEquals(result, calculatorRestController.add(-10, 10));
    }

    /**
     * Subtraction of +ve numbers
     *
     * @throws Exception
     */
    @org.junit.Test
    public void subtract_numbers() throws Exception {
        long result = 100 - 34 - (-17) - 4;
        Mockito.when(mathOperator.subtract(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(79L);
        assertEquals(result, calculatorRestController.subtract(100, 34, -17, 4));
        result = 0;
        Mockito.when(mathOperator.subtract(Mockito.anyLong(), Mockito.anyLong())).thenReturn(0L);
        assertEquals(result, calculatorRestController.subtract(0, 0));
    }

    /**
     * Multiplication of numbers
     *
     * @throws Exception
     */
    @org.junit.Test
    public void multiply_number() throws Exception {
        long result = 100 * 34 * -17 * 4;
        System.out.println(result);
        Mockito.when(mathOperator.multiply(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(-231200L);
        assertEquals(result, calculatorRestController.multiply(100, 34, -17, 4));
        result = 100 * 0;
        Mockito.when(mathOperator.multiply(Mockito.anyLong(), Mockito.anyLong())).thenReturn(0L);
        assertEquals(result, calculatorRestController.multiply(100, 0));
        result = -2 * -2;
        Mockito.when(mathOperator.multiply(-(Mockito.anyLong()), -(Mockito.anyLong()))).thenReturn(4L);
        assertEquals(result, calculatorRestController.multiply(-2, -2));
    }


    /**
     * Division of numbers
     *
     * @throws Exception
     */
    @org.junit.Test
    public void divide_number() throws Exception {
        Mockito.when(mathOperator.divide(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(16L);
        long result = 100 / 3 / 2;
        assertEquals(result, calculatorRestController.divide(100, 3, 2));
        result = 0;
        Mockito.when(mathOperator.divide(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(0L);
        assertEquals(result, calculatorRestController.divide(0, 1));
        result = -12 / -6;
        Mockito.when(mathOperator.divide(Mockito.anyLong(), Mockito.anyLong())).thenReturn(2L);
        assertEquals(result, calculatorRestController.divide(-12, -6));
        result = -17;
        Mockito.when(mathOperator.divide(Mockito.anyLong(), Mockito.anyLong())).thenReturn(-17L);
        assertEquals(result, calculatorRestController.divide(-17, 1));
    }

    @org.junit.Test
    public void divide_number_exception() throws Exception {
        String divisionByZero = "Division By Zero is not possible";
        Mockito.when(mathOperator.divide(Mockito.anyLong(), eq(0L))).thenThrow(new DivisionByZeroException("Division By Zero is not possible"));
        try {
            calculatorRestController.divide(11, 0);
        } catch (DivisionByZeroException e) {
            assertEquals(divisionByZero, e.getMessage());
        }
    }


    /**
     * @throws Exception
     */
    @org.junit.Test
    public void testPower() throws Exception {
        long result = Double.valueOf(Math.pow(10.0, 3.0)).longValue();
        Mockito.when(mathOperator.pow(Mockito.anyLong(), Mockito.anyLong())).thenReturn(1000L);
        assertEquals(result, calculatorRestController.pow(10, 3));

        result = Double.valueOf(Math.pow(Math.pow(12.0, 3.0), 4.0)).longValue();

        Mockito.when(mathOperator.pow(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(8916100448256L);
        assertEquals(result, calculatorRestController.pow(12, 3, 4));

    }

    @org.junit.Test
    public void testPower_exception() throws Exception {
        String powException = "Positive integer power only is possible";
        Mockito.when(mathOperator.pow(Mockito.anyLong(), -(Mockito.anyLong()))).thenThrow(new NegativePowerException("Positive integer power only is possible"));
        try {
            calculatorRestController.pow(12, -3);
        } catch (NegativePowerException e) {
            assertEquals(powException, e.getMessage());
        }
    }
}