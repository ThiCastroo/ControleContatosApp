package br.com.tgtdc.ContactManagement.model.enums;

public enum TipoContatoEnum {

	TELEFONE(0),
	CELULAR(1);
	
	private Integer tipo; 
	
	TipoContatoEnum(Integer tipo) {
		this.tipo = tipo;
	}
	
	public Integer getTipo() {
		return this.tipo;
	}
	
}
