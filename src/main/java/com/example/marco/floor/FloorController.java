package com.example.marco.floor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/floors")
public class FloorController {
    
    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService inFloorService){
        this.floorService = inFloorService;
    }

    @GetMapping("hello")
    public String getHello(){
        return "Hello, you tried getting in floor apis";
    }

    @GetMapping
    public List<FloorEntity> getAllFloor(){
        return floorService.getAllFloorEntity();
    }

    @GetMapping("/{floorId}")
    public FloorEntity getFloorById(@PathVariable("floorId") Long floorId) throws Exception{
        return floorService.getFloorEntityByFloorId(floorId);
    }

    @PostMapping
    public FloorEntity addFloor(@RequestBody FloorEntity inFloorEntity) throws Exception{
        return floorService.addFloorEntity(inFloorEntity);
    }

    @PutMapping("/{floorId}")
    public void replaceFloor(@PathVariable("floorId") Long inFloorId, @RequestBody FloorEntity inFloorEntity) throws Exception{
        inFloorEntity.setFloorId(inFloorId);
        floorService.replaceFloorEntity(inFloorEntity);
    }

    @DeleteMapping("/{floorId}")
    public void deleteFloor(@PathVariable(name = "floorId") Long floorId) throws Exception{
        floorService.deleteFloorEntityByFloorId(floorId);
    }

}
