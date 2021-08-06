package it.epicode.be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.model.Sala;
import it.epicode.be.model.Tavolo;
import it.epicode.be.model.Tavolo.Stato;

@Configuration
public class ConfigSala {
		
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
	@Bean
	public Sala sala() {
		Sala sala = new Sala();
		sala.add(f1());
		sala.add(f2());
		sala.add(f3());
		sala.add(f4());
		return sala;
	}
	
}
