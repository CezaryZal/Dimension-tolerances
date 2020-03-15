package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.FirstGroupOfMatcher;
import com.CezaryZal.api.service.validation.matcher.SecondGroupOfMatcher;
import com.CezaryZal.api.service.validation.matcher.ThirdGroupOfMatcher;
import com.CezaryZal.exceptions.InvalidInputException;

public abstract class Validator {

    protected FirstGroupOfMatcher firstGroupOfMatcher;
    protected SecondGroupOfMatcher secondGroupOfMatcher;
    protected ThirdGroupOfMatcher thirdGroupOfMatcher;

    public abstract void throwIfInputValuesIsIncorrect(
            int valueOfDimension,
            String symbolsFromInput,
            int valueITFromInput) throws InvalidInputException;

    public abstract void throwIfInputDoesNotMatchPattern() throws InvalidInputException;
}
