package com.example.marco.buildingfloor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.building.BuildingRepository;
import com.example.marco.floor.FloorRepository;

@Service
public class BuildingFloorService {
    
    private BuildingFloorRepository buildingFloorRepository;
    private BuildingRepository buildingRepository;
    private FloorRepository floorRepository;

    @Autowired
    public BuildingFloorService(BuildingFloorRepository inBuildingFloorRepository,
                                    BuildingRepository inBuildingRepository,
                                    FloorRepository inFloorRepository){
        this.buildingFloorRepository = inBuildingFloorRepository;
        this.buildingRepository = inBuildingRepository;
        this.floorRepository = inFloorRepository;
    }

    public List<BuildingFloorEntity> getAllBuildingFloorEntities(){
        return this.buildingFloorRepository.findAll();
    }

    public BuildingFloorEntity addBuildingFloorEntity(BuildingFloorEntity inBuildingFloorEntity) throws Exception{
        if(inBuildingFloorEntity.getBuildingFloorId() != null){
            throw new Exception("addBuildingFloorEntity error: Cannot have explicit buildingFloorId: " + inBuildingFloorEntity.getBuildingFloorId());
        }
        if(inBuildingFloorEntity.getBuildingId() == null){
            throw new Exception("addBuildingFloorEntity error: buildingId is null");
        }
        if(inBuildingFloorEntity.getFloorId() == null){
            throw new Exception("addBuildingFloorEntity error: floorId is null");
        }
        
        if(!this.buildingRepository.existsById(inBuildingFloorEntity.getBuildingId())){
            throw new Exception("addBuildingFloorEntity error: BuildingEntity with buildingId: " + inBuildingFloorEntity.getBuildingId() + " does not exist");
        }
        if(!this.floorRepository.existsById(inBuildingFloorEntity.getFloorId())){
            throw new Exception("addBuildingFloorEntity error: FloorEntity with floorId: " + inBuildingFloorEntity.getFloorId() + " does not exist");
        }

        return this.buildingFloorRepository.save(inBuildingFloorEntity);
    }

    public BuildingFloorEntity getBuildingFloorEntityByFloorId(Long inFloorId) throws Exception{
        Optional<BuildingFloorEntity> optEntity = this.buildingFloorRepository.findByFloorId(inFloorId);
        if(optEntity.isEmpty()){
            throw new Exception("getBuildingFloorEntityByFloorId error: buildingFloorEntity with floorId: " + inFloorId + " does not exist");
        }
        return optEntity.get(); 
    }

    public void deleteBuildingFloorEntityByFloorId(Long inFloorId){
        this.buildingFloorRepository.deleteByFloorId(inFloorId);
    }

    public List<BuildingFloorEntity> getBuildingFloorEntitiesByBuildingId(Long inBuildingId){
        return this.buildingFloorRepository.findByBuildingId(inBuildingId);
    }

    public void deleteBuildingFloorEntitiesByBuildingId(Long inBuildingId){
        this.buildingFloorRepository.deleteByBuildingId(inBuildingId);
    }

}
