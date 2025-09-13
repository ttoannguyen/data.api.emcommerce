package com.toanng.dataemcommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toanng.dataemcommerceapi.entity.Geolocation;
import com.toanng.dataemcommerceapi.entity.GeolocationPKId;

@Repository
public interface GeolocationsRepository extends JpaRepository<Geolocation, GeolocationPKId> {
}
