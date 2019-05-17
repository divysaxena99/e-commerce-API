package com.example.eComm.service;

import java.util.List;
import java.util.Optional;

import com.example.eComm.entity.Product;

public interface ProductService {

	List<Product> findAllProducts();

	Product updateProduct(long id, Product product);

	String deleteById(long id);

	Product createProduct(Product product);

	Product getProductById(long id);

}
