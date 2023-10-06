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
            List<Beacon> beaconList = List.of(
                new Beacon("FF:00:CC:CC:EE:DD", "8th floor", 52.4, 32.5),
                new Beacon("55:55:55:AA:AA:BB", "8th floor", 32.41, 12.3)
            );
            beaconRepository.saveAll(beaconList);
        };
    }
}
