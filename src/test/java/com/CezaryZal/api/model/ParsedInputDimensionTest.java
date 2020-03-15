package com.CezaryZal.api.model;

import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class ParsedInputDimensionTest {

    @Test
    public void is_symbol_over_H_should_be_symbol_above_H() {
        boolean isCorrectForTmpSymbolILowerCase =
                new ParsedInputDimension(10, 'i', 10).isSymbolOverH();
        then(isCorrectForTmpSymbolILowerCase)
                .isTrue();

        boolean isCorrectForTmpSymbolIUpperCase =
                new ParsedInputDimension(10, 'I', 10).isSymbolOverH();
        then(isCorrectForTmpSymbolIUpperCase)
                .isTrue();

        boolean isCorrectForSymbolHLowerCase =
                new ParsedInputDimension(10, 'h', 10).isSymbolOverH();
        then(isCorrectForSymbolHLowerCase)
                .isFalse();

        boolean isCorrectForTmpSymbolHUpperCase =
                new ParsedInputDimension(10, 'H', 10).isSymbolOverH();
        then(isCorrectForTmpSymbolHUpperCase)
                .isFalse();
    }
}
