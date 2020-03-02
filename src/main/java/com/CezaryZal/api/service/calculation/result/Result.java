package com.CezaryZal.api.service.calculation.result;

import com.CezaryZal.api.service.calculation.deviation.LowerDeviation;
import com.CezaryZal.api.service.calculation.deviation.UpperDeviation;
import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDTO;
import com.CezaryZal.api.model.dto.DimensionDTO;

public abstract class Result {
    protected UpperDeviation upperDeviation;
    protected LowerDeviation lowerDeviation;

    public DimensionDTO calculate (
            ValuesToDimensionDTO valuesToDimensionDTO,
            ParsedInputDimension parsedInputDimension){

        if (parsedInputDimension.isSymbolOverH()){
            return calculateForSymbolOverH(
                    parsedInputDimension.getValueOfDimension(),
                    valuesToDimensionDTO.getValueOfBasicDeviations(),
                    valuesToDimensionDTO.getValueOfNominalTolerance());
        }
        return calculateForSymbolBelowAndWithH(
                parsedInputDimension.getValueOfDimension(),
                valuesToDimensionDTO.getValueOfBasicDeviations(),
                valuesToDimensionDTO.getValueOfNominalTolerance());
    }

    abstract DimensionDTO calculateForSymbolOverH(
            int valueOfDimension,
            double valueOfDeviation,
            double valueOfNominalTolerance);

    abstract DimensionDTO calculateForSymbolBelowAndWithH(
            int valueOfDimension,
            double valueOfDeviation,
            double valueOfNominalTolerance);
}
