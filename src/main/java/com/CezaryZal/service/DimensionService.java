package com.CezaryZal.service;

import com.CezaryZal.config.DbConnector;
import com.CezaryZal.entity.Dimension;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DimensionService {

    private int valueOfDimension;
    private char symbolFromInput;
    private int valueITFromInput;
    private boolean isSymbolOverHh;
    private boolean error = false;

    public Dimension createDimensionTolerance (String input) {
        Deviation deviation = new Deviation();

        shareInput(input);
        int deviationByValueAndSymbol = deviation.getDeviationByValueAndSymbol(valueOfDimension,
                                                                            symbolFromInput,
                                                                            isSymbolOverHh,
                                                                            valueITFromInput);
        int deviationByValueAndIt = deviation.getDeviationByValueAndIt(valueOfDimension, valueITFromInput);

        return new Dimension(valueOfDimension,
                makeLowerDeviation(deviationByValueAndSymbol, deviationByValueAndIt),
                makeUpperDeviation(deviationByValueAndSymbol, deviationByValueAndIt));


//        return new Dimension(5,10,60);
    }

    public void shareInput(String input) {
        final Pattern pattern = Pattern.compile("([1-9][0-9]*)([a-zA-Z])([1-9][0-8]*)");

        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            valueOfDimension = Integer.valueOf(matcher.group(1));
            symbolFromInput = matcher.group(2).charAt(0);
            valueITFromInput = Integer.valueOf(matcher.group(3));
            isSymbolOverHh = Character.toLowerCase(symbolFromInput) > 'h' && Character.toLowerCase(symbolFromInput) < 'z';

        } else {
            error = true;
        }
    }

    public int makeUpperDeviation(int deviationByValueAndSymbol, int deviationByValueAndIt) {
        if (Character.isLowerCase(symbolFromInput)) {
            if (isSymbolOverHh) {
                return deviationByValueAndSymbol + deviationByValueAndIt;
            }
            return deviationByValueAndSymbol;
        }
        if (isSymbolOverHh){
            return deviationByValueAndSymbol;
        }
        return deviationByValueAndSymbol + deviationByValueAndIt;
    }

    public int makeLowerDeviation(int deviationByValueAndSymbol, int deviationByValueAndIt) {
        if (Character.isLowerCase(symbolFromInput)) {
            if (isSymbolOverHh){
                return deviationByValueAndSymbol;
            }
            return deviationByValueAndSymbol - deviationByValueAndIt;
        }
        if (isSymbolOverHh){
            return deviationByValueAndSymbol - deviationByValueAndIt;
        }
        return deviationByValueAndSymbol;
    }

}
