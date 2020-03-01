package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.model.entity.BasicDeviations;
import com.CezaryZal.api.repository.BasicDeviationsRepoDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasicDeviationServiceRepoImp {

    private final BasicDeviationsRepoDbImpl deviationsRepository;

    @Autowired
    public BasicDeviationServiceRepoImp(BasicDeviationsRepoDbImpl deviationsRepository) {
        this.deviationsRepository = deviationsRepository;
    }

//    @Override
    @Transactional
    public BasicDeviations getRecordBySignAndValue(String inputSign, int inputValue) {
        return deviationsRepository.getRecord(inputSign, inputValue);
    }
}
