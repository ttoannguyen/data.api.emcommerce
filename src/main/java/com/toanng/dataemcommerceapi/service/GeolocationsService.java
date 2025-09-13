package com.toanng.dataemcommerceapi.service;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.toanng.dataemcommerceapi.dto.response.ApiResponse;
import com.toanng.dataemcommerceapi.dto.response.GeolocationsResponse;
import com.toanng.dataemcommerceapi.entity.Geolocation;
import com.toanng.dataemcommerceapi.mapper.GeolocationsMapper;
import com.toanng.dataemcommerceapi.repository.GeolocationsRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GeolocationsService {
        GeolocationsRepository geolocationsRepository;
        GeolocationsMapper geolocationsMapper;

        public ApiResponse<List<GeolocationsResponse>> getAllGeolocationList(int page, int size) {
                Pageable pageable = PageRequest.of(page, size);

                Page<Geolocation> geolocationsPage = geolocationsRepository.findAll(pageable);

                List<GeolocationsResponse> geolocations = geolocationsMapper
                                .toListGeolocationsResponses(geolocationsPage.getContent());

                return ApiResponse.<List<GeolocationsResponse>>builder()
                                .success(true)
                                .data(geolocations)
                                .metadata(new ApiResponse.MetaData(
                                                page, size, geolocationsPage.getTotalElements()))
                                .timestamp(Instant.now().toString())
                                .build();
        }

}
