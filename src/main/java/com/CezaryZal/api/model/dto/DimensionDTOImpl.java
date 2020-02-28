package com.CezaryZal.api.model.dto;

public class DimensionDTOImpl implements DimensionDTO {

    private int valueOfDimension;
    private double lowerDeviation;
    private double upperDeviation;

    public DimensionDTOImpl(int valueOfDimension, double lowerDeviation, double upperDeviation) {
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
}
