package com.toanng.dataemcommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toanng.dataemcommerceapi.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

}
