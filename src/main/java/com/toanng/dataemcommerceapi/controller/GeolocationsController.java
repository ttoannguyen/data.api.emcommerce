package com.toanng.dataemcommerceapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toanng.dataemcommerceapi.dto.response.ApiResponse;
import com.toanng.dataemcommerceapi.dto.response.GeolocationsResponse;
import com.toanng.dataemcommerceapi.service.GeolocationsService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/geolocations")
public class GeolocationsController {
    GeolocationsService geolocationsService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<GeolocationsResponse>>> getAllGeolocations(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok().body(geolocationsService.getAllGeolocationList(page, size));
    }
}
