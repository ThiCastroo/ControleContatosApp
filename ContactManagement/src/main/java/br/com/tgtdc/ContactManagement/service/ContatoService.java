package br.com.tgtdc.ContactManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgtdc.ContactManagement.dto.ContatosPessoaIDDTO;
import br.com.tgtdc.ContactManagement.model.Contato;
import br.com.tgtdc.ContactManagement.model.Pessoa;
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
		if (contato.getPessoa().getId() != null) {
			Optional<Pessoa> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			
			if (!findPessoa.isEmpty()) {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			} else {
				System.out.println("Pessoa não encontrada com o id: " + contato.getPessoa().getId());
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public Optional<Contato> findById(Long id) {
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}

	@Override
	public Contato update(Contato contato) {
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		
		if (findContato.isPresent()) {
			Contato updateContato = findContato.get();
			
			updateContato.setTipoContato(contato.getTipoContato());
			updateContato.setContato(contato.getContato());
			updateContato.setPessoa(contato.getPessoa());
			
			return contatoRepository.save(updateContato);
		} else {
			return save(contato);
		}
	}

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}

	@Override
	public List<ContatosPessoaIDDTO> findAllByPessoaId(Long idPessoa) {
		List<Object[]> listResultado = contatoRepository.findAllByPessoaId(idPessoa);
		List<ContatosPessoaIDDTO> listAllByPessoaId = new ArrayList<ContatosPessoaIDDTO>();
		
		for (Object[] obj : listResultado) {
			ContatosPessoaIDDTO cDTO = returnDBContatosPessoaIdDTO(obj);
			listAllByPessoaId.add(cDTO);
		}
		return listAllByPessoaId;
	}
	
	private ContatosPessoaIDDTO returnDBContatosPessoaIdDTO(Object[] resultado) {
		if (resultado != null) {
			ContatosPessoaIDDTO contatosByPessoaId = new ContatosPessoaIDDTO(
					((Long)resultado[0]).longValue(),
					((Integer)resultado[1]).intValue(),
					(String)resultado[2],
					((Long)resultado[3]).longValue());
			return contatosByPessoaId;
		}else {
			return null;
		}
	}
}
