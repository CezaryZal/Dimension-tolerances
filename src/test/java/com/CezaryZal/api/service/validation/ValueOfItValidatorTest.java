package com.CezaryZal.api.service.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE;
import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(MockitoJUnitRunner.class)
public class ValueOfItValidatorTest {

    @Spy
    private ValueOfItValidator valueOfItValidator;

    private final String nameOfValueUnit = "IT";

    @Test
    public void is_correct_should_be_in_range_of_numbers_1_to_18() {
        int valueOfIt1 = 1;
        boolean isCorrectFor1It = valueOfItValidator.isCorrect(valueOfIt1);
        then(isCorrectFor1It)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + valueOfIt1 + nameOfValueUnit)
                .isTrue();

        int valueOfIt18 = 18;
        boolean isCorrectFor18It = valueOfItValidator.isCorrect(valueOfIt18);
        then(isCorrectFor18It)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + valueOfIt18 + nameOfValueUnit)
                .isTrue();
    }

    @Test
    public void is_correct_should_not_be_in_range_of_numbers_1_to_18() {
        int valueOfIt0 = 0;
        boolean isCorrectFor0It = valueOfItValidator.isCorrect(valueOfIt0);
        then(isCorrectFor0It)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + valueOfIt0 + nameOfValueUnit)
                .isFalse();

        int valueOfIt19 = 19;
        boolean isCorrectFor19It = valueOfItValidator.isCorrect(valueOfIt19);
        then(isCorrectFor19It)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + valueOfIt19 + nameOfValueUnit)
                .isFalse();
    }

    @Test
    public void number_is_correct_should_be_in_range_of_numbers_1_to_18() {
        int valueOfIt1 = 1;
        boolean isCorrectFor1It = valueOfItValidator.numberIsCorrect(valueOfIt1);
        then(isCorrectFor1It)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + valueOfIt1 + nameOfValueUnit)
                .isTrue();

        int valueOfIt18 = 18;
        boolean isCorrectFor18It = valueOfItValidator.numberIsCorrect(valueOfIt18);
        then(isCorrectFor18It)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_TRUE + valueOfIt18 + nameOfValueUnit)
                .isTrue();
    }

    @Test
    public void number_is_correct_should_not_be_in_range_of_numbers_1_to_18() {
        int valueOfIt0 = 0;
        boolean isCorrectFor0It = valueOfItValidator.numberIsCorrect(valueOfIt0);
        then(isCorrectFor0It)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + valueOfIt0 + nameOfValueUnit)
                .isFalse();

        int valueOfIt19 = 19;
        boolean isCorrectFor19It = valueOfItValidator.numberIsCorrect(valueOfIt19);
        then(isCorrectFor19It)
                .as(DESCRIPTION_OF_FAIL_WHEN_DO_NOT_GET_FALSE + valueOfIt19 + nameOfValueUnit)
                .isFalse();
    }
}