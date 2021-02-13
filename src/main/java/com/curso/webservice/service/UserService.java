package com.curso.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.webservice.entidades.Users;
import com.curso.webservice.retositories.UserRepository;
import com.curso.webservice.service.exceptions.ResourceNotFoundException.ResourceNotFoundException;

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
		// Esse metodo vai tentar dá o get(), caso nao consigo vai levantar uma exeção: Usando uma expressão lambida!
		// Dessa maneira está funcionando, porém com WARNING!
		return user.orElseThrow(() -> new ResourceNotFoundException(id) {
		}); 

	}
	
	// Metodo para salvar um usuario
	public Users inserirUsers(Users user) {
		return userRepository.save(user);
	}
	
	// Metodo para deletar um usuario pelo id
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	// Metodo para alterar dados de um usuario: Retornando um resgistro instanciado e alterado
	public Users update(Long id, Users obj) {
		Users entidade = userRepository.getOne(id);
		updateData(obj, entidade);		
		return userRepository.save(entidade);
	}
	
	// Esse metodo vai alterar todos os valores da classe antes de salvar
	private void updateData(Users obj, Users entidade) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}
	
	
	
}
