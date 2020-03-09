package com.CezaryZal.api.model;

import org.junit.Assert;
import org.junit.Test;

public class ParsedInputDimensionTest {

    @Test
    public void shouldSayThat15rIsInRange() {
        ParsedInputDimension parsedInputDimension = new ParsedInputDimension(10, 'm', 10);
        Assert.assertTrue(parsedInputDimension.isSymbolOverH());
    }
}
