package com.CezaryZal.rest;

import com.CezaryZal.dto.DimensionDTOImpl;
import com.CezaryZal.manager.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScoreRestController {

    private DimensionService service;

    @Autowired
    public ScoreRestController(DimensionService service) {
        this.service = service;
    }

    @GetMapping("/value/{input}")
    public DimensionDTOImpl dimension(@PathVariable String input){

        DimensionDTOImpl dimensionDTO = service.createDimensionTolerance(input);

        return dimensionDTO;
    }


}
