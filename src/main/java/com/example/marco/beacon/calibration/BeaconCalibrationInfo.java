package com.example.marco.beacon.calibration;

import jakarta.persistence.Entity;

public class BeaconCalibrationInfo {
    String macAddress;
    Integer rssi;

    public BeaconCalibrationInfo(String macAddress, Integer rssi) {
        this.macAddress = macAddress;
        this.rssi = rssi;
    }

    public BeaconCalibrationInfo() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getRssi() {
        return rssi;
    }

    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    @Override
    public String toString() {
        return "BeaconCalibrationInfo{" +
                "macAddress='" + macAddress + '\'' +
                ", rssi=" + rssi +
                "}\n";
    }
}
