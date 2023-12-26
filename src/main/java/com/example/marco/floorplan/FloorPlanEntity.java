package com.example.marco.floorplan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class FloorPlanEntity {

    @Id
    @SequenceGenerator(
        name = "floorSequence",
        sequenceName = "floorSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "floorSequence"
    )
    private Long floorPlanId;
    
    @Column(unique = true)
    private Long floorId;

    @Column(unique = true)
    private Long fileId;

    public FloorPlanEntity() {

    }

    public FloorPlanEntity(Long floorId, Long fileId) {
        this.floorId = floorId;
        this.fileId = fileId;
    }

    public FloorPlanEntity(Long floorPlanId, Long floorId, Long fileId) {
        this.floorPlanId = floorPlanId;
        this.floorId = floorId;
        this.fileId = fileId;
    }

    public Long getFloorPlanId() {
        return floorPlanId;
    }

    public void setFloorPlanId(Long floorPlanId) {
        this.floorPlanId = floorPlanId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "FloorPlanEntity [floorPlanId=" + floorPlanId + ", floorId=" + floorId + ", fileId=" + fileId + "]";
    }
}
