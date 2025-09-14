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
@Table(name = "customers", schema = "ecommerce")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerEntity {
    @Id
    @Column(name = "customer_id")
    String customerId;

    @Column(name = "customer_unique_id")
    String customerUniqueId;

    @Column(name = "customer_zip_code_prefix")
    String customerZipCodePrefix;

    @Column(name = "customer_city")
    String customerCity;

    @Column(name = "customer_state")
    String customerState;
}
