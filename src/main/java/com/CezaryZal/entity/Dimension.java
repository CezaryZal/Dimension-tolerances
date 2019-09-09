package com.CezaryZal.entity;

public class Dimension {

    private int valueOfDimension;
    private int lowerDeviation;
    private int upperDeviation;
    private boolean isShaft;

    public Dimension() {
    }

    public Dimension(int valueOfDimension, int lowerDeviation, int upperDeviation, boolean isShaft) {
        this.valueOfDimension = valueOfDimension;
        this.lowerDeviation = lowerDeviation;
        this.upperDeviation = upperDeviation;
        this.isShaft = isShaft;
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

    public void setValueOfDimension(int valueOfDimension) {
        this.valueOfDimension = valueOfDimension;
    }

    public void setLowerDeviation(int lowerDeviation) {
        this.lowerDeviation = lowerDeviation;
    }

    public void setUpperDeviation(int upperDeviation) {
        this.upperDeviation = upperDeviation;
    }

    public boolean isShaft() {
        return isShaft;
    }

    public void setShaft(boolean shaft) {
        isShaft = shaft;
    }
}
