package com.example.marco.floorplan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FloorPlanConfig {
    
    @Bean
    CommandLineRunner floorPlanCommandLineRunner(FloorPlanService floorPlanService){
        return args -> {
            floorPlanService.addFloorPlanEntity(new FloorPlanEntity(1L, 10L));
            floorPlanService.addFloorPlanEntity(new FloorPlanEntity(2L, 20L));
        };
    }
}
