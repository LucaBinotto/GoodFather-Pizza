package it.epicode.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.model.BasePizza;
import it.epicode.be.model.Conto;
import it.epicode.be.model.Drink;
import it.epicode.be.model.Franchise;
import it.epicode.be.model.Menu;
import it.epicode.be.model.Pizza;
import it.epicode.be.model.topping.Cheese;
import it.epicode.be.model.topping.FamilySize;
import it.epicode.be.model.topping.Ham;
import it.epicode.be.model.topping.Onions;
import it.epicode.be.model.topping.Pineapple;
import it.epicode.be.model.topping.Salami;
@SuppressWarnings("unused")
@Component
public class StartupPizzeria implements CommandLineRunner{

	@Autowired
	private ApplicationContext context;
	@Autowired
	private Menu godfather;
	@Autowired
	private Conto f4;
	
	
	@Override
	public void run(String... args) throws Exception {
//		Menu godfather = (Menu)context.getBean("godfather");
		godfather.stampaMenu();

		f4.stampa();
	}

}
