package com.yhoyos.bill.infrastructure.repository.builder;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.yhoyos.bill.domain.model.Bill;
import com.yhoyos.bill.infrastructure.repository.entity.BillEntity;

public class BillBuilder {

	public static BillEntity convertToEntity(Bill bill) {
		Timestamp generationDateTimestamp = Timestamp.valueOf(bill.getGenerationDate());
		return new BillEntity(generationDateTimestamp, bill.getSubTotal(), bill.getShippingCost(), bill.getTotalPrice());
	}
	
	public static Bill convertToDomain(BillEntity billEntity) {
		LocalDateTime generationDate = billEntity.getDate().toLocalDateTime();
		return new Bill(billEntity.getId() ,generationDate, billEntity.getSubTotal(), billEntity.getShippingCost(), billEntity.getTotalPrice());
	}
}
