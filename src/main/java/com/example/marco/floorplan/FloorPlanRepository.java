package com.example.marco.floorplan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorPlanRepository extends JpaRepository<FloorPlanEntity, Long> {
    
}
