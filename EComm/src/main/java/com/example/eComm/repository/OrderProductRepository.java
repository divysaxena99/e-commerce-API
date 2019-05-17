package com.example.eComm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eComm.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
