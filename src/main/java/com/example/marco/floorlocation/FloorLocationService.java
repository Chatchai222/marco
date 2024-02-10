package com.example.marco.floorlocation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.floor.FloorRepository;
import com.example.marco.location.LocationRepository;

@Service
public class FloorLocationService {
    
    private FloorLocationRepository floorLocationRepository;
    private FloorRepository floorRepository;
    private LocationRepository locationRepository;

    @Autowired
    public FloorLocationService(FloorLocationRepository inFloorLocationRepository,
                                FloorRepository inFloorRepository,
                                LocationRepository inLocationRepository){
        this.floorLocationRepository = inFloorLocationRepository;
        this.floorRepository = inFloorRepository;
        this.locationRepository = inLocationRepository;
    }

    public List<FloorLocationEntity> getAllFloorLocationEntities(){
        return this.floorLocationRepository.findAll();
    }

    public FloorLocationEntity addFloorLocationEntity(FloorLocationEntity inFloorLocationEntity) throws Exception{
        if(inFloorLocationEntity.getFloorLocationId() != null){
            throw new Exception("addFloorLocationEntity error: Cannot have explicit floorLocationId: " + inFloorLocationEntity.getFloorLocationId());
        }
        if(inFloorLocationEntity.getFloorId() == null){
            throw new Exception("addFloorLocationEntity error: floorId is null");
        }
        if(inFloorLocationEntity.getLocationId() == null){
            throw new Exception("addFloorLocationEntity error: locationId is null");
        }

        if(!this.floorRepository.existsById(inFloorLocationEntity.getFloorId())){
            throw new Exception("addFloorLocationEntity error: FloorEntity with floorId: " + inFloorLocationEntity.getFloorId() + " does not exist");
        }
        if(!this.locationRepository.existsById(inFloorLocationEntity.getLocationId())){
            throw new Exception("addFloorLocationEntity error: LocationEntity with locationId: " + inFloorLocationEntity.getLocationId() + " does not exist");
        }

        return this.floorLocationRepository.save(inFloorLocationEntity);
    }

    public FloorLocationEntity getFloorLocationEntityByLocationId(Long inLocationId) throws Exception{
        Optional<FloorLocationEntity> optEntity = this.floorLocationRepository.findByLocationId(inLocationId);
        if(optEntity.isEmpty()){
            throw new Exception("getFloorLocationEntityByLocationId error: FloorLocationEntity with locationId: " + inLocationId + " does not exist");
        }
        return optEntity.get();
    }

    public void deleteFloorLocationEntityByLocationId(Long inLocationId) throws Exception{
        this.floorLocationRepository.deleteByLocationId(inLocationId);
    }

    public List<FloorLocationEntity> getFloorLocationEntitiesByFloorId(Long inFloorId){
        return this.floorLocationRepository.findByFloorId(inFloorId);
    }

    public void deleteFloorLocationEntitiesByFloorId(Long inFloorId){
        this.floorLocationRepository.deleteByFloorId(inFloorId);
    }
}
