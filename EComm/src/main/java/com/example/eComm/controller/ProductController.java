package com.example.eComm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eComm.entity.Product;
import com.example.eComm.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> findAllEmployee() {
		return productService.findAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable(value="id") long id) {
		return productService.getProductById(id);
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable(value="id") long id, @RequestBody Product product){
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable long id) {
		return productService.deleteById(id);
	}
}
