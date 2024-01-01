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
            List<LocationEntity> locations = List.of(
            new LocationEntity("Back Left Toilet Door", 17.28, 14.1),
            new LocationEntity("Back Right Toilet Door", 25.79, 14.09),
            new LocationEntity("ECC801 Door", 29.5, 65.1),
            new LocationEntity("ECC802 Door", 29.5, 53.1),
            new LocationEntity("ECC803 Door", 29.5, 47.1),
            new LocationEntity("ECC804 Door", 29.5, 35.1),
            new LocationEntity("ECC805 Door", 29.5, 29.1),
            new LocationEntity("ECC806 Door", 29.5, 17.09),
            new LocationEntity("ECC807 Door", 13.55, 57.19),
            new LocationEntity("ECC808 Door", 13.55, 39.37),
            new LocationEntity("ECC809 Door", 13.55, 48.64),
            new LocationEntity("ECC810 Door", 13.55, 36.88),
            new LocationEntity("ECC811 Door", 13.55, 15.49),
            new LocationEntity("Front Left Toilet Door", 17.31, 49.76),
            new LocationEntity("Front Right Toilet Door", 25.82, 49.74),
            new LocationEntity("Prof Natthapong Office Door", 34.53, 19.98),
            new LocationEntity("Prof Pipat Office Door", 33.46, 19.98)
            );
            repository.saveAll(locations);
       };
    }

}
