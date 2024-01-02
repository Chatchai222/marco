package com.example.marco.buildingdirectory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingDirectoryRepository extends JpaRepository<BuildingDirectoryEntity, Long>{
    
    List<BuildingDirectoryEntity> findByBuildingId(Long inBuildingId);
}
