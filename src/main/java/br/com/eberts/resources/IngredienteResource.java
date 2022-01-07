package br.com.eberts.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eberts.domain.Ingrediente;
import br.com.eberts.services.IngredienteService;

@RestController
@RequestMapping(value="/ingredients")
public class IngredienteResource {
	
	@Autowired
	private IngredienteService iService;
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Ingrediente> find(@PathVariable Integer id) {
		
		Ingrediente ing = iService.find(id);
		
		return ResponseEntity.ok().body(ing);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Ingrediente>> findAll() {
		
		List<Ingrediente	> ing = iService.findAll();
		
		return ResponseEntity.ok().body(ing);

	}

}