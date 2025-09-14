package com.toanng.dataemcommerceapi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class GeolocationPKId implements Serializable {
    @Column(name = "geolocation_zip_code_prefix")
    String geolocationZipCodePrefix;

    @Column(name = "geolocation_lat")
    BigDecimal geolocationLat;

    @Column(name = "geolocation_lng")
    BigDecimal geolocationLng;
}
