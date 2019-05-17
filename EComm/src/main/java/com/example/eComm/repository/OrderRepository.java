package com.example.eComm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eComm.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
