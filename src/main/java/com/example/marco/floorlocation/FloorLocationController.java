package com.example.marco.floorlocation;

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
@RequestMapping("api/v1/floor-locations")
public class FloorLocationController {
    
    private FloorLocationService floorLocationService;

    @Autowired
    public FloorLocationController(FloorLocationService inFloorLocationService){
        this.floorLocationService = inFloorLocationService;
    }

    @GetMapping
    public List<FloorLocationEntity> getAllFloorLocationEntities(){
        return this.floorLocationService.getAllFloorLocationEntities();
    }

    @PostMapping
    public FloorLocationEntity addFloorLocationEntity(@RequestBody FloorLocationEntity inFloorLocationEntity) throws Exception{
        return this.floorLocationService.addFloorLocationEntity(inFloorLocationEntity);
    }

    @GetMapping("/floorId/{floorId}")
    public List<FloorLocationEntity> getFloorLocationEntitiesByFloorId(@PathVariable("floorId") Long inFloorId){
        return this.floorLocationService.getFloorLocationEntitiesByFloorId(inFloorId);
    }

    @DeleteMapping("/floorId/{floorId}")
    public void deleteFloorLocationEntitiesByFloorId(@PathVariable("floorId") Long inFloorId){
        this.floorLocationService.deleteFloorLocationEntitiesByFloorId(inFloorId);
    }

    @GetMapping("/locationId/{locationId}")
    public FloorLocationEntity getFloorLocationEntityByLocationId(@PathVariable("locationId") Long inLocationId) throws Exception{
        return this.floorLocationService.getFloorLocationEntityByLocationId(inLocationId);
    }

    @DeleteMapping("/locationId/{locationId}")
    public void deleteFloorLocationEntityByLocationid(@PathVariable("locationId") Long inLocationId) throws Exception{
        this.floorLocationService.deleteFloorLocationEntityByLocationId(inLocationId);
    }
}
