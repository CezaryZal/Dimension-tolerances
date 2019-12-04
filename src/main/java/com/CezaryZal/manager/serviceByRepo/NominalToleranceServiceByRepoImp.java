package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.NominalTolerance;
import com.CezaryZal.repository.NominalToleranceRepoDbImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NominalToleranceServiceByRepoImp {

    private NominalToleranceRepoDbImpl toleranceRepository;

    public NominalToleranceServiceByRepoImp(NominalToleranceRepoDbImpl toleranceRepository) {
        this.toleranceRepository = toleranceRepository;
    }

//    @Override
    @Transactional
    public NominalTolerance getRecordBySignAndValue(String inputSign, int inputValue) {
        return toleranceRepository.getRecord(inputSign, inputValue);
    }
}
