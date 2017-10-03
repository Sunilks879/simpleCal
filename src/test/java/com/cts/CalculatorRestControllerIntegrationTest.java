package com.cts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorRestController.class)
public class CalculatorRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void add_positive_number() throws Exception {
        int num1=10;
        int num2=15;
        mockMvc.perform(get("/calculator/add?num1="+num1+"&num2="+num2))
                .andExpect(content().string("25"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void add_positive_number_with_negative_number() throws Exception {
        int num1=10;
        int num2=-15;
        mockMvc.perform(get("/calculator/add?num1="+num1+"&num2="+num2))
                .andExpect(content().string("-5"))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    public void add_negative_number() throws Exception {
        int num1=-1;
        int num2=-2;
        mockMvc.perform(get("/calculator/add?num1="+num1+"&num2="+num2))
                .andExpect(content().string("-3"))
                .andExpect(status().is2xxSuccessful());
    }
}