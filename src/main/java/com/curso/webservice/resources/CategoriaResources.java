package com.curso.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.webservice.entidades.Categoria;
import com.curso.webservice.service.CategoriaService;

// Nesse caso essa classe faz o papel do Controller
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
	
	@Autowired
	private CategoriaService categoriaService;
	
	// Esse metodo vai responder uma requisão GET enviando o usuario
	@GetMapping
	public ResponseEntity<List<Categoria>> fnidAll(){		
		List<Categoria> listCategoria = categoriaService.findAll();
		// Acho que é esse ResponseEntity que faz o retorno de Json
		return ResponseEntity.ok().body(listCategoria);
	}
	
	// Metodo de busca por Id: FUNCIONANDO!
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria categoria = categoriaService.findById(id);		
		return ResponseEntity.ok(categoria); 
	}

}
