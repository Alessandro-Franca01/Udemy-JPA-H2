package com.curso.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.webservice.entidades.Users;
import com.curso.webservice.retositories.UserRepository;
import com.curso.webservice.service.exceptions.ResourceNotFoundException.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Users> findAll(){
		return userRepository.findAll();
	}
	
	public Users findById(Long id) {
		Optional<Users> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id) {
		}); 

	}
	
	public Users inserirUsers(Users user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public Users update(Long id, Users obj) {
		Users entidade = userRepository.getOne(id);
		updateData(obj, entidade);		
		return userRepository.save(entidade);
	}
	
	private void updateData(Users obj, Users entidade) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
	
	
	
}
