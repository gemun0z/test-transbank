package cl.everis.test.transbank.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.everis.test.transbank.dto.SalesDTO;
import cl.everis.test.transbank.dto.SalesResponse;
import cl.everis.test.transbank.model.Sales;
import cl.everis.test.transbank.repository.SalesRepository;
import cl.everis.test.transbank.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	private SalesRepository salesRepository;

	@Override
	public SalesResponse getSalesByCreateDate(String createDate) {
		// TODO Auto-generated method stub
		List<Sales> sales = salesRepository.findSalesByCreateDate(createDate);
		List<SalesDTO> salesDTOs = sales.stream().map(p -> new SalesDTO(p.getDescription(), p.getPrice(), p.getCreateDate())).collect(Collectors.toList());
		SalesResponse response = new SalesResponse();
		response.setSales(salesDTOs);
		return response;
	}

	@Override
	public void saveSales(SalesDTO salesDTO) {
		// TODO Auto-generated method stub
		Sales sales = new Sales();
		BeanUtils.copyProperties(salesDTO, sales);
		salesRepository.save(sales);
	}

}
