package it.epicode.be.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
		a.setCalories(1024);
		return a;
	}
	@Bean
	public Pizza salamiPizza() {
		Pizza a = new Salami(new Cheese(new BasePizza()));
		a.setName("Salami Pizza:\t");
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
		a.setName("Water\t");
		a.setCalories(0);
		a.setPrice(1.29);
		a.setDescription("(0.5l)");

		return a;
	}
	@Bean
	public Drink wine() {
		Drink a = new Drink();
		a.setName("Wine\t");
		a.setCalories(607);
		a.setPrice(7.49);
		a.setDescription("(0.75l, 13%)");
		return a;
	}
	@Bean
	public Topping cheese() {
		Topping a =  new Cheese(new FakePizza());
		a.setName("Cheese:\t\t");
		return a;
	}
	@Bean
	public Topping ham() {
		Topping a =  new Ham(new FakePizza());
		a.setName("Ham:\t\t");
		return a;
	}
	@Bean
	public Topping onions() {
		Topping a =  new Onions(new FakePizza());
		a.setName("Onions:\t\t");
		return a;
	}
	@Bean
	public Topping pineapple() {
		Topping a =  new Pineapple(new FakePizza());
		a.setName("Pineapple:\t");
		return a;
	}
	@Bean
	public Topping salami() {
		Topping a =  new Salami(new FakePizza());
		a.setName("Salami:\t\t");
		return a;
	}
	@Bean
	public Topping maxi() {
		Topping a =  new FamilySize(new FakePizza());
		a.setName("Family Size:\t");
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
	public Conto solito() {
		Conto f4 = new Conto("F4");
		f4.add((Drink)context.getBean("water"));
		f4.add((Drink)context.getBean("wine"));
		f4.add((Pizza)context.getBean("margherita"));
		f4.add(new FamilySize(new Pineapple(new Cheese(new Ham(new Onions( new Salami(new BasePizza())))))));
		f4.add((Franchise)context.getBean("mug"));
		f4.add((Franchise)context.getBean("shirt"));
		return f4;
	}
	
}
