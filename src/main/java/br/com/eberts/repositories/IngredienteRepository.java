package br.com.eberts.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eberts.domain.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>  {

}