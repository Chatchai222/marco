package com.example.marco.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/location")
public class LocationController {

    private final LocationService locationService;
    
    @Autowired
    public LocationController(LocationService in_location_service){
        this.locationService = in_location_service;
    }

    @GetMapping
    public List<Location> getAllLocation() {
        return locationService.getAllLocation();
    }

    @GetMapping("/{location_id}")
    public Location getLocationById(@PathVariable Long location_id){
        return locationService.getLocationById(location_id);
    }
}
