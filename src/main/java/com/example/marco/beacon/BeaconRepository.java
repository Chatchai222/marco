package com.example.marco.beacon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconRepository extends JpaRepository<BeaconEntity, Long> {

    public Optional<BeaconEntity> findByMacAddress(String macAddress);
}
