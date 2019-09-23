package com.CezaryZal.testDB;

import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.entity.Dimension;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/start")
    public DimensionDTOImpl start(){

        Dimension dimension = new Dimension(2, 0.3, 0.4);
        DimensionDTOImpl dimensionDTO = dimension.makeDimensionDto();

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
