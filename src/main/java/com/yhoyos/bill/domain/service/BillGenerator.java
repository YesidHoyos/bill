package com.yhoyos.bill.domain.service;

import java.util.List;

import com.yhoyos.bill.domain.model.Bill;
import com.yhoyos.bill.domain.model.Product;

public interface BillGenerator {

	public Bill generateBill(long clientId, List<Product> products);
}
