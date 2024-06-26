package br.com.tgtdc.ContactManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tgtdc.ContactManagement.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	@Query(value = "select tp.id, tp.nome, tp.endereco || ' - Cep: ' || tp.cep || ' - Cidade: ' || tp.cidade || ' - UF: ' || tp.uf as mala_direta from tb_pessoa tp", 
			nativeQuery = true)
	List<Object[]> findByIdMalaDireta();
}
