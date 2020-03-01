package com.CezaryZal.api.service.calculation.result;

import com.CezaryZal.api.service.calculation.deviation.LowerDeviationForHole;
import com.CezaryZal.api.service.calculation.deviation.UpperDeviationForHole;
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

        return new DimensionDTOImpl(
                valueOfDimension,
                lowerDeviation.calculateLowerDeviation(valueOfUpperDeviation, valueOfNominalTolerance),
                valueOfUpperDeviation);
    }

    @Override
    DimensionDTO calculateForSymbolBelowAndWithH(
            int valueOfDimension,
            double valueOfLowerDeviation,
            double valueOfNominalTolerance) {

        return new DimensionDTOImpl(
                valueOfDimension,
                valueOfLowerDeviation,
                upperDeviation.calculateUpperDeviation(valueOfLowerDeviation, valueOfNominalTolerance));
    }
}
