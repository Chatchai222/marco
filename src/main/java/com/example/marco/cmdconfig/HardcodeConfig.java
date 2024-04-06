package com.example.marco.cmdconfig;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import com.example.marco.beacon.BeaconEntity;
import com.example.marco.beacon.BeaconService;
import com.example.marco.file.FileEntity;
import com.example.marco.file.FileService;
import com.example.marco.floor.FloorEntity;
import com.example.marco.floor.FloorService;
import com.example.marco.floorbeacon.FloorBeaconEntity;
import com.example.marco.floorbeacon.FloorBeaconService;
import com.example.marco.floorfile.FloorFileEntity;
import com.example.marco.floorfile.FloorFileService;

@Configuration
public class HardcodeConfig {

    @Bean
    public CommandLineRunner HardcodeCommandLineRunner(BeaconService beaconService,
                                                       FileService fileService,
                                                       FloorService floorService,
                                                       FloorBeaconService floorBeaconService,
                                                       FloorFileService floorFileService){
        return args -> {
            
            FloorEntity ecc7thFloor = floorService.addFloorEntity(new FloorEntity("ECC 7th floor", 39.6, 73.6, 270.00, 7));
            FloorEntity ecc8thFloor = floorService.addFloorEntity(new FloorEntity("ECC 8th floor", 37.4, 73.4, 270.00, 8));

            // List<LocationEntity> ecc7thLocationList = List.of(
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Back-Left-Toilet-Door", 15.20, 12.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Back-Right-Toilet-Door", 24.40, 12.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Back-Left-Staircase", 19.00, 12.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Back-Right-Staricase", 20.80, 12.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Back-Left-Elevator", 18.60, 17.80)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Back-Right-Elevator", 21.20, 17.80)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Front-Left-Toilet-Door", 15.60, 48.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Front-Right-Toilet-Door", 24.60, 48.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Front-Left-Staricase", 17.40, 48.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Front-Right-Staircase", 23.00, 48.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC7-Front-Elevator", 20.20, 48.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC701-Door", 28.00, 63.00)),
            //     locationService.addLocationEntity(new LocationEntity("ECC702-Door", 28.00, 51.00)),
            //     locationService.addLocationEntity(new LocationEntity("ECC703-Door", 30.60, 47.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC704-Door", 28.40, 16.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC705-Door", 28.00, 6.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC706-Door", 8.40, 24.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC707-Door", 5.80, 30.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC708-Door", 8.50, 35.80))

            // );
            // List<LocationEntity> ecc8thLocationList = List.of(
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Back-Left-Toilet-Door", 15.30, 12.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Back-Right-Toilet-Door", 25.00, 12.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Back-Left-Staircase", 19.50, 12.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Back-Right-Staircase", 21.20, 12.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Back-Left-Elevator", 19.00, 18.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Back-Right-Elevator", 21.60, 18.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Front-Left-Toilet-Door", 15.30, 48.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Front-Right-Toilet-Door", 25.70, 48.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Front-Left-Staircase", 18.00, 48.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Front-Right-Staircase", 22.40, 48.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Front-Elevator", 20.20, 48.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC801-Door", 28.40, 63.00)),
            //     locationService.addLocationEntity(new LocationEntity("ECC802-Door", 28.40, 51.00)),
            //     locationService.addLocationEntity(new LocationEntity("ECC803-Door", 28.40, 45.00)),
            //     locationService.addLocationEntity(new LocationEntity("ECC804-Door", 28.40, 33.00)),
            //     locationService.addLocationEntity(new LocationEntity("ECC805-Door", 28.40, 27.00)),
            //     locationService.addLocationEntity(new LocationEntity("ECC806-Door", 28.40, 15.00)),
            //     locationService.addLocationEntity(new LocationEntity("ECC807-Door", 12.10, 55.20)),
            //     locationService.addLocationEntity(new LocationEntity("ECC808-Door", 12.10, 46.60)),
            //     locationService.addLocationEntity(new LocationEntity("ECC809-Door", 12.10, 37.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC810-Door", 12.10, 34.80)),
            //     locationService.addLocationEntity(new LocationEntity("ECC811-Door", 12.10, 13.40)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Prof-Pipat-Office-Door", 33.00, 18.30)),
            //     locationService.addLocationEntity(new LocationEntity("ECC8-Prof-Natthapong-Office-Door", 34.10, 18.40))
            // );

            // for(LocationEntity location: ecc7thLocationList){
            //     floorLocationService.addFloorLocationEntity(new FloorLocationEntity(ecc7thFloor.getFloorId(), location.getLocationId()));
            // }
            // for(LocationEntity location: ecc8thLocationList){
            //     floorLocationService.addFloorLocationEntity(new FloorLocationEntity(ecc8thFloor.getFloorId(), location.getLocationId()));
            // }
            
            List<BeaconEntity> ecc7thBeaconList = List.of(
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Back-Left-Toilet-Door", 15.20, 12.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Back-Right-Toilet-Door", 24.40, 12.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Back-Left-Staircase", 19.00, 12.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Back-Right-Staricase", 20.80, 12.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Back-Left-Elevator", 18.60, 17.80, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Back-Right-Elevator", 21.20, 17.80, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Front-Left-Toilet-Door", 15.60, 48.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Front-Right-Toilet-Door", 24.60, 48.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Front-Left-Staricase", 17.40, 48.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Front-Right-Staircase", 23.00, 48.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC7-Front-Elevator", 20.20, 48.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC701-Door", 28.00, 63.00, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC702-Door", 28.00, 51.00, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC703-Door", 30.60, 47.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC704-Door", 28.40, 16.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC705-Door", 28.00, 6.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC706-Door", 8.40, 24.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC707-Door", 5.80, 30.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC708-Door", 8.50, 35.80, "notBeacon" + UUID.randomUUID().toString()))
            );

            List<BeaconEntity> ecc8thBeaconList = List.of(
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Back-Left-Toilet-Door", 15.30, 12.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Back-Right-Toilet-Door", 25.00, 12.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Back-Left-Staircase", 19.50, 12.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Back-Right-Staircase", 21.20, 12.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Back-Left-Elevator", 19.00, 18.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Back-Right-Elevator", 21.60, 18.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Front-Left-Toilet-Door", 15.30, 48.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Front-Right-Toilet-Door", 25.70, 48.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Front-Left-Staircase", 18.00, 48.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Front-Right-Staircase", 22.40, 48.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Front-Elevator", 20.20, 48.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC801-Door", 28.40, 63.00, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC802-Door", 28.40, 51.00, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC803-Door", 28.40, 45.00, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC804-Door", 28.40, 33.00, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC805-Door", 28.40, 27.00, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC806-Door", 28.40, 15.00, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC807-Door", 12.10, 55.20, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC808-Door", 12.10, 46.60, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC809-Door", 12.10, 37.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC810-Door", 12.10, 34.80, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC811-Door", 12.10, 13.40, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Prof-Pipat-Office-Door", 33.00, 18.30, "notBeacon" + UUID.randomUUID().toString())),
                beaconService.addBeaconEntity(new BeaconEntity("ECC8-Prof-Natthapong-Office-Door", 34.10, 18.40, "notBeacon" + UUID.randomUUID().toString()))
            );
            
            for(BeaconEntity beaconEntity: ecc7thBeaconList){
                floorBeaconService.insertFloorBeaconEntity(new FloorBeaconEntity(ecc7thFloor.getFloorId(), beaconEntity.getBeaconId()));
            }
            for(BeaconEntity beaconEntity: ecc8thBeaconList){
                floorBeaconService.insertFloorBeaconEntity(new FloorBeaconEntity(ecc8thFloor.getFloorId(), beaconEntity.getBeaconId()));
            }

            
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            File ecc7thResource = resourceLoader.getResource("classpath:static/ecc7thfloor-cropped-to-floor.png").getFile();
            FileEntity ecc7thFileEntity = fileService.addFileEntity(ecc7thResource);
            File ecc8thResource = resourceLoader.getResource("classpath:static/ecc8thfloor-cropped-to-floor.png").getFile();
            FileEntity ecc8thFileEntity = fileService.addFileEntity(ecc8thResource);

            
            floorFileService.insertFloorFileEntity(new FloorFileEntity(ecc7thFloor.getFloorId(), ecc7thFileEntity.getFileId()));
            floorFileService.insertFloorFileEntity(new FloorFileEntity(ecc8thFloor.getFloorId(), ecc8thFileEntity.getFileId()));
        };
    }
    
}
