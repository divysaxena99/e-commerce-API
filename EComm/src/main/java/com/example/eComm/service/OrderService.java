package com.example.eComm.service;

import java.util.List;

import com.example.eComm.entity.Order;
import com.example.eComm.model.OrderCart;

public interface OrderService {

	List<Order> getAllOrders();

	Order createOrder(OrderCart orderCart);

}
