package com.estudos.microsservicos.hrworker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration()
public class ApplicationConfig {

	//Responsável por criar uma instancia unica de um componente bean, pode-se usar em qualquer comunicação 
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
