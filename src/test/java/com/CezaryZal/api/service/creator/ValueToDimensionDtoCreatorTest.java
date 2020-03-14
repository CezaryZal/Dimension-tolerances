package com.CezaryZal.api.service.creator;

import com.CezaryZal.api.model.ParsedInputDimension;
import com.CezaryZal.api.model.ValuesToDimensionDto;
import com.CezaryZal.api.repository.AdditionalDataToBasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.BasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.NominalToleranceRepoDbImp;
import com.CezaryZal.api.service.repo.ServiceRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValueToDimensionDtoCreatorTest {

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

    private ValuesToDimensionDto testValuesToDimensionDto = new ValuesToDimensionDto(5, 2);

    @Test
    public void create_values_to_dimension_testing_for_symbol_upper_case_and_over_H_and_without_additional_data() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("P", 35))
                .thenReturn(26.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT5", 35))
                .thenReturn(11.0);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom35P5 = new ValuesToDimensionDto(-26, 11);
        ValuesToDimensionDto valuesToDimensionDtoFrom35P5 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(35, 'P', 5)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom35P5, valuesToDimensionDtoFrom35P5);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom35P5);
    }

    @Test
    public void create_values_to_dimension_testing_for_symbol_upper_case_and_over_H_and_with_additional_data() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("N", 15))
                .thenReturn(12.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 15))
                .thenReturn(27.0);
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT8", 15))
                .thenReturn(9.0);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom15N8 = new ValuesToDimensionDto(-3, 27);
        ValuesToDimensionDto valuesToDimensionDtoFrom15N8 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(15, 'N', 8)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom15N8, valuesToDimensionDtoFrom15N8);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom15N8);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("N", 40))
                .thenReturn(17.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 40))
                .thenReturn(4.0);
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT3", 40))
                .thenReturn(1.5);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom40N3 = new ValuesToDimensionDto(-15.5, 4);
        ValuesToDimensionDto valuesToDimensionDtoFrom40N3 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(40, 'N', 3)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom40N3, valuesToDimensionDtoFrom40N3);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom40N3);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("J", 110))
                .thenReturn(-15.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 110))
                .thenReturn(54.0);
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT8", 110))
                .thenReturn(19.0);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom110J8 = new ValuesToDimensionDto(34, 54);
        ValuesToDimensionDto valuesToDimensionDtoFrom110J8 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(110, 'J', 8)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom110J8, valuesToDimensionDtoFrom110J8);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom110J8);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("J", 210))
                .thenReturn(-21.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 210))
                .thenReturn(10.0);
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT3", 210))
                .thenReturn(3.0);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom210J3 = new ValuesToDimensionDto(24, 10);
        ValuesToDimensionDto valuesToDimensionDtoFrom210J3 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(210, 'J', 3)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom210J3, valuesToDimensionDtoFrom210J3);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom210J3);
    }

    @Test
    public void create_values_to_dimension_dto_testing_for_symbol_upper_case_and_below_or_with_H() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("H", 200))
                .thenReturn(0.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT7", 200))
                .thenReturn(46.0);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom200H7 = new ValuesToDimensionDto(0, 46);
        ValuesToDimensionDto valuesToDimensionDtoFrom200H7 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(200, 'H', 7)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom200H7, valuesToDimensionDtoFrom200H7);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom200H7);
    }

    @Test
    public void create_values_to_dimension_dto_testing_for_symbol_lower_case_and_over_H() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("p", 70))
                .thenReturn(32.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT8", 70))
                .thenReturn(46.0);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom70p8 = new ValuesToDimensionDto(32, 46);
        ValuesToDimensionDto valuesToDimensionDtoFrom70p8 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(70, 'p', 8)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom70p8, valuesToDimensionDtoFrom70p8);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom70p8);
    }

    @Test
    public void create_values_to_dimension_dto_testing_for_symbol_lower_case_and_below_or_with_H() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("j", 25))
                .thenReturn(-8.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT3", 25))
                .thenReturn(4.0);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom25j3 = new ValuesToDimensionDto(-8, 4);
        ValuesToDimensionDto valuesToDimensionDtoFrom25j3 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(25, 'j', 3)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom25j3, valuesToDimensionDtoFrom25j3);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom25j3);


        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("h", 50))
                .thenReturn(0.0);
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT6", 50))
                .thenReturn(16.0);

        ValuesToDimensionDto expectedValuesToDimensionDtoFrom50h6 = new ValuesToDimensionDto(0, 16);
        ValuesToDimensionDto valuesToDimensionDtoFrom50h6 = valueToDimensionDtoCreator.createValuesToDimensionDto(
                new ParsedInputDimension(50, 'h', 6)
        );
        Assert.assertEquals(expectedValuesToDimensionDtoFrom50h6, valuesToDimensionDtoFrom50h6);
        Assert.assertNotEquals(testValuesToDimensionDto, valuesToDimensionDtoFrom50h6);
    }
}

