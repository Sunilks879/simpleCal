package com.cts;

import com.cts.exception.DivisionByZeroException;
import com.cts.exception.NegativePowerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorRestController {

    private MathOperator mathOperator;

    @Autowired
    public CalculatorRestController(MathOperator mathOperator) {
        this.mathOperator = mathOperator;
    }

    @GetMapping("/add")
    public long add(@RequestParam long... operands) {
        return mathOperator.add(operands);
    }

    @GetMapping("/subtract")
    public long subtract(@RequestParam long... operands) {
        return mathOperator.subtract(operands);
    }

    @GetMapping("/multiply")
    public long multiply(@RequestParam long... operands) {
        return mathOperator.multiply(operands);
    }

    @GetMapping("/divide")
    public long divide(@RequestParam long... operands)throws DivisionByZeroException {
        return mathOperator.divide(operands);
    }

    @GetMapping("/pow")
    public long pow(@RequestParam long... operands)throws NegativePowerException {
        return mathOperator.pow(operands);
    }

}
