package com.toanng.dataemcommerceapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "sellers", schema = "ecommerce")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellerEntity {
    @Id
    @Column(name = "seller_id")
    String sellerId;

    @Column(name = "seller_zip_code_prefix")
    String sellerZipCodePrefix;

    @Column(name = "seller_city")
    String sellerCity;

    @Column(name = "seller_state")
    String sellerState;
}
