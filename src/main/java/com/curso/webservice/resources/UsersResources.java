package com.curso.webservice.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curso.webservice.entidades.Users;
import com.curso.webservice.service.UserService;

// Nesse caso essa classe faz o papel do Controller
@RestController
@RequestMapping(value = "/users")
public class UsersResources {
	
	@Autowired
	private UserService userService;
	
	// Esse metodo vai responder uma requisão GET enviando o usuario
	@GetMapping
	public ResponseEntity<List<Users>> fnidAll(){		
		List<Users> listUsers = userService.findAll();
		// Criar metodo para tratar erro de usuario não encontrado!		
		return ResponseEntity.ok().body(listUsers);
	}
	
	// Metodo de busca por Id: FUNCIONANDO!
	@GetMapping("/{id}")
	public ResponseEntity<Users> findById(@PathVariable Long id){
		Users user = userService.findById(id);		
		return ResponseEntity.ok(user); 
	}
	
	@PostMapping
	public ResponseEntity<Users> inserir(@RequestBody Users user){
		user = userService.inserirUsers(user);
		// Rever essa implementação depois
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	/*
	 *  Verbo usardo pelo REST é DELETE para excluir registro do banco de dados
	 *  @PathVariable é para o id ser reconhecido pela url
	 *  O noContent e ResponseEntity<Void> são para receber a resposta em branco no corpo do HTML
	 *  Sem tratamento antes do Delete
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	// Metodo update: Funcionando!
	@PutMapping("/{id}")
	public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users user){
		userService.update(id, user);
		return ResponseEntity.ok().body(user);
	}

}
