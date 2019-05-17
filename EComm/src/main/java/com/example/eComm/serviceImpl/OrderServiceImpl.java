package com.example.eComm.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.eComm.entity.Order;
import com.example.eComm.entity.OrderProduct;
import com.example.eComm.entity.Product;
import com.example.eComm.exception.OutOfStockException;
import com.example.eComm.exception.RecordNotFoundException;
import com.example.eComm.model.OrderCart;
import com.example.eComm.model.ProductOrderModel;
import com.example.eComm.repository.OrderProductRepository;
import com.example.eComm.repository.OrderRepository;
import com.example.eComm.repository.ProductRepository;
import com.example.eComm.service.OrderService;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderProductRepository orderProductRepository;
	@Autowired
	ProductRepository productRepository;
	
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}


	@Override
	@Transactional
	public Order createOrder(OrderCart orderCart) {
		Order order = new Order();
		
		this.updateProductQuantity(orderCart.getProductList());
		
		order.setDateCreated(LocalDateTime.now());
		order.setEmailId(orderCart.getEmailId());
		order.setTotalCost(this.calculateTotalCost(orderCart.getProductList()));
		
		orderRepository.save(order);
		
		this.createOrderProductMapping(orderCart.getProductList(), order);
		
		return order;
	}

	@Transactional
	private void updateProductQuantity(List<ProductOrderModel> productList) {
		if(this.checkForProductQuantity(productList)) {
			for(ProductOrderModel productDetails:productList) {
				Product product = productRepository.findById(productDetails.getProductId())
						.orElseThrow(() -> new RecordNotFoundException("Product not found"));
						
						
				product.setStock(product.getStock()-productDetails.getQuantity());
				productRepository.save(product);
			}
		}
		else {
			throw new OutOfStockException("Product quantity cannot exceed stock");
		}
		
	}


	private boolean checkForProductQuantity(List<ProductOrderModel> productList) {
		for(ProductOrderModel productDetails:productList) {
			Product product = productRepository.findById(productDetails.getProductId())
					.orElseThrow(() -> new RecordNotFoundException("Product not found"));
			
			if(product.getStock()<productDetails.getQuantity()) {
				return false;
			}
		}
		return true;
	}


	private void createOrderProductMapping(List<ProductOrderModel> productList, Order order) {
		
		for(ProductOrderModel productDetails:productList) {
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setProduct(
					productRepository.findById(productDetails.getProductId())
					.orElseThrow(() -> new RecordNotFoundException("Product not found")));
			
			orderProduct.setQuantity(productDetails.getQuantity());
			orderProduct.setOrder(order);
			
			orderProductRepository.save(orderProduct);
		}
		return;
	}


	private double calculateTotalCost(List<ProductOrderModel> productList) {
		double totalCost = 0;
		Product product = new Product();
		for(ProductOrderModel productDetails:productList) {
			product = productRepository.findById(productDetails.getProductId()).get();
			
			totalCost += product.getPrice() * productDetails.getQuantity();
		}
		return totalCost;
	}

}
