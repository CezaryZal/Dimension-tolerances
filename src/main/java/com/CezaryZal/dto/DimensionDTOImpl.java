package com.CezaryZal.dto;

import com.CezaryZal.entity.score.Dimension;

public class DimensionDTOImpl implements DimensionDTO {

    private int valueOfDimension;
    private int lowerDeviation;
    private int upperDeviation;

    public DimensionDTOImpl(Dimension dimension) {
        this.valueOfDimension = dimension.getValueOfDimension();
        this.lowerDeviation = dimension.getLowerDeviation();
        this.upperDeviation = dimension.getUpperDeviation();
    }

    @Override
    public int getValueOfDimension() {
        return valueOfDimension;
    }

    @Override
    public int getLowerDeviation() {
        return lowerDeviation;
    }

    @Override
    public int getUpperDeviation() {
        return upperDeviation;
    }
}
