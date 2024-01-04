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
    
    public List<BeaconEntity> getAllBeaconEntities(){
        return this.beaconRepository.findAll();
    }

    public BeaconEntity getBeaconEntityByBeaconId(Long inBeaconId) throws Exception{
        Optional<BeaconEntity> optBeacon = this.beaconRepository.findById(inBeaconId);
        if(optBeacon.isEmpty()){
            throw new Exception("getBeaconEntityByBeaconId errro: BeaconEntity with beaconId: " + inBeaconId + " does not exist");
        }
        return optBeacon.get();
    }

}
