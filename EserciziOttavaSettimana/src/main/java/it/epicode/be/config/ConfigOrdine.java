package it.epicode.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import it.epicode.be.model.Ordine;
@Configuration
@Component
public class ConfigOrdine{

	
	@Bean
	@Scope("prototype")
	public Ordine ordine() {
		
		return new Ordine();
	}
	
}
