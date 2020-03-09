package com.CezaryZal.api.service.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SymbolsValidatorTest {

    SymbolsValidator symbolsValidator;

    @Before
    public void setUp() throws Exception {
        symbolsValidator = new SymbolsValidator();
    }

    @Test
    public void should_return_true_when_compare_with_correct_symbol() {
        Assert.assertTrue(symbolsValidator.isCorrect("a"));
    }
    @Test
    public void should_return_true_when_compare_with_correct_symbol_in_lower_case() {
        Assert.assertTrue(symbolsValidator.symbolsIsCorrect("a"));
    }
    @Test
    public void should_return_true_when_compare_with_correct_symbol_in_upper_case() {
        Assert.assertTrue(symbolsValidator.symbolsIsCorrect("C"));
    }

    @Test
    public void should_return_false_when_compare_with_empty_String() {
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect(""));
    }
    @Test
    public void should_return_false_when_compare_with_long_String() {
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("aa"));
    }
    @Test
    public void should_return_false_when_compare_with_lower_case_symbol_over_S() {
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("t"));
    }
    @Test
    public void should_return_false_when_compare_with_upper_case_symbol_over_S() {
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("T"));
    }
    @Test
    public void should_return_false_when_compare_with_incorrect_symbols() {
        List<String> incorrectSymbols = Arrays.asList("b", "i", "l", "o", "q");
        boolean result = false;
        for (String incorrectSymbol : incorrectSymbols) {
            if (symbolsValidator.symbolsIsCorrect(incorrectSymbol)) {
                result = true;
                break;
            }
        }
        Assert.assertFalse(result);
    }
}