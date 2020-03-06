package com.CezaryZal.api.service.validation;

import com.CezaryZal.exceptions.InvalidInputException;
import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import org.springframework.stereotype.Service;

@Service
public class InputValidator extends Validator{

    public InputValidator() {
        firstGroupOfMatcher = new ValueOfDimensionValidator();
        secondGroupOfMatcher = new SymbolsValidator();
        thirdGroupOfMatcher = new ValueOfItValidator();
    }

    @Override
    public void throwIfInputValuesIsIncorrect(int valueOfDimension, String symbolsFromInput, int valueITFromInput) {
        if (!firstGroupOfMatcher.isCorrect(valueOfDimension)){
            throw new InvalidValueOfDimensionException("Input dimension value must be from 1 to 500 mm");
        }

        if (!secondGroupOfMatcher.isCorrect(symbolsFromInput)){
            throw new InvalidValueOfDimensionException("Symbol entered is incorrect, should be ");
        }

        if (!thirdGroupOfMatcher.isCorrect(valueITFromInput)){
            throw new InvalidValueOfDimensionException("Input value Of IT must be from 1 to 18 mm");
        }
    }

    @Override
    public void throwIfInputDoesNotMatchPattern() {
        throw new InvalidInputException("entered value is incorrect (example of a valid value - 52H7)");
    }
}
