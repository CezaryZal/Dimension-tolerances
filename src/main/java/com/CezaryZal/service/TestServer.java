package com.CezaryZal.service;

import com.CezaryZal.entity.BasicDeviations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServer {

    @Autowired
    private BasicDeviationService basicDeviationService;

    public BasicDeviations showValueOfBasicDeviations(){
        String inputSign = "c";
        int inputValue = 2;
        BasicDeviations tmpDeviations = basicDeviationService.getSingleResultBySignAndValueFromInput(inputSign, inputValue);
        System.out.println(tmpDeviations.toString());
        System.out.println(tmpDeviations.getValue());

        return tmpDeviations;
    }
}
