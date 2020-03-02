package com.CezaryZal.api.service.creator;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDTO;
import com.CezaryZal.api.service.repo.AdditionalDataToBasicDeviationServiceRepoImp;
import com.CezaryZal.api.service.repo.BasicDeviationServiceRepoImp;
import com.CezaryZal.api.service.repo.NominalToleranceServiceRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValueToDimensionDTOCreator {

    private final NominalToleranceServiceRepoImp toleranceServiceByRepoImp;
    private final BasicDeviationServiceRepoImp deviationsServiceByRepoImp;
    private final AdditionalDataToBasicDeviationServiceRepoImp additionalDataServiceByRepoImp;

    @Autowired
    public ValueToDimensionDTOCreator(
            NominalToleranceServiceRepoImp toleranceServiceByRepoImp,
            BasicDeviationServiceRepoImp deviationsServiceByRepoImp,
            AdditionalDataToBasicDeviationServiceRepoImp additionalDataServiceByRepoImp) {
        this.toleranceServiceByRepoImp = toleranceServiceByRepoImp;
        this.deviationsServiceByRepoImp = deviationsServiceByRepoImp;
        this.additionalDataServiceByRepoImp = additionalDataServiceByRepoImp;
    }

    public ValuesToDimensionDTO createValuesToDimensionDTO(ParsedInputDimension parsedInputDimension) {

        double valueOfBasicDeviation =  deviationsServiceByRepoImp.getValueOfRecordBySignAndValue(
                String.valueOf(parsedInputDimension.getSymbol()),
                parsedInputDimension.getValueOfDimension());
        double valueOfNominalToleranceBySignAndValue = toleranceServiceByRepoImp.getValueOfRecordBySignAndValue(
                "IT" + parsedInputDimension.getValueOfIT(),
                parsedInputDimension.getValueOfDimension());

        valueOfBasicDeviation = modifyValueOfBasicDeviationIfIsSpeciallyDimension(
                parsedInputDimension, valueOfBasicDeviation);

        return new ValuesToDimensionDTO(valueOfBasicDeviation, valueOfNominalToleranceBySignAndValue);
    }

    private double createOppositeNumber(double valueOfDeviation){
        return valueOfDeviation * -1;
    }

    private double modifyValueOfBasicDeviationIfIsSpeciallyDimension(
            ParsedInputDimension parsedInputDimension,
            double valueOfBasicDeviation){

        if (parsedInputDimension.getSymbol() < 97){
            valueOfBasicDeviation = createOppositeNumber(valueOfBasicDeviation);
        }
        if (parsedInputDimension.isSymbolOverH() &&
                parsedInputDimension.getSymbol() < 'P' &&
                parsedInputDimension.getValueOfIT() >= 3 &&
                parsedInputDimension.getValueOfIT() <= 8) {

            valueOfBasicDeviation += additionalDataServiceByRepoImp.getValueOfRecordBySignAndValue(
                    "IT" + parsedInputDimension.getValueOfIT(),
                    parsedInputDimension.getValueOfDimension());
        }
        return valueOfBasicDeviation;
    }
}
