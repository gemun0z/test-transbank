package cl.everis.test.transbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.everis.test.transbank.dto.SalesDTO;
import cl.everis.test.transbank.service.SalesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Operaciones para agregar y obtener ventas")
public class SalesController {
	
	@Autowired
	private SalesService salesService;
	
	@ApiOperation(value = "Método para agregar ventas")
	@RequestMapping(value = "/sale", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<String> saveUser(@RequestBody SalesDTO salesDTO) {
		salesService.saveSales(salesDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Método para obtener ventas por fecha", response = SalesDTO.class, responseContainer = "List")
	@RequestMapping(value = "/sale/{createdate}", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<List<SalesDTO>> getSales(@PathVariable(value = "createdate") String createDate) {
		List<SalesDTO> salesDTOs = salesService.getSalesByCreateDate(createDate);
		if (salesDTOs != null && !salesDTOs.isEmpty()) {
			return new ResponseEntity<List<SalesDTO>>(salesDTOs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<SalesDTO>>(salesDTOs, HttpStatus.NO_CONTENT);
		}
		
	}

}
