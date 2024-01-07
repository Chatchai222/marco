package com.example.marco.buildingfloor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class BuildingFloorEntity {
    
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
    private Long buildingFloorId;

    @Column(nullable = false)
    private Long buildingId;

    @Column(unique = true, nullable = false)
    private Long floorId;

    public BuildingFloorEntity() {
        
    }

    public BuildingFloorEntity(Long buildingId, Long floorId) {
        this.buildingId = buildingId;
        this.floorId = floorId;
    }

    public BuildingFloorEntity(Long buildingDirectoryId, Long buildingId, Long floorId) {
        this.buildingFloorId = buildingDirectoryId;
        this.buildingId = buildingId;
        this.floorId = floorId;
    }

    public Long getBuildingFloorId() {
        return buildingFloorId;
    }

    public void setBuildingFloorId(Long buildingDirectoryId) {
        this.buildingFloorId = buildingDirectoryId;
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
