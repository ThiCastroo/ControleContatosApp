package br.com.tgtdc.ContactManagement.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.tgtdc.ContactManagement.dto.ContatosPessoaIdDTO;
import br.com.tgtdc.ContactManagement.model.Contato;

public interface ContatoServiceInterface {

	Contato save(Contato contato);
	Optional<Contato> findById(Long id);
	List<Contato> findAll();
	Contato update(Contato contato);
	void delete(Long id);
	List<ContatosPessoaIdDTO> findAllByPessoaId(Long id);
	
}
