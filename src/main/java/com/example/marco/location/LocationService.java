package com.example.marco.location;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LocationService {

    private final LocationRepository location_repository;
    
    @Autowired
    public LocationService(LocationRepository in_location_repository){
        this.location_repository = in_location_repository;
    }

    public List<Location> getAllLocation(){
        return this.location_repository.findAll();
    }

    public Location getLocationById(Long location_id){
        Optional<Location> opt_location = this.location_repository.findById(location_id);
        if (!opt_location.isPresent()){
            throw new IllegalStateException("Location with id: " + location_id + " does not exist");
        }
        return opt_location.get();
    }

    public void addLocation(Location location) {
        this.location_repository.save(location);
    }

    public void deleteLocationById(Long location_id){
        boolean location_exist = this.location_repository.existsById(location_id);
        if (!location_exist){
            throw new IllegalStateException("Location with id: " + location_id + " does not exist");
        }
        this.location_repository.deleteById(location_id);
    }

    public void replaceLocation(Location in_location){
        if(in_location.getId() == null){
            throw new IllegalStateException("Id of location cannot be null");
        }
        if(!this.location_repository.existsById(in_location.getId())){
            throw new IllegalStateException("Id of location " + in_location.getId() + " does not exist");
        }
        this.location_repository.save(in_location);
    }

}
