package com.CezaryZal.api.service.repo;


public interface ServiceRepo {

    Double getValueOfAdditionalDataBySignAndValue(String inputSign, int inputValue);

    Double getValueOfBasicDeviationBySignAndValue(String inputSign, int inputValue);

    Double getValueOfNominalToleranceBySignAndValue(String inputSign, int inputValue);
}
