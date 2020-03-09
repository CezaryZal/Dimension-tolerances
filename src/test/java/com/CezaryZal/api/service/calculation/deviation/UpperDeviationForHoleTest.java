package com.CezaryZal.api.service.calculation.deviation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpperDeviationForHoleTest {

    UpperDeviationForHole upperDeviationForHole;

    @Before
    public void setUp() throws Exception {
        upperDeviationForHole= new UpperDeviationForHole();
    }

    @Test
    public void calculate_upper_deviation_should_be_4_when_add_3_to_1() {
        double calculatedUpperDeviation = upperDeviationForHole.calculateUpperDeviation(3.0, 1.0);
        Assert.assertEquals(Double.valueOf(calculatedUpperDeviation), Double.valueOf(4.0));
    }

    @Test
    public void calculate_upper_deviation_should_not_be_5_when_add_1_to_5() {
        double calculatedUpperDeviation = upperDeviationForHole.calculateUpperDeviation(3.0, 5.0);
        Assert.assertNotEquals(Double.valueOf(calculatedUpperDeviation), Double.valueOf(5.0));
    }
}