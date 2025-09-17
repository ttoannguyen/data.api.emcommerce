package com.toanng.dataemcommerceapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.toanng.dataemcommerceapi.dto.response.OrderResponse;
import com.toanng.dataemcommerceapi.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "customer.customerId", target = "customer")
    OrderResponse toOrderResponse(OrderEntity order);
}
