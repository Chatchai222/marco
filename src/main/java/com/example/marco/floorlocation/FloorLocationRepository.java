package com.example.marco.floorlocation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FloorLocationRepository extends JpaRepository<FloorLocationEntity, Long>{
    
    public Optional<FloorLocationEntity> findByLocationId(Long inLocationId);
    public void deleteByLocationId(Long inLocationId);

    public List<FloorLocationEntity> findByFloorId(Long inFloorId);
    public void deleteByFloorId(Long inFloorId);
}
