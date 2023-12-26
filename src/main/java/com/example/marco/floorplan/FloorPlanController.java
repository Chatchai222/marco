package com.example.marco.floorplan;

import java.util.List;
import java.util.Optional;

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
    
    @GetMapping("{id}")
    public FloorPlanEntity getFloorPlanEntityById(@PathVariable Long inFloorPlanId) throws Exception{
        return this.floorPlanService.getFloorPlanEntityById(inFloorPlanId);
    }

    @PostMapping
    public FloorPlanEntity addFloorPlanEntity(@RequestBody FloorPlanEntity inFloorPlanEntity) throws Exception{
        return this.floorPlanService.addFloorPlanEntity(inFloorPlanEntity);
    }

    @PutMapping("{id}")
    public FloorPlanEntity replaceFloorPlanEntity(@PathVariable Long inFloorPlanId,
                                                  @RequestBody FloorPlanEntity inFloorPlanEntity) throws Exception{
        return this.floorPlanService.replaceFloorPlanEntity(inFloorPlanId, inFloorPlanEntity);
    }

    @DeleteMapping("{id}")
    public void deleteFloorPlanEntity(@PathVariable Long inFloorPlanId) throws Exception{
        this.floorPlanService.deleteFloorPlanEntityById(inFloorPlanId);
    }
}
