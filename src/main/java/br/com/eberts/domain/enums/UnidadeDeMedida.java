package br.com.eberts.domain.enums;

public enum UnidadeDeMedida {

	LITRO(1,"Litro","l"),
	MILILITRO(2,"Mililitro","ml"),
	KILOGRAMA(3,"Kilograma","kg"),
	GRAMA(4,"Grama","g"),
	UNIDADE(5,"Unidade","un");
	
	private int cod;
	private String nome;
	private String simbolo;
	
	private UnidadeDeMedida(int cod, String nome, String simbolo) {
		this.cod = cod;
		this.nome = nome;
		this.simbolo = simbolo;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public String getSimbolo() {
		return simbolo;
	}
	
	public static UnidadeDeMedida toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(UnidadeDeMedida x : UnidadeDeMedida.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido: " + cod);
	}
	
}
