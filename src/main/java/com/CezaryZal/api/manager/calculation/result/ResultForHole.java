package com.CezaryZal.api.manager.calculation.result;

import com.CezaryZal.api.manager.calculation.deviation.LowerDeviationForHole;
import com.CezaryZal.api.manager.calculation.deviation.UpperDeviationForHole;
import com.CezaryZal.api.model.dto.DimensionDTO;
import com.CezaryZal.api.model.dto.DimensionDTOImpl;
import org.springframework.stereotype.Service;

@Service
public class ResultForHole extends Result {

    public ResultForHole() {
        upperDeviation = new UpperDeviationForHole();
        lowerDeviation = new LowerDeviationForHole();
    }

    @Override
    DimensionDTO calculateForSymbolOverH(
            int valueOfDimension,
            double valueOfUpperDeviation,
            double valueOfNominalTolerance) {

        double realUpperDeviationValue = createOppositeNumber(valueOfUpperDeviation);

        return new DimensionDTOImpl(
                valueOfDimension,
                lowerDeviation.calculateLowerDeviation(realUpperDeviationValue, valueOfNominalTolerance),
                realUpperDeviationValue);
    }

    @Override
    DimensionDTO calculateForSymbolBelowAndWithH(
            int valueOfDimension,
            double valueOfLowerDeviation,
            double valueOfNominalTolerance) {

        double realLowerDeviationValue = createOppositeNumber(valueOfLowerDeviation);

        return new DimensionDTOImpl(
                valueOfDimension,
                realLowerDeviationValue,
                upperDeviation.calculateUpperDeviation(realLowerDeviationValue, valueOfNominalTolerance));
    }

    private double createOppositeNumber(double valueOfDeviation){
        return valueOfDeviation * (-1);
    }
}
