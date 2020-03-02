package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.repository.NominalToleranceRepoDbImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NominalToleranceServiceRepoImp {

    private final NominalToleranceRepoDbImp toleranceRepository;

    @Autowired
    public NominalToleranceServiceRepoImp(NominalToleranceRepoDbImp toleranceRepository) {
        this.toleranceRepository = toleranceRepository;
    }

    @Transactional
    public Double getValueOfRecordBySignAndValue(String inputSign, int inputValue) {
        return toleranceRepository.getValueOfRecord(inputSign, inputValue);
    }
}
