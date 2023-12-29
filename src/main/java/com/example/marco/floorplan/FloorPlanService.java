package com.example.marco.floorplan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorPlanService {
    
    private FloorPlanRepository floorPlanRepository;

    @Autowired
    public FloorPlanService(FloorPlanRepository inFloorPlanRepository){
        this.floorPlanRepository = inFloorPlanRepository;
    }

    public List<FloorPlanEntity> getAllFloorPlanEntity(){
        return this.floorPlanRepository.findAll();
    }

    public FloorPlanEntity getFloorPlanEntityByFloorPlanId(Long inFloorPlanId) throws Exception{
        Optional<FloorPlanEntity> optFloorPlanEntity = this.floorPlanRepository.findById(inFloorPlanId);
        if(optFloorPlanEntity.isEmpty()){
            throw new Exception("Get FloorPlanEntityByFloorPlanId error: FloorPlanEntity with floorPlanId: " + inFloorPlanId + " does not exist");
        }
        return optFloorPlanEntity.get();
    }

    public FloorPlanEntity getFloorPlanEntityByFloorId(Long inFloorId) throws Exception{
        Optional<FloorPlanEntity> optFloorPlanEntity = this.floorPlanRepository.findByFloorId(inFloorId);
        if(optFloorPlanEntity.isEmpty()){
            throw new Exception("Get FloorPlanEntityByFloorId error: FloorPlanEntity with floorId: " + inFloorId + " does not exist");
        }
        return optFloorPlanEntity.get();
    }

    public FloorPlanEntity addFloorPlanEntity(FloorPlanEntity inFloorPlanEntity) throws Exception{
        if(inFloorPlanEntity.getFloorPlanId() != null){
            throw new Exception("Add FloorPlanEntity error: Cannot have explicit floorPlanId: " + inFloorPlanEntity.getFloorPlanId());
        }
        if(inFloorPlanEntity.getFloorId() == null){
            throw new Exception("Add FloorPlanEntity error: floorId is null");
        }
        if(inFloorPlanEntity.getFileId() == null){
            throw new Exception("Add FloorPlanEntity error: fileId is null");
        }
        return this.floorPlanRepository.save(inFloorPlanEntity);
    }

    public FloorPlanEntity replaceFloorPlanEntity(Long inId, FloorPlanEntity inFloorPlanEntity) throws Exception{
        if(!this.floorPlanRepository.existsById(inId)){
            throw new Exception("Replace FloorPlanEntity error: FloorPlanEntity with floorPlanId: " + inId + " does not exist");
        }
        if(inFloorPlanEntity.getFloorId() == null){
            throw new Exception("Replace FloorPlanEntity error: floorId is null");
        }
        if(inFloorPlanEntity.getFileId() == null){
            throw new Exception("Replace FloorPlanEntity error: fileId is null");
        }
        inFloorPlanEntity.setFloorPlanId(inId);
        return this.floorPlanRepository.save(inFloorPlanEntity);
    }

    public void deleteFloorPlanEntityById(Long inId) throws Exception{
        if(!this.floorPlanRepository.existsById(inId)){
            throw new Exception("Delete FloorPlanEntity error: floorPlanId: " + inId + " does not exist");
        }
        this.floorPlanRepository.deleteById(inId);
    }

}
