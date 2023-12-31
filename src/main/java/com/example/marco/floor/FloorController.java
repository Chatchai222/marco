package com.example.marco.floor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/floor")
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

    @GetMapping("all")
    public List<FloorEntity> getAllFloor(){
        return floorService.getAllFloor();
    }

    @GetMapping("id")
    public FloorEntity getFloorById(@RequestParam(name = "id") Long floorId){
        return floorService.getFloorById(floorId);
    }

    @PostMapping
    public void addFloor(@RequestBody FloorEntity floor){
        floorService.addFloor(floor);
    }

    @PutMapping
    public void replaceFloor(@RequestBody FloorEntity floor){
        floorService.replaceFloor(floor);
    }

    @DeleteMapping
    public void deleteFloor(@RequestParam(name = "id") Long floorId){
        floorService.deleteFloorById(floorId);
    }

}
