package com.CezaryZal.rest;

import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.entity.NominalTolerance;
import com.CezaryZal.service.BasicDeviationService;
import com.CezaryZal.service.NominalToleranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @GetMapping("/hello")
    public String showHello() {
        return "Hello!? success?";
    }

//    @GetMapping("/value/{diameter}")
//    public DimensionDTO dimension(@PathVariable String diameter){
//        Dimension temDimension = new Dimension(Integer.parseInt(diameter), 10, -8, true);
//        DimensionDTO dimensionDTO = new DimensionDTOImpl(temDimension);
//        return dimensionDTO;
//    }

    @Autowired
    private BasicDeviationService basicDeviationService;

    @Autowired
    private NominalToleranceService nominalToleranceService;

    @GetMapping("/valueDeviation")
    public BasicDeviations showValueOfBasicDeviations(){
        String inputSign = "c";
        int inputValue = 2;
        BasicDeviations tmpDeviations = basicDeviationService.getSingleResultBySignAndValueFromInput(inputSign, inputValue);
        System.out.println(tmpDeviations.toString());
        System.out.println(tmpDeviations.getValue());

        return tmpDeviations;
    }

    @GetMapping("/valueTolerance")
    public NominalTolerance showValueOfNominalTolerance(){
        String inputSign = "IT7";
        int inputValue = 2;

        NominalTolerance tmpTolerance = nominalToleranceService.getSingleResultBySignAndValueFromInput(inputSign, inputValue);
        System.out.println(tmpTolerance.toString());
        System.out.println(tmpTolerance.getValue());

        return tmpTolerance;
    }

}
