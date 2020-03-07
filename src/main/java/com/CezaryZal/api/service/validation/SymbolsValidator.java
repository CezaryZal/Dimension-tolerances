package com.CezaryZal.api.service.validation;

import com.CezaryZal.api.service.validation.matcher.SecondGroupOfMatcher;

import java.util.Arrays;
import java.util.List;

public class SymbolsValidator implements StringValidator, SecondGroupOfMatcher {
    List<Character> incorrectSymbols = Arrays.asList('b', 'i', 'l', 'o', 'q');
    private final int maxLengthOfSymbolsFromInput = 1;

    @Override
    public boolean isCorrect(Object symbolsFromInput) {
        return symbolsIsCorrect((String) symbolsFromInput);
    }

    @Override
    public boolean symbolsIsCorrect(String symbolsFromInput) {
        return isOneLetter(symbolsFromInput) &&
                isSymbolOverS(symbolsFromInput) &&
                containsIncorrectSymbol(symbolsFromInput);

    }

    private boolean isOneLetter(String symbolsFromInput) {
        return symbolsFromInput.length() == maxLengthOfSymbolsFromInput;
    }

    private boolean isSymbolOverS(String symbolsFromInput) {
        return Character.toLowerCase(symbolsFromInput.charAt(0)) <= 's';
    }

    private boolean containsIncorrectSymbol(String symbolsFromInput) {
        Character symbolFromInput = symbolsFromInput.toLowerCase().charAt(0);
        return !incorrectSymbols.contains(symbolFromInput);
    }

}
