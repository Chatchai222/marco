package com.example.marco.location;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class LocationEntity {

    @Id
    @SequenceGenerator(
        name = "locationSequence",
        sequenceName = "locationSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "locationSequence"
    )
    private Long locationId;
    private String name;
    private Double geoX;
    private Double geoY;

    public LocationEntity() {
        
    }

    public LocationEntity(String name, Double geoX, Double geoY) {
        this.name = name;
        this.geoX = geoX;
        this.geoY = geoY;
    }

    public LocationEntity(Long locationId, String name, Double geoX, Double geoY) {
        this.locationId = locationId;
        this.name = name;
        this.geoX = geoX;
        this.geoY = geoY;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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

    @Override
    public String toString() {
        return "LocationEntity [locationId=" + locationId + ", name=" + name + ", geoX=" + geoX + ", geoY=" + geoY
                + "]";
    }
    
}
