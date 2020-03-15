package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.repository.AdditionalDataToBasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.BasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.NominalToleranceRepoDbImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.stream.Stream;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT;
import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ServiceRepoImpTest {

    @Mock
    private NominalToleranceRepoDbImp nominalToleranceRepository;
    @Mock
    private BasicDeviationRepoDbImp basicDeviationsRepository;
    @Mock
    private AdditionalDataToBasicDeviationRepoDbImp additionalDataRepository;

    @InjectMocks
    private ServiceRepoImp serviceRepoImp;

    private final Double notExpectedDouble = 10d;

    @Test
    public void get_value_of_additional_data_by_sign_and_value_test_this_repository() {
        String nameValueOfDimension = "value of dimension ";
        String nameAnd = " and ";

        String valueIt4 = "IT4";
        int valueOfDimensionEqual15 = 15;

        given(serviceRepoImp.getValueOfAdditionalDataBySignAndValue(valueIt4, valueOfDimensionEqual15))
                .willReturn(2.0);

        Double valueOfAdditionalDataByDimension15AndIT4 =
                serviceRepoImp.getValueOfAdditionalDataBySignAndValue(valueIt4, valueOfDimensionEqual15);

        Double expectedDoubleEqual2 = 2d;
        then(valueOfAdditionalDataByDimension15AndIT4)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual15),
                        nameAnd,
                        valueIt4))
                .isEqualTo(expectedDoubleEqual2);
        then(valueOfAdditionalDataByDimension15AndIT4)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual15),
                        nameAnd,
                        valueIt4))
                .isNotEqualTo(notExpectedDouble);
    }

    @Test
    public void get_value_of_basic_deviation_by_sign_and_value_test_this_repository() {
        String nameValueOfDimension = "value of dimension ";
        String nameAnd = " and symbol ";

        String symbolCUpperCase = "C";
        int valueOfDimensionEqual60 = 60;

        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue(symbolCUpperCase, valueOfDimensionEqual60))
                .willReturn(140.0);

        Double valueOfBasicDeviationByDimension60AndCSymbol =
                serviceRepoImp.getValueOfAdditionalDataBySignAndValue(symbolCUpperCase, valueOfDimensionEqual60);

        Double expectedDoubleEqual140 = 140d;
        then(valueOfBasicDeviationByDimension60AndCSymbol)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual60),
                        nameAnd,
                        symbolCUpperCase))
                .isEqualTo(expectedDoubleEqual140);
        then(valueOfBasicDeviationByDimension60AndCSymbol)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual60),
                        nameAnd,
                        symbolCUpperCase))
                .isNotEqualTo(notExpectedDouble);
    }

    @Test
    public void get_value_of_nominal_tolerance_by_sign_and_value_test_this_repository() {
        String nameValueOfDimension = "value of dimension ";
        String nameAnd = " and ";

        String valueIt5 = "IT5";
        int valueOfDimensionEqual20 = 20;

        given(serviceRepoImp.getValueOfAdditionalDataBySignAndValue(valueIt5, valueOfDimensionEqual20))
                .willReturn(9.0);

        Double valueOfNominalToleranceByDimension20AndIT5 =
                serviceRepoImp.getValueOfAdditionalDataBySignAndValue(valueIt5, valueOfDimensionEqual20);

        Double expectedDoubleEqual9 = 9d;
        then(valueOfNominalToleranceByDimension20AndIT5)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual20),
                        nameAnd,
                        valueIt5))
                .isEqualTo(expectedDoubleEqual9);
        then(valueOfNominalToleranceByDimension20AndIT5)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual20),
                        nameAnd,
                        valueIt5))
                .isNotEqualTo(notExpectedDouble);
    }

    private String makeDescriptionOfFail(String... words){
        Stream<String> descriptionString = Stream.of(words);
        StringBuilder description = new StringBuilder();
        descriptionString
                .forEach(description::append);
        return String.valueOf(description);
    }
}