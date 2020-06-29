package com.yhoyos.bill.infrastructure.repository.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yhoyos.bill.domain.model.Bill;
import com.yhoyos.bill.domain.repository.BillRepository;
import com.yhoyos.bill.infrastructure.repository.builder.BillBuilder;
import com.yhoyos.bill.infrastructure.repository.entity.BillEntity;
import com.yhoyos.bill.infrastructure.repository.persistence.jpa.BillRepositoryJpa;

@Repository
@Transactional
public class BillRepositoryImpl implements BillRepository {

	private BillRepositoryJpa billRepositoryJpa;
	
	public BillRepositoryImpl(BillRepositoryJpa billRepositoryJpa) {
		this.billRepositoryJpa = billRepositoryJpa;
	}
	
	@Override
	public Bill saveBill(Bill bill) {
		BillEntity billEntity = BillBuilder.convertToEntity(bill);
		return BillBuilder.convertToDomain(billRepositoryJpa.save(billEntity));
	}

}
