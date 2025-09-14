package com.toanng.dataemcommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toanng.dataemcommerceapi.entity.ProductCategoryTranslationEntity;

@Repository
public interface ProductCategoryTranslationRepository extends JpaRepository<ProductCategoryTranslationEntity, String> {

}
