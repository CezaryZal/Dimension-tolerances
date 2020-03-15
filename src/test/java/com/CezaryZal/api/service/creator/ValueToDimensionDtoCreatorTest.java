package com.CezaryZal.api.service.creator;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.repository.AdditionalDataToBasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.BasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.NominalToleranceRepoDbImp;
import com.CezaryZal.api.service.repo.ServiceRepo;
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
public class ValueToDimensionDtoCreatorTest {

    @Mock
    private AdditionalDataToBasicDeviationRepoDbImp additionalDataToBasicDeviationRepoDbImp;
    @Mock
    private BasicDeviationRepoDbImp basicDeviationRepoDbImp;
    @Mock
    private NominalToleranceRepoDbImp nominalToleranceRepoDbImp;
    @Mock
    private ServiceRepo serviceRepoImp;

    @InjectMocks
    private ValueToDimensionDtoCreator valueToDimensionDtoCreator;

    private final String nameValueOfDimension = "value of dimension ";
    private final String nameAnd = " and ";
    private final String nameSymbol = ", symbol ";

    private final ValuesToDimensionDto notExpectedValuesToDimensionDto = new ValuesToDimensionDto(5, 2);

    @Test
    public void create_values_to_dimension_testing_for_symbol_upper_case_and_over_H_and_without_additional_data() {
        int valueOfDimensionEqual35 = 35;
        char symbolPUpperCase = 'P';
        int valueIt5 = 5;
        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolPUpperCase), valueOfDimensionEqual35))
                .willReturn(26.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt5), valueOfDimensionEqual35))
                .willReturn(11.0);

        ValuesToDimensionDto valuesToDimensionDtoFrom35P5 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual35, symbolPUpperCase, valueIt5));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom35P5 = new ValuesToDimensionDto(-26, 11);
        then(valuesToDimensionDtoFrom35P5)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual35),
                        nameSymbol,
                        String.valueOf(symbolPUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt5)))
                .isEqualTo(expectedValuesToDimensionDtoFrom35P5);
        then(valuesToDimensionDtoFrom35P5)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual35),
                        nameSymbol,
                        String.valueOf(symbolPUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt5)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);
    }

    @Test
    public void create_values_to_dimension_testing_for_symbol_upper_case_and_over_H_and_with_additional_data() {
        int valueOfDimensionEqual15 = 15;
        int valueOfDimensionEqual40 = 40;
        int valueOfDimensionEqual110 = 110;
        int valueOfDimensionEqual210 = 210;
        char symbolJUpperCase = 'J';
        char symbolNUpperCase = 'N';
        int valueIt3 = 3;
        int valueIt8 = 8;

        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolNUpperCase), valueOfDimensionEqual15))
                .willReturn(12.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt8), valueOfDimensionEqual15))
                .willReturn(27.0);
        given(serviceRepoImp
                .getValueOfAdditionalDataBySignAndValue(madeDescriptionOfValueIt(valueIt8), valueOfDimensionEqual15))
                .willReturn(9.0);

        ValuesToDimensionDto valuesToDimensionDtoFrom15N8 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual15, symbolNUpperCase, valueIt8));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom15N8 = new ValuesToDimensionDto(-3, 27);
        then(valuesToDimensionDtoFrom15N8)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual15),
                        nameSymbol,
                        String.valueOf(symbolNUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt8)))
                .isEqualTo(expectedValuesToDimensionDtoFrom15N8);
        then(valuesToDimensionDtoFrom15N8)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual15),
                        nameSymbol,
                        String.valueOf(symbolNUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt8)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);


        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolNUpperCase), valueOfDimensionEqual40))
                .willReturn(17.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt3), valueOfDimensionEqual40))
                .willReturn(4.0);
        given(serviceRepoImp
                .getValueOfAdditionalDataBySignAndValue(madeDescriptionOfValueIt(valueIt3), valueOfDimensionEqual40))
                .willReturn(1.5);

        ValuesToDimensionDto valuesToDimensionDtoFrom40N3 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual40, symbolNUpperCase, valueIt3));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom40N3 = new ValuesToDimensionDto(-15.5, 4);
        then(valuesToDimensionDtoFrom40N3)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual40),
                        nameSymbol,
                        String.valueOf(symbolNUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt3)))
                .isEqualTo(expectedValuesToDimensionDtoFrom40N3);
        then(valuesToDimensionDtoFrom40N3)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual40),
                        nameSymbol,
                        String.valueOf(symbolNUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt3)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);


        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolJUpperCase), valueOfDimensionEqual110))
                .willReturn(-15.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt8), valueOfDimensionEqual110))
                .willReturn(54.0);
        given(serviceRepoImp
                .getValueOfAdditionalDataBySignAndValue(madeDescriptionOfValueIt(valueIt8), valueOfDimensionEqual110))
                .willReturn(19.0);

        ValuesToDimensionDto valuesToDimensionDtoFrom110J8 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual110, symbolJUpperCase, valueIt8));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom110J8 = new ValuesToDimensionDto(34, 54);
        then(valuesToDimensionDtoFrom110J8)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual110),
                        nameSymbol,
                        String.valueOf(symbolJUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt8)))
                .isEqualTo(expectedValuesToDimensionDtoFrom110J8);
        then(valuesToDimensionDtoFrom110J8)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual110),
                        nameSymbol,
                        String.valueOf(symbolJUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt8)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);


        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolJUpperCase), valueOfDimensionEqual210))
                .willReturn(-21.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt3), valueOfDimensionEqual210))
                .willReturn(10.0);
        given(serviceRepoImp
                .getValueOfAdditionalDataBySignAndValue(madeDescriptionOfValueIt(valueIt3), valueOfDimensionEqual210))
                .willReturn(3.0);

        ValuesToDimensionDto valuesToDimensionDtoFrom210J3 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual210, symbolJUpperCase, valueIt3));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom210J3 = new ValuesToDimensionDto(24, 10);
        then(valuesToDimensionDtoFrom210J3)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual210),
                        nameSymbol,
                        String.valueOf(symbolJUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt3)))
                .isEqualTo(expectedValuesToDimensionDtoFrom210J3);
        then(valuesToDimensionDtoFrom210J3)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual210),
                        nameSymbol,
                        String.valueOf(symbolJUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt3)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);
    }

    @Test
    public void create_values_to_dimension_dto_testing_for_symbol_upper_case_and_below_or_with_H() {
        int valueOfDimensionEqual200 = 200;
        char symbolHUpperCase = 'H';
        int valueIt7 = 7;
        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolHUpperCase), valueOfDimensionEqual200))
                .willReturn(0.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt7), valueOfDimensionEqual200))
                .willReturn(46.0);

        ValuesToDimensionDto valuesToDimensionDtoFrom200H7 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual200, symbolHUpperCase, valueIt7));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom200H7 = new ValuesToDimensionDto(0, 46);
        then(valuesToDimensionDtoFrom200H7)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual200),
                        nameSymbol,
                        String.valueOf(symbolHUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt7)))
                .isEqualTo(expectedValuesToDimensionDtoFrom200H7);
        then(valuesToDimensionDtoFrom200H7)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual200),
                        nameSymbol,
                        String.valueOf(symbolHUpperCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt7)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);
    }

    @Test
    public void create_values_to_dimension_dto_testing_for_symbol_lower_case_and_over_H() {
        int valueOfDimensionEqual70 = 70;
        char symbolPLowerCase = 'p';
        int valueIt8 = 8;
        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolPLowerCase), valueOfDimensionEqual70))
                .willReturn(32.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt8), valueOfDimensionEqual70))
                .willReturn(46.0);

        ValuesToDimensionDto valuesToDimensionDtoFrom70p8 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual70, symbolPLowerCase, valueIt8));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom70p8 = new ValuesToDimensionDto(32, 46);
        then(valuesToDimensionDtoFrom70p8)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual70),
                        nameSymbol,
                        String.valueOf(symbolPLowerCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt8)))
                .isEqualTo(expectedValuesToDimensionDtoFrom70p8);
        then(valuesToDimensionDtoFrom70p8)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual70),
                        nameSymbol,
                        String.valueOf(symbolPLowerCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt8)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);
    }

    @Test
    public void create_values_to_dimension_dto_testing_for_symbol_lower_case_and_below_or_with_H() {
        int valueOfDimensionEqual25 = 25;
        char symbolJLowerCase = 'j';
        int valueIt3 = 3;
        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolJLowerCase), valueOfDimensionEqual25))
                .willReturn(-8.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt3), valueOfDimensionEqual25))
                .willReturn(4.0);

        ValuesToDimensionDto valuesToDimensionDtoFrom25j3 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual25, symbolJLowerCase, valueIt3));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom25j3 = new ValuesToDimensionDto(-8, 4);
        then(valuesToDimensionDtoFrom25j3)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual25),
                        nameSymbol,
                        String.valueOf(symbolJLowerCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt3)))
                .isEqualTo(expectedValuesToDimensionDtoFrom25j3);
        then(valuesToDimensionDtoFrom25j3)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual25),
                        nameSymbol,
                        String.valueOf(symbolJLowerCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt3)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);


        int valueOfDimensionEqual50 = 50;
        char symbolHLowerCase = 'h';
        int valueIt6 = 6;
        given(serviceRepoImp
                .getValueOfBasicDeviationBySignAndValue(String.valueOf(symbolHLowerCase), valueOfDimensionEqual50))
                .willReturn(0.0);
        given(serviceRepoImp
                .getValueOfNominalToleranceBySignAndValue(madeDescriptionOfValueIt(valueIt6), valueOfDimensionEqual50))
                .willReturn(16.0);

        ValuesToDimensionDto valuesToDimensionDtoFrom50h6 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(valueOfDimensionEqual50, symbolHLowerCase, valueIt6));

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom50h6 = new ValuesToDimensionDto(0, 16);
        then(valuesToDimensionDtoFrom50h6)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual50),
                        nameSymbol,
                        String.valueOf(symbolHLowerCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt6)))
                .isEqualTo(expectedValuesToDimensionDtoFrom50h6);
        then(valuesToDimensionDtoFrom50h6)
                .as(makeDescriptionOfFail(
                        DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS,
                        nameValueOfDimension,
                        String.valueOf(valueOfDimensionEqual50),
                        nameSymbol,
                        String.valueOf(symbolHLowerCase),
                        nameAnd,
                        madeDescriptionOfValueIt(valueIt6)))
                .isNotEqualTo(notExpectedValuesToDimensionDto);
    }

    private String makeDescriptionOfFail(String... words){
        Stream<String> descriptionString = Stream.of(words);
        StringBuilder description = new StringBuilder();
        descriptionString
                .forEach(description::append);
        return String.valueOf(description);
    }

    private String madeDescriptionOfValueIt(int valueOfIt){
        return "IT" + valueOfIt;
    }
}

