package br.com.eberts.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import br.com.eberts.domain.enums.UnidadeDeMedida;

@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	private String nome;
	private int unidadeDeMedida;
	private Double preco;
	
	public Ingrediente() {}
	
	public Ingrediente(Integer id, String nome, UnidadeDeMedida unidadeDeMedida, Double preco) {
		super();
		Id = id;
		this.nome = nome;
		this.unidadeDeMedida = unidadeDeMedida.getCod();
		this.preco = preco;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeDeMedida getUnidadeDeMedida() {
		return UnidadeDeMedida.toEnum(unidadeDeMedida);
	}

	public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida.getCod();
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(Id, other.Id);
	}
	
	

}
