package com.CezaryZal.manager;

import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.entity.*;
import com.CezaryZal.manager.serviceByRepo.AdditionalDataToBasicDeviationsServiceByRepoImp;
import com.CezaryZal.manager.serviceByRepo.BasicDeviationsServiceByRepoImp;
import com.CezaryZal.manager.serviceByRepo.NominalToleranceServiceByRepoImp;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DimensionService {

    private NominalToleranceServiceByRepoImp toleranceServiceByRepoImp;
    private BasicDeviationsServiceByRepoImp deviationsServiceByRepoImp;
    private AdditionalDataToBasicDeviationsServiceByRepoImp additionalDataServiceByRepoImp;

    private int valueOfDimension;
    private char symbolFromInput;
    private int valueITFromInput;
    private boolean isSymbolOverH = false;
    private boolean isSymbolBetweenHAndP = false;

    private BasicDeviations basicDeviations;
    private NominalTolerance nominalTolerance;
    private AdditionalDataToBasicDeviations additionalData;

    public DimensionService(NominalToleranceServiceByRepoImp toleranceServiceByRepoImp,
                            BasicDeviationsServiceByRepoImp deviationsServiceByRepoImp,
                            AdditionalDataToBasicDeviationsServiceByRepoImp additionalDataServiceByRepoImp) {
        this.toleranceServiceByRepoImp = toleranceServiceByRepoImp;
        this.deviationsServiceByRepoImp = deviationsServiceByRepoImp;
        this.additionalDataServiceByRepoImp = additionalDataServiceByRepoImp;
    }

    public DimensionDTOImpl createDimensionTolerance (String input) {

        shareInput(input);
        takeResultsFromRepository();
        Dimension dimension = new Dimension(valueOfDimension, makeLowerDeviation(), makeUpperDeviation());

        return dimension.makeDimensionDto();
    }

    private void shareInput(String input) {
        final Pattern pattern = Pattern.compile("([1-9][0-9]*)([a-zA-Z])([1-9][0-8]*)");

        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            valueOfDimension = Integer.valueOf(matcher.group(1));
            symbolFromInput = matcher.group(2).charAt(0);
            valueITFromInput = Integer.valueOf(matcher.group(3));
            isSymbolOverH = Character.toLowerCase(symbolFromInput) > 'h';
            if (isSymbolOverH){
                isSymbolBetweenHAndP = Character.toLowerCase(symbolFromInput) < 'p';
            }
        }
    }

    private double makeUpperDeviation() {
        if (Character.isLowerCase(symbolFromInput)) {
            if (isSymbolOverH){
                return basicDeviations.getValue() + nominalTolerance.getValue();
            }
            return  basicDeviations.getValue()-nominalTolerance.getValue();
        }
        if(isSymbolOverH){
            if(isSymbolBetweenHAndP){
                return (basicDeviations.getValue()*(-1)) + (additionalData.getValue());
            }
            return basicDeviations.getValue()*(-1);
        }
        return (basicDeviations.getValue()*(-1)) + nominalTolerance.getValue();
    }

    private double makeLowerDeviation() {
        if (Character.isLowerCase(symbolFromInput)) {
            if (isSymbolOverH){
                return basicDeviations.getValue();
            }
            return  basicDeviations.getValue();
        }
        if(isSymbolOverH){
            if(isSymbolBetweenHAndP){
                return (basicDeviations.getValue()*(-1)) + (additionalData.getValue()) - nominalTolerance.getValue();
            }
            return basicDeviations.getValue()*(-1) - nominalTolerance.getValue();
        }
        return basicDeviations.getValue()*(-1);

    }

    private void takeResultsFromRepository() {

        basicDeviations = deviationsServiceByRepoImp.getRecordBySignAndValue(
                String.valueOf(symbolFromInput), valueOfDimension);

        nominalTolerance = toleranceServiceByRepoImp.getRecordBySignAndValue(
                    "IT" + String.valueOf(valueITFromInput), valueOfDimension);

        if (isSymbolOverH && isSymbolBetweenHAndP) {
            if (valueITFromInput < 3 || valueITFromInput > 8) {
                additionalData = new AdditionalDataToBasicDeviations(0, 0, null, 0);
            } else {
                additionalData = additionalDataServiceByRepoImp.getRecordBySignAndValue(
                        "IT" + String.valueOf(valueITFromInput), valueOfDimension);
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
