package com.example.marco.buildingdirectory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.building.BuildingRepository;
import com.example.marco.floor.FloorRepository;

@Service
public class BuildingDirectoryService {
    
    private BuildingDirectoryRepository buildingDirectoryRepository;
    private BuildingRepository buildingRepository;
    private FloorRepository floorRepository;

    @Autowired
    public BuildingDirectoryService(BuildingDirectoryRepository inBuildingDirectoryRepository,
                                    BuildingRepository inBuildingRepository,
                                    FloorRepository inFloorRepository){
        this.buildingDirectoryRepository = inBuildingDirectoryRepository;
        this.buildingRepository = inBuildingRepository;
        this.floorRepository = inFloorRepository;
    }

    public List<BuildingDirectoryEntity> getAllBuildingDirectoryEntities(){
        return this.buildingDirectoryRepository.findAll();
    }

    public BuildingDirectoryEntity getBuildingDirectoryEntityByBuildingDirectoryId(Long inBuildingDirectoryId) throws Exception{
        Optional<BuildingDirectoryEntity> optBuildingDirectoryEntity = this.buildingDirectoryRepository.findById(inBuildingDirectoryId);
        if(optBuildingDirectoryEntity.isEmpty()){
            throw new Exception("getBuildingDirectoryEntityByBuildingDirectoryId error: BuildingDirectoryEntity.buildingDirectoryId = " + inBuildingDirectoryId + " does not exist");
        }
        return optBuildingDirectoryEntity.get();
    }

    public BuildingDirectoryEntity addBuildingDirectoryEntity(BuildingDirectoryEntity inBuildingDirectoryEntity) throws Exception{
        if(inBuildingDirectoryEntity.getBuildingDirectoryId() != null){
            throw new Exception("addBuildingDirectoryEntity error: Cannot have explicit buildingDirectoryId: " + inBuildingDirectoryEntity.getBuildingDirectoryId());
        }
        if(inBuildingDirectoryEntity.getBuildingId() == null){
            throw new Exception("addBuildingDirectoryEntity error: buildingId is null");
        }
        if(inBuildingDirectoryEntity.getFloorId() == null){
            throw new Exception("addBuildingDirectoryEntity error: floorId is null");
        }
        if(!this.buildingRepository.existsById(inBuildingDirectoryEntity.getBuildingId())){
            throw new Exception("addBuildingDirectoryEntity error: BuildingEntity with buildingId: " + inBuildingDirectoryEntity.getBuildingId() + " does not exist");
        }
        if(!this.floorRepository.existsById(inBuildingDirectoryEntity.getFloorId())){
            throw new Exception("addBuildingDirectoryEntity error: FloorEntity with floorId: " + inBuildingDirectoryEntity.getFloorId());
        }
        return this.buildingDirectoryRepository.save(inBuildingDirectoryEntity);
    }

    public BuildingDirectoryEntity replaceBuildingDirectoryEntityByBuildingDirectoryId(BuildingDirectoryEntity inBuildingDirectoryEntity) throws Exception{
        if(inBuildingDirectoryEntity.getBuildingDirectoryId() == null){
            throw new Exception("replaceBuildingDirectoryEntity error: buildingDirectoryId is null");
        }
        if(inBuildingDirectoryEntity.getBuildingId() == null){
            throw new Exception("replaceBuildingDirectoryEntity error: buildingId is null");
        }
        if(inBuildingDirectoryEntity.getFloorId() == null){
            throw new Exception("replaceBuildingDirectoryEntity error: floorId is null");
        }
        if(!this.buildingRepository.existsById(inBuildingDirectoryEntity.getBuildingId())){
            throw new Exception("replaceBuildingDirectoryEntity error: BuildingEntity with buildingId: " + inBuildingDirectoryEntity.getBuildingId() + " does not exist");
        }
        if(!this.floorRepository.existsById(inBuildingDirectoryEntity.getFloorId())){
            throw new Exception("replaceBuildingDirectoryEntity error: FloorEntity with floorId: " + inBuildingDirectoryEntity.getFloorId());
        }
        return this.buildingDirectoryRepository.save(inBuildingDirectoryEntity);
    }

    public void deleteBuildingDirectoryEntityByBuildingDirectoryId(Long inBuildingDirectoryId){
        this.buildingDirectoryRepository.deleteById(inBuildingDirectoryId);
    }

    public List<BuildingDirectoryEntity> getBuildingDirectoryEntitiesByBuildingId(Long inBuildingId){
        return this.buildingDirectoryRepository.findByBuildingId(inBuildingId);
    }

}
