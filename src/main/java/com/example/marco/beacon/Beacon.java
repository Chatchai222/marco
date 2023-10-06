package com.example.marco.beacon;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Beacon {
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
    private Long id;
    private String macAddress;
    private String floorName;
    private Double x;
    private Double y;

    public Beacon() {

    }

    public Beacon(String macAddress, String floorName, Double x, Double y) {
        this.macAddress = macAddress;
        this.floorName = floorName;
        this.x = x;
        this.y = y;
    }

    public Beacon(Long id, String macAddress, String floorName, Double x, Double y) {
        this.id = id;
        this.macAddress = macAddress;
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

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
    
    @JsonIgnore
    public String getNullAttributes(){
        ArrayList<String> result = new ArrayList<String>();
        if(id == null){
            result.add("id");
        }
        if(macAddress == null){
            result.add("macAddress");
        }
        if(floorName == null){
            result.add("floorName");
        }
        if(x == null){
            result.add("x");
        }
        if(y == null){
            result.add("y");
        }
        
        return result.toString();
    }
    
    @JsonIgnore
    public Boolean isAnyAttributeNull(){
        Boolean result = false;
        if(id == null){
            result = true;
        }
        if(macAddress == null){
            result = true;
        }
        if(floorName == null){
            result = true;
        }
        if(x == null){
            result = true;
        }
        if(y == null){
            result = true;
        }
        return result;
    }

    @JsonIgnore
    public Boolean isAnyNonIdAttributeNull(){
        Boolean result = false;
        if(macAddress == null){
            result = true;
        }
        if(floorName == null){
            result = true;
        }
        if(x == null){
            result = true;
        }
        if(y == null){
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Beacon [id=" + id + ", macAddress=" + macAddress + ", floorName=" + floorName + ", x=" + x + ", y=" + y
                + "]";
    }
}
