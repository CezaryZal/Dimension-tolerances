package com.CezaryZal.api.service.repo;

import com.CezaryZal.api.repository.BasicDeviationRepoDbImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasicDeviationServiceRepoImp {

    private final BasicDeviationRepoDbImp deviationsRepository;

    @Autowired
    public BasicDeviationServiceRepoImp(BasicDeviationRepoDbImp deviationsRepository) {
        this.deviationsRepository = deviationsRepository;
    }

//    @Override
    @Transactional
    public Double getValueOfRecordBySignAndValue(String inputSign, int inputValue) {
        return deviationsRepository.getValueOfRecord(inputSign, inputValue);
    }
}
