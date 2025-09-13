package com.toanng.dataemcommerceapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.toanng.dataemcommerceapi.dto.response.GeolocationsResponse;
import com.toanng.dataemcommerceapi.entity.Geolocation;

@Mapper(componentModel = "spring")
public interface GeolocationsMapper {
    // Geolocations toGeolocations(GeolocationsRequest request);

    @Mapping(source = "geolocationZipCodePrefix", target = "zipCode")
    @Mapping(source = "geolocationLat", target = "lat")
    @Mapping(source = "geolocationLng", target = "lng")
    @Mapping(source = "geolocationCity", target = "city")
    @Mapping(source = "geolocationState", target = "state")
    GeolocationsResponse toGeolocationsResponse(Geolocation geolocations);

    List<GeolocationsResponse> toListGeolocationsResponses(List<Geolocation> geolocations);

}