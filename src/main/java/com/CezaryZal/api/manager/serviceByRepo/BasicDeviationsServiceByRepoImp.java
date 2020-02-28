package com.CezaryZal.api.manager.serviceByRepo;

import com.CezaryZal.api.model.entity.BasicDeviations;
import com.CezaryZal.api.repository.BasicDeviationsRepoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasicDeviationsServiceByRepoImp {

    private final BasicDeviationsRepoDbImpl deviationsRepository;

    @Autowired
    public BasicDeviationsServiceByRepoImp(BasicDeviationsRepoDbImpl deviationsRepository) {
        this.deviationsRepository = deviationsRepository;
    }

//    @Override
    @Transactional
    public BasicDeviations getRecordBySignAndValue(String inputSign, int inputValue) {
        return deviationsRepository.getRecord(inputSign, inputValue);
    }
}
