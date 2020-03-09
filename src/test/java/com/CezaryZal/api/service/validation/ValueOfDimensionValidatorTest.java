package com.CezaryZal.api.service.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValueOfDimensionValidatorTest {

    ValueOfDimensionValidator valueOfDimensionValidator;

    @Before
    public void setUp() throws Exception {
        valueOfDimensionValidator = new ValueOfDimensionValidator();
    }
    @Test
    public void should_return_true_when_compare_with_correct_symbol() {
        Assert.assertTrue(valueOfDimensionValidator.isCorrect(22));
    }
    @Test
    public void should_return_true_when_compare_with_min_length_of_dimension_value() {
        Assert.assertTrue(valueOfDimensionValidator.numberIsCorrect(1));
    }
    @Test
    public void should_return_true_when_compare_with_max_length_of_dimension_value() {
        Assert.assertTrue(valueOfDimensionValidator.numberIsCorrect(500));
    }

    @Test
    public void should_return_false_when_compare_with_0_number() {
        Assert.assertFalse(valueOfDimensionValidator.numberIsCorrect(0));
    }
    @Test
    public void should_return_false_when_compare_with_501_number() {
        Assert.assertFalse(valueOfDimensionValidator.numberIsCorrect(501));
    }
}
