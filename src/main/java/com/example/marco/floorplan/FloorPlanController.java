package com.example.marco.floorplan;

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
@RequestMapping("api/v1/floor-plans")
public class FloorPlanController {
    
    private FloorPlanService floorPlanService;

    @Autowired
    public FloorPlanController(FloorPlanService inFloorPlanService){
        this.floorPlanService = inFloorPlanService;
    }

    @GetMapping
    public List<FloorPlanEntity> getAllFloorPlanEntity(){
        return this.floorPlanService.getAllFloorPlanEntity();
    }
    
    @GetMapping("/{id}")
    public FloorPlanEntity getFloorPlanEntityByFloorPlanId(@PathVariable("id") Long inFloorPlanId) throws Exception{
        return this.floorPlanService.getFloorPlanEntityByFloorPlanId(inFloorPlanId);
    }

    @GetMapping("/floor/{id}")
    public FloorPlanEntity getFloorPlanEntityByFloorId(@PathVariable("id") Long inFloorId) throws Exception{
        return this.floorPlanService.getFloorPlanEntityByFloorId(inFloorId);
    }

    @PostMapping
    public FloorPlanEntity addFloorPlanEntity(@RequestBody FloorPlanEntity inFloorPlanEntity) throws Exception{
        return this.floorPlanService.addFloorPlanEntity(inFloorPlanEntity);
    }

    @PutMapping("/{id}")
    public FloorPlanEntity replaceFloorPlanEntityByFloorPlanId(@PathVariable("id") Long inFloorPlanId,
                                                  @RequestBody FloorPlanEntity inFloorPlanEntity) throws Exception{
        return this.floorPlanService.replaceFloorPlanEntityByFloorPlanId(inFloorPlanId, inFloorPlanEntity);
    }

    @PutMapping("/floor")
    public FloorPlanEntity reaplceFloorPlanEntityByFloorId(@RequestBody FloorPlanEntity inFloorPlanEntity) throws Exception{
        return this.floorPlanService.replaceFloorPlanEntityByFloorId(inFloorPlanEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteFloorPlanEntityByFloorPlanId(@PathVariable("id") Long inFloorPlanId) throws Exception{
        this.floorPlanService.deleteFloorPlanEntityByFloorPlanId(inFloorPlanId);
    }

    @DeleteMapping("/floor/{id}")
    public void deleteFloorPlanEntityByFloorId(@PathVariable("id") Long inFloorId) throws Exception{
        this.floorPlanService.deleteFloorPlanEntityByFloorId(inFloorId);
    }
}
