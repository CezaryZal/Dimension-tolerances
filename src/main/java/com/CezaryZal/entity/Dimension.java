package com.CezaryZal.entity;

import com.CezaryZal.dto.DimensionDTOImpl;

public class Dimension {

    private int valueOfDimension;
    private double lowerDeviation;
    private double upperDeviation;

    public Dimension(int valueOfDimension, double lowerDeviation, double upperDeviation) {
        this.valueOfDimension = valueOfDimension;
        this.lowerDeviation = lowerDeviation;
        this.upperDeviation = upperDeviation;
    }

    public DimensionDTOImpl makeDimensionDto (){

        return new DimensionDTOImpl(valueOfDimension, lowerDeviation, upperDeviation);
    }
}
