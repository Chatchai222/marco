package com.example.marco.beacon;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeaconConfig {
    
    @Bean
    public CommandLineRunner BeaconCommandLineRunner(BeaconRepository beaconRepository){
        return args -> {
            List<BeaconEntity> beaconList = List.of(
                new BeaconEntity(1L, "beaconECC811", 23.24, 32.23, "AA:AA:AA:AA:AA:AA"),
                new BeaconEntity(2L, "beaconECC810", 64.23, 32.23, "BB:BB:BB:BB:BB:BB"),
                new BeaconEntity(3L, "beaconHM306", 45.23, 23.23, "CC:CC:CC:CC:CC:CC"),
                new BeaconEntity(4L, "beaconHM307", 45.23, 23.23, "DD:DD:DD:DD:DD:DD")
            );
            beaconRepository.saveAll(beaconList);
        };
    }
}
