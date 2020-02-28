package com.CezaryZal.api.manager;

import com.CezaryZal.api.model.dto.DimensionDTOImpl;
import com.CezaryZal.api.model.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.api.model.entity.BasicDeviations;
import com.CezaryZal.api.model.entity.NominalTolerance;
import com.CezaryZal.api.manager.serviceByRepo.AdditionalDataToBasicDeviationsServiceByRepoImp;
import com.CezaryZal.api.manager.serviceByRepo.BasicDeviationsServiceByRepoImp;
import com.CezaryZal.api.manager.serviceByRepo.NominalToleranceServiceByRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DimensionService {

    private final Pattern PATTERN = Pattern.compile("([1-9]\\d*)([a-zA-Z])([1-9][0-8]*)");

    private final NominalToleranceServiceByRepoImp toleranceServiceByRepoImp;
    private final BasicDeviationsServiceByRepoImp deviationsServiceByRepoImp;
    private final AdditionalDataToBasicDeviationsServiceByRepoImp additionalDataServiceByRepoImp;

    private int valueOfDimension;
    private char symbolFromInput;
    private int valueITFromInput;
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

        shareInput(input);
        takeResultsFromRepository();
        return new DimensionDTOImpl(valueOfDimension, makeLowerDeviation(), makeUpperDeviation());
    }

    private void shareInput(String input) {

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
    }

    private double makeUpperDeviation() {
        if (Character.isLowerCase(symbolFromInput)) {
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

    private double makeLowerDeviation() {
        if (Character.isLowerCase(symbolFromInput)) {
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

    private void takeResultsFromRepository() {

        basicDeviations = deviationsServiceByRepoImp.getRecordBySignAndValue(
                String.valueOf(symbolFromInput), valueOfDimension);

        nominalTolerance = toleranceServiceByRepoImp.getRecordBySignAndValue(
                "IT" + valueITFromInput, valueOfDimension);

        if (isSymbolOverH && isSymbolBetweenHAndP) {
            if (valueITFromInput < 3 || valueITFromInput > 8) {
                additionalData = new AdditionalDataToBasicDeviations(0, 0, null, 0);
            } else {
                additionalData = additionalDataServiceByRepoImp.getRecordBySignAndValue(
                        "IT" + valueITFromInput, valueOfDimension);
            }
        }
    }

    @Override
    public String toString() {
        return "DimensionService{" +
                "valueOfDimension=" + valueOfDimension +
                ", symbolFromInput=" + symbolFromInput +
                ", valueITFromInput=" + valueITFromInput +
                ", isSymbolOverH=" + isSymbolOverH +
                ", isSymbolBetweenHAndP=" + isSymbolBetweenHAndP +
                '}';
    }
}
