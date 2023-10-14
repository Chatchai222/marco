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
            List<Location> locations = List.of(
            new Location("Back Left Toilet Door", "8th floor", 17.28, 14.1),
            new Location("Back Right Toilet Door", "8th floor", 25.79, 14.09),
            new Location("ECC801 Door", "8th floor", 29.5, 65.1),
            new Location("ECC802 Door", "8th floor", 29.5, 53.1),
            new Location("ECC803 Door", "8th floor", 29.5, 47.1),
            new Location("ECC804 Door", "8th floor", 29.5, 35.1),
            new Location("ECC805 Door", "8th floor", 29.5, 29.1),
            new Location("ECC806 Door", "8th floor", 29.5, 17.09),
            new Location("ECC807 Door", "8th floor", 13.55, 57.19),
            new Location("ECC808 Door", "8th floor", 13.55, 39.37),
            new Location("ECC809 Door", "8th floor", 13.55, 48.64),
            new Location("ECC810 Door", "8th floor", 13.55, 36.88),
            new Location("ECC811 Door", "8th floor", 13.55, 15.49),
            new Location("Front Left Toilet Door", "8th floor", 17.31, 49.76),
            new Location("Front Right Toilet Door", "8th floor", 25.82, 49.74),
            new Location("Prof Natthapong Office Door", "8th floor", 34.53, 19.98),
            new Location("Prof Pipat Office Door", "8th floor", 33.46, 19.98)
            );
            repository.saveAll(locations);
       };
    }

}
