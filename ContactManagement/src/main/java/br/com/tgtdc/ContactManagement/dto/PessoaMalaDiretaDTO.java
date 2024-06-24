package br.com.tgtdc.ContactManagement.dto;

public record PessoaMalaDiretaDTO(
		Long id,
		String nome,
		String malaDireta, 
		String endereco,
		String cep,
		String cidade, 
		String uf) {}
