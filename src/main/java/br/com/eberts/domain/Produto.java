package br.com.eberts.domain;

import java.util.List;
import java.util.Objects;

public class Produto {
	
	private Integer Id;
	private String nome;
	private String imagemURI;
	
	private List<Componente> componentes;
	
	public Produto () {}

	public Produto(Integer id, String nome, String imagemURI) {
		super();
		Id = id;
		this.nome = nome;
		this.imagemURI = imagemURI;
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

	public String getImagemURI() {
		return imagemURI;
	}

	public void setImagemURI(String imagemURI) {
		this.imagemURI = imagemURI;
	}

	public List<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
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
		Produto other = (Produto) obj;
		return Objects.equals(Id, other.Id);
	}
	
	

}
