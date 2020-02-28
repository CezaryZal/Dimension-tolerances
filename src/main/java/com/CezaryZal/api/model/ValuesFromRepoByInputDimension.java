package com.CezaryZal.api.model;

public class ValuesFromRepoByInputDimension {

    double valueOfBasicDeviations;
    double valueOfNominalTolerance;
    double valueOfAdditionalData;

    public ValuesFromRepoByInputDimension(
            double valueOfBasicDeviations,
            double valueOfNominalTolerance,
            double valueOfAdditionalData) {
        this.valueOfBasicDeviations = valueOfBasicDeviations;
        this.valueOfNominalTolerance = valueOfNominalTolerance;
        this.valueOfAdditionalData = valueOfAdditionalData;
    }

    public double getValueOfBasicDeviations() {
        return valueOfBasicDeviations;
    }

    public double getValueOfNominalTolerance() {
        return valueOfNominalTolerance;
    }

    public double getValueOfAdditionalData() {
        return valueOfAdditionalData;
    }

    @Override
    public String toString() {
        return "ValuesFromRepoByInputDimension{" +
                "valueOfBasicDeviations=" + valueOfBasicDeviations +
                ", valueOfNominalTolerance=" + valueOfNominalTolerance +
                ", valueOfAdditionalData=" + valueOfAdditionalData +
                '}';
    }
}
