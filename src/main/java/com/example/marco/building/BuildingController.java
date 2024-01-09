package com.example.marco.building;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/buildings")
public class BuildingController {
    
    private BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService inBuildingService){
        this.buildingService = inBuildingService;
    }

    @GetMapping
    public List<BuildingEntity> getAllBuildingEntity(){
        return this.buildingService.getAllBuildingEntity();
    }

    @GetMapping("{id}")
    public ResponseEntity<BuildingEntity> getBuildingEntityById(@PathVariable Long id) throws Exception{
        Optional<BuildingEntity> optBuildingEntity = this.buildingService.getBuildingEntityById(id);
        if(optBuildingEntity.isEmpty()){
            throw new Exception("BuildingEntity with id: " + id + " does not exist");
        } else {
            return ResponseEntity.ok().body(optBuildingEntity.get());
        }
    } 

    @PostMapping
    public ResponseEntity<BuildingEntity> addBuildingEntity(@RequestBody BuildingEntity buildingEntity) throws Exception{
        BuildingEntity retBuildingEnitity = this.buildingService.addBuildingEntity(buildingEntity);
        return ResponseEntity.ok().body(retBuildingEnitity);
    }

    @PutMapping("{id}")
    public ResponseEntity<BuildingEntity> replaceBuildingEntity(@PathVariable Long id, @RequestBody BuildingEntity inBuildingEntity) throws Exception{
        BuildingEntity retBuildingEntity = this.buildingService.replaceBuildingEntity(id, inBuildingEntity);
        return ResponseEntity.ok().body(retBuildingEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBuildingEntity(@PathVariable Long id) throws Exception{
    
        this.buildingService.deleteBuildingEntityById(id);
        return ResponseEntity.ok().body("Deleted BuildingEntity with id: " + id);
    }

}
