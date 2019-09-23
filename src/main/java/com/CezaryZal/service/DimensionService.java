package com.CezaryZal.service;

import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.entity.NominalTolerance;
import com.CezaryZal.entity.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DimensionService {

    private int valueOfDimension;
    private char symbolFromInput;
    private int valueITFromInput;
    private boolean isSymbolOverH = false;
    private boolean isSymbolBetweenHAndP = false;

    private ResultsBySignAndValueFromRepository resultsFromRepository;
    private BasicDeviations basicDeviations;
    private NominalTolerance nominalTolerance;
    private AdditionalDataToBasicDeviations additionalData;

    @Autowired
    public DimensionService(ResultsBySignAndValueFromRepository resultsFromRepository) {
        this.resultsFromRepository = resultsFromRepository;
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

        basicDeviations = resultsFromRepository.getSingleResultFromBasicDeviationsRepo(
                String.valueOf(symbolFromInput), valueOfDimension);

        nominalTolerance = resultsFromRepository.getSingleResultFromNominalToleranceRepo(
                    "IT" + String.valueOf(valueITFromInput), valueOfDimension);

        if (isSymbolOverH && isSymbolBetweenHAndP) {
            if (valueITFromInput < 3 || valueITFromInput > 8) {
                additionalData = new AdditionalDataToBasicDeviations(0, 0, null, 0);
            } else {
                additionalData = resultsFromRepository.getSingleResultFromAdditionalDataRepo(
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
