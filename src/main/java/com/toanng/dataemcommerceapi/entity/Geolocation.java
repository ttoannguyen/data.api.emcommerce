package com.toanng.dataemcommerceapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

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
public class Geolocation {
    @EmbeddedId
    GeolocationPKId id;

    @Column(name = "geolocation_city")
    String geolocationCity;

    @Column(name = "geolocation_state")
    String geolocationState;
}
