package com.example.marco.buildingdirectory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class BuildingDirectoryEntity {
    
    @Id
    @SequenceGenerator(
        name = "buildingSequence",
        sequenceName = "buildingSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "buildingSequence"
    )
    private Long buildingDirectoryId;

    private Long buildingId;

    @Column(unique = true)
    private Long floorId;

    public BuildingDirectoryEntity() {
        
    }

    public BuildingDirectoryEntity(Long buildingId, Long floorId) {
        this.buildingId = buildingId;
        this.floorId = floorId;
    }

    public BuildingDirectoryEntity(Long buildingDirectoryId, Long buildingId, Long floorId) {
        this.buildingDirectoryId = buildingDirectoryId;
        this.buildingId = buildingId;
        this.floorId = floorId;
    }

    public Long getBuildingDirectoryId() {
        return buildingDirectoryId;
    }

    public void setBuildingDirectoryId(Long buildingDirectoryId) {
        this.buildingDirectoryId = buildingDirectoryId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }
    
}
