package com.toanng.dataemcommerceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toanng.dataemcommerceapi.dto.response.record.TopProductDTO;
import com.toanng.dataemcommerceapi.entity.OrderItemEntity;
import com.toanng.dataemcommerceapi.entity.OrderItemPKId;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemPKId> {

    @Query(value = """
            SELECT p.product_id, p.product_category_name, COUNT(oi.product_id) AS total_sold
            FROM ecommerce.order_items oi
            JOIN ecommerce.products p ON oi.product_id = p.product_id
            GROUP BY p.product_id, p.product_category_name
            ORDER BY total_sold DESC
            LIMIT :limit
            """, nativeQuery = true)

    public List<TopProductDTO> findTopNProducts(@Param("limit") int limit);
}
