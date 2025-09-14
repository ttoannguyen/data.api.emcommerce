package com.toanng.dataemcommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toanng.dataemcommerceapi.entity.SellerEntity;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, String> {

}
