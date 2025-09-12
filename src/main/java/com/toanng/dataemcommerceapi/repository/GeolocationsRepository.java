package com.toanng.dataemcommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toanng.dataemcommerceapi.entity.Geolocations;
import com.toanng.dataemcommerceapi.entity.GeolocationsPKId;

public interface GeolocationsRepository extends JpaRepository<Geolocations, GeolocationsPKId> {

}
