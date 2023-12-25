package com.example.marco.building;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuildingConfig {

    @Bean
    CommandLineRunner buildingCommandLineRunner(BuildingRepository buildingRepository){
        return args -> {
            buildingRepository.save(new BuildingEntity(1L, "my ECC building"));
            buildingRepository.save(new BuildingEntity(2L, "my HM building"));
        };
    }
    
}
