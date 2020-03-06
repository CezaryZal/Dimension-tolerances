package com.CezaryZal.exceptions;

public class InvalidValueOfDimensionException extends RuntimeException{

    public InvalidValueOfDimensionException(String exceptionDescription) {
        super(exceptionDescription);
    }
}
