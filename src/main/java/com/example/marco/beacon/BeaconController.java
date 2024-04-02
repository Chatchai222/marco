package com.example.marco.beacon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/beacons")
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

    @GetMapping("/beacon-id-list")
    public List<BeaconEntity> getBeaconEntitiesByBeaconIdList(@RequestBody Map<String, Object> inJsonRequest) throws Exception{
        List<Integer> beaconIdListInteger = (List<Integer>) inJsonRequest.get("beaconIdList");
        List<Long> beaconIdListLong = new ArrayList<Long>();
        for(Integer beaconIdInteger: beaconIdListInteger){
            beaconIdListLong.add(Long.valueOf(beaconIdInteger));
        }
        List<BeaconEntity> beaconEntityList = this.beaconService.getBeaconEntitiesByBeaconIdList(beaconIdListLong);
        return beaconEntityList;
    }

    // this is F***ING cursed T_T BUT WE HAVE NO TIME
    // this API is using POST but not modifying anything
    // the reason this is here is because of Dart and Flutter not allowing GET method to have request body
    @PostMapping("/beacon-id-list")
    public List<BeaconEntity> getBeaconEntitiesByBeaconIdListUsingPOST(@RequestBody Map<String, Object> inJsonRequest) throws Exception{
        List<Integer> beaconIdListInteger = (List<Integer>) inJsonRequest.get("beaconIdList");
        List<Long> beaconIdListLong = new ArrayList<Long>();
        for(Integer beaconIdInteger: beaconIdListInteger){
            beaconIdListLong.add(Long.valueOf(beaconIdInteger));
        }
        List<BeaconEntity> beaconEntityList = this.beaconService.getBeaconEntitiesByBeaconIdList(beaconIdListLong);
        return beaconEntityList;
    }

    @GetMapping("/string-query")
    public List<BeaconEntity> queryBeaconByNameString(String name) {
        System.out.println(name);
        return this.beaconService.getBeaconEntitiesByBeaconName(name);
    }

    @GetMapping("/exact-string-query")
    public BeaconEntity queryBeaconByExactName(String name) {
        return this.beaconService.getBeaconEntityByBeaconName(name);
    }

    @PostMapping
    public BeaconEntity addBeaconEntity(@RequestBody BeaconEntity inBeaconEntity) throws Exception{
        return this.beaconService.addBeaconEntity(inBeaconEntity);
    }

    @PutMapping("/{beaconId}")
    public BeaconEntity replaceBeaconEntity(@PathVariable("beaconId") Long inBeaconId,
                                           @RequestBody BeaconEntity inBeaconEntity) throws Exception{
        inBeaconEntity.setBeaconId(inBeaconId);
        return this.beaconService.replaceBeaconEntity(inBeaconEntity);
    }

    @DeleteMapping("/{beaconId}")
    public void deleteBeaconEntityByBeaconId(@PathVariable("beaconId") Long inBeaconId){
        this.beaconService.deleteBeaconEntityByBeaconId(inBeaconId);
    }

    @GetMapping("/macAddress/{macAddress}")
    public BeaconEntity getBeaconEntityByMacAddress(@PathVariable("macAddress") String inMacAddress) throws Exception{
        return this.beaconService.getBeaconEntityByMacAddress(inMacAddress);
    }

    @DeleteMapping("/macAddress/{macAddress}")
    public void deleteBeaconEntityByMacAddress(@PathVariable("macAddress") String inMacAddress){
        this.beaconService.deleteBeaconEntityByMacAddress(inMacAddress);
    }
}
