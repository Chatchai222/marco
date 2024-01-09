package com.example.marco.floorfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/floor-files")
public class FloorFileController {
    
    private FloorFileService floorFileService;

    @Autowired
    public FloorFileController(FloorFileService inFloorFileService){
        this.floorFileService = inFloorFileService;
    }

    @GetMapping
    public List<FloorFileEntity> getAllFloorFileEntities(){
        return this.floorFileService.getAllFloorFileEntities();
    }

    @PutMapping
    public FloorFileEntity insertFloorFileEntity(@RequestBody FloorFileEntity inFloorFileEntity) throws Exception{
        return this.floorFileService.insertFloorFileEntity(inFloorFileEntity);
    }

    @GetMapping("/floorId/{floorId}")
    public FloorFileEntity getFloorFileEntityByFloorId(@PathVariable("floorId") Long inFloorId) throws Exception{
        return this.floorFileService.getFloorFileEntityByFloorId(inFloorId);
    }

    @DeleteMapping("/floorId/{floorId}")
    public void deleteFloorFileEntityByFloorId(@PathVariable("floorId") Long inFloorId){
        this.floorFileService.deleteFloorFileEntityByFloorId(inFloorId);
    }

    @GetMapping("/fileId/{fileId}")
    public FloorFileEntity getFloorFileEntityByFileId(@PathVariable("fileId") Long inFileId) throws Exception{
        return this.floorFileService.getFloorFileEntityByFileId(inFileId);
    }

    @DeleteMapping("/fileId/{fileId}")
    public void deleteFloorFileEntityByFileId(@PathVariable("fileId") Long inFileId){
        this.floorFileService.deleteFloorFileEntityByFileId(inFileId);
    }


}
