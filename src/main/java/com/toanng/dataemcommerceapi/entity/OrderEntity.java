package com.toanng.dataemcommerceapi.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "orders", schema = "ecommerce")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    String orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    CustomerEntity customer;

    @Column(name = "order_status")
    String orderStatus;

    @Column(name = "order_purchase_timestamp")
    Instant orderPurchaseTimestamp;

    @Column(name = "order_approved_at")
    Instant orderApprovedAt;

    @Column(name = "order_delivered_carrier_date")
    Instant orderDeliveredCarrierDate;

    @Column(name = "order_delivered_customer_date")
    Instant orderDeliveredCustomerDate;

    @Column(name = "order_estimated_delivery_date")
    Instant orderEstimatedDeliveryDate;
}
