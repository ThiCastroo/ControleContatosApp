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

import br.com.tgtdc.ContactManagement.dto.PessoaMalaDiretaDTO;
import br.com.tgtdc.ContactManagement.model.Pessoa;
import br.com.tgtdc.ContactManagement.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {
	
	@Autowired
	PessoaService pessoaService;
	
	@Operation(summary = "Retorna os dados de uma Pessoa por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
		Optional<Pessoa> findPessoa = pessoaService.findById(id);
		
		if(findPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(findPessoa);
	}
	
	@Operation(summary = "Lista todos os dados de Pessoas")
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> pessoas = pessoaService.findAll();
		
		if(pessoas == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pessoas);
	}
	
	@Operation(summary = "Cria uma nova Pessoa")
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		Pessoa newPessoa = pessoaService.save(pessoa);
		
		if (newPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(newPessoa);
	}
	
	@Operation(summary = "Atualiza o registro de uma Pessoa existente por ID")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa){
		Pessoa updatePessoa = pessoaService.update(pessoa);
		
		if(updatePessoa == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(updatePessoa);
	}
	
	@Operation(summary = "Remove uma Pessoa por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Operation(summary = "Retorna os dados de uma Pessoa por ID para mala direta")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<List<PessoaMalaDiretaDTO>> findByIdMalaDireta(@PathVariable Long id) {
		List<PessoaMalaDiretaDTO> pessoaMalaDiretaDTO = pessoaService.findByIdMalaDireta(id);
		
		if(pessoaMalaDiretaDTO == null) {
			return ResponseEntity.notFound().build();
		}
		if(pessoaMalaDiretaDTO.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pessoaMalaDiretaDTO);
	}
	
}
