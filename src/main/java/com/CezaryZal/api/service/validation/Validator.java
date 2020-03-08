package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.FirstGroupOfMatcher;
import com.CezaryZal.api.service.validation.matcher.SecondGroupOfMatcher;
import com.CezaryZal.api.service.validation.matcher.ThirdGroupOfMatcher;
import com.CezaryZal.exceptions.InvalidInputException;
import com.CezaryZal.exceptions.InvalidSymbolsException;
import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import com.CezaryZal.exceptions.InvalidValueOfItException;

public abstract class Validator {

    protected FirstGroupOfMatcher firstGroupOfMatcher;
    protected SecondGroupOfMatcher secondGroupOfMatcher;
    protected ThirdGroupOfMatcher thirdGroupOfMatcher;

    public abstract void throwIfInputValuesIsIncorrect(int valueOfDimension, String symbolsFromInput, int valueITFromInput) throws InvalidValueOfDimensionException, InvalidSymbolsException, InvalidValueOfItException;

    public abstract void throwIfInputDoesNotMatchPattern() throws InvalidInputException;
}
