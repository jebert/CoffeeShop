package br.com.eberts.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eberts.domain.Produto;
import br.com.eberts.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService pService;
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		
		Produto ing = pService.find(id);
		
		return ResponseEntity.ok().body(ing);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> findAll() {
		
		List<Produto	> ing = pService.findAll();
		
		return ResponseEntity.ok().body(ing);

	}

}