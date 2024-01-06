package com.example.marco.floorbeacon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.beacon.BeaconRepository;
import com.example.marco.floor.FloorRepository;

@Service
public class FloorBeaconService {
    
    private FloorBeaconRepository floorBeaconRepository;
    private FloorRepository floorRepository;
    private BeaconRepository beaconRepository;

    @Autowired
    public FloorBeaconService(FloorBeaconRepository inFloorBeaconRepository,
                              FloorRepository inFloorRepository,
                              BeaconRepository inBeaconRepository){
        this.floorBeaconRepository = inFloorBeaconRepository;
        this.floorRepository = inFloorRepository;
        this.beaconRepository = inBeaconRepository;
    }

    public List<FloorBeaconEntity> getAllFloorBeaconEntities(){
        return this.floorBeaconRepository.findAll();
    }

    public FloorBeaconEntity upsertFloorBeaconEntity(FloorBeaconEntity inFloorBeaconEntity) throws Exception{
        if(inFloorBeaconEntity.getFloorBeaconId() != null){
            throw new Exception("upsertFloorBeaconEntity error: Cannot have explicit floorBeaconId: " + floorBeaconRepository);
        }
        if(inFloorBeaconEntity.getFloorId() == null){
            throw new Exception("upsertFloorBeaconEntity error: floorId is null");
        }
        if(inFloorBeaconEntity.getBeaconId() == null){
            throw new Exception("upsertFloorBeaconEntity error: beaconId is null");
        }

        if(!this.floorRepository.existsById(inFloorBeaconEntity.getFloorId())){
            throw new Exception("upsertFloorBeaconEntity error; FloorEntity with floorId: " + inFloorBeaconEntity.getFloorId() + " does not exist");
        }
        if(!this.beaconRepository.existsById(inFloorBeaconEntity.getBeaconId())){
            throw new Exception("upsertFloorBeaconEntity error: BeaconEntity with beaconId: " + inFloorBeaconEntity.getFloorId() + " does not exist");
        }
        
        // This part is f***ed up but it works
        Optional<FloorBeaconEntity> optEntity = this.floorBeaconRepository.findByBeaconId(inFloorBeaconEntity.getBeaconId());
        FloorBeaconEntity entityToSave = null;
        if(optEntity.isEmpty()){ // insert new entity
            entityToSave = inFloorBeaconEntity;
        } else { // update old entity
            entityToSave = optEntity.get();
            entityToSave.setFloorId(inFloorBeaconEntity.getFloorId());
        }
        return this.floorBeaconRepository.save(inFloorBeaconEntity);
    }

    public FloorBeaconEntity getFloorBeaconEntityByBeaconId(Long inBeaconId) throws Exception{
        Optional<FloorBeaconEntity> optEntity = this.floorBeaconRepository.findByBeaconId(inBeaconId);
        if(optEntity.isEmpty()){
            throw new Exception("getFloorBeaconEntityByBeaconId error: FloorBeaconEntity with beaconId: " + " does not exist");
        }
        return optEntity.get();
    }

    public void deleteFloorBeaconEntityByBeaconId(Long inBeaconId){
        this.floorBeaconRepository.deleteByBeaconId(inBeaconId);
    }

    public List<FloorBeaconEntity> getFloorBeaconEntitiesByFloorId(Long inFloorId){
        return this.floorBeaconRepository.findByFloorId(inFloorId);
    }

    public void deleteFloorBeaconEntitiesByFloorId(Long inFloorId){
        this.floorBeaconRepository.deleteByFloorId(inFloorId);
    }
}
