package com.yhoyos.bill.domain.model;

public class Product {

	private long id;
	private int quantity;
	private double cost;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Product(long id, int quantity, double cost) {
		this.id = id;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public Product() {}
	
	
}
