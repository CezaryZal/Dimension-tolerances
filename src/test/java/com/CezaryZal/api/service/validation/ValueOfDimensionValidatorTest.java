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
    public void is_correct_should_be_in_range_of_numbers_1_to_500() {
        Assert.assertTrue(valueOfDimensionValidator.isCorrect(1));
        Assert.assertTrue(valueOfDimensionValidator.isCorrect(500));
        Assert.assertFalse(valueOfDimensionValidator.isCorrect(0));
        Assert.assertFalse(valueOfDimensionValidator.isCorrect(501));
    }

    @Test
    public void number_is_correct_should_be_in_range_of_numbers_1_to_500() {
        Assert.assertTrue(valueOfDimensionValidator.numberIsCorrect(1));
        Assert.assertTrue(valueOfDimensionValidator.numberIsCorrect(500));
        Assert.assertFalse(valueOfDimensionValidator.numberIsCorrect(0));
        Assert.assertFalse(valueOfDimensionValidator.numberIsCorrect(501));
    }

}
