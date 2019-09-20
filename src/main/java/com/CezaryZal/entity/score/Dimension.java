package com.CezaryZal.entity.score;

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
        DimensionDTOImpl dimensionDTO = new DimensionDTOImpl(valueOfDimension, lowerDeviation, upperDeviation);

        return dimensionDTO;
    }

    public int getValueOfDimension() {
        return valueOfDimension;
    }

    public double getLowerDeviation() {
        return lowerDeviation;
    }

    public double getUpperDeviation() {
        return upperDeviation;
    }

}
