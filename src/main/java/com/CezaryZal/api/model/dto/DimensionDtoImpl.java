package com.CezaryZal.api.model.dto;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DimensionDtoImpl)) return false;
        DimensionDtoImpl that = (DimensionDtoImpl) o;
        return valueOfDimension == that.valueOfDimension &&
                Double.compare(that.lowerDeviation, lowerDeviation) == 0 &&
                Double.compare(that.upperDeviation, upperDeviation) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueOfDimension, lowerDeviation, upperDeviation);
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
