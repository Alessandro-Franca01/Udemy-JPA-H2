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

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> fnidAll(){		
		List<Produto> listProduto = produtoService.findAll();	
		return ResponseEntity.ok().body(listProduto);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto user = produtoService.findById(id);		
		return ResponseEntity.ok(user); 
	}
	
	// Posso criar um metodo para mostrar os produtos do usuario
	

}
