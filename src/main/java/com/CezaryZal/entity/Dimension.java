package com.CezaryZal.entity;

public class Dimension {

    private int valueOfDimension;
    private int lowerDeviation;
    private int upperDeviation;

    public Dimension(int valueOfDimension, int lowerDeviation, int upperDeviation) {
        this.valueOfDimension = valueOfDimension;
        this.lowerDeviation = lowerDeviation;
        this.upperDeviation = upperDeviation;
    }

    public int getValueOfDimension() {
        return valueOfDimension;
    }

    public int getLowerDeviation() {
        return lowerDeviation;
    }

    public int getUpperDeviation() {
        return upperDeviation;
    }

}
