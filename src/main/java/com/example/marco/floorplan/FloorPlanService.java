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

    public FloorPlanEntity replaceFloorPlanEntityByFloorPlanId(Long inFloorPlanId, FloorPlanEntity inFloorPlanEntity) throws Exception{
        if(!this.floorPlanRepository.existsById(inFloorPlanId)){
            throw new Exception("Replace FloorPlanEntity error: FloorPlanEntity with floorPlanId: " + inFloorPlanId + " does not exist");
        }
        if(inFloorPlanEntity.getFloorId() == null){
            throw new Exception("Replace FloorPlanEntity error: floorId is null");
        }
        if(inFloorPlanEntity.getFileId() == null){
            throw new Exception("Replace FloorPlanEntity error: fileId is null");
        }
        inFloorPlanEntity.setFloorPlanId(inFloorPlanId);
        return this.floorPlanRepository.save(inFloorPlanEntity);
    }

    public FloorPlanEntity replaceFloorPlanEntityByFloorId(FloorPlanEntity inFloorPlanEntity) throws Exception{
        Optional<FloorPlanEntity> optFloorPlanEntity = this.floorPlanRepository.findByFloorId(inFloorPlanEntity.getFloorId());
        if(optFloorPlanEntity.isEmpty()){
            throw new Exception("Replace FloorPlanEntityByFloorId error: FloorPlanEntity with floorId: " + inFloorPlanEntity.getFloorId() + " does not exist");
        }
        if(inFloorPlanEntity.getFloorId() == null){
            throw new Exception("Replace FloorPlanEntityByFloorId error: floorId is null");
        }
        if(inFloorPlanEntity.getFileId() == null){
            throw new Exception("Replace FloorPlanEntityByFloorId error: fileId is null");
        }
        FloorPlanEntity retrievedFloorPlanEntity = optFloorPlanEntity.get();
        retrievedFloorPlanEntity.setFloorId(inFloorPlanEntity.getFloorId());
        retrievedFloorPlanEntity.setFileId(inFloorPlanEntity.getFileId());
        return this.floorPlanRepository.save(retrievedFloorPlanEntity);
    }

    public void deleteFloorPlanEntityByFloorPlanId(Long inFloorPlanId) throws Exception{
        if(!this.floorPlanRepository.existsById(inFloorPlanId)){
            throw new Exception("Delete FloorPlanEntity error: floorPlanId: " + inFloorPlanId + " does not exist");
        }
        this.floorPlanRepository.deleteById(inFloorPlanId);
    }

    public void deleteFloorPlanEntityByFloorId(Long inFloorId) throws Exception{
        if(!this.floorPlanRepository.existsByFloorId(inFloorId)){
            throw new Exception("Delete FloorPlanEntityByFloorId error: floorId: " + inFloorId + " does not exist");
        }
        this.floorPlanRepository.deleteByFloorId(inFloorId);
    }   
}
