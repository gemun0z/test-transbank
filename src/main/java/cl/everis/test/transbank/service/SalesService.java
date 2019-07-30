package cl.everis.test.transbank.service;

import java.util.List;

import cl.everis.test.transbank.dto.SalesDTO;

public interface SalesService {

	List<SalesDTO> getSalesByCreateDate(String createDate);
	
	void saveSales(SalesDTO salesDTO);
	
}
