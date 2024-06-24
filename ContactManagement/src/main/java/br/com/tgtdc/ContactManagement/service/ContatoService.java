package br.com.tgtdc.ContactManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgtdc.ContactManagement.model.Contato;
import br.com.tgtdc.ContactManagement.repository.ContatoRepository;
import br.com.tgtdc.ContactManagement.repository.PessoaRepository;
import br.com.tgtdc.ContactManagement.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService implements ContatoServiceInterface{
	
	@Autowired
	private ContatoRepository contatoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Contato save(Contato contato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Contato> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Contato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contato update(Contato contato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}	
}
