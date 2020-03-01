package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.model.entity.NominalTolerance;
import com.CezaryZal.api.repository.NominalToleranceRepoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NominalToleranceServiceRepoImp {

    private final NominalToleranceRepoDbImpl toleranceRepository;

    @Autowired
    public NominalToleranceServiceRepoImp(NominalToleranceRepoDbImpl toleranceRepository) {
        this.toleranceRepository = toleranceRepository;
    }

    @Transactional
    public NominalTolerance getRecordBySignAndValue(String inputSign, int inputValue) {
        return toleranceRepository.getRecord(inputSign, inputValue);
    }
}
