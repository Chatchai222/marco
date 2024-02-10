package com.example.marco.building;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.buildingfloor.BuildingFloorRepository;

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
    
    public BuildingEntity replaceBuildingEntity(BuildingEntity inBuildingEntity) throws Exception {
        if(inBuildingEntity.getBuildingId() == null){
            throw new Exception("replaceBuildingEntity error: buildingId is null");
        }
        if(inBuildingEntity.getName() == null){
            throw new Exception("replaceBuildingEntity error: name is null");
        }

        if(!buildingRepository.existsById(inBuildingEntity.getBuildingId())){
            throw new Exception("replaceBuildingEntity error: buildingId: " + inBuildingEntity.getBuildingId() + " does not exist");
        }
        return this.buildingRepository.save(inBuildingEntity);
    }

    public void deleteBuildingEntityById(Long id) throws Exception { 
        this.buildingRepository.deleteById(id);
        this.buildingFloorRepository.deleteByBuildingId(id);
    }
}
