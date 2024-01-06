package com.example.marco.floorbeacon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FloorBeaconRepository extends JpaRepository<FloorBeaconEntity, Long> {
    
    public Optional<FloorBeaconEntity> findByBeaconId(Long inBeaconId);
    public void deleteByBeaconId(Long inBeaconId);

    public List<FloorBeaconEntity> findByFloorId(Long inFloorId);
    public void deleteByFloorId(Long inFloorId);
}
