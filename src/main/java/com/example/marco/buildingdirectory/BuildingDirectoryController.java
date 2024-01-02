package com.example.marco.buildingdirectory;

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
@RequestMapping("api/v1/building-directories")
public class BuildingDirectoryController {

    private BuildingDirectoryService buildingDirectoryService;
    
    @Autowired
    public BuildingDirectoryController(BuildingDirectoryService inBuildingDirectoryService){
        this.buildingDirectoryService = inBuildingDirectoryService;
    }

    @GetMapping
    public List<BuildingDirectoryEntity> getAllBuildingDirectoryEntities(){
        return this.buildingDirectoryService.getAllBuildingDirectoryEntities();
    }

    @PutMapping
    public BuildingDirectoryEntity upsertBuildingDirectoryEntity(@RequestBody BuildingDirectoryEntity inBuildingDirectoryEntity) throws Exception{
        return this.buildingDirectoryService.upsertBuildingDirectoryEntity(inBuildingDirectoryEntity);
    }
    
    @GetMapping("/floorId/{floorId}")
    public BuildingDirectoryEntity getBuildingDirectoryEntityByFloorId(@PathVariable("floorId") Long inFloorId) throws Exception{
        return this.buildingDirectoryService.getBuildingDirectoryEntityByFloorId(inFloorId);
    }

    @DeleteMapping("/floorId/{floorId}")
    public void deleteBuildingDirectoryEntityByFloorId(@PathVariable("floorId") Long inFloorId){
        this.buildingDirectoryService.deleteBuildingDirectoryEntityByFloorId(inFloorId);
    }

    @GetMapping("/buildingId/{buildingId}")
    public List<BuildingDirectoryEntity> getBuildingDirectoryEntitiesByBuildingId(@PathVariable("buildingId") Long inBuildingId) throws Exception{
        return this.buildingDirectoryService.getBuildingDirectoryEntitiesByBuildingId(inBuildingId);
    }

    @DeleteMapping("/buildingId/{buildingId}")
    public void deleteBuildingDirectoryEntitiesByBuildingId(@PathVariable("buildingId") Long inBuildingId){
        this.buildingDirectoryService.deleteBuildingDirectoryEntitiesByBuildingId(inBuildingId);
    }

}
