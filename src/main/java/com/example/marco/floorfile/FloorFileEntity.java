package com.example.marco.floorfile;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class FloorFileEntity {

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
    private Long floorFileId;
    
    @Column(unique = true)
    private Long floorId;

    @Column(unique = true)
    private Long fileId;

    public FloorFileEntity() {
        
    }

    public FloorFileEntity(Long floorId, Long fileId) {
        this.floorId = floorId;
        this.fileId = fileId;
    }

    public FloorFileEntity(Long floorFileId, Long floorId, Long fileId) {
        this.floorFileId = floorFileId;
        this.floorId = floorId;
        this.fileId = fileId;
    }

    public Long getFloorFileId() {
        return floorFileId;
    }

    public void setFloorFileId(Long floorFileId) {
        this.floorFileId = floorFileId;
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
        return "FloorFileEntity [floorFileId=" + floorFileId + ", floorId=" + floorId + ", fileId=" + fileId + "]";
    }

}
