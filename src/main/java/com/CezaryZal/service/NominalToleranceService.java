package com.CezaryZal.service;

import com.CezaryZal.entity.NominalTolerance;
import com.CezaryZal.repository.NominalToleranceRepositoryDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NominalToleranceService {

    @Autowired
    private NominalToleranceRepositoryDbImpl toleranceRepo;

    @Transactional
    public NominalTolerance getSingleResultBySignAndValueFromInput (String inputSign, int inputValue) {
        return toleranceRepo.getRecord(inputSign, inputValue);
    }
}
