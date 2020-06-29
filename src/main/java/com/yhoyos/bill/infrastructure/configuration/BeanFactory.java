package com.yhoyos.bill.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yhoyos.bill.domain.model.Cashier;
import com.yhoyos.bill.domain.repository.BillRepository;

@Configuration
public class BeanFactory {

	@Autowired
	private BillRepository billRepository;
	
	@Bean
	public Cashier cashier() {
		return new Cashier(this.billRepository);
	}
}
