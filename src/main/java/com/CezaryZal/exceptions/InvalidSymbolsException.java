package com.CezaryZal.exceptions;

public class InvalidSymbolsException extends RuntimeException {

    public InvalidSymbolsException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
