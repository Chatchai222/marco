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

    public BeaconEntity addBeaconEntity(BeaconEntity inBeaconEntity) throws Exception{
        if(inBeaconEntity.getBeaconId() != null){
            throw new Exception("addBeaconEntity error: BeaconEntity cannot have explicit beaconId: " + inBeaconEntity.getBeaconId());
        }
        if(inBeaconEntity.getName() == null){
            throw new Exception("addBeaconEntity error: name is null");
        }
        if(inBeaconEntity.getGeoX() == null){
            throw new Exception("addBeaconEntity error: geoX is null");
        }
        if(inBeaconEntity.getGeoY() == null){
            throw new Exception("addBeaconEntity error: geoY is null");
        }
        if(inBeaconEntity.getMacAddress() == null){
            throw new Exception("addBeaconEntity error: macAddress is null");
        }

        Optional<BeaconEntity> optBeacon = this.beaconRepository.findByMacAddress(inBeaconEntity.getMacAddress());
        if(optBeacon.isPresent()){
            throw new Exception("addBeaconEntity error: beacon with macAddress: " + inBeaconEntity.getMacAddress() + " already exist");
        }
        return this.beaconRepository.save(inBeaconEntity);
    }

    public BeaconEntity resertBeaconEntity(BeaconEntity inBeaconEntity) throws Exception{
        if(inBeaconEntity.getBeaconId() == null){
            throw new Exception("replaceBeaconEntity error: beaconId is null");
        }
        if(inBeaconEntity.getName() == null){
            throw new Exception("replaceBeaconEntity error: name is null");
        }
        if(inBeaconEntity.getGeoX() == null){
            throw new Exception("replaceBeaconEntity error: geoX is null");
        }
        if(inBeaconEntity.getGeoY() == null){
            throw new Exception("replaceBeaconEntity error: geoY is null");
        }
        if(inBeaconEntity.getMacAddress() == null){
            throw new Exception("replaceBeaconEntity error: macAddress is null");
        }
        
        return this.beaconRepository.save(inBeaconEntity);
    }

    public void deleteBeaconEntityByBeaconId(Long inBeaconId){
        this.beaconRepository.deleteById(inBeaconId);
    }
}
