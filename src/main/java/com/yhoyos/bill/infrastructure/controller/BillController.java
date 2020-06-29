package com.yhoyos.bill.infrastructure.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhoyos.bill.application.dto.Order;
import com.yhoyos.bill.application.handler.GenerateBillHandler;
import com.yhoyos.bill.domain.model.Bill;

@RestController
@RequestMapping("/bill")
public class BillController {

	private GenerateBillHandler generateBillHandler;
	
	public BillController(GenerateBillHandler generateBillHandler) {
		this.generateBillHandler = generateBillHandler;
	}
	
	@PostMapping()
	public Bill generateBill(@RequestBody Order order) {
		return this.generateBillHandler.generateBill(order);
	}
}
