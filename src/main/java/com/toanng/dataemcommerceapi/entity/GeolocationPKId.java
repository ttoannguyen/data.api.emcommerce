package com.toanng.dataemcommerceapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GeolocationPKId implements Serializable {
    String geolocationZipCodePrefix;
    BigDecimal geolocationLat;
    BigDecimal geolocationLng;
}
