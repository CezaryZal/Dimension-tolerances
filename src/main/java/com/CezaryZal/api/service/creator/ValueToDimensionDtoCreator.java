package com.CezaryZal.api.service.creator;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.service.repo.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueToDimensionDtoCreator {

    private final int minValueOfItToModifyValueOfBasicDeviation = 3;
    private final int maxValueOfItToModifyValueOfBasicDeviation = 8;

    private final ServiceRepo serviceRepoImp;

    @Autowired
    public ValueToDimensionDtoCreator(ServiceRepo serviceRepoImp) {
        this.serviceRepoImp = serviceRepoImp;
    }

    public ValuesToDimensionDto createValuesToDimensionDto(ParsedInputDimension parsedInputDimension) {

        double valueOfBasicDeviation =  serviceRepoImp.getValueOfBasicDeviationBySignAndValue(
                String.valueOf(parsedInputDimension.getSymbol()),
                parsedInputDimension.getValueOfDimension());
        double valueOfNominalToleranceBySignAndValue = serviceRepoImp.getValueOfNominalToleranceBySignAndValue(
                "IT" + parsedInputDimension.getValueOfIt(),
                parsedInputDimension.getValueOfDimension());

        valueOfBasicDeviation = modifyValueOfBasicDeviationIfIsSpeciallyDimension(
                parsedInputDimension, valueOfBasicDeviation);

        return new ValuesToDimensionDto(valueOfBasicDeviation, valueOfNominalToleranceBySignAndValue);
    }

    private double modifyValueOfBasicDeviationIfIsSpeciallyDimension(
            ParsedInputDimension parsedInputDimension,
            double valueOfBasicDeviation){

            valueOfBasicDeviation = modifyValueOfBasicDeviationIfSymbolIsInUpperCase(
                    parsedInputDimension.getSymbol(), valueOfBasicDeviation);

        if (parsedInputDimension.isSymbolOverH() &&
                parsedInputDimension.getSymbol() < 'P' &&
                parsedInputDimension.getValueOfIt() >= minValueOfItToModifyValueOfBasicDeviation &&
                parsedInputDimension.getValueOfIt() <= maxValueOfItToModifyValueOfBasicDeviation) {

            valueOfBasicDeviation += serviceRepoImp.getValueOfAdditionalDataBySignAndValue(
                    "IT" + parsedInputDimension.getValueOfIt(),
                    parsedInputDimension.getValueOfDimension());
        }
        return valueOfBasicDeviation;
    }

    private double modifyValueOfBasicDeviationIfSymbolIsInUpperCase(
            char symbol,  double valueOfBasicDeviation){

        if (!(symbol < 'a') || valueOfBasicDeviation == 0){
            return valueOfBasicDeviation;
        }
        return  -valueOfBasicDeviation;
    }
}
