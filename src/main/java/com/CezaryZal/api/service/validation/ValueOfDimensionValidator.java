package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.FirstGroupOfMatcher;

public class ValueOfDimensionValidator implements NumberValidator, FirstGroupOfMatcher {
    private final int minLengthOfDimensionValue = 1;
    private final int maxLengthOfDimensionValue = 500;

    @Override
    public boolean isCorrect(Object valueOfDimension) {
        return numberIsCorrect((Integer) valueOfDimension);
    }

    @Override
    public boolean numberIsCorrect(Integer valueOfDimension) {
        return valueOfDimension >= minLengthOfDimensionValue && valueOfDimension <= maxLengthOfDimensionValue;
    }


}
