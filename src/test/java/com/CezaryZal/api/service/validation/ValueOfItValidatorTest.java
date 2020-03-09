package com.CezaryZal.api.service.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValueOfItValidatorTest {

    ValueOfItValidator valueOfItValidator;

    @Before
    public void setUp() throws Exception {
        valueOfItValidator = new ValueOfItValidator();
    }

    @Test
    public void is_correct_should_be_in_range_of_numbers_1_to_18() {
        Assert.assertTrue(valueOfItValidator.isCorrect(1));
        Assert.assertTrue(valueOfItValidator.isCorrect(18));
        Assert.assertFalse(valueOfItValidator.isCorrect(0));
        Assert.assertFalse(valueOfItValidator.isCorrect(19));
    }

    @Test
    public void number_is_correct_should_be_in_range_of_numbers_1_to_500() {
        Assert.assertTrue(valueOfItValidator.numberIsCorrect(1));
        Assert.assertTrue(valueOfItValidator.numberIsCorrect(18));
        Assert.assertFalse(valueOfItValidator.numberIsCorrect(0));
        Assert.assertFalse(valueOfItValidator.numberIsCorrect(19));
    }

}