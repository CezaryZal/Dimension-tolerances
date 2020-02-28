package com.CezaryZal.testDB;

import com.CezaryZal.api.model.dto.DimensionDTOImpl;
import com.CezaryZal.api.model.Dimension;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/start")
    public DimensionDTOImpl start(){

        Dimension dimension = new Dimension(2, 0.3, 0.4);
        return dimension.makeDimensionDto();
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
