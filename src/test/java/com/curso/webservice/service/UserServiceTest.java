package com.curso.webservice.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.curso.webservice.entidades.Users;
import com.curso.webservice.retositories.UserRepository;

@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@BeforeEach
    public void init() {
		// Metodo openMocks nao tem nessa versão
        MockitoAnnotations.initMocks(this);
        //service = Mockito.spy(userService);
    }
	
	@Test
    @DisplayName("Buscar todos os usuarios")
	public void findAll(){
		String users = "";  
       // Esse metodo deveria retornar um lista de usuarios do banco de dados!
	   // Porém comoo escopo do teste é unitario então não tem retorno!
	   // Nao consigo acessar a base de dados injetando um repositorio aqui!
    }

}
