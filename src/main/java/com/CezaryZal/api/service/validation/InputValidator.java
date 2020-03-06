package com.CezaryZal.api.service.validation;

import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import org.springframework.stereotype.Service;

@Service
public class InputValidator extends Validator{

    public InputValidator() {
        firstGroupOfMatcher = new ValueOfDimensionValidator();


    }

    @Override
    public void validation(int valueOfDimension, String symbolsFromInput, int valueITFromInput) {
        if (!firstGroupOfMatcher.isCorrect(valueOfDimension)){
            throw new InvalidValueOfDimensionException("Input dimension value must be from 1 to 500 mm");
        }


    }
}
