package com.CezaryZal.api.service;

import com.CezaryZal.api.service.calculation.result.ResultForHole;
import com.CezaryZal.api.service.calculation.result.ResultForShaft;
import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.service.creator.ValueToDimensionDtoCreator;
import com.CezaryZal.api.service.validation.InputValidator;
import com.CezaryZal.exceptions.InvalidInputException;
import com.CezaryZal.exceptions.InvalidSymbolsException;
import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import com.CezaryZal.exceptions.InvalidValueOfItException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DimensionService {

    private final ResultForShaft resultForShaft;
    private final ResultForHole resultForHole;
    private final ValueToDimensionDtoCreator valueToDimensionDtoCreator;
    private final InputDimensionParser inputDimensionParser;

    @Autowired
    public DimensionService(
            ResultForShaft resultForShaft,
            ResultForHole resultForHole,
            ValueToDimensionDtoCreator valueToDimensionDtoCreator,
            InputValidator inputValidator,
            InputDimensionParser inputDimensionParser) {
        this.resultForShaft = resultForShaft;
        this.resultForHole = resultForHole;
        this.valueToDimensionDtoCreator = valueToDimensionDtoCreator;
        this.inputDimensionParser = inputDimensionParser;
    }

    @SneakyThrows(InvalidInputException.class)
    public DimensionDto createDimensionTolerance(String input) {
        ParsedInputDimension parsedInputDimension = inputDimensionParser.parseInputDimension(input);
        ValuesToDimensionDto valuesToDimensionDto =
                valueToDimensionDtoCreator.createValuesToDimensionDto(parsedInputDimension);

        return (Character.isLowerCase(parsedInputDimension.getSymbol()) ?
                resultForShaft.calculate(valuesToDimensionDto, parsedInputDimension) :
                resultForHole.calculate(valuesToDimensionDto, parsedInputDimension));
    }
}
