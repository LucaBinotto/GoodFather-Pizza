package it.epicode.be.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.epicode.be.model.BasePizza;
import it.epicode.be.model.Ordine;
import it.epicode.be.model.Ordine.Stato;
import it.epicode.be.model.Drink;
import it.epicode.be.model.FakePizza;
import it.epicode.be.model.Franchise;
import it.epicode.be.model.Menu;
import it.epicode.be.model.Pizza;
import it.epicode.be.model.Tavolo;
import it.epicode.be.model.Topping;
import it.epicode.be.model.topping.Cheese;
import it.epicode.be.model.topping.FamilySize;
import it.epicode.be.model.topping.Ham;
import it.epicode.be.model.topping.Onions;
import it.epicode.be.model.topping.Pineapple;
import it.epicode.be.model.topping.Salami;

@Configuration
public class ConfigMenu {
	
	@Autowired
	private ApplicationContext context;
	
	public static final int COSTO_COPERTO = 2;
	
	@Bean
	public Pizza margherita() {
		Pizza a =  new Cheese(new BasePizza());
		a.setName("Margherita");
		return a;
	}
	@Bean
	public Pizza hawaian() {
		Pizza a = new Pineapple(new Ham(new Cheese(new BasePizza())));
		a.setName("Hawaian Pizza");
		a.setPrice(6.49);
		a.setCalories(1024);
		return a;
	}
	@Bean
	public Pizza salamiPizza() {
		Pizza a = new Salami(new Cheese(new BasePizza()));
		a.setName("Salami Pizza");
		a.setPrice(5.99);
		a.setCalories(1160);
		return a;
	}
	@Bean
	public Drink lemonade() {
		Drink a = new Drink();
		a.setName("Lemonade");
		a.setCalories(128);
		a.setPrice(1.29);
		a.setDescription("(0.33l)");

		return a;
	}
	@Bean
	public Drink water() {
		Drink a = new Drink();
		a.setName("Water");
		a.setCalories(0);
		a.setPrice(1.29);
		a.setDescription("(0.5l)");

		return a;
	}
	@Bean
	public Drink wine() {
		Drink a = new Drink();
		a.setName("Wine");
		a.setCalories(607);
		a.setPrice(7.49);
		a.setDescription("(0.75l, 13%)");
		return a;
	}
	@Bean
	public Topping cheese() {
		Topping a =  new Cheese(new FakePizza());
		a.setName("Cheese");
		return a;
	}
	@Bean
	public Topping ham() {
		Topping a =  new Ham(new FakePizza());
		a.setName("Ham");
		return a;
	}
	@Bean
	public Topping onions() {
		Topping a =  new Onions(new FakePizza());
		a.setName("Onions");
		return a;
	}
	@Bean
	public Topping pineapple() {
		Topping a =  new Pineapple(new FakePizza());
		a.setName("Pineapple");
		return a;
	}
	@Bean
	public Topping salami() {
		Topping a =  new Salami(new FakePizza());
		a.setName("Salami");
		return a;
	}
	@Bean
	public Topping maxi() {
		Topping a =  new FamilySize(new FakePizza());
		a.setName("Family Size");
		return a;
	}
	@Bean
	public Franchise shirt() {
		Franchise a = new Franchise();
		a.setName("Shirt");
		a.setPrice(21.99);
		return a;
	}
	@Bean
	public Franchise mug() {
		Franchise a = new Franchise();
		a.setName("Mug");
		a.setPrice(4.99);
		return a;
	}
	@Bean
	public Menu godfather() {
		Menu men = new Menu();
		men.setName("Godfather's Pizza");
		men.add(margherita());
		men.add(hawaian());
		men.add(salamiPizza());
		men.add(cheese());
		men.add(ham());
		men.add(onions());
		men.add(pineapple());
		men.add(salami());
		men.add(maxi());
		men.add(lemonade());
		men.add(water());
		men.add(wine());
		men.add(shirt());
		men.add(mug());

		return men;
	}
	
	@Bean
	public Ordine solito() {
		Ordine f4 = new Ordine((Tavolo)context.getBean("f4"));
		f4.add((Drink)context.getBean("water"));
		f4.add((Drink)context.getBean("wine"));
		f4.add((Pizza)context.getBean("margherita"));
		f4.add(new FamilySize(new Pineapple(new Cheese(new Ham(new Onions( new Salami(new BasePizza())))))), "Ananas dopo cottura");
		f4.add((Franchise)context.getBean("mug"));
		f4.add((Franchise)context.getBean("shirt"),"Taglia XL");
		f4.setStato(Stato.Servito);
		f4.setCoperti(2);
		return f4;
	}
	
}