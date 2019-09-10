package com.CezaryZal.service;

import com.CezaryZal.repository.DimensionRepository;


import java.util.List;

public class Deviation {

    private DimensionRepository dimensionRepository = new DimensionRepository();

    public int getDeviationByValueAndSymbol(int valueOfDimension, char symbolFromInput, boolean symbolIsOverHh, int valueToleranceClass) {

        if (Character.isLowerCase(symbolFromInput)) {
            if (symbolIsOverHh) {
                String nameTable = "basic_deviations_for_shaft_over_symbol_h";

                return dimensionRepository.getDeviationFromShaftOverHTable(
                        getValueOfRecord(valueOfDimension, nameTable), String.valueOf(symbolFromInput));

            } else {
                String nameTable = "basic_deviations_for_shaft_under_symbol_h";

                return dimensionRepository.getDeviationFromShaftUnderHTable(
                        getValueOfRecord(valueOfDimension, nameTable), String.valueOf(symbolFromInput));
            }
        } else {
            if (symbolIsOverHh) {
                String nameTable = "basic_deviations_for_hole_over_symbol_h";

                return dimensionRepository.getDeviationFromHoleOverHTable(
                        getValueOfRecord(valueOfDimension, nameTable),
                        String.valueOf(symbolFromInput));

            } else {
                String nameTable = "basic_deviations_for_hole_under_symbol_h";

                System.out.println("Przed get value; value of dimension: " + valueOfDimension + "\n name table: " + nameTable);
                int deviation = dimensionRepository.getDeviationFromHoleUnderHTable(
                        getValueOfRecord(valueOfDimension, nameTable),
                        String.valueOf(symbolFromInput));

                if (symbolFromInput > 'J' && symbolFromInput < 'P' && valueOfDimension > 3) {
                    String nameAddTable = "addition_for_hole_over_symbol_h";

                    int addValueDelta = dimensionRepository.getDeviationFromAdditionTable(
                            getValueOfRecord(valueOfDimension, nameAddTable), valueToleranceClass);

                    return deviation + addValueDelta;
                }
                return deviation;
            }
        }
    }

    public int getDeviationByValueAndIt(int valueOfDimension, int valueToleranceClass) {
        String nameTable = "nominal_tolerance";

        return dimensionRepository.getDeviationByValueAndIt(getValueOfRecord(valueOfDimension, nameTable),
                                                            valueToleranceClass);
    }

    public int getValueOfRecord(int valueOfDimension, String nameTable) {
        List<Integer> listDimensionsOfRecords = dimensionRepository.getListOfLowerDimension(nameTable);

        int lastDimension = 0;

        for (Integer value : listDimensionsOfRecords) {
            if (valueOfDimension >= lastDimension && valueOfDimension < value) {
                break;
            }
            lastDimension = value;
        }
        return lastDimension;
    }
}
