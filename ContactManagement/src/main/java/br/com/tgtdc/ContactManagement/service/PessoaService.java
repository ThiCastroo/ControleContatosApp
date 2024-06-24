package br.com.tgtdc.ContactManagement.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgtdc.ContactManagement.dto.PessoaMalaDiretaDTO;
import br.com.tgtdc.ContactManagement.model.Pessoa;
import br.com.tgtdc.ContactManagement.repository.PessoaRepository;
import br.com.tgtdc.ContactManagement.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public Pessoa save(Pessoa pessoa) {
		if (pessoa.getNome() == null) {
			return null;
		}
		try {
			return pessoaRepository.save(pessoa);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar pessoa: " + pessoa.toString() + " | " + e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id);
	}


	@Override
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		if (findPessoa.isPresent()) {
			Pessoa updatePessoa = findPessoa.get();
			updatePessoa.setNome(pessoa.getNome());
			updatePessoa.setEndereco(pessoa.getEndereco());
			updatePessoa.setCep(pessoa.getCep());
			updatePessoa.setCidade(pessoa.getCidade());
			updatePessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updatePessoa);
		}
		
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	@Override
	public List<PessoaMalaDiretaDTO> findByIdMalaDireta(Long id) {
		List<Object[]> listResultado = pessoaRepository.findByIdMalaDireta();
		List<PessoaMalaDiretaDTO> listPessoaMalaDiretaDTO = new ArrayList<PessoaMalaDiretaDTO>();
		
		for(Object[] obj : listResultado) {
			PessoaMalaDiretaDTO pDTO = returnBDPessoaMalaDiretaDTO(obj);
			listPessoaMalaDiretaDTO.add(pDTO);
		}
		
		return listPessoaMalaDiretaDTO;
	}
	
	private PessoaMalaDiretaDTO returnBDPessoaMalaDiretaDTO(Object[] resultado) {
		if (resultado != null) {
			PessoaMalaDiretaDTO pessoaMalaDiretaDTO = new PessoaMalaDiretaDTO(
					((Long)resultado[0]).longValue(),
					((String)resultado[1]),
					((String)resultado[2])
					);
			return pessoaMalaDiretaDTO;
		} else {
			return null;
		}
	}
}
