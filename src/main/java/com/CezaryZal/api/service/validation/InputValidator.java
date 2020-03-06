package com.CezaryZal.api.service.validation;

import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import org.springframework.stereotype.Service;

@Service
public class InputValidator extends Validator{

    public InputValidator() {
        firstGroupOfMatcher = new ValueOfDimensionValidator();
        thirdGroupOfMatcher = new ValueOfItValidator();

    }

    @Override
    public void validation(int valueOfDimension, String symbolsFromInput, int valueITFromInput) {
        if (!firstGroupOfMatcher.isCorrect(valueOfDimension)){
            throw new InvalidValueOfDimensionException("Input dimension value must be from 1 to 500 mm");
        }

        if (!thirdGroupOfMatcher.isCorrect(valueITFromInput)){
            throw new InvalidValueOfDimensionException("Input value Of IT must be from 1 to 18 mm");
        }
    }
}
