package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.repository.AdditionalDataToBasicDeviationRepoDbImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdditionalDataToBasicDeviationServiceRepoImp {

    private final AdditionalDataToBasicDeviationRepoDbImp additionalDataRepository;

    @Autowired
    public AdditionalDataToBasicDeviationServiceRepoImp(AdditionalDataToBasicDeviationRepoDbImp additionalDataRepository) {
        this.additionalDataRepository = additionalDataRepository;
    }

    @Transactional
    public Double getValueOfRecordBySignAndValue(String inputSign, int inputValue) {
        return additionalDataRepository.getValueOfRecord(inputSign, inputValue);
    }
}
