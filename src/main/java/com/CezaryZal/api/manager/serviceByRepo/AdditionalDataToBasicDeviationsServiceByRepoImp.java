package com.CezaryZal.api.manager.serviceByRepo;

import com.CezaryZal.api.model.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.api.repository.AdditionalDataToBasicDeviationsRepoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AdditionalDataToBasicDeviationsServiceByRepoImp {

    private final AdditionalDataToBasicDeviationsRepoDbImpl additionalDataRepository;

    @Autowired
    public AdditionalDataToBasicDeviationsServiceByRepoImp(AdditionalDataToBasicDeviationsRepoDbImpl additionalDataRepository) {
        this.additionalDataRepository = additionalDataRepository;
    }

    @Transactional
    public AdditionalDataToBasicDeviations getRecordBySignAndValue(String inputSign, int inputValue) {
        return additionalDataRepository.getRecord(inputSign, inputValue);
    }
}
