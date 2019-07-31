package cl.everis.test.transbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.everis.test.transbank.model.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, String> {
	
	List<Sales> findSalesByCreateDate(String createDate);

}
