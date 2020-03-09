package com.CezaryZal.api.model;

import org.junit.Assert;
import org.junit.Test;

public class ParsedInputDimensionTest {


    @Test
    public void is_symbol_over_H_should_be_symbol_above_H() {
        Assert.assertTrue(new ParsedInputDimension(10, 'i', 10).isSymbolOverH());
        Assert.assertTrue(new ParsedInputDimension(10, 'I', 10).isSymbolOverH());
        Assert.assertFalse(new ParsedInputDimension(10, 'h', 10).isSymbolOverH());
        Assert.assertFalse(new ParsedInputDimension(10, 'H', 10).isSymbolOverH());
    }
}
