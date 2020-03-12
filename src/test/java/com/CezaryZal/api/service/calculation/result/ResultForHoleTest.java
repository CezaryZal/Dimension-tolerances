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
import static org.mockito.Mockito.mock;


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
    public void calculate_should_testing_for_symbol_over_H(){
        given(resultForHole.calculateForSymbolOverH(100, 20, 15))
                .willReturn(new DimensionDtoImpl(100, 5, 20));


        ParsedInputDimension parsedInputDimensionFrom100J5 =
                new ParsedInputDimension(100, 'J', 5);
        ValuesToDimensionDto valuesToDimensionDtoFrom100J5 =
                new ValuesToDimensionDto(20, 15);
        DimensionDto dimensionDtoExpectedFrom100J5 =
                resultForHole.calculate(valuesToDimensionDtoFrom100J5, parsedInputDimensionFrom100J5);

        DimensionDtoImpl dimensionDtoImpFrom100K6 = new DimensionDtoImpl(100, 5, 20);

        Assert.assertEquals(dimensionDtoExpectedFrom100J5, dimensionDtoImpFrom100K6);
        Assert.assertNotEquals(dimensionDtoExpectedFrom100J5, testClassOfDimensionDtoImp);
    }

    //30H8 : 0 (lower), 33 (upper)
    //200F7 : 50 (lower), 96 (upper)
    @Test
    public void calculate_should_testing_for_symbol_below_or_equal_H() {
        given(resultForHole.calculateForSymbolBelowOrEqualH(30, 0, 33))
                .willReturn(new DimensionDtoImpl(30, 0, 33));

        ParsedInputDimension parsedInputDimensionFrom30H8 =
                new ParsedInputDimension(30, 'H', 8);
        ValuesToDimensionDto valuesToDimensionDtoFrom30H8 =
                new ValuesToDimensionDto(0, 33);
        DimensionDto dimensionDtoExpectedFrom30H8 =
                resultForHole.calculate(valuesToDimensionDtoFrom30H8, parsedInputDimensionFrom30H8);

        DimensionDtoImpl dimensionDtoImpFrom30H8 = new DimensionDtoImpl(30, 0, 33);

        Assert.assertEquals(dimensionDtoExpectedFrom30H8, dimensionDtoImpFrom30H8);
        Assert.assertNotEquals(dimensionDtoExpectedFrom30H8, testClassOfDimensionDtoImp);


        given(resultForHole.calculateForSymbolBelowOrEqualH(30, 50, 46))
                .willReturn(new DimensionDtoImpl(200, 50, 96));

        ParsedInputDimension parsedInputDimensionFrom200F7 =
                new ParsedInputDimension(200, 'F', 7);
        ValuesToDimensionDto valuesToDimensionDtoFrom200F7 =
                new ValuesToDimensionDto(50, 46);
        DimensionDto dimensionDtoExpectedFrom200F7 =
                resultForHole.calculate(valuesToDimensionDtoFrom200F7, parsedInputDimensionFrom200F7);

        DimensionDtoImpl dimensionDtoImpFrom200F7 = new DimensionDtoImpl(200, 50, 96);

        Assert.assertEquals(dimensionDtoExpectedFrom200F7, dimensionDtoImpFrom200F7);
        Assert.assertNotEquals(dimensionDtoExpectedFrom200F7, testClassOfDimensionDtoImp);
    }
}