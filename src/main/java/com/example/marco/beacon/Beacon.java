package com.example.marco.beacon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Beacon {

    @Id
    @SequenceGenerator(
        name = "beacon_sequence",
        sequenceName = "beacon_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "beacon_sequence"
    )
    private Long id;
    private String mac_address;
    private String floor_name;
    private double x_coord;
    private double y_coord;

    public Beacon() {

    }    

    public Beacon(String mac_address, String floor_name, double x_coord, double y_coord) {
        this.mac_address = mac_address;
        this.floor_name = floor_name;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    public Beacon(Long id, String mac_address, String floor_name, double x_coord, double y_coord) {
        this.id = id;
        this.mac_address = mac_address;
        this.floor_name = floor_name;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
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

    @Override
    public String toString() {
        return "Beacon [id=" + id + ", mac_address=" + mac_address + ", floor_name=" + floor_name + ", x_coord="
                + x_coord + ", y_coord=" + y_coord + "]";
    }

}
