package com.toanng.dataemcommerceapi.dto.response;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeolocationsResponse {
    String zipCode;
    BigDecimal lat;
    BigDecimal lng;
    String city;
    String state;
}
