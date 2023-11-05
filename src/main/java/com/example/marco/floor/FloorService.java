package com.example.marco.floor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorService {
    
    private final FloorRepository floorRepository;

    @Autowired
    public FloorService(FloorRepository inFloorRepository){
        this.floorRepository = inFloorRepository;
    }

    public List<Floor> getAllFloor(){
        return this.floorRepository.findAll();
    }

    public void addFloor(Floor floor) {
        this.floorRepository.save(floor);
    }

}
