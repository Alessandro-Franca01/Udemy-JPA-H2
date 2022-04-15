package com.curso.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebserviceApplication {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(WebserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
		LOGGER.info("Testando Log com SLF4J!!!");
	}

}
