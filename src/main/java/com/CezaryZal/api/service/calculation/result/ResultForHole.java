package com.CezaryZal.api.service.calculation.result;

import com.CezaryZal.api.service.calculation.deviation.LowerDeviationForHole;
import com.CezaryZal.api.service.calculation.deviation.UpperDeviationForHole;
import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.model.dto.DimensionDtoImpl;
import org.springframework.stereotype.Service;

@Service
public class ResultForHole extends Result {

    public ResultForHole() {
        upperDeviation = new UpperDeviationForHole();
        lowerDeviation = new LowerDeviationForHole();
    }

    @Override
    DimensionDto calculateForSymbolOverH(
            int valueOfDimension,
            double valueOfUpperDeviation,
            double valueOfNominalTolerance) {

        return new DimensionDtoImpl(
                valueOfDimension,
                lowerDeviation.calculateLowerDeviation(valueOfUpperDeviation, valueOfNominalTolerance),
                valueOfUpperDeviation);
    }

    @Override
    DimensionDto calculateForSymbolBelowAndWithH(
            int valueOfDimension,
            double valueOfLowerDeviation,
            double valueOfNominalTolerance) {

        return new DimensionDtoImpl(
                valueOfDimension,
                valueOfLowerDeviation,
                upperDeviation.calculateUpperDeviation(valueOfLowerDeviation, valueOfNominalTolerance));
    }
}
