package br.com.eberts;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.eberts.domain.Componente;
import br.com.eberts.domain.Ingrediente;
import br.com.eberts.domain.Produto;
import br.com.eberts.domain.enums.UnidadeDeMedida;
import br.com.eberts.repositories.ComponenteRepository;
import br.com.eberts.repositories.IngredienteRepository;
import br.com.eberts.repositories.ProdutoRepository;

@SpringBootApplication
public class CoffeeShopApplication implements CommandLineRunner {
	
	@Autowired
	IngredienteRepository iRepo;
	
	@Autowired
	ProdutoRepository pRepo;
	
	@Autowired
	ComponenteRepository cRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Ingrediente water = new Ingrediente(null,"Water",UnidadeDeMedida.LITRO, 0.20);
		Ingrediente egg  = new Ingrediente(null,"Egg",UnidadeDeMedida.UNIDADE, 0.10);		
		Ingrediente milk = new Ingrediente(null,"Milk",UnidadeDeMedida.LITRO, 3.20);
		Ingrediente coffee = new Ingrediente(null,"Coffee",UnidadeDeMedida.GRAMA, 5.50);
		Ingrediente flour = new Ingrediente(null,"Flour",UnidadeDeMedida.KILOGRAMA ,2.75);
		Ingrediente chocolate = new Ingrediente(null,"Chocolate",UnidadeDeMedida.GRAMA,0.75);
		Ingrediente vanilla = new Ingrediente(null,"Vanilla",UnidadeDeMedida.GRAMA,0.75);
		Ingrediente icecream = new Ingrediente(null,"Icecream",UnidadeDeMedida.LITRO, 5.25);

		Produto capuccino = new Produto(null,"Capuccino", 6.00, "URL_Imagem");
		
		Componente c1 = new Componente(null,milk,0.05,capuccino);
		Componente c2 = new Componente(null,coffee,10.00,capuccino);
		Componente c3 = new Componente(null,chocolate,0.03,capuccino);
		
		capuccino.setComponentes(Arrays.asList(c1,c2,c3));
		
		

		
		iRepo.saveAll(Arrays.asList(water,egg,milk,coffee,flour,chocolate,vanilla,icecream));
		pRepo.saveAll(Arrays.asList(capuccino));
		cRepo.saveAll(Arrays.asList(c1,c2,c3));
	}

}
