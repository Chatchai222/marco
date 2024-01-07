package com.example.marco.buildingfloor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BuildingFloorRepository extends JpaRepository<BuildingFloorEntity, Long>{
    
    List<BuildingFloorEntity> findByBuildingId(Long inBuildingId);
    void deleteByBuildingId(Long inBuildingId);

    Optional<BuildingFloorEntity> findByFloorId(Long inFloorId);
    void deleteByFloorId(Long inFloorId); 

    Optional<BuildingFloorEntity> findByBuildingIdAndFloorId(Long inBuildingId, Long inFloorId);
}
