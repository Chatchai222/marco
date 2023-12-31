package com.example.marco.floor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorService {
    
    private final FloorRepository floorRepository;

    @Autowired
    public FloorService(FloorRepository inFloorRepository){
        this.floorRepository = inFloorRepository;
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
            throw new Exception("addFloorEntity error: FloorEntity cannot have explicit floorId: " + inFloorEntity.getFloorId());
        }
        if(inFloorEntity.getName() == null){
            throw new Exception("addFloorEntity error: FloorEntity.name is null");
        }
        if(inFloorEntity.getGeoLength() == null){
            throw new Exception("addFloorEntity error: FloorEntity.geoLength is null");
        }
        if(inFloorEntity.getGeoWidth() == null){
            throw new Exception("addFloorEntity error: FloorEntity.geoWidth is null");
        }
        if(inFloorEntity.getAzimuth() == null){
            throw new Exception("addFloorEntity error: FloorEntity.azimuth is null");
        }
        return this.floorRepository.save(inFloorEntity);
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
        return this.floorRepository.save(inFloorEntity);
    }

    public void deleteFloorById(Long inFloorId) throws Exception{
        if(!floorRepository.existsById(inFloorId)){
            throw new Exception("deleteFloorEntity error:  FloorEntity with floorId: " + inFloorId + " does not exist");
        }
        this.floorRepository.deleteById(inFloorId);
    }

}
