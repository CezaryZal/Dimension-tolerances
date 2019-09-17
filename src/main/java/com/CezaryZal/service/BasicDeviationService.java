package com.CezaryZal.service;

import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.repository.BasicDeviationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BasicDeviationService {

    @Autowired
    private BasicDeviationsRepository deviationsRepo;

    @Transactional
    public BasicDeviations getBasicDeviations(int currentNominalDimension, String currentSign){
        return deviationsRepo.getRecord(currentNominalDimension, currentSign);
    }

    @Transactional
    public List<BasicDeviations> getListDeviations(){
        return deviationsRepo.getList();
    }

    @Transactional
    public BasicDeviations getRecordById (int id){
        return deviationsRepo.getRecordById(id);
    }
}
