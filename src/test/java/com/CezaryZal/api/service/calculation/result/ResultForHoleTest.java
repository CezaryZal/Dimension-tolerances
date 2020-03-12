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
public class ResultForHoleTest {

    @Spy
    ResultForHole resultForHole;

    private DimensionDtoImpl testClassOfDimensionDtoImp;

    @Before
    public void setUp() throws Exception {
        testClassOfDimensionDtoImp = new DimensionDtoImpl(110, -8, 5);
    }

    //100J5 : 5 (lower), 20 (upper)
    @Test
    public void calculate_should_testing_for_symbol_over_H() {
        DimensionDtoImpl dimensionDtoImpFrom100K6 = new DimensionDtoImpl(100, 5, 20);

        given(resultForHole.calculateForSymbolOverH(100, 20, 15))
                .willReturn(dimensionDtoImpFrom100K6);

        DimensionDto dimensionDtoExpectedFrom100J5 =
                resultForHole.calculate(
                        new ValuesToDimensionDto(20, 15),
                        new ParsedInputDimension(100, 'J', 5));

        Assert.assertEquals(dimensionDtoExpectedFrom100J5, dimensionDtoImpFrom100K6);
        Assert.assertNotEquals(dimensionDtoExpectedFrom100J5, testClassOfDimensionDtoImp);
    }

    //30H8 : 0 (lower), 33 (upper)
    //200F7 : 50 (lower), 96 (upper)
    @Test
    public void calculate_should_testing_for_symbol_below_or_equal_H() {
        DimensionDtoImpl dimensionDtoImpFrom30H8 = new DimensionDtoImpl(30, 0, 33);
        DimensionDtoImpl dimensionDtoImpFrom200F7 = new DimensionDtoImpl(200, 50, 96);

        given(resultForHole.calculateForSymbolBelowOrEqualH(30, 0, 33))
                .willReturn(dimensionDtoImpFrom30H8);

        DimensionDto dimensionDtoExpectedFrom30H8 =
                resultForHole.calculate(
                        new ValuesToDimensionDto(0, 33),
                        new ParsedInputDimension(30, 'H', 8));

        Assert.assertEquals(dimensionDtoExpectedFrom30H8, dimensionDtoImpFrom30H8);
        Assert.assertNotEquals(dimensionDtoExpectedFrom30H8, testClassOfDimensionDtoImp);


        given(resultForHole.calculateForSymbolBelowOrEqualH(200, 50, 46))
                .willReturn(dimensionDtoImpFrom200F7);

        DimensionDto dimensionDtoExpectedFrom200F7 =
                resultForHole.calculate(
                        new ValuesToDimensionDto(50, 46),
                        new ParsedInputDimension(200, 'F', 7));

        Assert.assertEquals(dimensionDtoExpectedFrom200F7, dimensionDtoImpFrom200F7);
        Assert.assertNotEquals(dimensionDtoExpectedFrom200F7, testClassOfDimensionDtoImp);
    }
}