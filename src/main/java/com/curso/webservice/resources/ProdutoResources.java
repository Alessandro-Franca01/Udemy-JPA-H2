package com.curso.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.webservice.entidades.Produto;
import com.curso.webservice.service.ProdutoService;

// Nesse caso essa classe faz o papel do Controller
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources {
	
	@Autowired
	private ProdutoService produtoService;
	
	// Esse metodo vai responder uma requisão GET enviando o usuario
	@GetMapping
	public ResponseEntity<List<Produto>> fnidAll(){		
		List<Produto> listProduto = produtoService.findAll();
		// Acho que é esse ResponseEntity que faz o retorno de Json
		return ResponseEntity.ok().body(listProduto);
	}
	
	// Metodo de busca por Id: FUNCIONANDO!
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto user = produtoService.findById(id);		
		return ResponseEntity.ok(user); 
	}

}
