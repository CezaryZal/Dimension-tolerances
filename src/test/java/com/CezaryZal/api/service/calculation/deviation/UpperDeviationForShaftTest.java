package com.CezaryZal.api.service.calculation.deviation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpperDeviationForShaftTest {

    UpperDeviation upperDeviationForShaft;

    @Before
    public void setUp() throws Exception {
        upperDeviationForShaft = new UpperDeviationForShaft();
    }

    @Test
    public void calculate_upper_deviation_should_be_4_when_add_3_to_1() {
        double calculatedUpperDeviation = upperDeviationForShaft.calculateUpperDeviation(3.0, 1.0);
        Assert.assertEquals(Double.valueOf(calculatedUpperDeviation), Double.valueOf(4.0));
    }

    @Test
    public void calculate_upper_deviation_should_not_be_5_when_add_3_to_1() {
        double calculatedUpperDeviation = upperDeviationForShaft.calculateUpperDeviation(3.0, 1.0);
        Assert.assertNotEquals(Double.valueOf(calculatedUpperDeviation), Double.valueOf(5.0));
    }
}