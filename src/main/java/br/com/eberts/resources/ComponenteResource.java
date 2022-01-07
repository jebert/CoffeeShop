package br.com.eberts.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eberts.domain.Componente;
import br.com.eberts.services.ComponenteService;

@RestController
@RequestMapping(value="/Componentes")
public class ComponenteResource {
	
	@Autowired
	private ComponenteService cService;
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<Componente> find(@PathVariable Integer id) {
		
		Componente ing = cService.find(id);
		
		return ResponseEntity.ok().body(ing);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Componente>> findAll() {
		
		List<Componente	> ing = cService.findAll();
		
		return ResponseEntity.ok().body(ing);

	}

}