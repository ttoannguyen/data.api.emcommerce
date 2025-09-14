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

public class OrderItemPKId implements Serializable {
    @Column(name = "order_id")
    String orderId;

    @Column(name = "order_item_id")
    Integer orderItemId;
}
