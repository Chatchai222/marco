package com.example.marco.beacon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeaconService {
    
    final private BeaconRepository beacon_repository;
    
    @Autowired
    public BeaconService(BeaconRepository in_beacon_repository){
        this.beacon_repository = in_beacon_repository;
    }
    
    public List<Beacon> getAllBeacon(){
        return this.beacon_repository.findAll();
    }
    
}
