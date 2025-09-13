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
@Table(name = "product_category_translation", schema = "ecommerce")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategoryTranslation {
    @Id
    @Column(name = "product_category_name")
    String productCategoryName;

    @Column(name = "product_category_name_english")
    String productCategoryNameEnglish;
}
