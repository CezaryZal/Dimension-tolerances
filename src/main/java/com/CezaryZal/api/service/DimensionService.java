package com.CezaryZal.api.service;

import com.CezaryZal.api.service.calculation.result.ResultForHole;
import com.CezaryZal.api.service.calculation.result.ResultForShaft;
import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDTO;
import com.CezaryZal.api.model.dto.DimensionDTO;
import com.CezaryZal.api.service.creator.ValueToDimensionDTOCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DimensionService {

    private final Pattern PATTERN = Pattern.compile("([1-9]\\d*)([a-zA-Z])([1-9][0-8]*)");

    private final ResultForShaft resultForShaft;
    private final ResultForHole resultForHole;
    private final ValueToDimensionDTOCreator valueToDimensionDTOCreator;

    @Autowired
    public DimensionService(
            ResultForShaft resultForShaft,
            ResultForHole resultForHole,
            ValueToDimensionDTOCreator valueToDimensionDTOCreator) {
        this.resultForShaft = resultForShaft;
        this.resultForHole = resultForHole;
        this.valueToDimensionDTOCreator = valueToDimensionDTOCreator;
    }

    public DimensionDTO createDimensionTolerance(String input) {
        ParsedInputDimension parsedInputDimension = shareInput(input);
        ValuesToDimensionDTO valuesToDimensionDTO =
                valueToDimensionDTOCreator.createValuesToDimensionDTO(parsedInputDimension);

        return (Character.isLowerCase(parsedInputDimension.getSymbol()) ?
                resultForShaft.calculate(valuesToDimensionDTO, parsedInputDimension) :
                resultForHole.calculate(valuesToDimensionDTO, parsedInputDimension));
    }

    private ParsedInputDimension shareInput(String input) {
        char symbolFromInput;
        Matcher matcher = PATTERN.matcher(input);

        if (matcher.find()) {
            symbolFromInput = matcher.group(2).charAt(0);

            return new ParsedInputDimension(
                    Integer.parseInt(matcher.group(1)),
                    symbolFromInput,
                    Integer.parseInt(matcher.group(3)),
                    Character.toLowerCase(symbolFromInput) > 'h');
        }
        //add Exception class
        return null;
    }
}
