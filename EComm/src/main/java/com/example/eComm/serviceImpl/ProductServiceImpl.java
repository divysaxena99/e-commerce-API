package com.example.eComm.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eComm.entity.Product;
import com.example.eComm.exception.RecordNotFoundException;
import com.example.eComm.repository.ProductRepository;
import com.example.eComm.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Optional<Product> currProduct = productRepository.findById(id);
		
		currProduct.get().setStock(product.getStock());
		return currProduct.get();
	}

	@Override
	public String deleteById(long id) {
		productRepository.deleteById(id);
		return "Product deleted";
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Product not found"));
	}
	
	
}
