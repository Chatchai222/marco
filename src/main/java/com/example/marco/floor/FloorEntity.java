package com.example.marco.floor;

import jakarta.persistence.Column;
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
    private Long floorId;
    private String name;
    private Double geoLength;
    private Double geoWidth;
    private Double azimuth;
    @Column(unique = true)
    private Integer level;

    public FloorEntity() {

    }

    public FloorEntity(String name, Double geoLength, Double geoWidth, Double azimuth, Integer level) {
        this.name = name;
        this.geoLength = geoLength;
        this.geoWidth = geoWidth;
        this.azimuth = azimuth;
        this.level = level;
    }

    public FloorEntity(Long floorId, String name, Double geoLength, Double geoWidth, Double azimuth, Integer level) {
        this.floorId = floorId;
        this.name = name;
        this.geoLength = geoLength;
        this.geoWidth = geoWidth;
        this.azimuth = azimuth;
        this.level = level;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "FloorEntity [floorId=" + floorId + ", name=" + name + ", geoLength=" + geoLength + ", geoWidth="
                + geoWidth + ", azimuth=" + azimuth + ", level=" + level + "]";
    }

    @Override
    public boolean equals(Object in){
        FloorEntity inFloor = (FloorEntity)in;
        return floorId == (inFloor.getFloorId()) &&
               name == inFloor.getName() &&
               geoLength.equals(inFloor.getGeoLength()) &&
               geoWidth.equals(inFloor.getGeoWidth()) &&
               azimuth.equals(inFloor.getAzimuth()) &&
               level.equals(inFloor.getLevel());
    }

}
