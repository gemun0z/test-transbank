package cl.everis.test.transbank.service;

import cl.everis.test.transbank.dto.SalesDTO;
import cl.everis.test.transbank.dto.SalesResponse;

public interface SalesService {

	SalesResponse getSalesByCreateDate(String createDate);
	
	void saveSales(SalesDTO salesDTO);
	
}
