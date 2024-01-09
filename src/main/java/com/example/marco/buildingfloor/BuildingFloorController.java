package com.example.marco.buildingfloor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<BuildingFloorEntity> getAllBuildingDirectoryEntities(){
        return this.buildingFloorService.getAllBuildingFloorEntities();
    }

    @PutMapping
    public BuildingFloorEntity upsertBuildingDirectoryEntity(@RequestBody BuildingFloorEntity inBuildingDirectoryEntity) throws Exception{
        return this.buildingFloorService.upsertBuildingDirectoryEntity(inBuildingDirectoryEntity);
    }
    
    @GetMapping("/floorId/{floorId}")
    public BuildingFloorEntity getBuildingDirectoryEntityByFloorId(@PathVariable("floorId") Long inFloorId) throws Exception{
        return this.buildingFloorService.getBuildingFloorEntityByFloorId(inFloorId);
    }

    @DeleteMapping("/floorId/{floorId}")
    public void deleteBuildingDirectoryEntityByFloorId(@PathVariable("floorId") Long inFloorId){
        this.buildingFloorService.deleteBuildingFloorEntityByFloorId(inFloorId);
    }

    @GetMapping("/buildingId/{buildingId}")
    public List<BuildingFloorEntity> getBuildingDirectoryEntitiesByBuildingId(@PathVariable("buildingId") Long inBuildingId) throws Exception{
        return this.buildingFloorService.getBuildingFloorEntitiesByBuildingId(inBuildingId);
    }

    @DeleteMapping("/buildingId/{buildingId}")
    public void deleteBuildingDirectoryEntitiesByBuildingId(@PathVariable("buildingId") Long inBuildingId){
        this.buildingFloorService.deleteBuildingFloorEntitiesByBuildingId(inBuildingId);
    }

}
