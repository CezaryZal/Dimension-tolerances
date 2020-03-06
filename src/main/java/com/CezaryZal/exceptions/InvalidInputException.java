package com.CezaryZal.exceptions;

public class InvalidInputException extends RuntimeException{

    public InvalidInputException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
