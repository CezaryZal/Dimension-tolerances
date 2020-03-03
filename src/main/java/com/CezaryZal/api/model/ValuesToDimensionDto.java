package com.CezaryZal.api.model;

public class ValuesToDimensionDto {

    double valueOfBasicDeviations;
    double valueOfNominalTolerance;

    public ValuesToDimensionDto(double valueOfBasicDeviations, double valueOfNominalTolerance) {
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
        return "ValuesToDimensionDto{" +
                "valueOfBasicDeviations=" + valueOfBasicDeviations +
                ", valueOfNominalTolerance=" + valueOfNominalTolerance +
                '}';
    }
}
