package br.com.eberts.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.eberts.domain.Ingrediente;
import br.com.eberts.services.IngredienteService;

@RestController
@RequestMapping(value="/ingredientes")
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Ingrediente ing){
		ing = iService.insert(ing);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ing.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id,@RequestBody Ingrediente ing){
		ing = iService.update(ing);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<Ingrediente> delete(@PathVariable Integer id) {
		
		iService.delete(id);
		
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Ingrediente>> findAll(
			@RequestParam(value = "page", defaultValue = "0")  Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "3")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String ordeBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		
		Page<Ingrediente> ing = iService.findPage(page,linesPerPage,ordeBy,direction);
		
		return ResponseEntity.ok().body(ing);

	}

}