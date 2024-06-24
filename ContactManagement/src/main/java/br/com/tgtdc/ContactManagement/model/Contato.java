package br.com.tgtdc.ContactManagement.model;

import java.util.Objects;

import br.com.tgtdc.ContactManagement.model.enums.TipoContatoEnum;

public class Contato {

	private Long id;
	private TipoContatoEnum tipoContato;
	private String contato;
	private Pessoa pessoa;
	
	public Contato() {}
	
	public Contato(Long id, TipoContatoEnum tipoContato, String contato, Pessoa pessoa) {
		this.id = id;
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoContatoEnum getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(TipoContatoEnum tipoContato) {
		this.tipoContato = tipoContato;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Contato [Id: " + this.id + ", Tipo de Contato: " + this.tipoContato + 
				", Contato: " + this.contato + ", Pessoa: " + this.pessoa + "]";
	} 
}
