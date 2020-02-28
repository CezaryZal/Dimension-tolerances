package com.CezaryZal.api.manager;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.dto.DimensionDTOImpl;
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

    private boolean isSymbolOverH = false;
    private boolean isSymbolBetweenHAndP = false;

    private BasicDeviations basicDeviations;
    private NominalTolerance nominalTolerance;
    private AdditionalDataToBasicDeviations additionalData;

    @Autowired
    public DimensionService(NominalToleranceServiceByRepoImp toleranceServiceByRepoImp,
                            BasicDeviationsServiceByRepoImp deviationsServiceByRepoImp,
                            AdditionalDataToBasicDeviationsServiceByRepoImp additionalDataServiceByRepoImp) {
        this.toleranceServiceByRepoImp = toleranceServiceByRepoImp;
        this.deviationsServiceByRepoImp = deviationsServiceByRepoImp;
        this.additionalDataServiceByRepoImp = additionalDataServiceByRepoImp;
    }

    public DimensionDTOImpl createDimensionTolerance(String input) {

        ParsedInputDimension parsedInputDimension = shareInput(input);
        takeResultsFromRepository(parsedInputDimension);
        return new DimensionDTOImpl(
                parsedInputDimension.getValueOfDimension(),
                makeLowerDeviation(parsedInputDimension),
                makeUpperDeviation(parsedInputDimension));
    }

    private ParsedInputDimension shareInput(String input) {
        int valueOfDimension = 0;
        char symbolFromInput = 'a';
        int valueITFromInput = 0;

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
        return new ParsedInputDimension(valueOfDimension, symbolFromInput, valueITFromInput);
    }

    private double makeUpperDeviation(ParsedInputDimension parsedInputDimension) {
        if (Character.isLowerCase(parsedInputDimension.getSymbolFromInput())) {
            if (isSymbolOverH) {
                return basicDeviations.getValue() + nominalTolerance.getValue();
            }
            return basicDeviations.getValue() - nominalTolerance.getValue();
        }
        if (isSymbolOverH) {
            if (isSymbolBetweenHAndP) {
                return (basicDeviations.getValue() * (-1)) + (additionalData.getValue());
            }
            return basicDeviations.getValue() * (-1);
        }
        return (basicDeviations.getValue() * (-1)) + nominalTolerance.getValue();
    }

    private double makeLowerDeviation(ParsedInputDimension parsedInputDimension) {
        if (Character.isLowerCase(parsedInputDimension.getSymbolFromInput())) {
            if (isSymbolOverH) {
                return basicDeviations.getValue();
            }
            return basicDeviations.getValue();
        }
        if (isSymbolOverH) {
            if (isSymbolBetweenHAndP) {
                return (basicDeviations.getValue() * (-1)) + (additionalData.getValue()) - nominalTolerance.getValue();
            }
            return basicDeviations.getValue() * (-1) - nominalTolerance.getValue();
        }
        return basicDeviations.getValue() * (-1);

    }

    private void takeResultsFromRepository(ParsedInputDimension parsedInputDimension) {

        basicDeviations = deviationsServiceByRepoImp.getRecordBySignAndValue(
                String.valueOf(parsedInputDimension.getSymbolFromInput()), parsedInputDimension.getValueOfDimension());

        nominalTolerance = toleranceServiceByRepoImp.getRecordBySignAndValue(
                "IT" + parsedInputDimension.getValueITFromInput(), parsedInputDimension.getValueOfDimension());

        if (isSymbolOverH && isSymbolBetweenHAndP) {
            if (parsedInputDimension.getValueITFromInput() < 3 || parsedInputDimension.getValueITFromInput() > 8) {
                additionalData = new AdditionalDataToBasicDeviations(0, 0, null, 0);
            } else {
                additionalData = additionalDataServiceByRepoImp.getRecordBySignAndValue(
                        "IT" + parsedInputDimension.getValueITFromInput(), parsedInputDimension.getValueOfDimension());
            }
        }
    }
}
