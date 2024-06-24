package br.com.tgtdc.ContactManagement.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.tgtdc.ContactManagement.dto.PessoaMalaDiretaDTO;
import br.com.tgtdc.ContactManagement.model.Pessoa;

public interface PessoaServiceInterface {

	Pessoa save(Pessoa pessoa);
	Optional<Pessoa> findById(Long id);
	List<Pessoa> findAll();
	Pessoa update(Pessoa pessoa);
	void delete(Long id);
	List<PessoaMalaDiretaDTO> findByIdMalaDireta(Long id);
}
