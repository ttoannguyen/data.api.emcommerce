package com.toanng.dataemcommerceapi.service;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.toanng.dataemcommerceapi.dto.response.ApiResponse;
import com.toanng.dataemcommerceapi.dto.response.OrderResponse;
import com.toanng.dataemcommerceapi.mapper.OrderMapper;
import com.toanng.dataemcommerceapi.repository.OrderRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {
    OrderRepository orderRepository;
    OrderMapper orderMapper;

    public ApiResponse<List<OrderResponse>> getOrders(Pageable data) {
        Page<OrderResponse> orders = orderRepository.findAll(data).map(orderMapper::toOrderResponse);
        return ApiResponse.<List<OrderResponse>>builder()
                .success(true)
                .data(orders.getContent())
                .error(null).metadata(new ApiResponse.MetaData(
                        orders.getNumber(), orders.getSize(), orders.getTotalElements()))
                .timestamp(Instant.now().toString())
                .build();
    }

}
