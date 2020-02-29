package com.CezaryZal.api.manager.calculation;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesFromRepoByInputDimension;
import com.CezaryZal.api.model.dto.DimensionDTO;

public abstract class Result {
    protected UpperDeviation upperDeviation;
    protected LowerDeviation lowerDeviation;

    public DimensionDTO calculate (
            ValuesFromRepoByInputDimension valuesFromRepoByInputDimension,
            ParsedInputDimension parsedInputDimension){

        if (parsedInputDimension.isSymbolOverH()){
            return calculateForSymbolOverH(
                    parsedInputDimension.getValueOfDimension(),
                    valuesFromRepoByInputDimension.getValueOfBasicDeviations(),
                    valuesFromRepoByInputDimension.getValueOfNominalTolerance());
        }
        return calculateForSymbolBelowAndWithH(
                parsedInputDimension.getValueOfDimension(),
                valuesFromRepoByInputDimension.getValueOfBasicDeviations(),
                valuesFromRepoByInputDimension.getValueOfNominalTolerance());
    }

    abstract DimensionDTO calculateForSymbolOverH(
            int valueOfDimension,
            double valueOfLowerDeviation,
            double valueOfNominalTolerance);

    abstract DimensionDTO calculateForSymbolBelowAndWithH(
            int valueOfDimension,
            double valueOfUpperDeviation,
            double valueOfNominalTolerance);
}
