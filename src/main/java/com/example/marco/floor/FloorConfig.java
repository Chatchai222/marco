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
            List<Floor> floorList = List.of(
                new Floor("ECC 8th Floor", 75.91, 38.17, 189.75),
                new Floor("ECC 9th Floor", 75.91, 38.17, 189.75)
            );
            repository.saveAll(floorList);
        };    
    }

}
