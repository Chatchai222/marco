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

    private final LocationService locationService;
    
    @Autowired
    public LocationController(LocationService inLocationService){
        this.locationService = inLocationService;
    }

    @GetMapping("all")
    public List<Location> getAllLocation() {
        return locationService.getAllLocation();
    }

    @GetMapping("id")
    public Location getLocationById(@RequestParam(name = "id") Long locationId){
        return locationService.getLocationById(locationId);
    }

    @PostMapping
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }
    
    @DeleteMapping("id")
    public void deleteLocationById(@RequestParam(name = "id") Long locationId){
        locationService.deleteLocationById(locationId);
    }

    @PutMapping
    public void replaceLocation(@RequestBody Location location){
        locationService.replaceLocation(location);
    }
}
