package com.example.marco.floorplan;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FloorPlanRepository extends JpaRepository<FloorPlanEntity, Long> {
    
    Optional<FloorPlanEntity> findByFloorId(Long inFloorId);
    Boolean existsByFloorId(Long inFloorId);
    void deleteByFloorId(Long inFloorId);

    void deleteByFileId(Long inFileId);
}
