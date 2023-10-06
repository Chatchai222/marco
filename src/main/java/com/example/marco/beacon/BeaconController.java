package com.example.marco.beacon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
