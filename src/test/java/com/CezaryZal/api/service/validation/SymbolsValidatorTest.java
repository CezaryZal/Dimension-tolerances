package com.CezaryZal.api.service.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE;
import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(MockitoJUnitRunner.class)
public class SymbolsValidatorTest {

    @Spy
    private SymbolsValidator symbolsValidator;

    private final String nameSymbol = "symbols ";

    @Test
    public void is_correct_should_be_symbol_match_to_expected() {
        String symbolsSLowerCase = "s";
        boolean isCorrectForSymbolsSLowerCase = symbolsValidator.isCorrect(symbolsSLowerCase);
        then(isCorrectForSymbolsSLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolsSLowerCase)
                .isTrue();

        String symbolsSUpperCase = "S";
        boolean isCorrectForSymbolsSUpperCase = symbolsValidator.isCorrect(symbolsSUpperCase);
        then(isCorrectForSymbolsSUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolsSUpperCase)
                .isTrue();
    }

    @Test
    public void is_correct_should_not_be_incorrect_symbol() {
        String symbolBLowerCase = "b";
        boolean isCorrectForSymbolBLowerCase = symbolsValidator.isCorrect(symbolBLowerCase);
        then(isCorrectForSymbolBLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolBLowerCase)
                .isFalse();

        String symbolILowerCase = "i";
        boolean isCorrectForSymbolILowerCase = symbolsValidator.isCorrect(symbolILowerCase);
        then(isCorrectForSymbolILowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolILowerCase)
                .isFalse();

        String symbolLLowerCase = "l";
        boolean isCorrectForSymbolLLowerCase = symbolsValidator.isCorrect(symbolLLowerCase);
        then(isCorrectForSymbolLLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolLLowerCase)
                .isFalse();

        String symbolOLowerCase = "o";
        boolean isCorrectForSymbolOLowerCase = symbolsValidator.isCorrect(symbolOLowerCase);
        then(isCorrectForSymbolOLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolOLowerCase)
                .isFalse();

        String symbolQLowerCase = "q";
        boolean isCorrectForSymbolQLowerCase = symbolsValidator.isCorrect(symbolQLowerCase);
        then(isCorrectForSymbolQLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolQLowerCase)
                .isFalse();

        String symbolBUpperCase = "B";
        boolean isCorrectForSymbolBUpperCase = symbolsValidator.isCorrect(symbolBUpperCase);
        then(isCorrectForSymbolBUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolBUpperCase)
                .isFalse();

        String symbolIUpperCase = "I";
        boolean isCorrectForSymbolIUpperCase = symbolsValidator.isCorrect(symbolIUpperCase);
        then(isCorrectForSymbolIUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolIUpperCase)
                .isFalse();

        String symbolLUpperCase = "L";
        boolean isCorrectForSymbolLUpperCase = symbolsValidator.isCorrect(symbolLUpperCase);
        then(isCorrectForSymbolLUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolLUpperCase)
                .isFalse();

        String symbolOUpperCase = "O";
        boolean isCorrectForSymbolOUpperCase = symbolsValidator.isCorrect(symbolOUpperCase);
        then(isCorrectForSymbolOUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolOUpperCase)
                .isFalse();

        String symbolQUpperCase = "Q";
        boolean isCorrectForSymbolQUpperCase = symbolsValidator.isCorrect(symbolQUpperCase);
        then(isCorrectForSymbolQUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolQUpperCase)
                .isFalse();
    }

    @Test
    public void is_correct_should_not_be_empty_or_from_several_symbols() {
        String emptySymbol = "";
        String descriptionEmptySymbol = "empty";
        boolean isCorrectForEmptySymbol = symbolsValidator.isCorrect(emptySymbol);
        then(isCorrectForEmptySymbol)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + descriptionEmptySymbol)
                .isFalse();

