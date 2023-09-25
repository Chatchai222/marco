package com.example.marco.location;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
    
    public List<Location> getAllLocation(){
        return List.of( new Location(1L, "ECC804", "Eighth floor", 34.23, 27) );
    }

}
