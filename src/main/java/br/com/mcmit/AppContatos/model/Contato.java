package br.com.mcmit.AppContatos.model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "CONTATOS")
public class Contato {
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Id
	@Column(name= "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	/**
	 * 0 - Telefone
	 * 1 - Celular
	 * 2 - E-mail
	 * 3 - Rede Social
	 */
	@Column(name= "tipoContato", nullable= false)
	private Integer tipoContato;
	
	@Column(name = "contato", nullable= false)
	private String contato;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "id_pessoa")
	private Pessoa pessoa;
	
	public Contato() {}

	public Contato(Long id, Integer tipoContato, String contato, Pessoa pessoa) {
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
	
	/**
	 * 0 - Telefone
	 * 1 - Celular
	 * 2 - E-mail
	 * 3 - Rede Social
	 */
	public Integer getTipoContato() {
		return tipoContato;
	}
	
	/**
	 * 0 - Telefone
	 * 1 - Celular
	 * 2 - E-mail
	 * 3 - Rede Social
	 */
	public void setTipoContato(Integer tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
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

	
	
	
}
