package com.CezaryZal.api.service.calculation.deviation;

import org.junit.Before;
import org.junit.Test;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT;
import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS;
import static org.assertj.core.api.BDDAssertions.then;

public class LowerDeviationForHoleTest {

    private LowerDeviation lowerDeviationForHole = new LowerDeviationForHole();

    @Before
    public void setUp() {
        lowerDeviationForHole = new LowerDeviationForHole();
    }

    @Test
    public void calculate_lower_deviation_should_be_4_when_subtract_1_from_5() {
        double calculatedLowerDeviation = lowerDeviationForHole.calculateLowerDeviation(5.0, 1.0);

        Double expectedValue = 4.0;
        then(calculatedLowerDeviation)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + calculatedLowerDeviation)
                .isEqualTo(expectedValue);
    }

    @Test
    public void calculate_lower_deviation_should_not_be_8_when_subtract_1_from_5() {
        double calculatedLowerDeviation = lowerDeviationForHole.calculateLowerDeviation(5.0, 1.0);

        Double notExpectedValue = 8.0;
        then(calculatedLowerDeviation)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + calculatedLowerDeviation)
                .isNotEqualTo(notExpectedValue);
    }
}