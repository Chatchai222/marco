package com.example.marco.beacon.calibration;

import java.util.List;

public class CalibrationInfo {
    private List<BeaconCalibrationInfo> beacons;
    
    public CalibrationInfo(List<BeaconCalibrationInfo> beacons) {
        this.beacons = beacons;
    }

    public CalibrationInfo() {
    }

    public String toString() {
        StringBuilder retStr = new StringBuilder();
        for (BeaconCalibrationInfo beacon: beacons) {
            retStr.append(beacon.toString());
        }

        return retStr.toString();
    }

    public List<BeaconCalibrationInfo> getBeacons() {
        return beacons;
    }

    public void setBeacons(List<BeaconCalibrationInfo> beacons) {
        this.beacons = beacons;
    }
}