package com.CezaryZal.api.model.dto;

public class DimensionDtoImpl implements DimensionDto {

    private int valueOfDimension;
    private double lowerDeviation;
    private double upperDeviation;

    public DimensionDtoImpl(int valueOfDimension, double lowerDeviation, double upperDeviation) {
        this.valueOfDimension = valueOfDimension;
        this.lowerDeviation = lowerDeviation;
        this.upperDeviation = upperDeviation;
    }

    @Override
    public int getValueOfDimension() {
        return valueOfDimension;
    }

    @Override
    public double getLowerDeviation() {
        return lowerDeviation;
    }

    @Override
    public double getUpperDeviation() {
        return upperDeviation;
    }

    @Override
    public String toString() {
        return "DimensionDtoImpl{" +
                "valueOfDimension=" + valueOfDimension +
                ", lowerDeviation=" + lowerDeviation +
                ", upperDeviation=" + upperDeviation +
                '}';
    }
}
