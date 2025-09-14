package com.toanng.dataemcommerceapi.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentPKId implements Serializable {
    @Column(name = "order_id")
    String orderId;

    @Column(name = "payment_sequential")
    Integer paymentSequential;
}
