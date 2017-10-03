package com.cts;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorRestController {

    @GetMapping("/add")
    public int add(@RequestParam int num1, @RequestParam int num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int num1, @RequestParam int num2) {
        return num1 - num2;
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int num1, @RequestParam int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("num2 must not be zero");
        }
        return num1 / num2;
    }

    @GetMapping("/reverse")
    public String reverse(@RequestParam String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char[] characters = str.toCharArray();
        int i = 0;
        int j = characters.length - 1;
        while (i < j) {
            swap(characters, i, j);
            i++;
            j--;
        }
        return new String(characters);
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
