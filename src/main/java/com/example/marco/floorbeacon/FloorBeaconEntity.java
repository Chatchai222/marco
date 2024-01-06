package com.example.marco.floorbeacon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class FloorBeaconEntity {
    
    @Id
    @SequenceGenerator(
        name = "floorBeaconSequence",
        sequenceName = "floorBeaconSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "floorBeaconSequence"
    )
    private Long floorBeaconId;
    private Long floorId;
    @Column(unique = true)
    private Long beaconId;

    public FloorBeaconEntity() {
        
    }

    public FloorBeaconEntity(Long floorId, Long beaconId) {
        this.floorId = floorId;
        this.beaconId = beaconId;
    }

    public FloorBeaconEntity(Long floorBeaconId, Long floorId, Long beaconId) {
        this.floorBeaconId = floorBeaconId;
        this.floorId = floorId;
        this.beaconId = beaconId;
    }

    public Long getFloorBeaconId() {
        return floorBeaconId;
    }

    public void setFloorBeaconId(Long floorBeaconId) {
        this.floorBeaconId = floorBeaconId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(Long beaconId) {
        this.beaconId = beaconId;
    }

    @Override
    public String toString() {
        return "FloorBeaconEntity [floorBeaconId=" + floorBeaconId + ", floorId=" + floorId + ", beaconId=" + beaconId
                + "]";
    }

}
