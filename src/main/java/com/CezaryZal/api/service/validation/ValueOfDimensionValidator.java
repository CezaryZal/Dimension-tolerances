package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.FirstGroupOfMatcher;

public class ValueOfDimensionValidator implements NumberValidator, FirstGroupOfMatcher {

    @Override
    public boolean isCorrect(Object valueOfDimension) {
        return numberIsCorrect((Integer) valueOfDimension);
    }

    @Override
    public boolean numberIsCorrect(Integer valueOfDimension) {
        return valueOfDimension >= 1 && valueOfDimension <= 500;
    }


}
