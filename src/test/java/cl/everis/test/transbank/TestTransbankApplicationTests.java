package cl.everis.test.transbank;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import cl.everis.test.transbank.dto.SalesDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebClient
public class TestTransbankApplicationTests {

	@Autowired
    private TestRestTemplate template;
	
	private String token;
	
	@Before
	public void setup() throws Exception {
		ResponseEntity<String> responseEntity = template.withBasicAuth("transbank", "transbank").
				getForEntity("/login", String.class);
		token = responseEntity.getBody();
	}
	
	@Test
	public void loginAuthTest() throws Exception {
		ResponseEntity<String> responseEntity = template.withBasicAuth("transbank", "transbank").
				getForEntity("/login", String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void saveSalesTest() throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", token);
        
        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setDescription("Test Product");
        salesDTO.setPrice("$100.000");
        salesDTO.setCreateDate("30-07-2019");

        HttpEntity<SalesDTO> requestEntity = new HttpEntity<>(salesDTO, requestHeaders);
        
        ResponseEntity<String> responseEntity = template.exchange("/api/v1/sale", HttpMethod.POST, requestEntity, String.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	@Test
	public void getSalesTest() throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", token);
        
        Map<String, String> params = new HashMap<>();
        params.put("createdate", "transbank");
        
        ResponseEntity<List<SalesDTO>> responseEntity = template.exchange("/api/v1/sale", HttpMethod.GET)
	}
	
	@Test
	public void contextLoads() {
	}

}
