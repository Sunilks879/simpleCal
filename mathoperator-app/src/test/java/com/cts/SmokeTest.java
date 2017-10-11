package com.cts;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmokeTest {

    private RestTemplate restTemplate = new RestTemplate();

    private String url(String path) {
        String baseUrl = "http://localhost:8181";
        return baseUrl + path;
    }

    @Test
    public void additionTest() {
        String homePage = restTemplate.getForObject(url("/"), String.class);
        assertThat(homePage, containsString("Choice of Operations"));

        String additionCountPage = restTemplate.getForObject(url("/addition/count"), String.class);
        assertThat(additionCountPage, containsString("How many digits addition needed?"));

        String additionPage = restTemplate.getForObject(url("/addition?count=2"), String.class);
        assertThat(additionPage, containsString("Add"));

        String additionResultPage = restTemplate.getForObject(url("/add?operands=10&operands=10"), String.class);
        assertThat(additionResultPage, containsString("Result of Addition"));
        assertThat(additionResultPage, containsString("20"));
    }

    @Test
    public void subtractionTest() {
        String homePage = restTemplate.getForObject(url("/"), String.class);
        assertThat(homePage, containsString("Choice of Operations"));

        String subtractionCountPage = restTemplate.getForObject(url("/subtraction/count"), String.class);
        assertThat(subtractionCountPage, containsString("How many digits subtraction needed?"));

        String subtractionPage = restTemplate.getForObject(url("/subtraction?count=2"), String.class);
        assertThat(subtractionPage, containsString("Subtract"));

        String subtractionCountPageResultPage = restTemplate.getForObject(url("/subtract?operands=2&operands=6"), String.class);
        assertThat(subtractionCountPageResultPage, containsString("Result of Subtraction"));
        assertThat(subtractionCountPageResultPage, containsString("-4"));
    }

    @Test
    public void multiplicationTest() {
        String homePage = restTemplate.getForObject(url("/"), String.class);
        assertThat(homePage, containsString("Choice of Operations"));

        String multiplicationCountPage = restTemplate.getForObject(url("/multiplication/count"), String.class);
        assertThat(multiplicationCountPage, containsString("How many digits multiplication needed?"));

        String multiplicationPage = restTemplate.getForObject(url("/multiplication?count=2"), String.class);
        assertThat(multiplicationPage, containsString("Multiply"));

        String multiplicationResultPage = restTemplate.getForObject(url("/multiply?operands=2&operands=6"), String.class);
        assertThat(multiplicationResultPage, containsString("Result of Multiplication"));
        assertThat(multiplicationResultPage, containsString("12"));
    }

    @Test
    public void divisionTest() {
        String homePage = restTemplate.getForObject(url("/"), String.class);
        assertThat(homePage, containsString("Choice of Operations"));

        String divisionCountPage = restTemplate.getForObject(url("/division/count"), String.class);
        assertThat(divisionCountPage, containsString("How many digits division needed?"));

        String divisionPage = restTemplate.getForObject(url("/division?count=2"), String.class);
        assertThat(divisionPage, containsString("Divide"));

        String divisionResultPage = restTemplate.getForObject(url("/divide?operands=4&operands=2"), String.class);
        assertThat(divisionResultPage, containsString("Result of Division"));
        assertThat(divisionResultPage, containsString("2"));
    }

    @Test
    public void divisionExceptionTest() {
        String homePage = restTemplate.getForObject(url("/"), String.class);
        assertThat(homePage, containsString("Choice of Operations"));

        String divisionCountPage = restTemplate.getForObject(url("/division/count"), String.class);
        assertThat(divisionCountPage, containsString("How many digits division needed?"));

        String divisionPage = restTemplate.getForObject(url("/division?count=2"), String.class);
        assertThat(divisionPage, containsString("Divide"));

        String divisionResultPage = restTemplate.getForObject(url("/divide?operands=4&operands=0"), String.class);
        assertThat(divisionResultPage, containsString("Not Acceptable"));
    }

    @Test
    public void powerTest() {
        String homePage = restTemplate.getForObject(url("/"), String.class);
        assertThat(homePage, containsString("Choice of Operations"));

        String powerCountPage = restTemplate.getForObject(url("/power/count"), String.class);
        assertThat(powerCountPage, containsString("How many digits power needed?"));

        String powerPage = restTemplate.getForObject(url("/power?count=2"), String.class);
        assertThat(powerPage, containsString("Power"));

        String powerResultPage = restTemplate.getForObject(url("/pow?operands=4&operands=2"), String.class);
        assertThat(powerResultPage, containsString("Result of Power"));
        assertThat(powerResultPage, containsString("16"));
    }

    @Test
    public void powerExceptionTest() {
        String homePage = restTemplate.getForObject(url("/"), String.class);
        assertThat(homePage, containsString("Choice of Operations"));

        String powerCountPage = restTemplate.getForObject(url("/power/count"), String.class);
        assertThat(powerCountPage, containsString("How many digits power needed?"));

        String powerPage = restTemplate.getForObject(url("/power?count=2"), String.class);
        assertThat(powerPage, containsString("Power"));

        String powerResultPage = restTemplate.getForObject(url("/pow?operands=4&operands=-2"), String.class);
        assertThat(powerResultPage, containsString("Not Acceptable"));
    }

}
