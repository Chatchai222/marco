package com.example.marco.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/config")
public class ConfigController {
    
    @Value("${fruit}")
    private String fruit;

    @GetMapping("fruit")
    public String favFruit(){
        return fruit;
    }
}
