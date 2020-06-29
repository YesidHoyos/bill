package com.yhoyos.bill.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import com.yhoyos.bill.domain.repository.BillRepository;
import com.yhoyos.bill.domain.service.BillGenerator;

public class Cashier implements BillGenerator{

	private static final double SHIPPING_COST = 10000;
	
	private BillRepository billRepository;
	
	public Cashier(BillRepository billRepository) {
		this.billRepository = billRepository;
	}

	@Override
	public Bill generateBill(long clientId, List<Product> products) {
				
		double shippingCost = calculateShippingCost();
		double subTotal = calculateSubTotal(products);
		double totalPrice = calculateTotalPrice(subTotal, shippingCost);
		
		Bill bill = new Bill(LocalDateTime.now(), subTotal, shippingCost, totalPrice);
		
		return this.billRepository.saveBill(bill);
	}
	
	public double calculateShippingCost() {
		return SHIPPING_COST;
	}
	
	public double calculateSubTotal(List<Product> products) {
		
		return products.stream()
				.mapToDouble(producto -> producto.getCost() * producto.getQuantity())
				.sum();	
	}
	
	public double calculateTotalPrice(double subTotal, double shippingCost) {
		return subTotal + shippingCost;
	}

}
