package com.example.marco.beacon;

import java.util.List;
import java.util.Map;

import com.example.marco.beacon.calibration.BeaconCalibrationInfo;
import com.example.marco.beacon.calibration.CalibrationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/beacon")
public class BeaconController {
    
    final private BeaconService beaconService;

    @Autowired
    public BeaconController(BeaconService beaconService){
        this.beaconService = beaconService;
    }

    @GetMapping("all")
    public List<Beacon> getAllBeacon(){
        return this.beaconService.getAllBeacon();
    }

    @GetMapping("id")
    public Beacon getBeaconById(@RequestParam(name = "id") Long beaconId){
        return this.beaconService.getBeaconById(beaconId);
    }

    @GetMapping("macAddress")
    public Beacon getBeaconByMacAddress(@RequestParam(name = "macAddress") String macAddress){
        return this.beaconService.getBeaconByMacAddress(macAddress);
    }

    @PostMapping
    public void addBeacon(@RequestBody Beacon beacon){
        this.beaconService.addBeacon(beacon);
    }

    @DeleteMapping("id")
    public void deleteBeaconById(@RequestParam(name = "id") Long beaconId){
        this.beaconService.deleteBeaconById(beaconId);
    }

    @DeleteMapping("macAddress")
    public void deleteBeaconByMacAddress(@RequestParam(name = "macAddress") String macAddress){
        this.beaconService.deleteBeaconByMacAddress(macAddress);
    }

    @PutMapping
    public void replaceLocation(@RequestBody Beacon beacon){
        this.beaconService.replaceBeacon(beacon);
    }
    
    @PostMapping("/calibrate")
    public String calibrateBeacon(@RequestBody CalibrationInfo calibrationInfo) {
        return calibrationInfo.toString();
    }

}
