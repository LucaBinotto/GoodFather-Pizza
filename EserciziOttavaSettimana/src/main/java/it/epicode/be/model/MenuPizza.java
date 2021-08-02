package it.epicode.be.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.model.topping.Cheese;
import it.epicode.be.model.topping.Ham;
import it.epicode.be.model.topping.Pineapple;
import it.epicode.be.model.topping.Salami;

@Configuration
public class MenuPizza {
	@Bean
	public Pizza margherita() {
		Pizza a =  new Cheese(new BasePizza());
		a.setName("Margherita:\t");
		return a;
	}
	@Bean
	public Pizza hawaian() {
		Pizza a = new Pineapple(new Ham(new Cheese(new BasePizza())));
		a.setName("Hawaian Pizza:\t");
		a.setPrice(6.49);
		return a;
	}
	@Bean
	public Pizza salami() {
		Pizza a = new Salami(new Cheese(new BasePizza()));
		a.setName("Salami Pizza:\t");
		a.setPrice(5.99);
		return a;
	}
	
}
