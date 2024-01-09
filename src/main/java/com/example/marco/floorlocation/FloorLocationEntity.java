package com.example.marco.floorlocation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class FloorLocationEntity {
    
    @Id
    @SequenceGenerator(
        name = "floorLocationSequence",
        sequenceName = "floorLocationSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "floorLocationSequence"
    )
    private Long floorLocationId;
    private Long floorId;
    @Column(unique = true)
    private Long locationId;
    
    public FloorLocationEntity() {
        
    }

    public FloorLocationEntity(Long floorId, Long locationId) {
        this.floorId = floorId;
        this.locationId = locationId;
    }

    public FloorLocationEntity(Long floorLocationId, Long floorId, Long locationId) {
        this.floorLocationId = floorLocationId;
        this.floorId = floorId;
        this.locationId = locationId;
    }

    public Long getFloorLocationId() {
        return floorLocationId;
    }

    public void setFloorLocationId(Long floorLocationId) {
        this.floorLocationId = floorLocationId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "FloorLocationEntity [floorLocationId=" + floorLocationId + ", floorId=" + floorId + ", locationId="
                + locationId + "]";
    }
    
}
