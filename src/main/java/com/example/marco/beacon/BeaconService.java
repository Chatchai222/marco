package com.example.marco.beacon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.floorbeacon.FloorBeaconRepository;

@Service
public class BeaconService {
    
    final private BeaconRepository beaconRepository;
    final private FloorBeaconRepository floorBeaconRepository;
    
    @Autowired
    public BeaconService(BeaconRepository inBeaconRepository, FloorBeaconRepository inFloorBeaconRepository){
        this.beaconRepository = inBeaconRepository;
        this.floorBeaconRepository = inFloorBeaconRepository;
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

    public List<BeaconEntity> getBeaconEntitiesByBeaconIdList(List<Long> inBeaconIdList) {
        List<BeaconEntity> beaconEntityList = new ArrayList<BeaconEntity>();
        for(Long beaconId: inBeaconIdList){
            Optional<BeaconEntity> optBeacon = this.beaconRepository.findById(beaconId);
            if(optBeacon.isEmpty()){
                continue;
            }
            beaconEntityList.add(optBeacon.get());
        }
        return beaconEntityList;
    }

    public List<BeaconEntity> getBeaconEntitiesByBeaconName(String nameString) {
        return this.beaconRepository.findByNameContaining(nameString);
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

    public BeaconEntity replaceBeaconEntity(BeaconEntity inBeaconEntity) throws Exception{
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
        
        if(!this.beaconRepository.existsById(inBeaconEntity.getBeaconId())){
            throw new Exception("reaplceBeaconEntity error: beacon with beaconId " + inBeaconEntity.getBeaconId() + " does not exist");
        }
        return this.beaconRepository.save(inBeaconEntity);
    }

    public void deleteBeaconEntityByBeaconId(Long inBeaconId){
        this.floorBeaconRepository.deleteByBeaconId(inBeaconId);
        this.beaconRepository.deleteById(inBeaconId);
    }

    public BeaconEntity getBeaconEntityByMacAddress(String inMacAddress) throws Exception{
        Optional<BeaconEntity> optBeacon = this.beaconRepository.findByMacAddress(inMacAddress);
        if(optBeacon.isEmpty()){
            throw new Exception("replaceBeaconEntity error: BeaconEntity with macAddress: " + inMacAddress + " does not exist");
        }
        return optBeacon.get();
    }

    public void deleteBeaconEntityByMacAddress(String inMacAddress){
        try {
            BeaconEntity beaconEntity = getBeaconEntityByMacAddress(inMacAddress);
            this.floorBeaconRepository.deleteByBeaconId(beaconEntity.getBeaconId());
        } catch (Exception e) {
            ;
        }
        this.beaconRepository.deleteByMacAddress(inMacAddress);
    }
}
