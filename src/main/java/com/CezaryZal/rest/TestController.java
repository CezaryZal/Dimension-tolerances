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

    @GetMapping("/value")
    public Dimension dimension(){
        return new Dimension(20, 5,-6);
    }

}
