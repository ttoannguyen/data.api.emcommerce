package com.toanng.dataemcommerceapi.dto.response.record;

public record TopProductDTO(
        String productId,
        String categoryName,
        Long totalSold) {
}
