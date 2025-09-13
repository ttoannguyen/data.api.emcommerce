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
@Table(name = "products", schema = "ecommerce")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    String productId;

    @Column(name = "product_category_name")
    String productCategoryName;

    @Column(name = "product_name_length")
    Integer productNameLength;

    @Column(name = "product_description_length")
    Integer productDescriptionLength;

    @Column(name = "product_photos_qty")
    Integer productPhotoQty;

    @Column(name = "product_weight_g")
    Integer productWeightG;

    @Column(name = "product_length_cm")
    Integer productLengthCM;

    @Column(name = "product_height_cm")
    Integer productHeightCM;

    @Column(name = "product_width_cm")
    Integer productWidthCM;
}
