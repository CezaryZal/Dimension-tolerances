package com.CezaryZal.api.service.creator;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.service.repo.AdditionalDataToBasicDeviationServiceRepoImp;
import com.CezaryZal.api.service.repo.BasicDeviationServiceRepoImp;
import com.CezaryZal.api.service.repo.NominalToleranceServiceRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueToDimensionDtoCreator {

    private final int minValueOfItToModifyValueOfBasicDeviation = 3;
    private final int maxValueOfItToModifyValueOfBasicDeviation = 8;

    private final NominalToleranceServiceRepoImp toleranceServiceByRepoImp;
    private final BasicDeviationServiceRepoImp deviationsServiceByRepoImp;
    private final AdditionalDataToBasicDeviationServiceRepoImp additionalDataServiceByRepoImp;

    @Autowired
    public ValueToDimensionDtoCreator(
            NominalToleranceServiceRepoImp toleranceServiceByRepoImp,
            BasicDeviationServiceRepoImp deviationsServiceByRepoImp,
            AdditionalDataToBasicDeviationServiceRepoImp additionalDataServiceByRepoImp) {
        this.toleranceServiceByRepoImp = toleranceServiceByRepoImp;
        this.deviationsServiceByRepoImp = deviationsServiceByRepoImp;
        this.additionalDataServiceByRepoImp = additionalDataServiceByRepoImp;
    }

    public ValuesToDimensionDto createValuesToDimensionDto(ParsedInputDimension parsedInputDimension) {

        double valueOfBasicDeviation =  deviationsServiceByRepoImp.getValueOfRecordBySignAndValue(
                String.valueOf(parsedInputDimension.getSymbol()),
                parsedInputDimension.getValueOfDimension());
        double valueOfNominalToleranceBySignAndValue = toleranceServiceByRepoImp.getValueOfRecordBySignAndValue(
                "IT" + parsedInputDimension.getValueOfIt(),
                parsedInputDimension.getValueOfDimension());

        valueOfBasicDeviation = modifyValueOfBasicDeviationIfIsSpeciallyDimension(
                parsedInputDimension, valueOfBasicDeviation);

        return new ValuesToDimensionDto(valueOfBasicDeviation, valueOfNominalToleranceBySignAndValue);
    }

    private double createOppositeNumber(double valueOfDeviation){
        return -valueOfDeviation;
    }

    private double modifyValueOfBasicDeviationIfIsSpeciallyDimension(
            ParsedInputDimension parsedInputDimension,
            double valueOfBasicDeviation){

        if (parsedInputDimension.getSymbol() < 'a'){
            valueOfBasicDeviation = createOppositeNumber(valueOfBasicDeviation);
        }
        if (parsedInputDimension.isSymbolOverH() &&
                parsedInputDimension.getSymbol() < 'P' &&
                parsedInputDimension.getValueOfIt() >= minValueOfItToModifyValueOfBasicDeviation &&
                parsedInputDimension.getValueOfIt() <= maxValueOfItToModifyValueOfBasicDeviation) {

            valueOfBasicDeviation += additionalDataServiceByRepoImp.getValueOfRecordBySignAndValue(
                    "IT" + parsedInputDimension.getValueOfIt(),
                    parsedInputDimension.getValueOfDimension());
        }
        return valueOfBasicDeviation;
    }
}
