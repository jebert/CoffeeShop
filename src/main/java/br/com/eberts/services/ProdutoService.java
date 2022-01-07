package br.com.eberts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eberts.domain.Produto;
import br.com.eberts.repositories.ProdutoRepository;
import br.com.eberts.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired 	
	private ProdutoRepository pRepo;
	
	public Produto find(Integer id) {
		Optional<Produto> ing = pRepo.findById(id);
		return ing.orElseThrow(()-> new ObjectNotFoundException("Produto Id: " + id + ", não encontrado!"));
	}
	
	public Produto create(Produto i) {
		Produto ing = pRepo.save(i);
		return ing;
	
	}
	
	public List<Produto> findAll(){
		List<Produto> list = pRepo.findAll();
		return list;
	}

}
