package com.example.marco.location;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
