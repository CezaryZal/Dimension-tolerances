package com.CezaryZal.api.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValuesToDimensionDto)) return false;
        ValuesToDimensionDto that = (ValuesToDimensionDto) o;
        return Double.compare(that.valueOfBasicDeviations, valueOfBasicDeviations) == 0 &&
                Double.compare(that.valueOfNominalTolerance, valueOfNominalTolerance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueOfBasicDeviations, valueOfNominalTolerance);
    }

    @Override
    public String toString() {
        return "ValuesToDimensionDto{" +
                "valueOfBasicDeviations=" + valueOfBasicDeviations +
                ", valueOfNominalTolerance=" + valueOfNominalTolerance +
                '}';
    }
}
