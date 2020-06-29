package com.yhoyos.bill.application.handler;

import org.springframework.stereotype.Component;

import com.yhoyos.bill.application.dto.Order;
import com.yhoyos.bill.domain.model.Bill;
import com.yhoyos.bill.domain.service.BillGenerator;

/**
 * Clase encargada de manejar la comunicación entre el controlador y la lógica de negocio.
 * Su responsabilidad es tomar los datos de entrada y transformarlos en objetos de dominio(lógica de negocio).
 *
 */
@Component
public class GenerateBillHandler {

	private BillGenerator billGenerator;
	
	public GenerateBillHandler(BillGenerator billGenerator) {
		this.billGenerator = billGenerator;
	}
	
	public Bill generateBill(Order order) {
		return billGenerator.generateBill(order.getClientId(), order.getProducts());
	}
}
