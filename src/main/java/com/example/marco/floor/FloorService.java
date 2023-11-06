package com.example.marco.floor;

import java.util.List;
import java.util.Optional;

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

    public Floor getFloorById(Long floorId){
        Optional<Floor> floorOpt = this.floorRepository.findById(floorId);
        if (!floorOpt.isPresent()){
            throw new IllegalStateException("Floor with id:" + floorId + " does not exist");
        }
        return floorOpt.get();
    }

    public void addFloor(Floor floor) {
        this.floorRepository.save(floor);
    }

    public void replaceFloor(Floor floor) {
        if(floor.getId() == null){
            throw new IllegalStateException("Error: Floor with id:" + floor.getId() + " does not exist");
        }
        this.floorRepository.save(floor);
    }

    public void deleteFloorById(Long floorId){
        if(!floorRepository.existsById(floorId)){
            throw new IllegalStateException("Error: Floor with id: " + floorId + " does not exist");
        }
        this.floorRepository.deleteById(floorId);
    }

}
