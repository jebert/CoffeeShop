package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eberts.domain.Ingrediente;
import br.com.eberts.repositories.IngredienteRepository;
import br.com.eberts.services.exceptions.ObjectNotFoundException;

@Service
public class IngredienteService {
	
	@Autowired 	
	private IngredienteRepository iRepo;
	
	public Ingrediente find(Integer id) {
		Optional<Ingrediente> ing = iRepo.findById(id);
		return ing.orElseThrow(()-> new ObjectNotFoundException("Ingrediente Id: " + id + ", não encontrado!"));
	}
	
	public Ingrediente create(Ingrediente i) {
		Ingrediente ing = iRepo.save(i);
		return ing;
	
	}
	
	public List<Ingrediente> findAll(){
		List<Ingrediente> list = iRepo.findAll();
		return list;
	}

}
