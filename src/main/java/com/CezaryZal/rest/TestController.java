package com.CezaryZal.rest;

import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.entity.AdditionalDataToBasicDeviations;
import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.entity.NominalTolerance;
import com.CezaryZal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    DimensionService service;

    @GetMapping("/start/{input}")
    public DimensionDTOImpl testStart(@PathVariable String input){

        DimensionDTOImpl dimensionDTO = new DimensionDTOImpl(service.createDimensionTolerance(input));

        return dimensionDTO;
    }


    @ResponseBody
    @GetMapping("/hello")
    public String showHello() {
        return "Hello!? success?";
    }

    @GetMapping("/exp/{name}")
    public String dimension(@PathVariable String name){
        System.out.println(name);
        return name;
    }

    @GetMapping("/input/{name}")
    public NominalTolerance showValueOfNominalFromInput(@PathVariable String name) {

        int inputValue = 2;
        NominalTolerance tmpTolerance = nominalToleranceService.getSingleResultBySignAndValueFromInput(name, inputValue);

        return tmpTolerance;
    }

    @Autowired
    TestServer server;

    @GetMapping("/testServer/{input}")
    public BasicDeviations testServer(@PathVariable String input){


        BasicDeviations tmpDeviations = server.showValueOfBasicDeviations();
        System.out.println(tmpDeviations.toString());
        System.out.println(tmpDeviations.getValue());

        return tmpDeviations;
    }

    @Autowired
    private BasicDeviationService basicDeviationService;

    @GetMapping("/valueDeviation")
    public BasicDeviations showValueOfBasicDeviations(){
        String inputSign = "c";
        int inputValue = 2;
        BasicDeviations tmpDeviations = basicDeviationService.getSingleResultBySignAndValueFromInput(inputSign, inputValue);
        System.out.println(tmpDeviations.toString());
        System.out.println(tmpDeviations.getValue());

        return tmpDeviations;
    }



    @Autowired
    private NominalToleranceService nominalToleranceService;

    @GetMapping("/valueTolerance")
    public NominalTolerance showValueOfNominalTolerance(){
        String inputSign = "IT7";
        int inputValue = 2;

        NominalTolerance tmpTolerance = nominalToleranceService.getSingleResultBySignAndValueFromInput(inputSign, inputValue);
        System.out.println(tmpTolerance.toString());
        System.out.println(tmpTolerance.getValue());

        return tmpTolerance;
    }

    @Autowired
    private AdditionalDataToBasicDeviationsService additionalDataService;

    @GetMapping("/valueAddData")
    public AdditionalDataToBasicDeviations showValueOfAdditionalData(){
        String inputSign = "IT7";
        int inputValue = 5;

        AdditionalDataToBasicDeviations tmpData = additionalDataService.getSingleResultBySignAndValueFromInput(inputSign, inputValue);
        System.out.println(tmpData.toString());
        System.out.println(tmpData.getValue());

        return tmpData;
    }


}
