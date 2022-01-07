package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eberts.domain.Componente;
import br.com.eberts.repositories.ComponenteRepository;
import br.com.eberts.services.exceptions.ObjectNotFoundException;

@Service
public class ComponenteService {
	
	@Autowired 	
	private ComponenteRepository pRepo;
	
	public Componente find(Integer id) {
		Optional<Componente> ing = pRepo.findById(id);
		return ing.orElseThrow(()-> new ObjectNotFoundException("Componente Id: " + id + ", não encontrado!"));
	}
	
	public Componente create(Componente i) {
		Componente ing = pRepo.save(i);
		return ing;
	
	}
	
	public List<Componente> findAll(){
		List<Componente> list = pRepo.findAll();
		return list;
	}

}
