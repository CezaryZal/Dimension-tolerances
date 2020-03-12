package com.CezaryZal.api.service.calculation.result;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.model.dto.DimensionDtoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ResultForShaftTest {

    @Spy
    ResultForShaft resultForShaft;

    private DimensionDtoImpl testClassOfDimensionDtoImp;

    @Before
    public void setUp() throws Exception {
        testClassOfDimensionDtoImp = new DimensionDtoImpl(110, -10, 6);
    }

    //80j5 - -12 (lower), 1 (upper)
    @Test
    public void calculate_should_testing_for_symbol_over_H() {
        DimensionDtoImpl dimensionDtoImpFrom80j5 = new DimensionDtoImpl(80, -12, 1);

        given(resultForShaft.calculateForSymbolOverH(80, -12, 13))
                .willReturn(dimensionDtoImpFrom80j5);

        DimensionDto dimensionDtoExpectedFrom80j5 =
                resultForShaft.calculate(
                        new ValuesToDimensionDto(-12, 13),
                        new ParsedInputDimension(80, 'j', 5));

        Assert.assertEquals(dimensionDtoExpectedFrom80j5, dimensionDtoImpFrom80j5);
        Assert.assertNotEquals(dimensionDtoExpectedFrom80j5, testClassOfDimensionDtoImp);
    }

    //45h7 - -25 (lower), 0
    //40g5 - -20 (lower), -9 (upper)
    @Test
    public void calculate_should_testing_for_symbol_below_or_equal_H() {
        DimensionDtoImpl dimensionDtoImpFrom45h7 = new DimensionDtoImpl(45, -25, 0);
        DimensionDtoImpl dimensionDtoImpFrom40g5 = new DimensionDtoImpl(40, -20, -9);

        given(resultForShaft.calculateForSymbolBelowOrEqualH(45, 0, 25))
                .willReturn(dimensionDtoImpFrom45h7);

        DimensionDto dimensionDtoExpectedFrom45h7 =
                resultForShaft.calculate(
                        new ValuesToDimensionDto(0, 25),
                        new ParsedInputDimension(45, 'h', 7));

        Assert.assertEquals(dimensionDtoExpectedFrom45h7, dimensionDtoImpFrom45h7);
        Assert.assertNotEquals(dimensionDtoExpectedFrom45h7, testClassOfDimensionDtoImp);


        given(resultForShaft.calculateForSymbolBelowOrEqualH(40, -9, 11))
                .willReturn(dimensionDtoImpFrom40g5);

        DimensionDto dimensionDtoExpectedFrom40g5 =
                resultForShaft.calculate(
                        new ValuesToDimensionDto(-9, 11),
                        new ParsedInputDimension(40, 'g', 5));

        Assert.assertEquals(dimensionDtoExpectedFrom40g5, dimensionDtoImpFrom40g5);
        Assert.assertNotEquals(dimensionDtoExpectedFrom40g5, testClassOfDimensionDtoImp);
    }
}