package com.CezaryZal.entity.score;

public class Dimension {

    private double valueOfDimension;
    private double lowerDeviation;
    private double upperDeviation;

    public Dimension(double valueOfDimension, double lowerDeviation, double upperDeviation) {
        this.valueOfDimension = valueOfDimension;
        this.lowerDeviation = lowerDeviation;
        this.upperDeviation = upperDeviation;
    }

    public double getValueOfDimension() {
        return valueOfDimension;
    }

    public double getLowerDeviation() {
        return lowerDeviation;
    }

    public double getUpperDeviation() {
        return upperDeviation;
    }

}
