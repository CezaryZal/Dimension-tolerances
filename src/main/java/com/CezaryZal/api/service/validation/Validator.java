package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.FirstGroupOfMatcher;
import com.CezaryZal.api.service.validation.matcher.SecondGroupOfMatcher;
import com.CezaryZal.api.service.validation.matcher.ThirdGroupOfMatcher;

public abstract class Validator {

    protected FirstGroupOfMatcher firstGroupOfMatcher;
    protected SecondGroupOfMatcher secondGroupOfMatcher;
    protected ThirdGroupOfMatcher thirdGroupOfMatcher;

    abstract void validation(int valueOfDimension, String symbolsFromInput, int valueITFromInput);
}
