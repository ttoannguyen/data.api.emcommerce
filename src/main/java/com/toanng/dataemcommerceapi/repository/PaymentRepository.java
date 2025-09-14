package com.toanng.dataemcommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toanng.dataemcommerceapi.entity.PaymentEntity;
import com.toanng.dataemcommerceapi.entity.PaymentPKId;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, PaymentPKId> {

}