        String tmpSymbols = "aa";
        boolean isCorrectForTmpSymbols = symbolsValidator.isCorrect(tmpSymbols);
        then(isCorrectForTmpSymbols)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + tmpSymbols)
                .isFalse();
    }

    @Test
    public void is_correct_should_not_be_symbols_over_T() {
        String symbolTLowerCase = "t";
        boolean isCorrectForSymbolTLowerCase = symbolsValidator.isCorrect(symbolTLowerCase);
        then(isCorrectForSymbolTLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolTLowerCase)
                .isFalse();

        String symbolTUpperCase = "T";
        boolean isCorrectForSymbolTUpperCase = symbolsValidator.isCorrect(symbolTUpperCase);
        then(isCorrectForSymbolTUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolTUpperCase)
                .isFalse();
    }

    @Test
    public void symbols_is_correct_should_be_symbol_match_to_expected() {
        String symbolsSLowerCase = "s";
        boolean isCorrectForSymbolsSLowerCase = symbolsValidator.symbolsIsCorrect(symbolsSLowerCase);
        then(isCorrectForSymbolsSLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolsSLowerCase)
                .isTrue();

        String symbolsSUpperCase = "S";
        boolean isCorrectForSymbolsSUpperCase = symbolsValidator.symbolsIsCorrect(symbolsSUpperCase);
        then(isCorrectForSymbolsSUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolsSUpperCase)
                .isTrue();
    }

    @Test
    public void symbols_is_correct_should_not_be_incorrect_symbol() {
        String symbolBLowerCase = "b";
        boolean isCorrectForSymbolBLowerCase = symbolsValidator.symbolsIsCorrect(symbolBLowerCase);
        then(isCorrectForSymbolBLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolBLowerCase)
                .isFalse();

        String symbolILowerCase = "i";
        boolean isCorrectForSymbolILowerCase = symbolsValidator.symbolsIsCorrect(symbolILowerCase);
        then(isCorrectForSymbolILowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolILowerCase)
                .isFalse();

        String symbolLLowerCase = "l";
        boolean isCorrectForSymbolLLowerCase = symbolsValidator.symbolsIsCorrect(symbolLLowerCase);
        then(isCorrectForSymbolLLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolLLowerCase)
                .isFalse();

        String symbolOLowerCase = "o";
        boolean isCorrectForSymbolOLowerCase = symbolsValidator.symbolsIsCorrect(symbolOLowerCase);
        then(isCorrectForSymbolOLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolOLowerCase)
                .isFalse();

        String symbolQLowerCase = "q";
        boolean isCorrectForSymbolQLowerCase = symbolsValidator.symbolsIsCorrect(symbolQLowerCase);
        then(isCorrectForSymbolQLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + nameSymbol + symbolQLowerCase)
                .isFalse();

        String symbolBUpperCase = "B";
        boolean isCorrectForSymbolBUpperCase = symbolsValidator.symbolsIsCorrect(symbolBUpperCase);
        then(isCorrectForSymbolBUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolBUpperCase)
                .isFalse();

        String symbolIUpperCase = "I";
        boolean isCorrectForSymbolIUpperCase = symbolsValidator.symbolsIsCorrect(symbolIUpperCase);
        then(isCorrectForSymbolIUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolIUpperCase)
                .isFalse();

        String symbolLUpperCase = "L";
        boolean isCorrectForSymbolLUpperCase = symbolsValidator.symbolsIsCorrect(symbolLUpperCase);
        then(isCorrectForSymbolLUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolLUpperCase)
                .isFalse();

        String symbolOUpperCase = "O";
        boolean isCorrectForSymbolOUpperCase = symbolsValidator.symbolsIsCorrect(symbolOUpperCase);
        then(isCorrectForSymbolOUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolOUpperCase)
                .isFalse();

        String symbolQUpperCase = "Q";
        boolean isCorrectForSymbolQUpperCase = symbolsValidator.symbolsIsCorrect(symbolQUpperCase);
        then(isCorrectForSymbolQUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolQUpperCase)
                .isFalse();
    }

    @Test
    public void symbols_is_correct_should_not_be_empty_or_from_several_symbols() {
        String emptySymbol = "";
        String descriptionEmptySymbol = "empty";
        boolean isCorrectForEmptySymbol = symbolsValidator.symbolsIsCorrect(emptySymbol);
        then(isCorrectForEmptySymbol)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + descriptionEmptySymbol)
                .isFalse();

        String tmpSymbols = "aa";
        boolean isCorrectForTmpSymbols = symbolsValidator.symbolsIsCorrect(tmpSymbols);
        then(isCorrectForTmpSymbols)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + tmpSymbols)
                .isFalse();
    }

    @Test
    public void symbols_is_correct_should_not_be_symbols_over_T() {
        String symbolTLowerCase = "t";
        boolean isCorrectForSymbolTLowerCase = symbolsValidator.symbolsIsCorrect(symbolTLowerCase);
        then(isCorrectForSymbolTLowerCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolTLowerCase)
                .isFalse();

        String symbolTUpperCase = "T";
        boolean isCorrectForSymbolTUpperCase = symbolsValidator.symbolsIsCorrect(symbolTUpperCase);
        then(isCorrectForSymbolTUpperCase)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + nameSymbol + symbolTUpperCase)
                .isFalse();
    }
}