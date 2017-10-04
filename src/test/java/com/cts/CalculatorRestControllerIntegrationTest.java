package com.cts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MathOperator mathOperator;

    @Test
    public void add_positive_number() throws Exception {
        mockMvc.perform(get("/calculator/add?operands=" + 10 + "," + 15))
                .andExpect(content().string("25"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void add_positive_number_with_negative_number() throws Exception {
        mockMvc.perform(get("/calculator/add?operands=" + 10 + "," + 14 + "," + (-28)))
                .andExpect(content().string("-4"))
                .andExpect(status().is2xxSuccessful());
    }
}