package com.example.marco.floorfile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FloorFileRepository extends JpaRepository<FloorFileEntity, Long> {
    
    Optional<FloorFileEntity> findByFloorId(Long inFloorId);
    Boolean existsByFloorId(Long inFloorId);
    void deleteByFloorId(Long inFloorId);

    Optional<FloorFileEntity> findByFileId(Long inFileId);
    void deleteByFileId(Long inFileId);
}
