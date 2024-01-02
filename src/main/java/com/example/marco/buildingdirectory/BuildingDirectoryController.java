package com.example.marco.buildingdirectory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/{buildingDirectoryId}")
    public BuildingDirectoryEntity getBuildingDirectoryEntityByBuildingDirectoryId(@PathVariable("buildingDirectoryId") Long inBuildingDirectoryId) throws Exception{
        return this.buildingDirectoryService.getBuildingDirectoryEntityByBuildingDirectoryId(inBuildingDirectoryId);
    }

    @PostMapping
    public BuildingDirectoryEntity addBuildingDirectoryEntity(@RequestBody BuildingDirectoryEntity inBuildingDirectoryEntity) throws Exception{
        return this.buildingDirectoryService.addBuildingDirectoryEntity(inBuildingDirectoryEntity);
    }

    @PutMapping("/{buildingDirectoryId}")
    public BuildingDirectoryEntity replaceBuildingDirectoryEntityByBuildingDirectoryId(@RequestBody BuildingDirectoryEntity inBuildingDirectoryEntity) throws Exception{
        return this.buildingDirectoryService.replaceBuildingDirectoryEntityByBuildingDirectoryId(inBuildingDirectoryEntity);
    }

    @DeleteMapping("/{buildingDirectoryId}")
    public void deleteBuildingDirectoryEntityByBuildingDirectoryId(@PathVariable("buildingDirectoryId")Long inBuildingDirectoryId){
        this.buildingDirectoryService.deleteBuildingDirectoryEntityByBuildingDirectoryId(inBuildingDirectoryId);
    }

    @GetMapping("/buildingId/{buildingId}")
    public List<BuildingDirectoryEntity> getBuildingDirectoryEntitiesByBuildingId(@PathVariable("buildingId") Long inBuildingId){
        return this.buildingDirectoryService.getBuildingDirectoryEntitiesByBuildingId(inBuildingId);
    }
    
    @PostMapping("/buildingId/{buildingId}")
    public BuildingDirectoryEntity addBuildingDirectoryEntityByBuildingId(@PathVariable("buildingId") Long inBuildingId,
                                                                          @RequestBody BuildingDirectoryEntity inBuildingDirectoryEntity) throws Exception{
        inBuildingDirectoryEntity.setBuildingId(inBuildingId);
        return this.buildingDirectoryService.addBuildingDirectoryEntity(inBuildingDirectoryEntity);        
    }




    
}
