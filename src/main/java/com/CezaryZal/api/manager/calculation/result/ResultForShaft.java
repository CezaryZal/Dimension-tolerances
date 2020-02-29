package com.CezaryZal.api.manager.calculation.result;

import com.CezaryZal.api.manager.calculation.deviation.LowerDeviationForShaft;
import com.CezaryZal.api.manager.calculation.deviation.UpperDeviationForShaft;
import com.CezaryZal.api.model.dto.DimensionDTO;
import com.CezaryZal.api.model.dto.DimensionDTOImpl;
import org.springframework.stereotype.Service;

@Service
public class ResultForShaft extends Result {

    public ResultForShaft() {
        upperDeviation = new UpperDeviationForShaft();
        lowerDeviation = new LowerDeviationForShaft();
    }

    @Override
    DimensionDTO calculateForSymbolOverH(
            int valueOfDimension,
            double valueOfLowerDeviation,
            double valueOfNominalTolerance){

        return new DimensionDTOImpl(
                valueOfDimension,
                valueOfLowerDeviation,
                upperDeviation.calculateUpperDeviation(valueOfLowerDeviation, valueOfNominalTolerance));
    }

    @Override
    DimensionDTO calculateForSymbolBelowAndWithH(
            int valueOfDimension,
            double valueOfUpperDeviation,
            double valueOfNominalTolerance){

        return new DimensionDTOImpl(
                valueOfDimension,
                lowerDeviation.calculateLowerDeviation(valueOfUpperDeviation, valueOfNominalTolerance),
                valueOfUpperDeviation);
    }
}
