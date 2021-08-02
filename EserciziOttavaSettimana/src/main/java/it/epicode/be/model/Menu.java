package it.epicode.be.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	List<Pizza> pizze = new ArrayList<>();
	List<Topping> toppings = new ArrayList<>();
	List<Drink> drinks = new ArrayList<>();
	List<Franchise> franchises = new ArrayList<>();

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
		System.out.println("PIZZE");
		for (Pizza piz : pizze) {
			System.out.println(piz.stampa());
		}
	}

	public void stampaTopping() {
		System.out.println("TOPPINGS");
		for (Topping top : toppings) {
			System.out.println(top.stampa());
		}
	}

	public void stampaDrink() {
		System.out.println("DRINKS");
		for (Drink dri : drinks) {
			System.out.println(dri.stampa());
		}
	}

	public void stampaFranchise() {
		System.out.println("FRANCHISE");
		for (Franchise fra : franchises) {
			System.out.println(fra.stampa());
		}
	}

	public void stampaMenu() {
		stampaPizze();
		stampaTopping();
		stampaDrink();
		stampaFranchise();
	}
}
