package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE , reason = "Division By Zero is not possible.")
public class DivisionByZeroException extends Exception {

    public DivisionByZeroException(String message) {
        super(message);
    }
}
