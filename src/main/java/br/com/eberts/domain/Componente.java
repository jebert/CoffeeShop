package br.com.eberts.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Componente implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;
	
	@OneToOne
	@JoinColumn(name="ingrediente_id")
	private Ingrediente ingrediente;
	
	private Double quantidade;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	public Componente() {
		
	}

	public Componente(Integer Id, Ingrediente ingrediente, Double quantidade, Produto produto) {
		super();
		this.Id = Id;
		this.ingrediente = ingrediente;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, ingrediente, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Componente other = (Componente) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(ingrediente, other.ingrediente)
				&& Objects.equals(produto, other.produto);
	}
	
	
	
	

}
