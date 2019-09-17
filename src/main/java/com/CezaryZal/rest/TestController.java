package com.CezaryZal.rest;

import com.CezaryZal.dto.DimensionDTO;
import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.entity.Dimension;
import com.CezaryZal.service.BasicDeviationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/value")
    public BasicDeviations showValueOfBasicDeviations(){
        String inputSign = "c";
        int inputValue = 2;
        BasicDeviations tmpDeviations = basicDeviationService.getSingleResultBySignAndValueFromInput(inputSign, inputValue);
        System.out.println(tmpDeviations.toString());
        System.out.println(tmpDeviations.getValue());

        return tmpDeviations;
    }

    @GetMapping("/list")
    public List<BasicDeviations> showListDeviations(){
        String inputSign = "c";
        int inputValue = 2;
        return basicDeviationService.getListDeviations(inputSign, inputValue);
    }

    @GetMapping("/id/{id}")
    public BasicDeviations getDeviations (@PathVariable int id){
        BasicDeviations tmpDeviations = basicDeviationService.getRecordById(id);

        return tmpDeviations;
    }

}
