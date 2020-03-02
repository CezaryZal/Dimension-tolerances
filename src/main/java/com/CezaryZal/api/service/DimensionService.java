package com.CezaryZal.api.service;

import com.CezaryZal.api.service.calculation.result.ResultForHole;
import com.CezaryZal.api.service.calculation.result.ResultForShaft;
import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.service.creator.ValueToDimensionDtoCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DimensionService {

    private final int hInAscii = 104;
    private final Pattern pattern = Pattern.compile("([1-9]\\d*)([a-zA-Z])([1-9][0-8]*)");

    private final ResultForShaft resultForShaft;
    private final ResultForHole resultForHole;
    private final ValueToDimensionDtoCreator valueToDimensionDtoCreator;

    @Autowired
    public DimensionService(
            ResultForShaft resultForShaft,
            ResultForHole resultForHole,
            ValueToDimensionDtoCreator valueToDimensionDtoCreator) {
        this.resultForShaft = resultForShaft;
        this.resultForHole = resultForHole;
        this.valueToDimensionDtoCreator = valueToDimensionDtoCreator;
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
        char symbolFromInput;
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            symbolFromInput = matcher.group(2).charAt(0);

            return new ParsedInputDimension(
                    Integer.parseInt(matcher.group(1)),
                    symbolFromInput,
                    Integer.parseInt(matcher.group(3)),
                    Character.toLowerCase(symbolFromInput) > hInAscii);
        }
        //add Exception class
        return null;
    }
}
