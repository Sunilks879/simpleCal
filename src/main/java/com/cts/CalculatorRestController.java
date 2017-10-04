package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
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
    @ExceptionHandler(IllegalArgumentException.class)
    public long divide(@RequestParam long... operands){
        return mathOperator.divide(operands);
    }

    @GetMapping("/power")
    @ExceptionHandler(IllegalArgumentException.class)
    public long pow(@RequestParam long... operands) {
        return mathOperator.pow(operands);
    }
//
//    @GetMapping("/reverse")
//    public String reverse(@RequestParam String str) {
//        if (str == null || str.isEmpty()) {
//            return str;
//        }
//        char[] characters = str.toCharArray();
//        int i = 0;
//        int j = characters.length - 1;
//        while (i < j) {
//            swap(characters, i, j);
//            i++;
//            j--;
//        }
//        return new String(characters);
//    }
//
//    private void swap(char[] str, int i, int j) {
//        char temp = str[i];
//        str[i] = str[j];
//        str[j] = temp;
//    }

}
