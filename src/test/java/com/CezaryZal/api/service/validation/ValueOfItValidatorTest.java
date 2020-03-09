package com.CezaryZal.api.service.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValueOfItValidatorTest {

    ValueOfItValidator valueOfItValidator;

    @Before
    public void setUp() throws Exception {
        valueOfItValidator = new ValueOfItValidator();
    }

    @Test
    public void should_return_true_when_compare_with_correct_symbol() {
        Assert.assertTrue(valueOfItValidator.isCorrect(15));
    }
    @Test
    public void should_return_true_when_compare_with_min_length_of_value_IT() {
        Assert.assertTrue(valueOfItValidator.numberIsCorrect(1));
    }
    @Test
    public void should_return_true_when_compare_with_max_length_of_value_IT() {
        Assert.assertTrue(valueOfItValidator.numberIsCorrect(18));
    }

    @Test
    public void should_return_false_when_compare_with_0_number() {
        Assert.assertFalse(valueOfItValidator.numberIsCorrect(0));
    }
    @Test
    public void should_return_false_when_compare_with_19_number() {
        Assert.assertFalse(valueOfItValidator.numberIsCorrect(19));
    }
}