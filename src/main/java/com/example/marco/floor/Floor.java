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
        name = "beaconSequence",
        sequenceName = "beaconSequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "beaconSequence"
    )
    private Long id;
    private String name;
    private Double length;
    private Double width;
    private Double aziumuth;

    public Floor() {

    }

    public Floor(String name, Double length, Double width, Double aziumuth) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.aziumuth = aziumuth;
    }

    public Floor(Long id, String name, Double length, Double width, Double aziumuth) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.width = width;
        this.aziumuth = aziumuth;
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

    public Double getAziumuth() {
        return aziumuth;
    }

    public void setAziumuth(Double aziumuth) {
        this.aziumuth = aziumuth;
    }
   
    @Override
    public String toString() {
        return "Floor [id=" + id + ", name=" + name + ", length=" + length + ", width=" + width + ", aziumuth="
                + aziumuth + "]";
    }
    
}
