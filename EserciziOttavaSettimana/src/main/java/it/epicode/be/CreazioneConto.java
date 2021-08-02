package it.epicode.be;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.be.model.BasePizza;
import it.epicode.be.model.ConfigMenu;
import it.epicode.be.model.Conto;
import it.epicode.be.model.Drink;
import it.epicode.be.model.Franchise;
import it.epicode.be.model.Pizza;
import it.epicode.be.model.topping.Cheese;
import it.epicode.be.model.topping.FamilySize;
import it.epicode.be.model.topping.Ham;
import it.epicode.be.model.topping.Onions;
import it.epicode.be.model.topping.Pineapple;
import it.epicode.be.model.topping.Salami;

public class CreazioneConto {
	public static void main(String[] args) {
SpringApplication.run(GestioneMenu.class, args);
		
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigMenu.class);
		
		Conto f4 = new Conto("f4");
		f4.add((Drink)context.getBean("water"));
		f4.add((Drink)context.getBean("wine"));
		f4.add((Pizza)context.getBean("margherita"));
		f4.add(new FamilySize(new Pineapple(new Cheese(new Ham(new Onions( new Salami(new BasePizza())))))));
		f4.add((Franchise)context.getBean("mug"));
		f4.add((Franchise)context.getBean("shirt"));

		f4.stampa();
		
	}
}
