package com.CezaryZal.api.service.calculation.result;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.model.dto.DimensionDtoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT;
import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ResultForHoleTest {

    @Spy
    private ResultForHole resultForHole;

    private final DimensionDtoImpl notExpectedClassOfDimensionDtoImp =
            new DimensionDtoImpl(110, -8, 5);

    //100J5 : 5 (lower), 20 (upper)
    @Test
    public void calculate_should_testing_for_symbol_over_H() {
        DimensionDtoImpl expectedDimensionDtoImpFrom100K6 = new DimensionDtoImpl(100, 5, 20);

        given(resultForHole.calculateForSymbolOverH(100, 20, 15))
                .willReturn(expectedDimensionDtoImpFrom100K6);

        DimensionDto dimensionDtoFrom100J5 =
                resultForHole.calculate(
                        new ValuesToDimensionDto(20, 15),
                        new ParsedInputDimension(100, 'J', 5));

        then(dimensionDtoFrom100J5)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + expectedDimensionDtoImpFrom100K6)
                .isEqualTo(expectedDimensionDtoImpFrom100K6);
        then(dimensionDtoFrom100J5)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + expectedDimensionDtoImpFrom100K6)
                .isNotEqualTo(notExpectedClassOfDimensionDtoImp);
    }

    //30H8 : 0 (lower), 33 (upper)
    //200F7 : 50 (lower), 96 (upper)
    @Test
    public void calculate_should_testing_for_symbol_below_or_equal_H() {
        DimensionDtoImpl expectedDimensionDtoImpFrom30H8 = new DimensionDtoImpl(30, 0, 33);
        DimensionDtoImpl expectedDimensionDtoImpFrom200F7 = new DimensionDtoImpl(200, 50, 96);

        given(resultForHole.calculateForSymbolBelowOrEqualH(30, 0, 33))
                .willReturn(expectedDimensionDtoImpFrom30H8);

        DimensionDto dimensionDtoFrom30H8 =
                resultForHole.calculate(
                        new ValuesToDimensionDto(0, 33),
                        new ParsedInputDimension(30, 'H', 8));

        then(dimensionDtoFrom30H8)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + expectedDimensionDtoImpFrom30H8)
                .isEqualTo(expectedDimensionDtoImpFrom30H8);
        then(dimensionDtoFrom30H8)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + expectedDimensionDtoImpFrom30H8)
                .isNotEqualTo(notExpectedClassOfDimensionDtoImp);


        given(resultForHole.calculateForSymbolBelowOrEqualH(200, 50, 46))
                .willReturn(expectedDimensionDtoImpFrom200F7);

        DimensionDto dimensionDtoFrom200F7 =
                resultForHole.calculate(
                        new ValuesToDimensionDto(50, 46),
                        new ParsedInputDimension(200, 'F', 7));

        then(dimensionDtoFrom200F7)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + expectedDimensionDtoImpFrom200F7)
                .isEqualTo(expectedDimensionDtoImpFrom200F7);
        then(dimensionDtoFrom200F7)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + expectedDimensionDtoImpFrom200F7)
                .isNotEqualTo(notExpectedClassOfDimensionDtoImp);
    }
}