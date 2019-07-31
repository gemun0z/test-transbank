package cl.everis.test.transbank.dto;

import java.util.List;

public class SalesResponse {

	private List<SalesDTO> sales;

	public List<SalesDTO> getSales() {
		return sales;
	}

	public void setSales(List<SalesDTO> sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "SalesResponse [sales=" + sales + "]";
	}
	
}
