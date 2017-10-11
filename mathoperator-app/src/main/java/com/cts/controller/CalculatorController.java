package com.cts.controller;

import com.cts.dto.ExceptionMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;

import java.io.IOException;
import java.util.Map;

@Controller
public class CalculatorController {

    @Value("${mathServiceEndpoint}")
    public String mathServiceName;

    private RestOperations restOperations;

    @Autowired
    public CalculatorController(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/addition/count")
    public String addition(Map<String, Object> model) {
        model.put("resultText", "How many digits addition needed?");
        return "addcount";
    }

    @GetMapping("/addition")
    public String addition(Map<String, Object> model, @RequestParam int count) {
        model.put("resultText", "How many digits addition needed?");
        model.put("count", count);
        return "addition";
    }

    @GetMapping("/subtraction")
    public String subtraction(Map<String, Object> model, @RequestParam int count) {
        model.put("resultText", "How many digits subtraction needed?");
        model.put("count", count);
        return "subtraction";
    }

    @GetMapping("/subtraction/count")
    public String subtraction(Map<String, Object> model) {
        model.put("resultText", "How many digits subtraction needed?");
        return "subcount";
    }

    @GetMapping("/division")
    public String division(Map<String, Object> model, @RequestParam int count) {
        model.put("resultText", "How many digits division needed?");
        model.put("count", count);
        return "division";
    }

    @GetMapping("/division/count")
    public String division(Map<String, Object> model) {
        model.put("resultText", "How many digits division needed?");
        return "divcount";
    }

    @GetMapping("/multiplication")
    public String multiplication(Map<String, Object> model, @RequestParam int count) {
        model.put("resultText", "How many digits multiplication needed?");
        model.put("count", count);
        return "multiplication";
    }

    @GetMapping("/multiplication/count")
    public String multiplication(Map<String, Object> model) {
        model.put("resultText", "How many digits multiplication needed?");
        return "mulcount";
    }

    @GetMapping("/power")
    public String power(Map<String, Object> model, @RequestParam int count) {
        model.put("resultText", "How many digits power needed?");
        model.put("count", count);
        return "power";
    }

    @GetMapping("/power/count")
    public String power(Map<String, Object> model) {
        model.put("resultText", "How many digits power needed?");
        return "powcount";
    }

    @GetMapping("/add")
    public String add(Map<String, Object> model, @RequestParam long... operands) {
        StringBuilder operandsVal = prepareRestURI(operands);
        model.put("resultText", "Result of Addition ");
        model.put("resultValue", restOperations.getForObject(mathServiceName + "/add?" + operandsVal, Long.class));
        return "resultPage";
    }

    @GetMapping("/subtract")
    public String subtract(Map<String, Object> model, @RequestParam long... operands) {
        StringBuilder operandsVal = prepareRestURI(operands);
        model.put("resultText", "Result of Subtraction ");
        model.put("resultValue", restOperations.getForObject(mathServiceName + "/subtract?" + operandsVal, Long.class));
        return "resultPage";
    }

    @GetMapping("/divide")
    public String division(Map<String, Object> model, @RequestParam long... operands) {
        String returnStr = "resultPage";
        StringBuilder operandsVal = prepareRestURI(operands);
        model.put("resultText", "Result of Division ");
        try {
            model.put("resultValue", restOperations.getForObject(mathServiceName + "/divide?" + operandsVal, Long.class));
        } catch (HttpClientErrorException ex) {
            returnStr = "errorPage";
            formException(model, ex);
        }
        return returnStr;
    }

    @GetMapping("/multiply")
    public String multiply(Map<String, Object> model, @RequestParam long... operands) {
        StringBuilder operandsVal = prepareRestURI(operands);
        model.put("resultText", "Result of Multiplication ");
        model.put("resultValue", restOperations.getForObject(mathServiceName + "/multiply?" + operandsVal, Long.class));
        return "resultPage";
    }

    @GetMapping("/pow")
    public String power(Map<String, Object> model, @RequestParam long... operands) {
        String returnStr = "resultPage";
        StringBuilder operandsVal = prepareRestURI(operands);
        model.put("resultText", "Result of Power ");
        try {
            model.put("resultValue", restOperations.getForObject(mathServiceName + "/pow?" + operandsVal, Long.class));
        } catch (HttpClientErrorException ex) {
            returnStr = "errorPage";
            formException(model, ex);
        }
        return returnStr;
    }

    private StringBuilder prepareRestURI(long[] operands) {
        StringBuilder operandsVal = new StringBuilder("operands=");
        int index = 0;
        for (long operand : operands) {
            operandsVal.append(operand);
            index++;
            if (index < operands.length) {
                operandsVal.append(',');
            }
        }
        return operandsVal;
    }

    private void formException(Map<String, Object> model, HttpClientErrorException ex) {
        ObjectMapper mapper = new ObjectMapper();
        ExceptionMapper exceptionMapper = null;
        try {
            exceptionMapper = mapper.readValue(ex.getResponseBodyAsString(), ExceptionMapper.class);
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (exceptionMapper == null) {
            exceptionMapper = new ExceptionMapper();
            exceptionMapper.setStatus(ex.getStatusCode().toString());
            exceptionMapper.setMessage(ex.getMessage());
        }
        model.put("exceptionMapper", exceptionMapper);
    }
}
