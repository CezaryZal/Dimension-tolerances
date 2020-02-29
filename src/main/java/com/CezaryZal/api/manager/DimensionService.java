package com.CezaryZal.api.manager;

import com.CezaryZal.api.manager.calculation.result.ResultForShaft;
import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesFromRepoByInputDimension;
import com.CezaryZal.api.model.dto.DimensionDTO;
import com.CezaryZal.api.model.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.api.model.entity.BasicDeviations;
import com.CezaryZal.api.model.entity.NominalTolerance;
import com.CezaryZal.api.manager.serviceByRepo.AdditionalDataToBasicDeviationsServiceByRepoImp;
import com.CezaryZal.api.manager.serviceByRepo.BasicDeviationsServiceByRepoImp;
import com.CezaryZal.api.manager.serviceByRepo.NominalToleranceServiceByRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DimensionService {

    private final Pattern PATTERN = Pattern.compile("([1-9]\\d*)([a-zA-Z])([1-9][0-8]*)");

    private final NominalToleranceServiceByRepoImp toleranceServiceByRepoImp;
    private final BasicDeviationsServiceByRepoImp deviationsServiceByRepoImp;
    private final AdditionalDataToBasicDeviationsServiceByRepoImp additionalDataServiceByRepoImp;
    private final ResultForShaft resultForShaft;

    @Autowired
    public DimensionService(NominalToleranceServiceByRepoImp toleranceServiceByRepoImp,
                            BasicDeviationsServiceByRepoImp deviationsServiceByRepoImp,
                            AdditionalDataToBasicDeviationsServiceByRepoImp additionalDataServiceByRepoImp,
                            ResultForShaft resultForShaft) {
        this.toleranceServiceByRepoImp = toleranceServiceByRepoImp;
        this.deviationsServiceByRepoImp = deviationsServiceByRepoImp;
        this.additionalDataServiceByRepoImp = additionalDataServiceByRepoImp;
        this.resultForShaft = resultForShaft;
    }

    public DimensionDTO createDimensionTolerance(String input) {

        ParsedInputDimension parsedInputDimension = shareInput(input);
        ValuesFromRepoByInputDimension valuesFromRepoByInputDimension = takeResultsFromRepository(parsedInputDimension);
        if (Character.isLowerCase(parsedInputDimension.getSymbolFromInput())) {
            return resultForShaft.calculate(valuesFromRepoByInputDimension, parsedInputDimension);
        }
        return null;
    }

    private ParsedInputDimension shareInput(String input) {
        int valueOfDimension = 0;
        char symbolFromInput = 'a';
        int valueITFromInput = 0;
        boolean isSymbolOverH = false;
        boolean isSymbolBetweenHAndP = false;

        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            valueOfDimension = Integer.parseInt(matcher.group(1));
            symbolFromInput = matcher.group(2).charAt(0);
            valueITFromInput = Integer.parseInt(matcher.group(3));
            isSymbolOverH = Character.toLowerCase(symbolFromInput) > 'h';
            if (isSymbolOverH) {
                isSymbolBetweenHAndP = Character.toLowerCase(symbolFromInput) < 'p';
            }
        }
        return new ParsedInputDimension(valueOfDimension, symbolFromInput, valueITFromInput, isSymbolOverH, isSymbolBetweenHAndP);
    }

    //method from the previous solution
    private double makeUpperDeviation(
            ParsedInputDimension parsedInputDimension,
            ValuesFromRepoByInputDimension valuesByInputDimension) {
        if (Character.isLowerCase(parsedInputDimension.getSymbolFromInput())) {
            if (parsedInputDimension.isSymbolOverH()) {
                return valuesByInputDimension.getValueOfBasicDeviations() +
                        valuesByInputDimension.getValueOfNominalTolerance();
            }
            return valuesByInputDimension.getValueOfBasicDeviations() -
                    valuesByInputDimension.getValueOfNominalTolerance();
        }
        if (parsedInputDimension.isSymbolOverH()) {
            if (parsedInputDimension.isSymbolBetweenHAndP()) {
                return (valuesByInputDimension.getValueOfBasicDeviations() * (-1)) +
                        (valuesByInputDimension.getValueOfAdditionalData());
            }
            return valuesByInputDimension.getValueOfBasicDeviations() * (-1);
        }
        return (valuesByInputDimension.getValueOfBasicDeviations() * (-1)) +
                valuesByInputDimension.getValueOfNominalTolerance();
    }

    //method from the previous solution
    private double makeLowerDeviation(
            ParsedInputDimension parsedInputDimension,
            ValuesFromRepoByInputDimension valuesByInputDimension) {
        if (Character.isLowerCase(parsedInputDimension.getSymbolFromInput())) {
            if (parsedInputDimension.isSymbolOverH()) {
                return valuesByInputDimension.getValueOfBasicDeviations();
            }
            return valuesByInputDimension.getValueOfBasicDeviations();
        }
        if (parsedInputDimension.isSymbolOverH()) {
            if (parsedInputDimension.isSymbolBetweenHAndP()) {
                return (valuesByInputDimension.getValueOfBasicDeviations() * (-1)) +
                        (valuesByInputDimension.getValueOfAdditionalData()) -
                        valuesByInputDimension.getValueOfNominalTolerance();
            }
            return valuesByInputDimension.getValueOfBasicDeviations() * (-1) -
                    valuesByInputDimension.getValueOfNominalTolerance();
        }
        return valuesByInputDimension.getValueOfBasicDeviations() * (-1);

    }

    private ValuesFromRepoByInputDimension takeResultsFromRepository(ParsedInputDimension parsedInputDimension) {

        AdditionalDataToBasicDeviations additionalData = new AdditionalDataToBasicDeviations(0, 0, null, 0);
        BasicDeviations basicDeviations = deviationsServiceByRepoImp.getRecordBySignAndValue(
                String.valueOf(parsedInputDimension.getSymbolFromInput()), parsedInputDimension.getValueOfDimension());
        NominalTolerance nominalTolerance = toleranceServiceByRepoImp.getRecordBySignAndValue(
                "IT" + parsedInputDimension.getValueITFromInput(), parsedInputDimension.getValueOfDimension());

        if (parsedInputDimension.isSymbolOverH() && parsedInputDimension.isSymbolBetweenHAndP()) {
            if (!(parsedInputDimension.getValueITFromInput() < 3 || parsedInputDimension.getValueITFromInput() > 8)) {
                additionalData = additionalDataServiceByRepoImp.getRecordBySignAndValue(
                        "IT" + parsedInputDimension.getValueITFromInput(), parsedInputDimension.getValueOfDimension());
            }
        }
        return new ValuesFromRepoByInputDimension(
                basicDeviations.getValue(),
                nominalTolerance.getValue(),
                additionalData.getValue());
    }
}
