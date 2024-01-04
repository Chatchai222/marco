package com.example.marco.beacon;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class BeaconEntity {
    // Check @JsonPropety to determine the json property name 

    @Id
    @SequenceGenerator(
        name = "beaconSequence",
        sequenceName = "beaconSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "beaconSequence"
    )
    private Long beaconId;
    private String name;
    private Double geoX;
    private Double geoY;
    @Column(unique = true)
    private String macAddress;

    public BeaconEntity() {

    }

    public BeaconEntity(String name, Double geoX, Double geoY, String macAddress) {
        this.name = name;
        this.geoX = geoX;
        this.geoY = geoY;
        this.macAddress = macAddress;
    }

    public BeaconEntity(Long beaconId, String name, Double geoX, Double geoY, String macAddress) {
        this.beaconId = beaconId;
        this.name = name;
        this.geoX = geoX;
        this.geoY = geoY;
        this.macAddress = macAddress;
    }

    public Long getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(Long beaconId) {
        this.beaconId = beaconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGeoX() {
        return geoX;
    }

    public void setGeoX(Double geoX) {
        this.geoX = geoX;
    }

    public Double getGeoY() {
        return geoY;
    }

    public void setGeoY(Double geoY) {
        this.geoY = geoY;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Override
    public String toString() {
        return "BeaconEntity [beaconId=" + beaconId + ", name=" + name + ", geoX=" + geoX + ", geoY=" + geoY
                + ", macAddress=" + macAddress + "]";
    }

}
