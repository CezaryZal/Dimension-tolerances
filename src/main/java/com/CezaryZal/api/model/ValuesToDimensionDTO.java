package com.CezaryZal.api.model;

public class ValuesToDimensionDTO {

    double valueOfBasicDeviations;
    double valueOfNominalTolerance;

    public ValuesToDimensionDTO(double valueOfBasicDeviations, double valueOfNominalTolerance) {
        this.valueOfBasicDeviations = valueOfBasicDeviations;
        this.valueOfNominalTolerance = valueOfNominalTolerance;
    }

    public double getValueOfBasicDeviations() {
        return valueOfBasicDeviations;
    }

    public double getValueOfNominalTolerance() {
        return valueOfNominalTolerance;
    }

    @Override
    public String toString() {
        return "ValuesFromRepoByInputDimension{" +
                "valueOfBasicDeviations=" + valueOfBasicDeviations +
                ", valueOfNominalTolerance=" + valueOfNominalTolerance +
                '}';
    }
}
