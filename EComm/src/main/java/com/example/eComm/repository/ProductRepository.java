package com.example.eComm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eComm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
