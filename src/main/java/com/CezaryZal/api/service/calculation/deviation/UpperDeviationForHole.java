package com.CezaryZal.api.service.calculation.deviation;

public class UpperDeviationForHole implements UpperDeviation {

    @Override
    public double calculateUpperDeviation(double lowerDeviation, double valueOfNominalTolerance) {
        return lowerDeviation + valueOfNominalTolerance;
    }
}
