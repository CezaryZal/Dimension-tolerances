package com.CezaryZal.manager.serviceByRepo;

import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.repository.BasicDeviationsRepoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class BasicDeviationsServiceByRepoImp implements ServiceByRepo{

    private final BasicDeviationsRepoDbImpl deviationsRepository;

    @Autowired
    public BasicDeviationsServiceByRepoImp(BasicDeviationsRepoDbImpl deviationsRepository) {
        this.deviationsRepository = deviationsRepository;
    }

    @Transactional
    @Override
    public BasicDeviations getRecordBySignAndValue(String inputSign, int inputValue) {
        return deviationsRepository.getRecord(inputSign, inputValue);
    }
}
