package com.CezaryZal.api.service;

import com.CezaryZal.api.service.calculation.result.ResultForHole;
import com.CezaryZal.api.service.calculation.result.ResultForShaft;
import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.service.creator.ValueToDimensionDtoCreator;
import com.CezaryZal.api.service.validation.InputValidator;
import com.CezaryZal.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DimensionService {

    private final Pattern pattern = Pattern.compile("([0-9]\\d*)([a-zA-Z])([0-9][0-8]*)");

    private final ResultForShaft resultForShaft;
    private final ResultForHole resultForHole;
    private final ValueToDimensionDtoCreator valueToDimensionDtoCreator;
    private final InputValidator inputValidator;

    @Autowired
    public DimensionService(
            ResultForShaft resultForShaft,
            ResultForHole resultForHole,
            ValueToDimensionDtoCreator valueToDimensionDtoCreator,
            InputValidator inputValidator) {
        this.resultForShaft = resultForShaft;
        this.resultForHole = resultForHole;
        this.valueToDimensionDtoCreator = valueToDimensionDtoCreator;
        this.inputValidator = inputValidator;
    }

    public DimensionDto createDimensionTolerance(String input) {
        ParsedInputDimension parsedInputDimension = shareInput(input);
        ValuesToDimensionDto valuesToDimensionDto =
                valueToDimensionDtoCreator.createValuesToDimensionDto(parsedInputDimension);

        return (Character.isLowerCase(parsedInputDimension.getSymbol()) ?
                resultForShaft.calculate(valuesToDimensionDto, parsedInputDimension) :
                resultForHole.calculate(valuesToDimensionDto, parsedInputDimension));
    }

    private ParsedInputDimension shareInput(String input) {
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            int valueOfDimension = Integer.parseInt(matcher.group(1));
            String symbolsFromInput = String.valueOf(matcher.group(2));
            int valueITFromInput = Integer.parseInt(matcher.group(3));

            inputValidator.validation(valueOfDimension, symbolsFromInput, valueITFromInput);

            char symbolFromInput = symbolsFromInput.charAt(0);
            boolean isSymbolOverH = Character.toLowerCase(symbolFromInput) > 'h';

            return new ParsedInputDimension(valueOfDimension, symbolFromInput, valueITFromInput, isSymbolOverH);
        }
        throw new InvalidInputException("entered value is incorrect");
    }
}
