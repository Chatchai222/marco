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

    public BuildingDirectoryEntity upsertBuildingDirectoryEntity(BuildingDirectoryEntity inBuildingDirectoryEntity) throws Exception{
        if(inBuildingDirectoryEntity.getBuildingDirectoryId() != null){
            throw new Exception("upsertBuildingDirectoryEntity error: Cannot have explicit buildingDirectoryId: " + inBuildingDirectoryEntity.getBuildingDirectoryId());
        }
        if(inBuildingDirectoryEntity.getBuildingId() == null){
            throw new Exception("upsertBuildingDirectoryEntity error: buildingId is null");
        }
        if(inBuildingDirectoryEntity.getFloorId() == null){
            throw new Exception("upsertBuildingDirectoryEntity error: floorId is null");
        }
        
        if(!this.buildingRepository.existsById(inBuildingDirectoryEntity.getBuildingId())){
            throw new Exception("upsertBuildingDirectoryEntity error: BuildingEntity with buildingId: " + inBuildingDirectoryEntity.getBuildingId() + " does not exist");
        }
        if(!this.floorRepository.existsById(inBuildingDirectoryEntity.getFloorId())){
            throw new Exception("upsertBuildingDirectoryEntity error: FloorEntity with floorId: " + inBuildingDirectoryEntity.getFloorId() + " does not exist");
        }

        // this is f***ed but it works
        Optional<BuildingDirectoryEntity> optEntity = this.buildingDirectoryRepository
                                                          .findByFloorId(inBuildingDirectoryEntity.getFloorId());
        BuildingDirectoryEntity entityToSave = null;
        if(optEntity.isEmpty()){ // Insert new entity
            entityToSave = inBuildingDirectoryEntity;
        } else { // Update an existing entity ("assign b")
            entityToSave = optEntity.get();
            entityToSave.setBuildingId(inBuildingDirectoryEntity.getBuildingId());
        }
        return this.buildingDirectoryRepository.save(entityToSave);
        /* 
        
        if(optEntity.isEmpty()){ // Inserting new Entity
            entityToSave = new BuildingDirectoryEntity();
            entityToSave.setBuildingId(inBuildingDirectoryEntity.getBuildingId());
            entityToSave.setFloorId(inBuildingDirectoryEntity.getFloorId());
            return this.buildingDirectoryRepository.save(entityToSave);
        } else {
            BuildingDirectoryEntity retrievedEntity = optEntity.get();
            if(retrievedEntity.getBuildingId() == inBuildingDirectoryEntity.getBuildingId() &&
               retrievedEntity.getFloorId() == inBuildingDirectoryEntity.getFloorId()){ // InEntity == RetrievedEntity
                return retrievedEntity;
            } else { // InEntity != RetrievedEntity 
                throw new Exception("upsertBuildingDirectoryEntity error: Potential violate unique FloorId: " + inBuildingDirectoryEntity.getFloorId());
            }
        }
        */
    }
}
