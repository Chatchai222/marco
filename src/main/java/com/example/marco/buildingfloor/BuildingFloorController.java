package com.example.marco.buildingfloor;

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
@RequestMapping("api/v1/building-floors")
public class BuildingFloorController {

    private BuildingFloorService buildingFloorService;
    
    @Autowired
    public BuildingFloorController(BuildingFloorService inBuildingFloorService){
        this.buildingFloorService = inBuildingFloorService;
    }

    @GetMapping
    public List<BuildingFloorEntity> getAllBuildingFloorEntities(){
        return this.buildingFloorService.getAllBuildingFloorEntities();
    }

    @PostMapping
    public BuildingFloorEntity addBuildingFloorEntity(@RequestBody BuildingFloorEntity inBuildingDirectoryEntity) throws Exception{
        return this.buildingFloorService.addBuildingFloorEntity(inBuildingDirectoryEntity);
    }
    
    @GetMapping("/floorId/{floorId}")
    public BuildingFloorEntity getBuildingFloorEntityByFloorId(@PathVariable("floorId") Long inFloorId) throws Exception{
        return this.buildingFloorService.getBuildingFloorEntityByFloorId(inFloorId);
    }

    @DeleteMapping("/floorId/{floorId}")
    public void deleteBuildingFloorEntityByFloorId(@PathVariable("floorId") Long inFloorId){
        this.buildingFloorService.deleteBuildingFloorEntityByFloorId(inFloorId);
    }

    @GetMapping("/buildingId/{buildingId}")
    public List<BuildingFloorEntity> getBuildingFloorEntitiesByBuildingId(@PathVariable("buildingId") Long inBuildingId) throws Exception{
        return this.buildingFloorService.getBuildingFloorEntitiesByBuildingId(inBuildingId);
    }

    @DeleteMapping("/buildingId/{buildingId}")
    public void deleteBuildingFloorEntitiesByBuildingId(@PathVariable("buildingId") Long inBuildingId){
        this.buildingFloorService.deleteBuildingFloorEntitiesByBuildingId(inBuildingId);
    }

}
