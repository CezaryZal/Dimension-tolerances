package com.CezaryZal.api.service.calculation.deviation;

public class UpperDeviationForShaft implements UpperDeviation {

    @Override
    public double calculateUpperDeviation(double lowerDeviation, double valueOfNominalTolerance) {
        return lowerDeviation + valueOfNominalTolerance;
    }
}
