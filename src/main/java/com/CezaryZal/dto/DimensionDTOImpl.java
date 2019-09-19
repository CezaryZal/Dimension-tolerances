package com.CezaryZal.dto;

import com.CezaryZal.entity.score.Dimension;

public class DimensionDTOImpl implements DimensionDTO {

    private double valueOfDimension;
    private double lowerDeviation;
    private double upperDeviation;

    public DimensionDTOImpl(Dimension dimension) {
        this.valueOfDimension = dimension.getValueOfDimension();
        this.lowerDeviation = dimension.getLowerDeviation();
        this.upperDeviation = dimension.getUpperDeviation();
    }

    @Override
    public double getValueOfDimension() {
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
