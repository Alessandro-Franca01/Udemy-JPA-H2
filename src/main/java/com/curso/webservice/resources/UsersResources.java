package com.curso.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		// Acho que é esse ResponseEntity que faz o retorno de Json
		return ResponseEntity.ok().body(listUsers);
	}
	
	// Metodo de busca por Id: FUNCIONANDO!
	@GetMapping("/{id}")
	public ResponseEntity<Users> findById(@PathVariable Long id){
		Users user = userService.findById(id);		
		return ResponseEntity.ok(user); 
	}

}
