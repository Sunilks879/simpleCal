package com.cts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE , reason = "Positive integer power only is possible.")
public class NegativePowerException extends Exception {
    public NegativePowerException(String message) {
        super(message);
    }
}
