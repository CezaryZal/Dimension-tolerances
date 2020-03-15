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
public class ResultForShaftTest {

    @Spy
    private ResultForShaft resultForShaft;

    private final DimensionDtoImpl notExpectedClassOfDimensionDtoImp =
            new DimensionDtoImpl(110, -10, 6);

    //80j5 - -12 (lower), 1 (upper)
    @Test
    public void calculate_should_testing_for_symbol_over_H() {
        DimensionDtoImpl expectedDimensionDtoImpFrom80j5 = new DimensionDtoImpl(80, -12, 1);

        given(resultForShaft.calculateForSymbolOverH(80, -12, 13))
                .willReturn(expectedDimensionDtoImpFrom80j5);

        DimensionDto dimensionDtoFrom80j5 =
                resultForShaft.calculate(
                        new ValuesToDimensionDto(-12, 13),
                        new ParsedInputDimension(80, 'j', 5));

        then(dimensionDtoFrom80j5)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + expectedDimensionDtoImpFrom80j5)
                .isEqualTo(expectedDimensionDtoImpFrom80j5);
        then(dimensionDtoFrom80j5)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + expectedDimensionDtoImpFrom80j5)
                .isNotEqualTo(notExpectedClassOfDimensionDtoImp);
    }

    //45h7 - -25 (lower), 0
    //40g5 - -20 (lower), -9 (upper)
    @Test
    public void calculate_should_testing_for_symbol_below_or_equal_H() {
        DimensionDtoImpl expectedDimensionDtoImpFrom45h7 = new DimensionDtoImpl(45, -25, 0);
        DimensionDtoImpl expectedDimensionDtoImpFrom40g5 = new DimensionDtoImpl(40, -20, -9);

        given(resultForShaft.calculateForSymbolBelowOrEqualH(45, 0, 25))
                .willReturn(expectedDimensionDtoImpFrom45h7);

        DimensionDto dimensionDtoFrom45h7 =
                resultForShaft.calculate(
                        new ValuesToDimensionDto(0, 25),
                        new ParsedInputDimension(45, 'h', 7));

        then(dimensionDtoFrom45h7)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + expectedDimensionDtoImpFrom45h7)
                .isEqualTo(expectedDimensionDtoImpFrom45h7);
        then(dimensionDtoFrom45h7)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + expectedDimensionDtoImpFrom45h7)
                .isNotEqualTo(notExpectedClassOfDimensionDtoImp);


        given(resultForShaft.calculateForSymbolBelowOrEqualH(40, -9, 11))
                .willReturn(expectedDimensionDtoImpFrom40g5);

        DimensionDto dimensionDtoFrom40g5 =
                resultForShaft.calculate(
                        new ValuesToDimensionDto(-9, 11),
                        new ParsedInputDimension(40, 'g', 5));

        then(dimensionDtoFrom40g5)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + expectedDimensionDtoImpFrom40g5)
                .isEqualTo(expectedDimensionDtoImpFrom40g5);
        then(dimensionDtoFrom40g5)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + expectedDimensionDtoImpFrom40g5)
                .isNotEqualTo(notExpectedClassOfDimensionDtoImp);
    }
}