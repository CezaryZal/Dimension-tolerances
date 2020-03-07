package com.CezaryZal.api.rest;

import com.CezaryZal.api.model.dto.DimensionDto;
import com.CezaryZal.api.service.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DimensionDto> dimension(@PathVariable String input){
        return new ResponseEntity<>(service.createDimensionTolerance(input), HttpStatus.OK);
    }


}
