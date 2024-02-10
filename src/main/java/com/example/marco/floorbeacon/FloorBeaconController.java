package com.example.marco.floorbeacon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/floor-beacons")
public class FloorBeaconController {
    
    private FloorBeaconService floorBeaconService;

    @Autowired
    public FloorBeaconController(FloorBeaconService inFloorBeaconService){
        this.floorBeaconService = inFloorBeaconService;
    }

    @GetMapping
    public List<FloorBeaconEntity> getAllFloorBeaconEntities(){
        return this.floorBeaconService.getAllFloorBeaconEntities();
    }

    @PostMapping
    public FloorBeaconEntity insertFloorBeaconEntity(@RequestBody FloorBeaconEntity inFloorBeaconEntity) throws Exception{
        return this.floorBeaconService.insertFloorBeaconEntity(inFloorBeaconEntity);
    }

    @GetMapping("/floorId/{floorId}")
    public List<FloorBeaconEntity> getFloorBeaconEntityByFloorId(@PathVariable("floorId") Long inFloorId){
        return this.floorBeaconService.getFloorBeaconEntitiesByFloorId(inFloorId);
    }

    @DeleteMapping("/floorId/{floorId}")
    public void deleteFloorBeaconEntityByFloorId(@PathVariable("floorId") Long inFloorId){
        this.floorBeaconService.deleteFloorBeaconEntitiesByFloorId(inFloorId);
    }

    @GetMapping("/beaconId/{beaconId}")
    public FloorBeaconEntity getFloorBeaconEntityByBeaconId(@PathVariable("beaconId") Long beaconId) throws Exception{
        return this.floorBeaconService.getFloorBeaconEntityByBeaconId(beaconId);
    }

    @DeleteMapping("/beaconId/{beaconId}")
    public void deleteFloorBeaconEntitiesByBeaconId(@PathVariable("beaconId") Long beaconId){
        this.floorBeaconService.deleteFloorBeaconEntityByBeaconId(beaconId);
    }
}
