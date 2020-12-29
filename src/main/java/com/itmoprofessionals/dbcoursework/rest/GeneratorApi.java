package com.itmoprofessionals.dbcoursework.rest;

import com.itmoprofessionals.dbcoursework.service.generator.GeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generator")
public class GeneratorApi {

    private final GeneratorService generatorService;

    public GeneratorApi(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @GetMapping("/generate/data")
    public void generateData() {
        this.generatorService.generateData();
    }
}
