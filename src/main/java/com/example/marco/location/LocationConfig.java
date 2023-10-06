package com.example.marco.location;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationConfig {
    
    @Bean
    public CommandLineRunner LocationCommandLineRunner(LocationRepository repository) {
        return args -> {
            Location ecc804 = new Location("ECC804", "8th floor", 23.4, 24.2);
            Location profPipatOffice = new Location("Prof Pipat Office", "8th floor", 32.4, 25.5);
            
            repository.saveAll(List.of(ecc804, profPipatOffice));
        };
    }

}
