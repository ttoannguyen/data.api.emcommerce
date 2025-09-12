package com.toanng.dataemcommerceapi.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GeolocationsPKId implements Serializable {
    String geolocationZipCodePrefix;
    String geolocationLat;
    String geolocationLng;
}
