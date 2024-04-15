package com.example.marco.floor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.floorbeacon.FloorBeaconRepository;
import com.example.marco.floorfile.FloorFileRepository;

@Service
public class FloorService {
    
    private final FloorRepository floorRepository;
    private final FloorBeaconRepository floorBeaconRepository;
    private final FloorFileRepository floorFileRepository;

    @Autowired
    public FloorService(FloorRepository inFloorRepository,
                        FloorBeaconRepository inFloorBeaconRepository,
                        FloorFileRepository inFloorFileRepository){
        this.floorRepository = inFloorRepository;
        this.floorBeaconRepository = inFloorBeaconRepository;
        this.floorFileRepository = inFloorFileRepository;
    }

    public List<FloorEntity> getAllFloorEntity(){
        return this.floorRepository.findAll();
    }

    public FloorEntity getFloorEntityByFloorId(Long inFloorId) throws Exception{
        Optional<FloorEntity> floorOpt = this.floorRepository.findById(inFloorId);
        if(floorOpt.isEmpty()){
            throw new Exception("Floor with id:" + inFloorId + " does not exist");
        }
        return floorOpt.get();
    }

    public FloorEntity addFloorEntity(FloorEntity inFloorEntity) throws Exception{
        if(inFloorEntity.getFloorId() != null){
            throw new Exception("FloorEntity cannot have explicit floorId: " + inFloorEntity.getFloorId());
        }
        if(inFloorEntity.getName() == null){
            throw new Exception("FloorEntity field name is null");
        }
        if(inFloorEntity.getGeoLength() == null){
            throw new Exception("FloorEntity field geoLength is null");
        }
        if(inFloorEntity.getGeoWidth() == null){
            throw new Exception("FloorEntity field geoWidth is null");
        }
        if(inFloorEntity.getAzimuth() == null){
            throw new Exception("FloorEntity field azimuth is null");
        }
        if(inFloorEntity.getLevel() == null){
            throw new Exception("FloorEntity field level is null");
        }
        FloorEntity floorToReturn = this.floorRepository.save(inFloorEntity);
        return floorToReturn;
    }

    public FloorEntity replaceFloorEntity(FloorEntity inFloorEntity) throws Exception{
        if(inFloorEntity.getFloorId() == null){
            throw new Exception("replaceFloorEntity error: FloorEntity.floorId is null");
        }
        if(inFloorEntity.getName() == null){
            throw new Exception("replaceFloorEntity error: FloorEntity.name is null");
        }
        if(inFloorEntity.getGeoLength() == null){
            throw new Exception("replaceFloorEntity error: FloorEntity.geoLength is null");
        }
        if(inFloorEntity.getGeoWidth() == null){
            throw new Exception("replaceFloorEntity error: FloorEntity.geoWidth is null");
        }
        if(inFloorEntity.getAzimuth() == null){
            throw new Exception("replaceFloorEntity error: FloorEntity.azimuth is null");
        }
        if(inFloorEntity.getLevel() == null){
            throw new Exception("replaceFloorEntity error: FloorEntity.level is null");
        }

        if(!floorRepository.existsById(inFloorEntity.getFloorId())){
            throw new Exception("replaceFloorEntity error: FloorEntity.floorId " + inFloorEntity.getFloorId() + " does not exist");
        }
        return this.floorRepository.save(inFloorEntity);
    }

    public void deleteFloorEntityByFloorId(Long inFloorId) throws Exception{
        this.floorBeaconRepository.deleteByFloorId(inFloorId);
        this.floorFileRepository.deleteByFloorId(inFloorId);

        this.floorRepository.deleteById(inFloorId);
    }

}
