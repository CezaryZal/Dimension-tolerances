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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT;
import static com.CezaryZal.constant.DescriptionOfConstants.DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class DimensionServiceTest {

    @Spy
    private ResultForShaft resultForShaft;
    @Spy
    private ResultForHole resultForHole;

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

    @Spy
    private InputValidator inputValidator;


    private DimensionService dimensionService;
    private final DimensionDto notExpectedDimensionDtoFrom40g5 =
            new DimensionDtoImpl(35, -20, -9);

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
        String dimension35P5 = "35P5";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("P", 35))
                .willReturn(26.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT5", 35))
                .willReturn(11.0);

        DimensionDto dimensionToleranceFrom35P5 = dimensionService.createDimensionTolerance(dimension35P5);

        DimensionDto expectedDimensionDtoFrom35P5 = new DimensionDtoImpl(35, -37, -26);
        then(dimensionToleranceFrom35P5)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension35P5)
                .isEqualTo(expectedDimensionDtoFrom35P5);
        then(dimensionToleranceFrom35P5)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension35P5)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);


        String dimension65M9 = "65M9";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("M", 65))
                .willReturn(11.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT9", 65))
                .willReturn(74.0);

        DimensionDto dimensionToleranceFrom65M9 = dimensionService.createDimensionTolerance(dimension65M9);

        DimensionDto expectedDimensionDtoFrom65M9 = new DimensionDtoImpl(65, -85, -11);
        then(dimensionToleranceFrom65M9)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension65M9)
                .isEqualTo(expectedDimensionDtoFrom65M9);
        then(dimensionToleranceFrom65M9)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension65M9)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);


        String dimension95K2 = "95K2";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("K", 95))
                .willReturn(3.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT2", 95))
                .willReturn(4.0);

        DimensionDto dimensionToleranceFrom95K2 = dimensionService.createDimensionTolerance(dimension95K2);

        DimensionDto expectedDimensionDtoFrom95K2 = new DimensionDtoImpl(95, -7, -3);
        then(dimensionToleranceFrom95K2)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension95K2)
                .isEqualTo(expectedDimensionDtoFrom95K2);
        then(dimensionToleranceFrom95K2)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension95K2)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_hole_with_additional_data_and_symbol_over_H() {
        String dimension15N8 = "15N8";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("N", 15))
                .willReturn(12.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 15))
                .willReturn(27.0);
        given(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT8", 15))
                .willReturn(9.0);

        DimensionDto dimensionToleranceFrom15N8 = dimensionService.createDimensionTolerance(dimension15N8);

        DimensionDto expectedDimensionDtoFrom15N8 = new DimensionDtoImpl(15, -30, -3);
        then(dimensionToleranceFrom15N8)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension15N8)
                .isEqualTo(expectedDimensionDtoFrom15N8);
        then(dimensionToleranceFrom15N8)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension15N8)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);


        String dimension40N3 = "40N3";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("N", 40))
                .willReturn(17.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 40))
                .willReturn(4.0);
        given(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT3", 40))
                .willReturn(1.5);

        DimensionDto dimensionToleranceFrom40N3 = dimensionService.createDimensionTolerance(dimension40N3);

        DimensionDto expectedDimensionDtoFrom40N3 = new DimensionDtoImpl(40, -19.5, -15.5);
        then(dimensionToleranceFrom40N3)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension40N3)
                .isEqualTo(expectedDimensionDtoFrom40N3);
        then(dimensionToleranceFrom40N3)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension40N3)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);


        String dimension110J8 = "110J8";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("J", 110))
                .willReturn(-15.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 110))
                .willReturn(54.0);
        given(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT8", 110))
                .willReturn(19.0);

        DimensionDto dimensionToleranceFrom110J8 = dimensionService.createDimensionTolerance(dimension110J8);

        DimensionDto expectedDimensionDtoFrom110J8 = new DimensionDtoImpl(110, -20, 34);
        then(dimensionToleranceFrom110J8)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension110J8)
                .isEqualTo(expectedDimensionDtoFrom110J8);
        then(dimensionToleranceFrom110J8)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension110J8)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);


        String dimension210J3 = "210J3";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("J", 210))
                .willReturn(-21.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 210))
                .willReturn(10.0);
        given(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT3", 210))
                .willReturn(3.0);

        DimensionDto dimensionToleranceFrom210J3 = dimensionService.createDimensionTolerance(dimension210J3);

        DimensionDto expectedDimensionDtoFrom210J3 = new DimensionDtoImpl(210, 14, 24);
        then(dimensionToleranceFrom210J3)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension210J3)
                .isEqualTo(expectedDimensionDtoFrom210J3);
        then(dimensionToleranceFrom210J3)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension210J3)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_hole_with_symbol_below_or_with_H() {
        String dimension200H7 = "200H7";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("H", 200))
                .willReturn(0.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT7", 200))
                .willReturn(46.0);

        DimensionDto dimensionToleranceFrom200H7 = dimensionService.createDimensionTolerance(dimension200H7);

        DimensionDto expectedDimensionDtoFrom200H7 = new DimensionDtoImpl(200, 0, 46);
        then(dimensionToleranceFrom200H7)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension200H7)
                .isEqualTo(expectedDimensionDtoFrom200H7);
        then(dimensionToleranceFrom200H7)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension200H7)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_shaft_with_symbol_over_H() {
        String dimension70p8 = "70p8";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("p", 70))
                .willReturn(32.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 70))
                .willReturn(46.0);

        DimensionDto dimensionToleranceFrom70p8 = dimensionService.createDimensionTolerance(dimension70p8);

        DimensionDto expectedDimensionDtoFrom70p8 = new DimensionDtoImpl(70, 32, 78);
        then(dimensionToleranceFrom70p8)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension70p8)
                .isEqualTo(expectedDimensionDtoFrom70p8);
        then(dimensionToleranceFrom70p8)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension70p8)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_dimension_for_shaft_with_symbol_below_or_with_H() {
        String dimension25j3 = "25j3";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("j", 25))
                .willReturn(-8.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 25))
                .willReturn(4.0);

        DimensionDto dimensionToleranceFrom25j3 = dimensionService.createDimensionTolerance(dimension25j3);

        DimensionDto expectedDimensionDtoFrom25j3 = new DimensionDtoImpl(25, -8, -4);
        then(dimensionToleranceFrom25j3)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension25j3)
                .isEqualTo(expectedDimensionDtoFrom25j3);
        then(dimensionToleranceFrom25j3)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension25j3)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_in_the_diameter_dimension_range() {
        String dimension1F3 = "1F3";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("F", 1))
                .willReturn(-6.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 1))
                .willReturn(2.0);

        DimensionDto dimensionToleranceFrom1F3 = dimensionService.createDimensionTolerance(dimension1F3);

        DimensionDto expectedDimensionDtoFrom1F3 = new DimensionDtoImpl(1, 6, 8);
        then(dimensionToleranceFrom1F3)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension1F3)
                .isEqualTo(expectedDimensionDtoFrom1F3);
        then(dimensionToleranceFrom1F3)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension1F3)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);


        String dimension500n6 = "500n6";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("n", 500))
                .willReturn(40.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT6", 500))
                .willReturn(40.0);

        DimensionDto dimensionToleranceFrom500n6 = dimensionService.createDimensionTolerance(dimension500n6);

        DimensionDto expectedDimensionDtoFrom500n6 = new DimensionDtoImpl(500, 40, 80);
        then(dimensionToleranceFrom500n6)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension500n6)
                .isEqualTo(expectedDimensionDtoFrom500n6);
        then(dimensionToleranceFrom500n6)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension500n6)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);
    }

    @Test
    public void create_dimension_to_tolerance_should_be_in_the_value_of_IT_range() {
        String dimension25g1 = "25g1";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("g", 25))
                .willReturn(-7.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT1", 25))
                .willReturn(1.5);

        DimensionDto dimensionToleranceFrom25g1 = dimensionService.createDimensionTolerance(dimension25g1);

        DimensionDto expectedDimensionDtoFrom25g1 = new DimensionDtoImpl(25, -8.5, -7);
        then(dimensionToleranceFrom25g1)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension25g1)
                .isEqualTo(expectedDimensionDtoFrom25g1);
        then(dimensionToleranceFrom25g1)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension25g1)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);


        String dimension50P18 = "50P18";
        given(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("P", 50))
                .willReturn(26.0);
        given(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT18", 50))
                .willReturn(3900.0);

        DimensionDto dimensionToleranceFrom50P18 = dimensionService.createDimensionTolerance(dimension50P18);

        DimensionDto expectedDimensionDtoFrom50P18 = new DimensionDtoImpl(50, -3926, -26);
        then(dimensionToleranceFrom50P18)
                .as(DESCRIPTION_OF_FAIL_FOR_COMPARING_OBJECT + dimension50P18)
                .isEqualTo(expectedDimensionDtoFrom50P18);
        then(dimensionToleranceFrom50P18)
                .as(DESCRIPTION_OF_FAIL_WHEN_COMPARED_OBJECT_ARE_EQUALS + dimension50P18)
                .isNotEqualTo(notExpectedDimensionDtoFrom40g5);
    }

    @Test(expected = InvalidValueOfDimensionException.class)
    public void create_dimension_to_tolerance_should_throw_invalid_value_of_dimension_exception() {
        dimensionService.createDimensionTolerance("0a2");
        dimensionService.createDimensionTolerance("501a2");
    }

    @Test(expected = InvalidSymbolsException.class)
    public void create_dimension_to_tolerance_should_throw_invalid_symbols_exception() {
        dimensionService.createDimensionTolerance("1aa2");
        dimensionService.createDimensionTolerance("1t2");
        dimensionService.createDimensionTolerance("1T2");
        dimensionService.createDimensionTolerance("1b2");
        dimensionService.createDimensionTolerance("1i2");
        dimensionService.createDimensionTolerance("1l2");
        dimensionService.createDimensionTolerance("1o2");
        dimensionService.createDimensionTolerance("1q2");
        dimensionService.createDimensionTolerance("1B2");
        dimensionService.createDimensionTolerance("1I2");
        dimensionService.createDimensionTolerance("1L2");
        dimensionService.createDimensionTolerance("1O2");
        dimensionService.createDimensionTolerance("1Q2");
    }

    @Test(expected = InvalidValueOfItException.class)
    public void create_dimension_to_tolerance_should_throw_invalid_value_of_IT_exception() {
        dimensionService.createDimensionTolerance("1a0");
        dimensionService.createDimensionTolerance("1a19");
    }

    @Test(expected = InvalidInputException.class)
    public void create_dimension_to_tolerance_should_throw_invalid_input_exception() {
        dimensionService.createDimensionTolerance("");
        dimensionService.createDimensionTolerance("4%5E5k7");
        dimensionService.createDimensionTolerance("5^1k8");
        dimensionService.createDimensionTolerance("50t8k");
        dimensionService.createDimensionTolerance("50t8k6");
        dimensionService.createDimensionTolerance("58");
        dimensionService.createDimensionTolerance("k8");
        dimensionService.createDimensionTolerance("80G");
    }
}