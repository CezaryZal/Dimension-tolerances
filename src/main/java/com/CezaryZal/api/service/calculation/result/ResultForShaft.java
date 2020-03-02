package com.CezaryZal.api.service.calculation.result;

import com.CezaryZal.api.service.calculation.deviation.LowerDeviationForShaft;
import com.CezaryZal.api.service.calculation.deviation.UpperDeviationForShaft;
import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.model.dto.DimensionDtoImpl;
import org.springframework.stereotype.Service;

@Service
public class ResultForShaft extends Result {

    public ResultForShaft() {
        upperDeviation = new UpperDeviationForShaft();
        lowerDeviation = new LowerDeviationForShaft();
    }

    @Override
    DimensionDto calculateForSymbolOverH(
            int valueOfDimension,
            double valueOfLowerDeviation,
            double valueOfNominalTolerance){

        return new DimensionDtoImpl(
                valueOfDimension,
                valueOfLowerDeviation,
                upperDeviation.calculateUpperDeviation(valueOfLowerDeviation, valueOfNominalTolerance));
    }

    @Override
    DimensionDto calculateForSymbolBelowAndWithH(
            int valueOfDimension,
            double valueOfUpperDeviation,
            double valueOfNominalTolerance){

        return new DimensionDtoImpl(
                valueOfDimension,
                lowerDeviation.calculateLowerDeviation(valueOfUpperDeviation, valueOfNominalTolerance),
                valueOfUpperDeviation);
    }
}
