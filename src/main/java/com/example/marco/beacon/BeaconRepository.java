package com.example.marco.beacon;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BeaconRepository extends JpaRepository<BeaconEntity, Long> {

    public Optional<BeaconEntity> findByMacAddress(String macAddress);
    public void deleteByMacAddress(String macAddress);

    public List<BeaconEntity> findByNameContaining(String name);

    public BeaconEntity findByName(String name);
}
