package com.cts;

import com.cts.exception.DivisionByZeroException;
import com.cts.exception.NegativePowerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.fail;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class MathOperatorTest {

    @Autowired
    private MathOperator mathOperator;

    /**
     * Configuration of Bean so that Autowire will happen
     */
    @Configuration
    static class MathOperatorTestContextConfiguration {

        @Bean
        public MathOperator mathOperator() {
            return new MathOperator();
        }
    }

    @Test
    public void add() {
        long result = 10 + 15 + 100;
        assertEquals(result, mathOperator.add(10, 15, 100));
        result = 10;
        assertEquals(result, mathOperator.add(10));
        result = 10 + 23 + (-1) + 16;
        assertEquals(result, mathOperator.add(10, 23, (-1), 16));
        result = (-10) + 10;
        assertEquals(result, mathOperator.add(-10, 10));
    }

    @Test
    public void subtract() {
        long result = 100 - 34 - (-17) - 4;
        assertEquals(result, mathOperator.subtract(100, 34, -17, 4));
        result = 0;
        assertEquals(result, mathOperator.subtract(0, 0));
    }

    @Test
    public void multiply() {
        long result = 100 * 34 * -17 * 4;
        assertEquals(result, mathOperator.multiply(100, 34, -17, 4));
        result = 100 * 0;
        assertEquals(result, mathOperator.multiply(100, 0));

    }

    @Test
    public void divide() throws DivisionByZeroException {
        String divisionByZero = "Division By Zero is not possible";
        try {
            mathOperator.divide(12, 0);
        } catch (DivisionByZeroException e) {
            assertEquals(divisionByZero, e.getMessage());
        }
        long result = 100 / 3 / 2;
        assertEquals(result, mathOperator.divide(100, 3, 2));
        result = 0;
        assertEquals(result, mathOperator.divide(0, 1));
        result = -12 / -6;
        assertEquals(result, mathOperator.divide(-12, -6));
        result = -17;
        assertEquals(result, mathOperator.divide(-17, 1));

    }

    @Test
    public void pow() throws NegativePowerException {
        String powException = "Positive integer power only is possible";
        long result = Double.valueOf(Math.pow(12.0, 3.0)).longValue();
        assertEquals(result, mathOperator.pow(12, 3));

        result = Double.valueOf(Math.pow(Math.pow(12.0, 3.0), 4.0)).longValue();
        assertEquals(result, mathOperator.pow(12, 3, 4));

        try {
            mathOperator.pow(12, -3);
        } catch (NegativePowerException e) {
            assertEquals(powException, e.getMessage());
        }

    }

}