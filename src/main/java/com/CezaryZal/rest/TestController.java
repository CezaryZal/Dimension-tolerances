package com.CezaryZal.rest;

import com.CezaryZal.entity.Dimension;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @ResponseBody
    @GetMapping("/hello")
    public String showHello() {
        return "Hello!? success?";
    }

    @GetMapping("/value/{diameter}")
    public Dimension dimension(@PathVariable String diameter){
        Dimension temDimension = new Dimension(Integer.parseInt(diameter), 10, -8);
        return temDimension;
    }

}
