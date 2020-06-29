package com.yhoyos.bill.domain.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yhoyos.bill.domain.model.Bill;
import com.yhoyos.bill.domain.model.Cashier;
import com.yhoyos.bill.domain.model.Product;
import com.yhoyos.bill.domain.repository.BillRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CashierTest {

	@Mock
	private BillRepository billRepository;
	
	@InjectMocks
	private Cashier cashier;
	
	private static final double SHIPPING_COST = 10000;
	
	@Test
	public void generateBillTest() {
		//arrange
		long clientId = 1;
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, 2, 50000));
		products.add(new Product(2, 1, 70000));
		
		double subTotal = 170000;
		double shippingCost = SHIPPING_COST;
		double totalPrice = 180000;
		
		Bill billExpected = new Bill(1, LocalDateTime.now(), subTotal, shippingCost, totalPrice);
		
		when(billRepository.saveBill(Mockito.any())).thenReturn(billExpected);
		//act
		Bill bill = this.cashier.generateBill(clientId, products);
		//assert
		assertEquals(billExpected, bill);
	}
	
	@Test
	public void calculateShippingCostTest() {
		//arrange
		double shippingCostExpected = SHIPPING_COST;
		//act
		double shippingCost = this.cashier.calculateShippingCost();
		//assert
		assertEquals(shippingCostExpected, shippingCost);
	}
	
	@Test
	public void calculateSubTotalTest() {
		//arrange
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, 2, 50000));
		products.add(new Product(2, 1, 70000));
		
		double subTotalExpected = 170000;
		//act
		double subTotal = this.cashier.calculateSubTotal(products);
		//assert
		assertEquals(subTotalExpected, subTotal);
	}
	
	@Test
	public void calculateTotalPriceTest() {
		//arrange
		double shippingCost = SHIPPING_COST;
		double subTotal = 170000;
		double totalPriceExpected = 180000;
		//act
		double totalPrice = this.cashier.calculateTotalPrice(subTotal, shippingCost);
		//assert
		assertEquals(totalPriceExpected, totalPrice);
	}
}
