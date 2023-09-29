package com.example.marco.beacon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, Long> {

    @Query("SELECT b FROM Beacon b WHERE b.mac_address = ?1")
    public Optional<Beacon> findByMacAddress(String mac_address);
}
