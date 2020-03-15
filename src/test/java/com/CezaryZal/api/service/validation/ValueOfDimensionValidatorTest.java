package com.CezaryZal.api.service.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE;
import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(MockitoJUnitRunner.class)
public class ValueOfDimensionValidatorTest {

    @Spy
    private ValueOfDimensionValidator valueOfDimensionValidator;

    @Test
    public void is_correct_should_be_in_range_of_numbers_1_to_500() {
        int valueOfDimension1 = 1;
        boolean isCorrectForValueOfDimension1 = valueOfDimensionValidator.isCorrect(valueOfDimension1);
        then(isCorrectForValueOfDimension1)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + valueOfDimension1)
                .isTrue();

        int valueOfDimension500 = 500;
        boolean isCorrectForValueOfDimension500 = valueOfDimensionValidator.isCorrect(valueOfDimension500);
        then(isCorrectForValueOfDimension500)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + valueOfDimension500)
                .isTrue();
    }

    @Test
    public void is_correct_should_not_be_in_range_of_numbers_1_to_500() {
        int valueOfDimension0 = 0;
        boolean isCorrectForValueOfDimension0 = valueOfDimensionValidator.isCorrect(valueOfDimension0);
        then(isCorrectForValueOfDimension0)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + valueOfDimension0)
                .isFalse();

        int valueOfDimension501 = 501;
        boolean isCorrectForValueOfDimension501 = valueOfDimensionValidator.isCorrect(valueOfDimension501);
        then(isCorrectForValueOfDimension501)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + valueOfDimension501)
                .isFalse();
    }

    @Test
    public void number_is_correct_should_be_in_range_of_numbers_1_to_500() {
        int valueOfDimension1 = 1;
        boolean numberIsCorrectForValueOfDimension1 = valueOfDimensionValidator.numberIsCorrect(valueOfDimension1);
        then(numberIsCorrectForValueOfDimension1)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + valueOfDimension1)
                .isTrue();

        int valueOfDimension500 = 500;
        boolean numberIsCorrectForValueOfDimension500 = valueOfDimensionValidator.numberIsCorrect(valueOfDimension500);
        then(numberIsCorrectForValueOfDimension500)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + valueOfDimension500)
                .isTrue();
    }

    @Test
    public void number_is_correct_should_not_be_in_range_of_numbers_1_to_500() {
        int valueOfDimension0 = 0;
        boolean numberIsCorrectForValueOfDimension0 = valueOfDimensionValidator.numberIsCorrect(valueOfDimension0);
        then(numberIsCorrectForValueOfDimension0)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + valueOfDimension0)
                .isFalse();

        int valueOfDimension501 = 501;
        boolean numberIsCorrectForValueOfDimension501 = valueOfDimensionValidator.numberIsCorrect(valueOfDimension501);
        then(numberIsCorrectForValueOfDimension501)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + valueOfDimension501)
                .isFalse();
    }
}
