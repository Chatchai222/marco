package com.example.marco.location;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.floorlocation.FloorLocationRepository;


@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final FloorLocationRepository floorLocationRepository;
    
    @Autowired
    public LocationService(LocationRepository inLocationRepository, FloorLocationRepository inFloorLocationRepository){
        this.locationRepository = inLocationRepository;
        this.floorLocationRepository = inFloorLocationRepository;
    }

    public List<LocationEntity> getAllLocationEntity(){
        return this.locationRepository.findAll();
    }

    public LocationEntity getLocationEntityByLocationId(Long inLocationId) throws Exception{
        Optional<LocationEntity> locationOpt = this.locationRepository.findById(inLocationId);
        if(locationOpt.isEmpty()){
            throw new Exception("getLocationEntityByLocationId error: LocationEntity with locationId: " + inLocationId + " does not exist");
        }
        return locationOpt.get();
    }

    public LocationEntity addLocationEntity(LocationEntity inLocationEntity) throws Exception{
        if(inLocationEntity.getLocationId() != null){
            throw new Exception("addLocationEntity error: LocationEntity cannot have explicit locationId");
        }
        if(inLocationEntity.getName() == null){
            throw new Exception("addLocationEntity error: LocationEntity.name is null");
        }
        if(inLocationEntity.getGeoX() == null){
            throw new Exception("addLocationEntity error: LocationEntity.geoX is null");
        }
        if(inLocationEntity.getGeoY() == null){
            throw new Exception("addLocationEntity error: LocationEntity.geoY is null");
        }
        return this.locationRepository.save(inLocationEntity);
    }

    public LocationEntity replaceLocationEntity(LocationEntity inLocationEntity) throws Exception{
        if(inLocationEntity.getLocationId() == null){
            throw new Exception("replaceLocationEntity error: LocationEntity.locationId is null");
        }
        if(inLocationEntity.getName() == null){
            throw new Exception("replaceLocationEntity error: LocationEntity.name is null");
        }
        if(inLocationEntity.getGeoX() == null){
            throw new Exception("replaceLocationEntity error: LocationEntity.geoX is null");
        }
        if(inLocationEntity.getGeoY() == null){
            throw new Exception("replaceLocationEntity error: LocationEntity.geoY is null");
        }

        if(!locationRepository.existsById(inLocationEntity.getLocationId())){
            throw new Exception("replaceLocationEntity error: LocationEntity with locationId: " + inLocationEntity.getLocationId() + " does not exist");
        }
        return this.locationRepository.save(inLocationEntity);
    }

    public void deleteLocationEntityByLocationId(Long inLocationId){
        this.floorLocationRepository.deleteByLocationId(inLocationId);

        this.locationRepository.deleteById(inLocationId);
    }

}
