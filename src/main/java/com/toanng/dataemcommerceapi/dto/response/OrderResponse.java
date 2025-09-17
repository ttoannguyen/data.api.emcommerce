package com.toanng.dataemcommerceapi.dto.response;

import java.time.Instant;

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
public class OrderResponse {
    String orderId;

    String customer;

    String orderStatus;

    Instant orderPurchaseTimestamp;

    Instant orderApprovedAt;

    Instant orderDeliveredCarrierDate;

    Instant orderDeliveredCustomerDate;

    Instant orderEstimatedDeliveryDate;
}
