package com.CezaryZal.service;

import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.repository.BasicDeviationsRepositoryDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BasicDeviationService {

    @Autowired
    private BasicDeviationsRepositoryDbImpl deviationsRepo;

    @Transactional
    public BasicDeviations getSingleResultBySignAndValueFromInput (String inputSign, int inputValue){
        return deviationsRepo.getRecord(inputSign, inputValue);
    }

}
