package br.com.tgtdc.ContactManagement.dto;

public record ContatosPessoaIDDTO(
		Long id, 
		Integer tipoContato, 
		String contato,
		Long idPessoa) {}
