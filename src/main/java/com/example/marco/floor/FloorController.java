package com.example.marco.floor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/floor")
public class FloorController {
    
    @GetMapping("hello")
    public String getHello(){
        return "Hello, you tried getting in floor apis";
    }

    


}
