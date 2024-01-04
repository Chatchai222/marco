package com.example.marco.beacon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public List<BeaconEntity> getAllBeaconEntities(){
        return this.beaconService.getAllBeaconEntities();
    }

    @GetMapping("/{beaconId}")
    public BeaconEntity getBeaconEntityByBeaconId(@PathVariable("beaconId") Long inBeaconId) throws Exception{
        return this.beaconService.getBeaconEntityByBeaconId(inBeaconId);
    }

}
