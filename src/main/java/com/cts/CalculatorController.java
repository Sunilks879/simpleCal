package com.cts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String home() {
        return "/home";
    }
}
