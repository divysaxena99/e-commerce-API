package com.example.eComm.entity;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	private LocalDateTime dateCreated;
	
	private String emailId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private List<OrderProduct> orderProducts ;
	
	private double totalCost;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public LocalDateTime getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}


	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
