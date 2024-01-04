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
                new BeaconEntity("beacon Moxxie", 23.24, 32.23, "FF:00:CC:CC:EE:DD"),
                new BeaconEntity("beacon Loona", 64.23, 32.23, "11:00:00:88:AA:AA")
            );
            beaconRepository.saveAll(beaconList);
        };
    }
}
