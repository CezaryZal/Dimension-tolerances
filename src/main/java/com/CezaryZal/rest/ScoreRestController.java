package com.CezaryZal.rest;

import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.entity.Dimension;
import com.CezaryZal.service.DimensionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/*")
public class ScoreRestController {


    @GetMapping("/value/{input}")
    public DimensionDTOImpl dimension(@PathVariable String input){

        DimensionService service = new DimensionService();
        DimensionDTOImpl dimensionDTO = new DimensionDTOImpl(service.createDimensionTolerance(input));

        return dimensionDTO;
    }


}
