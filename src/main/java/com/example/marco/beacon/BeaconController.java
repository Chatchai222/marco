package com.example.marco.beacon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/beacon")
public class BeaconController {
    
    final private BeaconService beacon_service;

    @Autowired
    public BeaconController(BeaconService in_beacon_service){
        this.beacon_service = in_beacon_service;
    }

    @GetMapping
    public List<Beacon> getAllBeacon(){
        return this.beacon_service.getAllBeacon();
    }

}
