package com.example.marco.location;

import java.util.List;

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

}
