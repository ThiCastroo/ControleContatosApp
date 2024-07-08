package br.com.tgtdc.ContactManagement.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tgtdc.ContactManagement.configuration.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class AuthController {
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Operation(summary = "Retorna o token para autorizar a aplicação")
	@GetMapping("/token") //http://localhost:8080/token?username=NOME
	public ResponseEntity<?> createToken(@RequestParam String username) {
		String token = jwtTokenUtil.createToken(username);
		return ResponseEntity.ok(token);	
	}
}
