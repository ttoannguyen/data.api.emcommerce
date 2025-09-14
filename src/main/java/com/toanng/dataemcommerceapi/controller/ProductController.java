package com.toanng.dataemcommerceapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toanng.dataemcommerceapi.dto.response.ApiResponse;
import com.toanng.dataemcommerceapi.dto.response.record.TopProductDTO;
import com.toanng.dataemcommerceapi.service.ProductService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;

    @GetMapping("/top/{n}")
    public ResponseEntity<ApiResponse<List<TopProductDTO>>> getMethodName(@PathVariable("n") int param) {
        return ResponseEntity.ok().body(productService.getTopNProducts(param));
    }

}
