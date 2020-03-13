package com.CezaryZal.api.service.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SymbolsValidatorTest {

    SymbolsValidator symbolsValidator;

    @Before
    public void setUp() throws Exception {
        symbolsValidator = new SymbolsValidator();
    }

    @Test
    public void is_correct_should_be_symbol_match_to_expected() {
        Assert.assertTrue(symbolsValidator.isCorrect("s"));
        Assert.assertTrue(symbolsValidator.isCorrect("S"));
        Assert.assertFalse(symbolsValidator.isCorrect(""));
        Assert.assertFalse(symbolsValidator.isCorrect("aa"));
        Assert.assertFalse(symbolsValidator.isCorrect("t"));
        Assert.assertFalse(symbolsValidator.isCorrect("T"));
    }

    @Test
    public void is_correct_should_not_commit_incorrect_symbols() {
        Assert.assertFalse(symbolsValidator.isCorrect("b"));
        Assert.assertFalse(symbolsValidator.isCorrect("i"));
        Assert.assertFalse(symbolsValidator.isCorrect("l"));
        Assert.assertFalse(symbolsValidator.isCorrect("o"));
        Assert.assertFalse(symbolsValidator.isCorrect("q"));
        Assert.assertFalse(symbolsValidator.isCorrect("B"));
        Assert.assertFalse(symbolsValidator.isCorrect("I"));
        Assert.assertFalse(symbolsValidator.isCorrect("L"));
        Assert.assertFalse(symbolsValidator.isCorrect("O"));
        Assert.assertFalse(symbolsValidator.isCorrect("Q"));
    }

    @Test
    public void symbols_is_correct_should_be_symbol_match_to_expected() {
        Assert.assertTrue(symbolsValidator.symbolsIsCorrect("s"));
        Assert.assertTrue(symbolsValidator.symbolsIsCorrect("S"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect(""));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("aa"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("t"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("T"));
    }

    @Test
    public void symbols_is_correct_should_not_commit_incorrect_symbols() {
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("b"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("i"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("l"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("o"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("q"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("B"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("I"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("L"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("O"));
        Assert.assertFalse(symbolsValidator.symbolsIsCorrect("Q"));
    }
}