package br.com.tgtdc.ContactManagement.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tgtdc.ContactManagement.service.ContatoService;
import br.com.tgtdc.ContactManagement.service.PessoaService;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {
	
	@Autowired
	ContatoService contatoService;
	
	@Autowired
	PessoaService pessoaService;
	
	
	
}
