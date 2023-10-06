package com.example.marco.location;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LocationService {

    private final LocationRepository locationRepository;
    
    @Autowired
    public LocationService(LocationRepository inLocationRepository){
        this.locationRepository = inLocationRepository;
    }

    public List<Location> getAllLocation(){
        return this.locationRepository.findAll();
    }

    public Location getLocationById(Long locationId){
        Optional<Location> locationOpt = this.locationRepository.findById(locationId);
        if (!locationOpt.isPresent()){
            throw new IllegalStateException("Location with id: " + locationId + " does not exist");
        }
        return locationOpt.get();
    }

    public void addLocation(Location location) {
        this.locationRepository.save(location);
    }

    public void deleteLocationById(Long locationId){
        boolean locationExist = this.locationRepository.existsById(locationId);
        if (!locationExist){
            throw new IllegalStateException("Location with id: " + locationId + " does not exist");
        }
        this.locationRepository.deleteById(locationId);
    }

    public void replaceLocation(Location inLocation){
        if(inLocation.getId() == null){
            throw new IllegalStateException("Id of location cannot be null");
        }
        if(!this.locationRepository.existsById(inLocation.getId())){
            throw new IllegalStateException("Id of location " + inLocation.getId() + " does not exist");
        }
        this.locationRepository.save(inLocation);
    }

}
