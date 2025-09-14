package com.toanng.dataemcommerceapi.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toanng.dataemcommerceapi.dto.response.ApiResponse;
import com.toanng.dataemcommerceapi.dto.response.record.TopProductDTO;
import com.toanng.dataemcommerceapi.repository.OrderItemRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    OrderItemRepository orderItemRepository;

    public ApiResponse<List<TopProductDTO>> getTopNProducts(int limit) {
        return ApiResponse.<List<TopProductDTO>>builder()
                .error(null)
                .success(true)
                // .metadata(new ApiResponse.MetaData())
                .data(orderItemRepository.findTopNProducts(limit))
                .timestamp(Instant.now().toString())
                .build();

    }

}
