package com.CezaryZal.api.service;

import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.model.dto.DimensionDtoImpl;
import com.CezaryZal.api.repository.AdditionalDataToBasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.BasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.NominalToleranceRepoDbImp;
import com.CezaryZal.api.service.calculation.result.ResultForHole;
import com.CezaryZal.api.service.calculation.result.ResultForShaft;
import com.CezaryZal.api.service.creator.ValueToDimensionDtoCreator;
import com.CezaryZal.api.service.repo.ServiceRepo;
import com.CezaryZal.api.service.validation.InputValidator;
import com.CezaryZal.exceptions.InvalidInputException;
import com.CezaryZal.exceptions.InvalidSymbolsException;
import com.CezaryZal.exceptions.InvalidValueOfDimensionException;
import com.CezaryZal.exceptions.InvalidValueOfItException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DimensionServiceTest {

    @Spy
    ResultForShaft resultForShaft;
    @Spy
    ResultForHole resultForHole;

    @Mock
    AdditionalDataToBasicDeviationRepoDbImp additionalDataToBasicDeviationRepoDbImp;
    @Mock
    BasicDeviationRepoDbImp basicDeviationRepoDbImp;
    @Mock
    NominalToleranceRepoDbImp nominalToleranceRepoDbImp;
    @Mock
    ServiceRepo serviceRepoImp;
    @InjectMocks
    ValueToDimensionDtoCreator valueToDimensionDtoCreator;

    @Spy
    InputValidator inputValidator;

    private DimensionService dimensionService;
    private DimensionDto testDimensionDtoFrom40g5 = new DimensionDtoImpl(35, -20, -9);

    @Before
    public void setUp() {
        InputDimensionParser inputDimensionParser = new InputDimensionParser(inputValidator);

        dimensionService = new DimensionService(
                resultForShaft,
                resultForHole,
                valueToDimensionDtoCreator,
                inputDimensionParser);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_hole_with_symbol_over_H_and_without_additional_data() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("P", 35))
                .thenReturn(26.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT5", 35))
                .thenReturn(11.0);

        DimensionDto expectedDimensionDtoFrom35P5 = new DimensionDtoImpl(35, -37, -26);
        DimensionDto dimensionToleranceFrom35P5 = dimensionService.createDimensionTolerance("35P5");

        Assert.assertEquals(expectedDimensionDtoFrom35P5, dimensionToleranceFrom35P5);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom35P5);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("M", 65))
                .thenReturn(11.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT9", 65))
                .thenReturn(74.0);

        DimensionDto expectedDimensionDtoFrom65M9 = new DimensionDtoImpl(65, -85, -11);
        DimensionDto dimensionToleranceFrom65M9 = dimensionService.createDimensionTolerance("65M9");

        Assert.assertEquals(expectedDimensionDtoFrom65M9, dimensionToleranceFrom65M9);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom65M9);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("K", 95))
                .thenReturn(3.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT2", 95))
                .thenReturn(4.0);

        DimensionDto expectedDimensionDtoFrom95K2 = new DimensionDtoImpl(95, -7, -3);
        DimensionDto dimensionToleranceFrom95K2 = dimensionService.createDimensionTolerance("95K2");

        Assert.assertEquals(expectedDimensionDtoFrom95K2, dimensionToleranceFrom95K2);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom95K2);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_hole_with_additional_data_and_symbol_over_H() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("N", 15))
                .thenReturn(12.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 15))
                .thenReturn(27.0);
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT8", 15))
                .thenReturn(9.0);

        DimensionDto expectedDimensionDtoFrom15N8 = new DimensionDtoImpl(15, -30, -3);
        DimensionDto dimensionToleranceFrom15N8 = dimensionService.createDimensionTolerance("15N8");

        Assert.assertEquals(expectedDimensionDtoFrom15N8, dimensionToleranceFrom15N8);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom15N8);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("N", 40))
                .thenReturn(17.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 40))
                .thenReturn(4.0);
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT3", 40))
                .thenReturn(1.5);

        DimensionDto expectedDimensionDtoFrom40N3 = new DimensionDtoImpl(40, -19.5, -15.5);
        DimensionDto dimensionToleranceFrom40N3 = dimensionService.createDimensionTolerance("40N3");

        Assert.assertEquals(expectedDimensionDtoFrom40N3, dimensionToleranceFrom40N3);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom40N3);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("J", 110))
                .thenReturn(-15.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 110))
                .thenReturn(54.0);
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT8", 110))
                .thenReturn(19.0);

        DimensionDto expectedDimensionDtoFrom110J8 = new DimensionDtoImpl(110, -20, 34);
        DimensionDto dimensionToleranceFrom110J8 = dimensionService.createDimensionTolerance("110J8");

        Assert.assertEquals(expectedDimensionDtoFrom110J8, dimensionToleranceFrom110J8);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom110J8);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("J", 210))
                .thenReturn(-21.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 210))
                .thenReturn(10.0);
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT3", 210))
                .thenReturn(3.0);

        DimensionDto expectedDimensionDtoFrom210J3 = new DimensionDtoImpl(210, 14, 24);
        DimensionDto dimensionToleranceFrom210J3 = dimensionService.createDimensionTolerance("210J3");

        Assert.assertEquals(expectedDimensionDtoFrom210J3, dimensionToleranceFrom210J3);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom210J3);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_hole_with_symbol_below_or_with_H() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("H", 200))
                .thenReturn(0.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT7", 200))
                .thenReturn(46.0);

        DimensionDto expectedDimensionDtoFrom200H7 = new DimensionDtoImpl(200, 0, 46);
        DimensionDto dimensionToleranceFrom200H7 = dimensionService.createDimensionTolerance("200H7");

        Assert.assertEquals(expectedDimensionDtoFrom200H7, dimensionToleranceFrom200H7);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom200H7);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_shaft_with_symbol_over_H() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("p", 70))
                .thenReturn(32.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 70))
                .thenReturn(46.0);

        DimensionDto expectedDimensionDtoFrom70p8 = new DimensionDtoImpl(70, 32, 78);
        DimensionDto dimensionToleranceFrom70p8 = dimensionService.createDimensionTolerance("70p8");

        Assert.assertEquals(expectedDimensionDtoFrom70p8, dimensionToleranceFrom70p8);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom70p8);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_shaft_with_symbol_below_or_with_H() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("j", 25))
                .thenReturn(-8.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 25))
                .thenReturn(4.0);

        DimensionDto expectedDimensionDtoFrom25j3 = new DimensionDtoImpl(25, -8, -4);
        DimensionDto dimensionToleranceFrom25j3 = dimensionService.createDimensionTolerance("25j3");

        Assert.assertEquals(expectedDimensionDtoFrom25j3, dimensionToleranceFrom25j3);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom25j3);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_in_the_diameter_dimension_range() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("F", 1))
                .thenReturn(-6.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 1))
                .thenReturn(2.0);

        DimensionDto expectedDimensionDtoFrom1F3 = new DimensionDtoImpl(1, 6, 8);
        DimensionDto dimensionToleranceFrom1F3 = dimensionService.createDimensionTolerance("1F3");

        Assert.assertEquals(expectedDimensionDtoFrom1F3, dimensionToleranceFrom1F3);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom1F3);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("n", 500))
                .thenReturn(40.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT6", 500))
                .thenReturn(40.0);

        DimensionDto expectedDimensionDtoFrom500n6 = new DimensionDtoImpl(500, 40, 80);
        DimensionDto dimensionToleranceFrom500n6 = dimensionService.createDimensionTolerance("500n6");

        Assert.assertEquals(expectedDimensionDtoFrom500n6, dimensionToleranceFrom500n6);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom500n6);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_in_the_value_of_IT_range() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("g", 25))
                .thenReturn(-7.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT1", 25))
                .thenReturn(1.5);

        DimensionDto expectedDimensionDtoFrom25g1 = new DimensionDtoImpl(25, -8.5, -7);
        DimensionDto dimensionToleranceFrom25g1 = dimensionService.createDimensionTolerance("25g1");

        Assert.assertEquals(expectedDimensionDtoFrom25g1, dimensionToleranceFrom25g1);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom25g1);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("P", 50))
                .thenReturn(26.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT18", 50))
                .thenReturn(3900.0);

        DimensionDto expectedDimensionDtoFrom50P18 = new DimensionDtoImpl(50, -3926, -26);
        DimensionDto dimensionToleranceFrom50P18 = dimensionService.createDimensionTolerance("50P18");

        Assert.assertEquals(expectedDimensionDtoFrom50P18, dimensionToleranceFrom50P18);
        Assert.assertNotEquals(testDimensionDtoFrom40g5, dimensionToleranceFrom50P18);
    }

    @Test
    public void create_dimension_to_tolerance_should_throw_invalid_value_of_dimension_exception() {
        Assert.assertThrows(
                InvalidValueOfDimensionException.class, () -> dimensionService.createDimensionTolerance("0a2"));
        Assert.assertThrows(
                InvalidValueOfDimensionException.class, () -> dimensionService.createDimensionTolerance("501a2"));
    }

    @Test
    public void create_dimension_to_tolerance_should_throw_invalid_symbols_exception() {
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1aa2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1t2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1T2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1b2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1i2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1l2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1o2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1q2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1B2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1I2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1L2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1O2"));
        Assert.assertThrows(
                InvalidSymbolsException.class, () -> dimensionService.createDimensionTolerance("1Q2"));
    }

    @Test
    public void create_dimension_to_tolerance_should_throw_invalid_value_of_IT_exception() {
        Assert.assertThrows(
                InvalidValueOfItException.class, () -> dimensionService.createDimensionTolerance("1a0"));
        Assert.assertThrows(
                InvalidValueOfItException.class, () -> dimensionService.createDimensionTolerance("1a19"));
    }

    @Test
    public void create_dimension_to_tolerance_should_throw_invalid_input_exception() {
        Assert.assertThrows(
                InvalidInputException.class, () -> dimensionService.createDimensionTolerance(""));
        Assert.assertThrows(
                InvalidInputException.class, () -> dimensionService.createDimensionTolerance("4%5E5k7"));
        Assert.assertThrows(
                InvalidInputException.class, () -> dimensionService.createDimensionTolerance("5^1k8"));
        Assert.assertThrows(
                InvalidInputException.class, () -> dimensionService.createDimensionTolerance("50t8k"));
        Assert.assertThrows(
                InvalidInputException.class, () -> dimensionService.createDimensionTolerance("50t8k6"));
        Assert.assertThrows(
                InvalidInputException.class, () -> dimensionService.createDimensionTolerance("58"));
        Assert.assertThrows(
                InvalidInputException.class, () -> dimensionService.createDimensionTolerance("k8"));
        Assert.assertThrows(
                InvalidInputException.class, () -> dimensionService.createDimensionTolerance("80G"));
    }
}