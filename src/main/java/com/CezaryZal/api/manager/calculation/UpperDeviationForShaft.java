package com.CezaryZal.api.manager.calculation;

public class UpperDeviationForShaft implements UpperDeviation {

    @Override
    public double calculateUpperDeviation(double lowerDeviation, double valueOfNominalTolerance) {
        return lowerDeviation + valueOfNominalTolerance;
    }
}
