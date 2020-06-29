package com.yhoyos.bill.application.dto;

import java.util.List;

import com.yhoyos.bill.domain.model.Product;

import lombok.Data;

@Data
public class Order {

	private long clientId;
	private List<Product> products;
}
