package br.com.tgtdc.ContactManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tgtdc.ContactManagement.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{}
