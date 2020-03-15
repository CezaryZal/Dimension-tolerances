package com.CezaryZal.api.service.validation;

import com.CezaryZal.exceptions.InvalidInputException;
import com.CezaryZal.exceptions.InvalidSymbolsException;
import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import com.CezaryZal.exceptions.InvalidValueOfItException;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InputValidatorTest {

    @Spy
    private InputValidator inputValidator;

    @SneakyThrows
    @Test(expected = InvalidValueOfDimensionException.class)
    public void throw_if_input_values_is_incorrect_should_throw_exceptions() {
        inputValidator.throwIfInputValuesIsIncorrect(0, "s", 2);
        inputValidator.throwIfInputValuesIsIncorrect(501, "s", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "aa", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "aa", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "aa", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "aa", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "t", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "T", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "b", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "i", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "l", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "o", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "q", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "B", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "I", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "L", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "O", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "Q", 2);
        inputValidator.throwIfInputValuesIsIncorrect(1, "a", 0);
        inputValidator.throwIfInputValuesIsIncorrect(1, "a", 19);
    }

    @Test
    public void throw_if_input_values_is_incorrect_should_not_throw_exceptions() {
        try {
            inputValidator.throwIfInputValuesIsIncorrect(1, "s", 2);
            inputValidator.throwIfInputValuesIsIncorrect(500, "s", 2);
            inputValidator.throwIfInputValuesIsIncorrect(1, "S", 2);
            inputValidator.throwIfInputValuesIsIncorrect(1, "a", 2);
            inputValidator.throwIfInputValuesIsIncorrect(18, "a", 2);
        } catch (InvalidInputException exception) {
            Assert.fail("InputValidator thrown exception, but he should not throw nothing");
        }
    }

    @SneakyThrows
    @Test(expected = InvalidInputException.class)
    public void throwIfInputDoesNotMatchPattern() {
        inputValidator.throwIfInputDoesNotMatchPattern();
    }
}