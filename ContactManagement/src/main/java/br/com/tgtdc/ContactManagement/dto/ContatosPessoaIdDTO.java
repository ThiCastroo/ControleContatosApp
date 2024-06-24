package br.com.tgtdc.ContactManagement.dto;

public record ContatosPessoaIdDTO(
		Long id, 
		Integer tipoContato, 
		String contato,
		Long pessoa_id
		) {}
