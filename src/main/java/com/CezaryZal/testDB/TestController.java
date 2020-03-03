package com.CezaryZal.testDB;

import com.CezaryZal.api.model.dto.DimensionDtoImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/start")
    public DimensionDtoImpl start(){

        return new DimensionDtoImpl(2, 0.3, 0.4);
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
