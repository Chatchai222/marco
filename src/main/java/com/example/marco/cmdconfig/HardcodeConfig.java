package com.example.marco.cmdconfig;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.marco.beacon.BeaconEntity;
import com.example.marco.beacon.BeaconService;
import com.example.marco.building.BuildingService;
import com.example.marco.buildingfloor.BuildingFloorService;
import com.example.marco.file.FileService;
import com.example.marco.floor.FloorService;
import com.example.marco.floorbeacon.FloorBeaconService;
import com.example.marco.floorfile.FloorFileService;
import com.example.marco.floorlocation.FloorLocationService;
import com.example.marco.location.LocationService;

@Configuration
public class HardcodeConfig {

    @Bean
    public CommandLineRunner HardcodeCommandLineRunner(BeaconService beaconService,
                                                       BuildingService buildingService,
                                                       BuildingFloorService buildingFloorService,
                                                       FileService fileService,
                                                       FloorService floorService,
                                                       FloorBeaconService floorBeaconService,
                                                       FloorFileService floorFileService,
                                                       FloorLocationService floorLocationService,
                                                       LocationService locationService){
        return args -> {
            
        };
    }
    
}
