package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.FirstGroupOfMatcher;

public abstract class Validator {

    protected FirstGroupOfMatcher firstGroupOfMatcher;


    abstract void validation(int valueOfDimension, String symbolsFromInput, int valueITFromInput);
}
