package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.eberts.domain.Ingrediente;
import br.com.eberts.repositories.IngredienteRepository;
import br.com.eberts.services.exceptions.DataIntegrityException;
import br.com.eberts.services.exceptions.ObjectNotFoundException;

@Service
public class IngredienteService {
	
	@Autowired 	
	private IngredienteRepository iRepo;
	
	public Ingrediente find(Integer id) {
		Optional<Ingrediente> ing = iRepo.findById(id);
		return ing.orElseThrow(()-> new ObjectNotFoundException("Ingrediente Id: " + id + ", não encontrado!"));
	}
	
	public Ingrediente insert(Ingrediente i) {
		i.setId(null);
		Ingrediente ing = iRepo.save(i);
		return ing;
	
	}
	
	public List<Ingrediente> findAll(){
		List<Ingrediente> list = iRepo.findAll();
		return list;
	}

	public Ingrediente update(Ingrediente ing) {
		find(ing.getId());
		return iRepo.save(ing);
		
	}

	public void delete(Integer id) {
		find(id);
		try {

			iRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir ingrediente usado em Produto existente!");
		}
		
	}

}
