package com.curso.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.webservice.entidades.Users;
import com.curso.webservice.retositories.UserRepository;

@Service // registrando a classe de serviço no spring
public class UserService {
	
	// Injetando uma dependecia da camada repositorio: para repassar a chamada da lista
	@Autowired
	private UserRepository userRepository;
	
	// Esse metodo vai repassar a chamada para a camada de repositorio
	public List<Users> findAll(){
		return userRepository.findAll();
	}
	
	// Tentando implementar um metodo para buscar um User por id: IMPLEMENTADO
	public Users findById(Long id) {
		Optional<Users> user = userRepository.findById(id);		
		return user.get();
	}
	
}
