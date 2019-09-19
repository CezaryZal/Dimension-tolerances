package com.CezaryZal.testDB;

import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.entity.BasicDeviations;
import com.CezaryZal.entity.score.Dimension;
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

    @GetMapping("/start")
    public DimensionDTOImpl start(){

        DimensionDTOImpl dimensionDTO = new DimensionDTOImpl(new Dimension(0.2, 0.3, 0.4));

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
}
