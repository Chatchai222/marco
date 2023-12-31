package com.example.marco.floor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class FloorEntity {

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
    private Long id;
    private String name;
    private Double geoLength;
    private Double geoWidth;
    private Double azimuth;

    public FloorEntity() {

    }

    public FloorEntity(String name, Double geoLength, Double geoWidth, Double azimuth) {
        this.name = name;
        this.geoLength = geoLength;
        this.geoWidth = geoWidth;
        this.azimuth = azimuth;
    }

    public FloorEntity(Long id, String name, Double geoLength, Double geoWidth, Double azimuth) {
        this.id = id;
        this.name = name;
        this.geoLength = geoLength;
        this.geoWidth = geoWidth;
        this.azimuth = azimuth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGeoLength() {
        return geoLength;
    }

    public void setGeoLength(Double geoLength) {
        this.geoLength = geoLength;
    }

    public Double getGeoWidth() {
        return geoWidth;
    }

    public void setGeoWidth(Double geoWidth) {
        this.geoWidth = geoWidth;
    }

    public Double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Double azimuth) {
        this.azimuth = azimuth;
    }

    @Override
    public String toString() {
        return "FloorEntity [id=" + id + ", name=" + name + ", geoLength=" + geoLength + ", geoWidth=" + geoWidth
                + ", azimuth=" + azimuth + "]";
    }
    
}
