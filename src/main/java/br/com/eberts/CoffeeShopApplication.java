package br.com.eberts;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.eberts.domain.Ingrediente;
import br.com.eberts.domain.enums.UnidadeDeMedida;
import br.com.eberts.repositories.IngredienteRepository;

@SpringBootApplication
public class CoffeeShopApplication implements CommandLineRunner {
	
	@Autowired
	IngredienteRepository iRepo;
	
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
		Ingrediente chocolate = new Ingrediente(null,"Chocolate",UnidadeDeMedida.LITRO,7.75);
		Ingrediente vanilla = new Ingrediente(null,"Vanilla",UnidadeDeMedida.GRAMA,0.75);
		Ingrediente icecream = new Ingrediente(null,"Icecream",UnidadeDeMedida.LITRO, 5.25);

		iRepo.saveAll(Arrays.asList(water,egg,milk,coffee,flour,chocolate,vanilla,icecream));
	}

}
