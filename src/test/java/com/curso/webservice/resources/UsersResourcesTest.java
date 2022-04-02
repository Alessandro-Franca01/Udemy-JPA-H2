package com.curso.webservice.resources;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;


public class UsersResourcesTest {
	
	// TUDO OK, TENHO QUE RODAR O TESTE COM A APLICAÇÃO RODANDO!!
	
	@Autowired
    private MockMvc mockMvc;
	
	private static final String URL_BASE = "http://localhost:8080/";
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void test() {
		given().contentType("application/json").
			when().get("https://api.thecatapi.com/v1/categories").then().statusCode(200).and().log().all();
	}
	
	@Test
	public void testFindAll() {
		given().contentType("application/json").
			when().get("http://localhost:8080/users").then().statusCode(200).and().log().all();
	}
	
	@Test
	public void teste() {
		given().contentType("application/json").
			when().get("http://localhost:8080/users/teste").then().statusCode(200).and().log().all();
	}
	
}
