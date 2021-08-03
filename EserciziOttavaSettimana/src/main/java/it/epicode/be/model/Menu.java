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

	public void add(Pizza pizza) {
		pizze.add(pizza);
	}

	public void add(Topping topping) {
		toppings.add(topping);
	}

	public void add(Drink drink) {
		drinks.add(drink);
	}

	public void add(Franchise franchise) {
		franchises.add(franchise);
	}

	private void stampaPizze() {
		System.out.println("\nPIZZE\t\tCal\tPREZZO\tINGREDIENTI");
		for (Pizza piz : pizze) {
			System.out.println(piz.stampa());
		}
	}

	private void stampaTopping() {
		System.out.println("\nTOPPINGS\tCal\tPREZZO");
		for (Topping top : toppings) {
			System.out.println(top.stampa());
		}
	}

	private void stampaDrink() {
		System.out.println("\nDRINKS\t\tCal\tPREZZO\t");
		for (Drink dri : drinks) {
			System.out.println(dri.stampa());
		}
	}

	private void stampaFranchise() {
		System.out.println("\nFRANCHISE\t\tPREZZO");
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
