package com.example.marco.floor;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FloorConfig {
    
    @Bean
    public CommandLineRunner FloorCommandLineRunner(FloorRepository repository){
        return args -> {
            List<FloorEntity> floorList = List.of(
                new FloorEntity(1L, "ECC 8th Floor", 75.91, 38.17, 189.75),
                new FloorEntity(2L, "ECC 9th Floor", 75.91, 38.17, 189.75),
                new FloorEntity(3L, "HM 3th Floor", 75.61, 34.23, 35.32),
                new FloorEntity(4L, "HM 4th Floor", 75.61, 34.23, 35.32)
            );
            repository.saveAll(floorList);
        };    
    }

}
