package com.example.marco.beacon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/beacon")
public class BeaconController {
    
    final private BeaconService beacon_service;

    @Autowired
    public BeaconController(BeaconService in_beacon_service){
        this.beacon_service = in_beacon_service;
    }

    @GetMapping("all")
    public List<Beacon> getAllBeacon(){
        return this.beacon_service.getAllBeacon();
    }

    @GetMapping("id")
    public Beacon getBeaconById(@RequestParam(name = "id") Long beacon_id){
        return this.beacon_service.getBeaconById(beacon_id);
    }

    @GetMapping("mac_address")
    public Beacon getBeaconByMacAddress(@RequestParam(name = "mac_address") String mac_address){
        return this.beacon_service.getBeaconByMacAddress(mac_address);
    }

}
