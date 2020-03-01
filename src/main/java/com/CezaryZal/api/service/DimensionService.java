package com.CezaryZal.api.service;

import com.CezaryZal.api.service.calculation.result.ResultForHole;
import com.CezaryZal.api.service.calculation.result.ResultForShaft;
import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesFromRepoByInputDimension;
import com.CezaryZal.api.model.dto.DimensionDTO;
import com.CezaryZal.api.model.entity.NominalTolerance;
import com.CezaryZal.api.service.repo.AdditionalDataToBasicDeviationServiceRepoImp;
import com.CezaryZal.api.service.repo.BasicDeviationServiceRepoImp;
import com.CezaryZal.api.service.repo.NominalToleranceServiceRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DimensionService {

    private final Pattern PATTERN = Pattern.compile("([1-9]\\d*)([a-zA-Z])([1-9][0-8]*)");

    private final NominalToleranceServiceRepoImp toleranceServiceByRepoImp;
    private final BasicDeviationServiceRepoImp deviationsServiceByRepoImp;
    private final AdditionalDataToBasicDeviationServiceRepoImp additionalDataServiceByRepoImp;
    private final ResultForShaft resultForShaft;
    private final ResultForHole resultForHole;

    @Autowired
    public DimensionService(NominalToleranceServiceRepoImp toleranceServiceByRepoImp,
                            BasicDeviationServiceRepoImp deviationsServiceByRepoImp,
                            AdditionalDataToBasicDeviationServiceRepoImp additionalDataServiceByRepoImp,
                            ResultForShaft resultForShaft,
                            ResultForHole resultForHole) {
        this.toleranceServiceByRepoImp = toleranceServiceByRepoImp;
        this.deviationsServiceByRepoImp = deviationsServiceByRepoImp;
        this.additionalDataServiceByRepoImp = additionalDataServiceByRepoImp;
        this.resultForShaft = resultForShaft;
        this.resultForHole = resultForHole;
    }

    public DimensionDTO createDimensionTolerance(String input) {

        ParsedInputDimension parsedInputDimension = shareInput(input);
        ValuesFromRepoByInputDimension valuesFromRepoByInputDimension = takeResultsFromRepository(parsedInputDimension);
        if (Character.isLowerCase(parsedInputDimension.getSymbolFromInput())) {
            return resultForShaft.calculate(valuesFromRepoByInputDimension, parsedInputDimension);
        }
        return resultForHole.calculate(valuesFromRepoByInputDimension, parsedInputDimension);
    }

    private ParsedInputDimension shareInput(String input) {
        int valueOfDimension = 0;
        char symbolFromInput = 'a';
        int valueITFromInput = 0;
        boolean isSymbolOverH = false;

        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            valueOfDimension = Integer.parseInt(matcher.group(1));
            symbolFromInput = matcher.group(2).charAt(0);
            valueITFromInput = Integer.parseInt(matcher.group(3));
            isSymbolOverH = Character.toLowerCase(symbolFromInput) > 'h';
        }
        return new ParsedInputDimension(valueOfDimension, symbolFromInput, valueITFromInput, isSymbolOverH);
    }

    private ValuesFromRepoByInputDimension takeResultsFromRepository(ParsedInputDimension parsedInputDimension) {

        double valueOfBasicDeviation =  deviationsServiceByRepoImp.getRecordBySignAndValue(
                String.valueOf(parsedInputDimension.getSymbolFromInput()),
                parsedInputDimension.getValueOfDimension())
                .getValue();

        NominalTolerance nominalTolerance = toleranceServiceByRepoImp.getRecordBySignAndValue(
                "IT" + parsedInputDimension.getValueITFromInput(), parsedInputDimension.getValueOfDimension());

        if (parsedInputDimension.getSymbolFromInput() < 97){
            valueOfBasicDeviation = createOppositeNumber(valueOfBasicDeviation);
        }

        if (parsedInputDimension.isSymbolOverH() && parsedInputDimension.getSymbolFromInput() < 'P') {
            if (!(parsedInputDimension.getValueITFromInput() < 3 || parsedInputDimension.getValueITFromInput() > 8)) {
                double valueOfAdditionalData = additionalDataServiceByRepoImp.getRecordBySignAndValue(
                        "IT" + parsedInputDimension.getValueITFromInput(),
                        parsedInputDimension.getValueOfDimension())
                        .getValue();

                valueOfBasicDeviation += valueOfAdditionalData;
            }
        }

        return new ValuesFromRepoByInputDimension(valueOfBasicDeviation, nominalTolerance.getValue());
    }

    private double createOppositeNumber(double valueOfDeviation){
        return valueOfDeviation * -1;
    }
}
