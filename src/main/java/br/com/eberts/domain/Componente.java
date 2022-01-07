package br.com.eberts.domain;

import java.io.Serializable;
import java.util.Objects;

public class Componente implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Ingrediente ingrediente;
	private Double quantidade;
	
	private Produto produto;
	
	public Componente() {
		
	}

	public Componente(Integer id, Ingrediente ingrediente, Double quantidade, Produto produto) {
		super();
		this.id = id;
		this.ingrediente = ingrediente;
		this.quantidade = quantidade;
		this.produto = produto;
	}
	
	
	
	

}
