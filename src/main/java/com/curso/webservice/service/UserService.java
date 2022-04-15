package com.curso.webservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.webservice.entidades.Users;
import com.curso.webservice.retositories.UserRepository;
import com.curso.webservice.service.exceptions.ResourceNotFoundException.ResourceNotFoundException;

@Service
public class UserService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	// Posso ainda implementar um log para um usuario especifico passando um User como parametro: Depois fazer
	public List<Users> findAll(){
		LOGGER.info("Consultando todos os usuarios!");
		return userRepository.findAll();
	}
	
	public Users findById(Long id) {
		Optional<Users> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id) {
		}); 

	}
	
	public Users inserirUsers(Users user) {
		Users usuario = userRepository.save(user);
		LOGGER.info("Usuario salvo com sucesso!");
		return usuario;
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
		LOGGER.warn("Usuario excluido!");
	}
	
	public Users update(Long id, Users obj) {
		Users entidade = userRepository.getOne(id);
		updateData(obj, entidade);	
		LOGGER.warn("Usuario editado!");
		return userRepository.save(entidade);
	}
	
	private void updateData(Users obj, Users entidade) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
	
	
	
}
