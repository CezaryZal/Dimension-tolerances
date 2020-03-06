package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.ThirdGroupOfMatcher;

public class ValueOfItValidator implements NumberValidator, ThirdGroupOfMatcher {

    @Override
    public boolean isCorrect(Object valueITFromInput) {
        return numberIsCorrect((Integer) valueITFromInput);
    }

    @Override
    public boolean numberIsCorrect(Integer valueITFromInput) {
        return valueITFromInput >= 1 && valueITFromInput <= 18;
    }



}
