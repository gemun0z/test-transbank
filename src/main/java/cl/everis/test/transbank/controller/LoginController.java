package cl.everis.test.transbank.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;

@RestController
public class LoginController {

	private final String SECRET = "testSecretKey";
	
	@ApiOperation(value = "Método para aunteticarse")
	@GetMapping("/login")
	public String login() {
	
		String token;
		token = getJWTToken();
		return token;
		
	}
	
	private String getJWTToken() {
				
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("everisJWT")
				.setSubject("USER")
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();

		return "Bearer " + token;
	}
	
}
