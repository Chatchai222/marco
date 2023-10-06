package com.example.marco.beacon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, Long> {

    @Query("SELECT b FROM Beacon b WHERE b.macAddress = ?1")
    public Optional<Beacon> findByMacAddress(String macAddress);
}
