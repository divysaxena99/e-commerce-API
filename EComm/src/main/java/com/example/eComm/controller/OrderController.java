package com.example.eComm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eComm.entity.Order;
import com.example.eComm.model.OrderCart;
import com.example.eComm.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@PostMapping
	public Order createOrder(@RequestBody OrderCart orderCart) {
		return orderService.createOrder(orderCart);
	}
}
