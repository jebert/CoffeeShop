package br.com.eberts.domain;

import br.com.eberts.domain.enums.UnidadeDeMedida;

public class Ingrediente {
	
	private Integer Id;
	private String nome;
	private int unidadeDeMedida;
	private Double preco;
	
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
	
	

}
