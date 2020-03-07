package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.ThirdGroupOfMatcher;

public class ValueOfItValidator implements NumberValidator, ThirdGroupOfMatcher {
    private final int minLengthOfValueIt = 1;
    private final int maxLengthOfValueIt = 18;

    @Override
    public boolean isCorrect(Object valueITFromInput) {
        return numberIsCorrect((Integer) valueITFromInput);
    }

    @Override
    public boolean numberIsCorrect(Integer valueITFromInput) {
        return valueITFromInput >= minLengthOfValueIt && valueITFromInput <= maxLengthOfValueIt;
    }



}
