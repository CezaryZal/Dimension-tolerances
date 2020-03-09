package com.CezaryZal.api.service.calculation.deviation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LowerDeviationForShaftTest {

    LowerDeviationForShaft calculateLowerDeviation;

    @Before
    public void setUp() throws Exception {
        calculateLowerDeviation = new LowerDeviationForShaft();
    }

    @Test
    public void calculate_lower_deviation_should_be_2_when_subtract_1_from_3() {
        double calculatedLowerDeviation = calculateLowerDeviation.calculateLowerDeviation(3.0, 1.0);
        Assert.assertEquals(Double.valueOf(calculatedLowerDeviation), Double.valueOf(2.0));
    }

    @Test
    public void calculate_lower_deviation_should_not_be_8_when_subtract_1_from_5() {
        double calculatedLowerDeviation = calculateLowerDeviation.calculateLowerDeviation(5.0, 1.0);
        Assert.assertNotEquals(Double.valueOf(calculatedLowerDeviation), Double.valueOf(8.0));
    }
}