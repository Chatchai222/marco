package com.example.marco.floorplan;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorPlanRepository extends JpaRepository<FloorPlanEntity, Long> {
    
    Optional<FloorPlanEntity> findByFloorId(Long inFloorId);

    Boolean existsByFloorId(Long inFloorId);

    
}
