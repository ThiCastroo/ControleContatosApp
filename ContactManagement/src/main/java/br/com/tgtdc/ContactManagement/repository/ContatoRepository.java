package br.com.tgtdc.ContactManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tgtdc.ContactManagement.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	@Query(value = "select tc.id, tc.tipo_contato, tc.contato, tc.pessoa_id from tb_contato tc inner join tb_pessoa tp on tc.pessoa_id = tp.id where tp.id = ?1", 
			nativeQuery = true)
	List<Object[]> findAllByPessoaId(Long id);
}
