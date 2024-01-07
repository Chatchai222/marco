package com.example.marco.building;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.buildingdirectory.BuildingFloorRepository;

@Service
public class BuildingService {
    
    private BuildingRepository buildingRepository;
    private BuildingFloorRepository buildingFloorRepository;
    
    @Autowired
    public BuildingService(BuildingRepository inBuildingRepository, BuildingFloorRepository inBuildingFloorRepository){
        this.buildingRepository = inBuildingRepository;
        this.buildingFloorRepository = inBuildingFloorRepository;
    }

    public List<BuildingEntity> getAllBuildingEntity(){
        return this.buildingRepository.findAll();
    }

    public Optional<BuildingEntity> getBuildingEntityById(Long id) {
        return this.buildingRepository.findById(id);
    }
    
    public BuildingEntity addBuildingEntity(BuildingEntity inBuildingEntity) throws Exception {
        if(inBuildingEntity.getBuildingId() != null){
            throw new Exception("Add BuildingEntity must not have explicit buildingId " + inBuildingEntity.getBuildingId());
        }
        if(inBuildingEntity.getName() == null){
            throw new Exception("BuildingEntity must have a name");
        }

        return this.buildingRepository.save(inBuildingEntity);
    }
    
    public BuildingEntity replaceBuildingEntity(Long id, BuildingEntity inBuildingEntity) throws Exception {
        if(!buildingRepository.existsById(id)){
            throw new Exception("BuildingEntity with id: " + id + " does not exist");
        }
        if(inBuildingEntity.getName() == null){
            throw new Exception("BuildingEntity must have a name");
        }

        inBuildingEntity.setBuildingId(id);
        return this.buildingRepository.save(inBuildingEntity);
    }

    public void deleteBuildingEntityById(Long id) throws Exception { 
        this.buildingRepository.deleteById(id);
        this.buildingFloorRepository.deleteByBuildingId(id);
    }
}
