package com.example.marco.location;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Location {

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
    private Long id;

    private String name;
    private String floorName;
    private double x;
    private double y;

    public Location(){

    }

    public Location(String name, String floor_name, double x, double y) {
        this.name = name;
        this.floorName = floor_name;
        this.x = x;
        this.y = y;
    }

    public Location(Long id, String name, String floorName, double x, double y) {
        this.id = id;
        this.name = name;
        this.floorName = floorName;
        this.x = x;
        this.y = y;
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

    public void setName(String location_name) {
        this.name = location_name;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public double getX() {
        return x;
    }

    public void setX(double x_coord) {
        this.x = x_coord;
    }

    public double getY() {
        return y;
    }

    public void setY(double y_coord) {
        this.y = y_coord;
    }

}
