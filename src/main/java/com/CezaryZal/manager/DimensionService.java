package com.CezaryZal.manager;

import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.entity.*;
import com.CezaryZal.manager.serviceByRepo.AdditionalDataToBasicDeviationsServiceByRepoImp;
import com.CezaryZal.manager.serviceByRepo.BasicDeviationsServiceByRepoImp;
import com.CezaryZal.manager.serviceByRepo.NominalToleranceServiceByRepoImp;
import com.CezaryZal.manager.serviceByRepo.ServiceByRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DimensionService {

//    private NominalToleranceServiceByRepoImp toleranceServiceByRepoImp;
//    private BasicDeviationsServiceByRepoImp deviationsServiceByRepoImp;
//    private AdditionalDataToBasicDeviationsServiceByRepoImp additionalDataServiceByRepoImp;
    private final ServiceByRepo serviceByRepo;

    private int valueOfDimension;
    private char symbolFromInput;
    private int valueITFromInput;
    private boolean isSymbolOverH = false;
    private boolean isSymbolBetweenHAndP = false;

    private BasicDeviations basicDeviations;
    private NominalTolerance nominalTolerance;
    private AdditionalDataToBasicDeviations additionalData;

    @Autowired
    public DimensionService(ServiceByRepo serviceByRepo) {
        this.serviceByRepo = serviceByRepo;
    }

    public DimensionDTOImpl createDimensionTolerance (String input) {

        shareInput(input);
        takeResultsFromRepository();
        Dimension dimension = new Dimension(valueOfDimension, makeLowerDeviation(), makeUpperDeviation());

        return dimension.makeDimensionDto();
    }

    private void shareInput(String input) {
        final Pattern PATTERN = Pattern.compile("([1-9]\\d*)([a-zA-Z])([1-9][0-8]*)");

        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            valueOfDimension = Integer.parseInt(matcher.group(1));
            symbolFromInput = matcher.group(2).charAt(0);
            valueITFromInput = Integer.parseInt(matcher.group(3));
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

        basicDeviations = (BasicDeviations) serviceByRepo.getRecordBySignAndValue(
                String.valueOf(symbolFromInput), valueOfDimension);

        nominalTolerance = (NominalTolerance) serviceByRepo.getRecordBySignAndValue(
                    "IT" + valueITFromInput, valueOfDimension);

        if (isSymbolOverH && isSymbolBetweenHAndP) {
            if (valueITFromInput < 3 || valueITFromInput > 8) {
                additionalData = new AdditionalDataToBasicDeviations(0, 0, null, 0);
            } else {
                additionalData = (AdditionalDataToBasicDeviations) serviceByRepo.getRecordBySignAndValue(
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
