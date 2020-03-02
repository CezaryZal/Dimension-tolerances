package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.repository.BasicDeviationsRepoDbImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasicDeviationServiceRepoImp {

    private final BasicDeviationsRepoDbImp deviationsRepository;

    @Autowired
    public BasicDeviationServiceRepoImp(BasicDeviationsRepoDbImp deviationsRepository) {
        this.deviationsRepository = deviationsRepository;
    }

//    @Override
    @Transactional
    public Double getValueOfRecordBySignAndValue(String inputSign, int inputValue) {
        return deviationsRepository.getValueOfRecord(inputSign, inputValue);
    }
}
