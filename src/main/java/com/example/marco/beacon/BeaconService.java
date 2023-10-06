package com.example.marco.beacon;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeaconService {
    
    final private BeaconRepository beaconRepository;
    
    @Autowired
    public BeaconService(BeaconRepository beaconRepository){
        this.beaconRepository = beaconRepository;
    }
    
    public List<Beacon> getAllBeacon(){
        return this.beaconRepository.findAll();
    }

    public Beacon getBeaconById(Long beaconId){
        Optional<Beacon> beaconOpt = this.beaconRepository.findById(beaconId);
        if (!beaconOpt.isPresent()){
            throw new IllegalStateException("Beacon with id: " + beaconId + " does not exist");
        }
        return beaconOpt.get();
    }

    public Beacon getBeaconByMacAddress(String macAddress){
        Optional<Beacon> beaconOpt = this.beaconRepository.findByMacAddress(macAddress);
        if (!beaconOpt.isPresent()){
            throw new IllegalStateException("Beacon with mac address: " + macAddress + " does not exist");
        }
        return beaconOpt.get();
    }

    public void addBeacon(Beacon beacon){
        if(beacon.isAnyNonIdAttributeNull()){
            throw new IllegalStateException("Cannot add beacon, the following attribute " + beacon.getNullAttributes() + " is null");
        }

        Optional<Beacon> beaconOpt = this.beaconRepository.findByMacAddress(beacon.getMacAddress());
        if(beaconOpt.isPresent()){
            throw new IllegalStateException("beacon with mac address " + beacon.getMacAddress() + " already exists");
        }
        this.beaconRepository.save(beacon);
    }

    public void deleteBeaconById(Long beaconId) {
        Boolean exists = this.beaconRepository.existsById(beaconId);
        if(!exists){
            throw new IllegalStateException("beacon with id " + beaconId + " does not exist");
        }
        this.beaconRepository.deleteById(beaconId);
    }
    
}
