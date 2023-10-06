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
        name = "location_sequence",
        sequenceName = "location_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "location_sequence"
    )
    private Long id;

    private String name;
    private String floor_name;
    private double x_coord;
    private double y_coord;

    public Location(){

    }

    public Location(String name, String floor_name, double x_coord, double y_coord) {
        this.name = name;
        this.floor_name = floor_name;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    public Location(Long id, String name, String floor_name, double x_coord, double y_coord) {
        this.id = id;
        this.name = name;
        this.floor_name = floor_name;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    @Override
    public String toString() {
        return "Location [id=" + id + ", name=" + name + ", floor_name=" + floor_name + ", x_coord=" + x_coord
                + ", y_coord=" + y_coord + "]";
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

    public String getFloor_name() {
        return floor_name;
    }

    public void setFloor_name(String floor_name) {
        this.floor_name = floor_name;
    }

    public double getX_coord() {
        return x_coord;
    }

    public void setX_coord(double x_coord) {
        this.x_coord = x_coord;
    }

    public double getY_coord() {
        return y_coord;
    }

    public void setY_coord(double y_coord) {
        this.y_coord = y_coord;
    }
    
    

}
