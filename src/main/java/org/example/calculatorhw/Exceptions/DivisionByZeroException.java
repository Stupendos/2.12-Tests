package org.example.calculatorhw.Exceptions;

import org.springframework.http.HttpStatus;

public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException(String message) {
        super(message);
    }
}
