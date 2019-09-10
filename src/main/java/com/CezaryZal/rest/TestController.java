package com.CezaryZal.rest;

import com.CezaryZal.dto.DimensionDTO;
import com.CezaryZal.dto.DimensionDTOImpl;
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

//    @GetMapping("/value/{diameter}")
//    public DimensionDTO dimension(@PathVariable String diameter){
//        Dimension temDimension = new Dimension(Integer.parseInt(diameter), 10, -8, true);
//        DimensionDTO dimensionDTO = new DimensionDTOImpl(temDimension);
//        return dimensionDTO;
//    }

}