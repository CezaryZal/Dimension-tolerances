package com.CezaryZal.api.rest;

import com.CezaryZal.api.model.dto.DimensionDTO;
import com.CezaryZal.api.manager.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScoreRestController {

    private final DimensionService service;

    @Autowired
    public ScoreRestController(DimensionService service) {
        this.service = service;
    }

    @GetMapping("/value/{input}")
    public DimensionDTO dimension(@PathVariable String input){
        return service.createDimensionTolerance(input);
    }


}
