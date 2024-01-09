package com.example.marco.building;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class BuildingEntity {
    
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
    private Long buildingId;
    private String name;

    public BuildingEntity() {

    }

    public BuildingEntity(String name) {
        this.name = name;
    }

    public BuildingEntity(Long buildingId, String name) {
        this.buildingId = buildingId;
        this.name = name;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BuildingEntity [buildingId=" + buildingId + ", name=" + name + "]";
    }
    
}
