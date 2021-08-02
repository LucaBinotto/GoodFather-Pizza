package it.epicode.be.model;

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
	public Pizza salamiPizza() {
		Pizza a = new Salami(new Cheese(new BasePizza()));
		a.setName("Salami Pizza:\t");
		a.setPrice(5.99);
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
}
