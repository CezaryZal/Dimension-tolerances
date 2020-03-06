package com.CezaryZal.api.service;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.service.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class InputDimensionParser {
    private final Pattern pattern = Pattern.compile("(^([0-9]\\d*)([a-zA-Z]+)([0-9]*))\\s");

    private final Validator inputValidator;

    @Autowired
    public InputDimensionParser(Validator inputValidator) {
        this.inputValidator = inputValidator;
    }

    ParsedInputDimension parseInputDimension(String input) {
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            inputValidator.throwIfInputDoesNotMatchPattern();
        }

        int valueOfDimension = Integer.parseInt(matcher.group(1));
        String symbolsFromInput = String.valueOf(matcher.group(2));
        int valueITFromInput = Integer.parseInt(matcher.group(3));

        inputValidator.throwIfInputValuesIsIncorrect(valueOfDimension, symbolsFromInput, valueITFromInput);

        char symbolFromInput = symbolsFromInput.charAt(0);
        boolean isSymbolOverH = Character.toLowerCase(symbolFromInput) > 'h';

        return new ParsedInputDimension(valueOfDimension, symbolFromInput, valueITFromInput, isSymbolOverH);
    }
}
