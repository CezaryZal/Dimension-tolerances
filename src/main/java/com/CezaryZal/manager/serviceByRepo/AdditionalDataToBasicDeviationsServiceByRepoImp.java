package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.repository.AdditionalDataToBasicDeviationsRepoDbImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AdditionalDataToBasicDeviationsServiceByRepoImp {

    private AdditionalDataToBasicDeviationsRepoDbImpl additionalDataRepository;

    public AdditionalDataToBasicDeviationsServiceByRepoImp(AdditionalDataToBasicDeviationsRepoDbImpl additionalDataRepository) {
        this.additionalDataRepository = additionalDataRepository;
    }

//    @Override
    @Transactional
    public AdditionalDataToBasicDeviations getRecordBySignAndValue(String inputSign, int inputValue) {
        return additionalDataRepository.getRecord(inputSign, inputValue);
    }
}
