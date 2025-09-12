package com.toanng.dataemcommerceapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "geolocations", schema = "ecommerce")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@IdClass(GeolocationsPKId.class)
public class Geolocations {
    @Id
    @Column(name = "geolocation_zip_code_prefix")
    String geolocationZipCodePrefix;

    @Id
    @Column(name = "geolocation_lat")
    String geolocationLat;

    @Id
    @Column(name = "geolocation_lng")
    String geolocationLng;

    @Column(name = "geolocation_city")
    String geolocationCity;

    @Column(name = "geolocation_state")
    String geolocationState;
}
