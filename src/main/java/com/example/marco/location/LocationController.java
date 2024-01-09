package com.example.marco.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/locations")
public class LocationController {

    private final LocationService locationService;
    
    @Autowired
    public LocationController(LocationService inLocationService){
        this.locationService = inLocationService;
    }

    @GetMapping
    public List<LocationEntity> getAllLocation() {
        return locationService.getAllLocationEntity();
    }

    @GetMapping("/{locationId}")
    public LocationEntity getLocationById(@PathVariable("locationId") Long inLocationId) throws Exception{
        return locationService.getLocationEntityByLocationId(inLocationId);
    }

    @PostMapping
    public LocationEntity addLocation(@RequestBody LocationEntity location) throws Exception{
        return locationService.addLocationEntity(location);
    }

    @PutMapping("/{locationId}")
    public LocationEntity replaceLocation(@PathVariable("locationId") Long inLocationId, @RequestBody LocationEntity inLocationEntity) throws Exception{
        inLocationEntity.setLocationId(inLocationId);
        return locationService.replaceLocationEntity(inLocationEntity);
    }
    
    @DeleteMapping("/{locationId}")
    public void deleteLocationById(@PathVariable("locationId") Long locationId) throws Exception{
        locationService.deleteLocationEntityByLocationId(locationId);
    }
}