package com.CezaryZal.service;

import com.CezaryZal.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.entity.NominalTolerance;
import com.CezaryZal.entity.score.Dimension;
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

    private boolean error = false;

//    BasicDeviations basicDeviations;
//    NominalTolerance nominalTolerance;
//    AdditionalDataToBasicDeviations additionalData;


    public Dimension createDimensionTolerance (String input) {

        shareInput(input);
        takeResultsFromRepository();

        return new Dimension(5 , 6, 7);
//        return new Dimension(valueOfDimension, makeLowerDeviation(), makeUpperDeviation());
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
            System.out.println(toString()); //działa właściwie

        } else {
            error = true;
        }
    }

//    private int makeUpperDeviation() {
//        if (Character.isLowerCase(symbolFromInput)) {
//            if (isSymbolOverH){
//                return basicDeviations.getValue() + nominalTolerance.getValue();
//            }
//            return  basicDeviations.getValue()-nominalTolerance.getValue();
//        }
//        if(isSymbolOverH){
//            if(isSymbolBetweenHAndP){
//                return (basicDeviations.getValue()*(-1)) + (additionalData.getValue());
//            }
//            return basicDeviations.getValue()*(-1);
//        }
//        System.out.println("gorna odchylka");
//        return (basicDeviations.getValue()*(-1)) + nominalTolerance.getValue();
//    }
//
//    private int makeLowerDeviation() {
//        if (Character.isLowerCase(symbolFromInput)) {
//            if (isSymbolOverH){
//                return basicDeviations.getValue();
//            }
//            return  basicDeviations.getValue();
//        }
//        if(isSymbolOverH){
//            if(isSymbolBetweenHAndP){
//                return (basicDeviations.getValue()*(-1)) + (additionalData.getValue()) - nominalTolerance.getValue();
//            }
//            return basicDeviations.getValue()*(-1) - nominalTolerance.getValue();
//        }
//        System.out.println("dolna odchylka");
//        return basicDeviations.getValue()*(-1);
//
//    }


//    @Autowired
//    private ResultsBySignAndValueFromRepository resultsFromRepository;

    @Autowired
    private BasicDeviationService basicDeviationServ;

    private void takeResultsFromRepository() {


        System.out.println("Before basic deviation");
        String inputSign = "c";
        int inputValue = 2;
        BasicDeviations tmpDeviations = basicDeviationServ.getSingleResultBySignAndValueFromInput(inputSign, inputValue);
        System.out.println(tmpDeviations.toString());
        System.out.println(tmpDeviations.getValue());

    }





//        BasicDeviations basicDeviations = resultsFromRepository.getSingleResultFromBasicDeviationsRepo(
//                inputSign, inputValue);

//        basicDeviations = resultsFromRepository.getSingleResultFromBasicDeviationsRepo(
//                String.valueOf(symbolFromInput), valueOfDimension);

//        System.out.println("Inside basic deviations: " + basicDeviations.toString());

//        nominalTolerance = resultsFromRepository.getSingleResultFromNominalToleranceRepo(
//                    "IT" + String.valueOf(valueITFromInput), valueOfDimension);
//
//        System.out.println("Inside nominal tolrancje: " + nominalTolerance.toString());
//
//        if (isSymbolOverH && isSymbolBetweenHAndP) {
//            additionalData = resultsFromRepository.getSingleResultFromAdditionalDataRepo(
//                    "IT" + String.valueOf(valueITFromInput), valueOfDimension);
//        }
//
//    }

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
