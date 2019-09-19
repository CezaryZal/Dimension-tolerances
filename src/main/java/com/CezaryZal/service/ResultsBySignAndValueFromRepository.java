package com.CezaryZal.service;

import com.CezaryZal.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.entity.NominalTolerance;
import com.CezaryZal.repository.AdditionalDataToBasicDeviationsRepoDbImpl;
import com.CezaryZal.repository.BasicDeviationsRepositoryDbImpl;
import com.CezaryZal.repository.NominalToleranceRepositoryDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResultsBySignAndValueFromRepository {

    @Autowired
    private NominalToleranceRepositoryDbImpl toleranceRepository;

    @Autowired
    private BasicDeviationsRepositoryDbImpl deviationsRepository;

    @Autowired
    private AdditionalDataToBasicDeviationsRepoDbImpl additionalDataRepository;


    @Transactional
    public NominalTolerance getSingleResultFromNominalToleranceRepo (String inputSign, int inputValue) {
        return toleranceRepository.getRecord(inputSign, inputValue);
    }

    @Transactional
    public BasicDeviations getSingleResultFromBasicDeviationsRepo (String inputSign, int inputValue){
        return deviationsRepository.getRecord(inputSign, inputValue);
    }

    @Transactional
    public AdditionalDataToBasicDeviations getSingleResultFromAdditionalDataRepo (String inputSign, int inputValue) {
        return additionalDataRepository.getRecord(inputSign, inputValue);
    }

}
