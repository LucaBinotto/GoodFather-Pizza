package it.epicode.be.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.model.Tavolo;
import it.epicode.be.model.Tavolo.Stato;

@Configuration
public class ConfigSala {
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public Tavolo f1() {
		Tavolo tav = new Tavolo();
		tav.setCodiceTavolo("F1");
		tav.setPosti(6);
		tav.setStato(Stato.libero);
		return tav;
	}
	@Bean
	public Tavolo f2() {
		Tavolo tav = new Tavolo();
		tav.setCodiceTavolo("F2");
		tav.setPosti(10);
		tav.setStato(Stato.libero);
		return tav;
	}
	@Bean
	public Tavolo f3() {
		Tavolo tav = new Tavolo();
		tav.setCodiceTavolo("F3");
		tav.setPosti(8);
		tav.setStato(Stato.libero);
		return tav;
	}
	@Bean
	public Tavolo f4() {
		Tavolo tav = new Tavolo();
		tav.setCodiceTavolo("F4");
		tav.setPosti(4);
		tav.setStato(Stato.libero);
		return tav;
	}
	
}
