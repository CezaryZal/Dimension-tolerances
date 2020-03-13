package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.repository.AdditionalDataToBasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.BasicDeviationRepoDbImp;
import com.CezaryZal.api.repository.NominalToleranceRepoDbImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceRepoImpTest {

    @Mock
    NominalToleranceRepoDbImp nominalToleranceRepository;
    @Mock
    BasicDeviationRepoDbImp basicDeviationsRepository;
    @Mock
    AdditionalDataToBasicDeviationRepoDbImp additionalDataRepository;

    @InjectMocks
    ServiceRepoImp serviceRepoImp;

    @Test
    public void get_value_of_additional_data_by_sign_and_value_test_this_repository() {
        when(serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT4", 15))
                .thenReturn(2.0);

        Double valueOfAdditionalDataBySignAndValue =
                serviceRepoImp.getValueOfAdditionalDataBySignAndValue("IT4", 15);

        Assert.assertEquals(Double.valueOf(2.0), valueOfAdditionalDataBySignAndValue);
        Assert.assertNotEquals(Double.valueOf(10), valueOfAdditionalDataBySignAndValue);
    }


    @Test
    public void get_value_of_basic_deviation_by_sign_and_value_test_this_repository() {
        when(serviceRepoImp.getValueOfBasicDeviationBySignAndValue("C", 60))
                .thenReturn(140.0);


        Double actualValueOfBasicDeviationBySignAndValue =
                serviceRepoImp.getValueOfBasicDeviationBySignAndValue("C", 60);

        Assert.assertEquals(Double.valueOf(140), actualValueOfBasicDeviationBySignAndValue);
        Assert.assertNotEquals(Double.valueOf(60), actualValueOfBasicDeviationBySignAndValue);
    }

    @Test
    public void get_value_of_nominal_tolerance_by_sign_and_value_test_this_repository() {
        when(serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT5", 20))
                .thenReturn(9.0);


        Double actualValueOfNominalToleranceBySignAndValue =
                serviceRepoImp.getValueOfNominalToleranceBySignAndValue("IT5", 20);

        Assert.assertEquals(Double.valueOf(9), actualValueOfNominalToleranceBySignAndValue);
        Assert.assertNotEquals(Double.valueOf(45), actualValueOfNominalToleranceBySignAndValue);
    }
}