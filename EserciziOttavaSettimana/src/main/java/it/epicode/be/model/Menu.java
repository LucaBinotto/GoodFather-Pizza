package it.epicode.be.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String name;
	List<Pizza> pizze = new ArrayList<>();
	List<Topping> toppings = new ArrayList<>();
	List<Drink> drinks = new ArrayList<>();
	List<Franchise> franchises = new ArrayList<>();

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPizza(Pizza pizza) {
		pizze.add(pizza);
	}

	public void addTopping(Topping topping) {
		toppings.add(topping);
	}

	public void addDrink(Drink drink) {
		drinks.add(drink);
	}

	public void addFranchise(Franchise franchise) {
		franchises.add(franchise);
	}

	public void stampaPizze() {
		System.out.println("PIZZE\t\tCal\tPREZZO\tINGREDIENTI");
		for (Pizza piz : pizze) {
			System.out.println(piz.stampa());
		}
	}

	public void stampaTopping() {
		System.out.println("TOPPINGS\tCal\tPREZZO");
		for (Topping top : toppings) {
			System.out.println(top.stampa());
		}
	}

	public void stampaDrink() {
		System.out.println("DRINKS\t\tCal\tPREZZO\t");
		for (Drink dri : drinks) {
			System.out.println(dri.stampa());
		}
	}

	public void stampaFranchise() {
		System.out.println("FRANCHISE\t\tPREZZO");
		for (Franchise fra : franchises) {
			System.out.println(fra.stampa());
		}
	}

	public void stampaMenu() {
		System.out.println("\t\t\t" + getName());
		stampaPizze();
		stampaTopping();
		stampaDrink();
		stampaFranchise();
	}
}
