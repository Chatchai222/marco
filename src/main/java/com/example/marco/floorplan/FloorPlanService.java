package com.example.marco.floorplan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.file.FileRepository;
import com.example.marco.floor.FloorRepository;

@Service
public class FloorPlanService {
    
    private FloorPlanRepository floorPlanRepository;
    private FloorRepository floorRepository;
    private FileRepository fileRepository;

    @Autowired
    public FloorPlanService(FloorPlanRepository inFloorPlanRepository,
                            FloorRepository inFloorRepository,
                            FileRepository inFileRepository){
        this.floorPlanRepository = inFloorPlanRepository;
        this.floorRepository = inFloorRepository;
        this.fileRepository = inFileRepository;
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
        if(!this.floorRepository.existsById(inFloorPlanEntity.getFloorId())){
            throw new Exception("Add FloorPlanEntity error: FloorEntity with floorId: " + inFloorPlanEntity.getFloorId() + " does not exist");
        }
        if(!this.fileRepository.existsById(inFloorPlanEntity.getFileId())){
            throw new Exception("Add FloorPlanEntity error: FileEntity with fileId: " + inFloorPlanEntity.getFileId() + " does not exist");
        }
        return this.floorPlanRepository.save(inFloorPlanEntity);
    }

    public FloorPlanEntity replaceFloorPlanEntityByFloorPlanId(Long inFloorPlanId, FloorPlanEntity inFloorPlanEntity) throws Exception{
        if(!this.floorPlanRepository.existsById(inFloorPlanId)){
            throw new Exception("replaceFloorPlanEntityByFloorPlanId error: FloorPlanEntity with floorPlanId: " + inFloorPlanId + " does not exist");
        }
        if(inFloorPlanEntity.getFloorId() == null){
            throw new Exception("replaceFloorPlanEntityByFloorPlanId  error: floorId is null");
        }
        if(inFloorPlanEntity.getFileId() == null){
            throw new Exception("replaceFloorPlanEntityByFloorPlanId  error: fileId is null");
        }
        if(!this.floorRepository.existsById(inFloorPlanEntity.getFloorId())){
            throw new Exception("replaceFloorPlanEntityByFloorPlanId  error: FloorEntity with floorId: " + inFloorPlanEntity.getFloorId() + " does not exist");
        }
        if(!this.fileRepository.existsById(inFloorPlanEntity.getFileId())){
            throw new Exception("replaceFloorPlanEntityByFloorPlanId  error: FileEntity with fileId: " + inFloorPlanEntity.getFileId() + " does not exist");
        }
        inFloorPlanEntity.setFloorPlanId(inFloorPlanId);
        return this.floorPlanRepository.save(inFloorPlanEntity);
    }

    public FloorPlanEntity replaceFloorPlanEntityByFloorId(FloorPlanEntity inFloorPlanEntity) throws Exception{
        Optional<FloorPlanEntity> optFloorPlanEntity = this.floorPlanRepository.findByFloorId(inFloorPlanEntity.getFloorId());
        if(inFloorPlanEntity.getFloorId() == null){
            throw new Exception("replaceFloorPlanEntityByFloorId error: floorId is null");
        }
        if(inFloorPlanEntity.getFileId() == null){
            throw new Exception("replaceFloorPlanEntityByFloorId error: fileId is null");
        }
        if(!this.floorRepository.existsById(inFloorPlanEntity.getFloorId())){
            throw new Exception("replaceFloorPlanEntityByFloorId  error: FloorEntity with floorId: " + inFloorPlanEntity.getFloorId() + " does not exist");
        }
        if(!this.fileRepository.existsById(inFloorPlanEntity.getFileId())){
            throw new Exception("replaceFloorPlanEntityByFloorId  error: FileEntity with fileId: " + inFloorPlanEntity.getFileId() + " does not exist");
        }
        FloorPlanEntity retrievedFloorPlanEntity = optFloorPlanEntity.get();
        retrievedFloorPlanEntity.setFloorId(inFloorPlanEntity.getFloorId());
        retrievedFloorPlanEntity.setFileId(inFloorPlanEntity.getFileId());
        return this.floorPlanRepository.save(retrievedFloorPlanEntity);
    }

    public void deleteFloorPlanEntityByFloorPlanId(Long inFloorPlanId) throws Exception{
        this.floorPlanRepository.deleteById(inFloorPlanId);
    }

    public void deleteFloorPlanEntityByFloorId(Long inFloorId) throws Exception{
        this.floorPlanRepository.deleteByFloorId(inFloorId);
    }   
}
