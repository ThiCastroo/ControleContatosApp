package br.com.tgtdc.ContactManagement.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tgtdc.ContactManagement.dto.ContatosPessoaIdDTO;
import br.com.tgtdc.ContactManagement.model.Contato;
import br.com.tgtdc.ContactManagement.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {
	
	@Autowired
	ContatoService contatoService;
	
	@Operation(summary = "Retorna os dados de um Contato por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.findById(id);
		
		if(findContato == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(findContato);
	}
	
	@Operation(summary = "Lista todos os Contatos")
	@GetMapping
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> contatos = contatoService.findAll();
		
		if(contatos == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(contatos);
	}
	
	@Operation(summary = "Adiciona um novo Contato a uma Pessoa")
	@PostMapping
	public ResponseEntity<Contato> save(@RequestBody Contato contato) {
		Contato newContato = contatoService.save(contato);
		
		if (newContato == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(newContato);
	}
	
	@Operation(summary = "Atualiza o registro de um Contato existente por ID")
	@PutMapping("/{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato){
		Contato updateContato = contatoService.update(contato);
		
		if(updateContato == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(updateContato);
	}
	
	@Operation(summary = "Remove uma Pessoa por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Operation(summary = "Lista todos os Contatos de uma Pessoa")
	@GetMapping("/pessoa/{idPessoa}")
	public ResponseEntity<List<ContatosPessoaIdDTO>> findByIdMalaDireta(@PathVariable Long idPessoa) {
		List<ContatosPessoaIdDTO> contatosPessoaIdDTO = contatoService.findAllByPessoaId(idPessoa);
		
		if(contatosPessoaIdDTO == null) {
			return ResponseEntity.notFound().build();
		}
		if(contatosPessoaIdDTO.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(contatosPessoaIdDTO);
	}
}
