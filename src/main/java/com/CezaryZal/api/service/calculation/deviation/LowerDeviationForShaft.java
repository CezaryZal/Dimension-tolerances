package com.CezaryZal.api.service.calculation.deviation;

public class LowerDeviationForShaft implements LowerDeviation{

    @Override
    public double calculateLowerDeviation(double upperDeviation, double valueOfNominalTolerance) {
        return upperDeviation - valueOfNominalTolerance;
    }
}
