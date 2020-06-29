package com.yhoyos.bill.infrastructure.repository.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "bill")
@Entity
@Data
@NoArgsConstructor
public class BillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILL_SEQ")
    @SequenceGenerator(sequenceName = "bill_sequence", allocationSize = 1, name = "BILL_SEQ")
	@Column(name = "bill_id")
	private Long id;
	
	@Column(name = "generation_date")
	private Timestamp date;
	
	@Column(name = "subtotal")
	private double subTotal;
	
	@Column(name = "shipping_cost")
	private double shippingCost;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	public BillEntity(Timestamp date, double subTotal, double shippingCost, double totalPrice) {
		this.date = date;
		this.subTotal = subTotal;
		this.shippingCost = shippingCost;
		this.totalPrice = totalPrice;
	}
}
