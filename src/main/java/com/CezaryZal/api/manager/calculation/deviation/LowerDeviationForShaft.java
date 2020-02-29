package com.CezaryZal.api.manager.calculation.deviation;

public class LowerDeviationForShaft implements LowerDeviation{

    @Override
    public double calculateLowerDeviation(double upperDeviation, double valueOfNominalTolerance) {
        return upperDeviation - valueOfNominalTolerance;
    }
}
