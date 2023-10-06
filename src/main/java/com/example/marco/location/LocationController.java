package com.example.marco.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/location")
public class LocationController {

    private final LocationService location_service;
    
    @Autowired
    public LocationController(LocationService in_location_service){
        this.location_service = in_location_service;
    }

    @GetMapping("all")
    public List<Location> getAllLocation() {
        return location_service.getAllLocation();
    }

    @GetMapping("id")
    public Location getLocationById(@RequestParam(name = "id") Long location_id){
        return location_service.getLocationById(location_id);
    }

    @PostMapping
    public void addLocation(@RequestBody Location location){
        location_service.addLocation(location);
    }
    
    @DeleteMapping("id")
    public void deleteLocationById(@RequestParam(name = "id") Long location_id){
        location_service.deleteLocationById(location_id);
    }

    @PutMapping
    public void replaceLocation(@RequestBody Location location){
        location_service.replaceLocation(location);
    }
}
