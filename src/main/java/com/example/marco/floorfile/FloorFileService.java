package com.example.marco.floorfile;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marco.file.FileRepository;
import com.example.marco.floor.FloorRepository;

@Service
public class FloorFileService {
    
    private FloorFileRepository floorFileRepository;
    private FloorRepository floorRepository;
    private FileRepository fileRepository;

    @Autowired
    public FloorFileService(FloorFileRepository inFloorFileRepository,
                            FloorRepository inFloorRepository,
                            FileRepository inFileRepository) {
        this.floorFileRepository = inFloorFileRepository;
        this.floorRepository = inFloorRepository;
        this.fileRepository = inFileRepository;
    }

    public List<FloorFileEntity> getAllFloorFileEntities(){
        return this.floorFileRepository.findAll();
    }

    public FloorFileEntity insertFloorFileEntity(FloorFileEntity inFloorFileEntity) throws Exception{
        if(inFloorFileEntity.getFloorFileId() != null){
            throw new Exception("insertFloorFileEntity error: Cannot have explicit floorFileId: " + inFloorFileEntity.getFloorFileId());
        }
        if(inFloorFileEntity.getFloorId() == null){
            throw new Exception("insertFloorFileEntity error: floorId is null");
        }
        if(inFloorFileEntity.getFileId() == null){
            throw new Exception("insertFloorFileEntity error: fileId is null");
        }

        if(!this.floorRepository.existsById(inFloorFileEntity.getFloorId())){
            throw new Exception("insertFloorFileEntity error: FloorEntity with floorId: " + inFloorFileEntity.getFloorId() + " does not exist");
        }
        if(!this.fileRepository.existsById(inFloorFileEntity.getFileId())){
            throw new Exception("insertFloorFileEntity error: FileEntity with fileId: " + inFloorFileEntity.getFileId() + " does not exist");
        }
        
        return this.floorFileRepository.save(inFloorFileEntity);
    }

    public FloorFileEntity getFloorFileEntityByFloorId(Long inFloorId) throws Exception{
        Optional<FloorFileEntity> optEntity = this.floorFileRepository.findByFloorId(inFloorId);
        if(optEntity.isEmpty()){
            throw new Exception("getFloorFileEntityByFloorId error: FloorFileEntity with floorId: " + inFloorId + " does not exist");
        }
        return optEntity.get();
    }

    public void deleteFloorFileEntityByFloorId(Long inFloorId){
        this.floorFileRepository.deleteByFloorId(inFloorId);
    }

    public FloorFileEntity getFloorFileEntityByFileId(Long inFileId) throws Exception{
        Optional<FloorFileEntity> optEntity = this.floorFileRepository.findByFileId(inFileId);
        if(optEntity.isEmpty()){
            throw new Exception("getFloorFileEntityByFileId errro: FloorFileEntity with fileId: " + inFileId + " does not exist");
        }
        return optEntity.get();
    }

    public void deleteFloorFileEntityByFileId(Long inFileId){
        this.floorFileRepository.deleteByFileId(inFileId);
    }
}
