package br.com.eberts.domain.enums;

public enum UnidadeDeMedida {

	l(1,"Litro"),
	ml(2,"Mililitro"),
	kg(3,"Kilograma"),
	g(4,"Grama"),
	un(5,"Unidade");
	
	private int cod;
	private String nome;
	
	private UnidadeDeMedida(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
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
