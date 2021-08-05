package it.epicode.be;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.model.BasePizza;
import it.epicode.be.model.Ordine;
import it.epicode.be.model.Drink;
import it.epicode.be.model.Franchise;
import it.epicode.be.model.Menu;
import it.epicode.be.model.MenuItem;
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
	private Ordine f4;
	
	
	@Override
	public void run(String... args) throws Exception {
		godfather.stampaMenu();
		System.out.println();
		
		f4.setCoperti(3);
		f4.stampa();
		Ordine giorgio = (Ordine) context.getBean("solito");
		giorgio.setCoperti(4);
		giorgio.add(new Onions((Pizza) context.getBean("hawaian")));
		giorgio.stampa();
//		Pizza marghe = (Pizza) context.getBean("margherita");
//		
//		marghe.setName("Cacca");
//		
//		Pizza marghe1 = (Pizza) context.getBean("margherita");
//		
//		System.out.println(marghe.getName());
//		System.out.println(marghe1.getName());

	}

}
