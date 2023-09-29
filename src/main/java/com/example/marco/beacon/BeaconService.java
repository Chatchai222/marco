package com.example.marco.beacon;

import java.util.List;
import java.util.Optional;

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

    public Beacon getBeaconById(Long beacon_id){
        Optional<Beacon> beacon_optional = this.beacon_repository.findById(beacon_id);
        if (!beacon_optional.isPresent()){
            throw new IllegalStateException("Beacon with id: " + beacon_id + " does not exist");
        }
        return beacon_optional.get();
    }

    public Beacon getBeaconByMacAddress(String mac_address){
        Optional<Beacon> beacon_optional = this.beacon_repository.findByMacAddress(mac_address);
        if (!beacon_optional.isPresent()){
            throw new IllegalStateException("Beacon with mac address: " + mac_address + " does not exist");
        }
        return beacon_optional.get();
    }
    
}
