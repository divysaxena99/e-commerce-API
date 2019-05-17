package com.example.eComm.model;

import java.util.List;

public class OrderCart {
	
	private long id;
	private List<ProductOrderModel> productList;
	private String emailId;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<ProductOrderModel> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductOrderModel> productList) {
		this.productList = productList;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
