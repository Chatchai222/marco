package com.example.marco.floor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Floor {

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
    private Double length;
    private Double width;
    private Double azimuth;

    public Floor() {

    }

    public Floor(String name, Double length, Double width, Double azimuth) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.azimuth = azimuth;
    }

    public Floor(Long id, String name, Double length, Double width, Double azimuth) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.width = width;
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

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Double azimuth) {
        this.azimuth = azimuth;
    }
   
    @Override
    public String toString() {
        return "Floor [id=" + id + ", name=" + name + ", length=" + length + ", width=" + width + ", aziumuth="
                + azimuth + "]";
    }
    
}
