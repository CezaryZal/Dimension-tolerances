package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.repository.BasicDeviationsRepoDbImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasicDeviationsServiceByRepoImp {

    private BasicDeviationsRepoDbImpl deviationsRepository;

    public BasicDeviationsServiceByRepoImp(BasicDeviationsRepoDbImpl deviationsRepository) {
        this.deviationsRepository = deviationsRepository;
    }

//    @Override
    @Transactional
    public BasicDeviations getRecordBySignAndValue(String inputSign, int inputValue) {
        return deviationsRepository.getRecord(inputSign, inputValue);
    }
}
