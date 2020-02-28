package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.NominalTolerance;
import com.CezaryZal.repository.NominalToleranceRepoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class NominalToleranceServiceByRepoImp implements ServiceByRepo{

    private final NominalToleranceRepoDbImpl toleranceRepository;

    @Autowired
    public NominalToleranceServiceByRepoImp(NominalToleranceRepoDbImpl toleranceRepository) {
        this.toleranceRepository = toleranceRepository;
    }

    @Transactional
    @Override
    public NominalTolerance getRecordBySignAndValue(String inputSign, int inputValue) {
        return toleranceRepository.getRecord(inputSign, inputValue);
    }
}
