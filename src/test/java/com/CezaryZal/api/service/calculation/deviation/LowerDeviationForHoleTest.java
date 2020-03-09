package com.CezaryZal.api.service.calculation.deviation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowerDeviationForHoleTest {

    LowerDeviationForHole lowerDeviationForHole;

    @Before
    public void setUp() throws Exception {
        lowerDeviationForHole = new LowerDeviationForHole();
    }

    @Test
    public void calculate_lower_deviation_should_be_4_when_subtract_1_from_5() {
        double calculatedLowerDeviation = lowerDeviationForHole.calculateLowerDeviation(5.0, 1.0);
        Assert.assertEquals(Double.valueOf(calculatedLowerDeviation), Double.valueOf(4.0));
    }

    @Test
    public void calculate_lower_deviation_should_not_be_8_when_subtract_1_from_5() {
        double calculatedLowerDeviation = lowerDeviationForHole.calculateLowerDeviation(5.0, 1.0);
        Assert.assertNotEquals(Double.valueOf(calculatedLowerDeviation), Double.valueOf(8.0));
    }
}