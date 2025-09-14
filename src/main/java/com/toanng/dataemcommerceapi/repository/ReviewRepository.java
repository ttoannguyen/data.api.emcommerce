package com.toanng.dataemcommerceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toanng.dataemcommerceapi.entity.ReviewEntity;
import com.toanng.dataemcommerceapi.entity.ReviewPKId;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, ReviewPKId> {

}
