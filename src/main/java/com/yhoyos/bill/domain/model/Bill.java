package com.yhoyos.bill.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Bill {

	private long id;
	private LocalDateTime generationDate;
	private double subTotal;
	private double shippingCost;
	private double totalPrice;
	
	public Bill(LocalDateTime generationDate, double subTotal, double shippingCost, double totalPrice) {
		this.generationDate = generationDate;
		this.subTotal = subTotal;
		this.shippingCost = shippingCost;
		this.totalPrice = totalPrice;
	}

	public Bill(long id, LocalDateTime generationDate, double subTotal, double shippingCost, double totalPrice) {
		this.id = id;
		this.generationDate = generationDate;
		this.subTotal = subTotal;
		this.shippingCost = shippingCost;
		this.totalPrice = totalPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(LocalDateTime generationDate) {
		this.generationDate = generationDate;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(generationDate, id, shippingCost, subTotal, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return Objects.equals(generationDate, other.generationDate) && id == other.id
				&& Double.doubleToLongBits(shippingCost) == Double.doubleToLongBits(other.shippingCost)
				&& Double.doubleToLongBits(subTotal) == Double.doubleToLongBits(other.subTotal)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}	
}
