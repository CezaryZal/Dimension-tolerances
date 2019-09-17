package com.CezaryZal.service;

import com.CezaryZal.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.repository.AdditionalDataToBasicDeviationsRepoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdditionalDataToBasicDeviationsService {

    @Autowired
    private AdditionalDataToBasicDeviationsRepoDbImpl additionalDataRepo;

    @Transactional
    public AdditionalDataToBasicDeviations getSingleResultBySignAndValueFromInput (String inputSign, int inputValue) {
        return additionalDataRepo.getRecord(inputSign, inputValue);
    }
}
