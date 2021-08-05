package it.epicode.be.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

public class Menu {
	Logger menLog = LoggerFactory.getLogger(Menu.class);
	
	@Getter
	@Setter
	private String name;
	private List<MenuItem> pizze = new ArrayList<>();
	private List<MenuItem> toppings = new ArrayList<>();
	private List<MenuItem> drinks = new ArrayList<>();
	private List<MenuItem> franchises = new ArrayList<>();

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
		menLog.info("PIZZE                    Cal       PREZZO\tINGREDIENTI");
		for (MenuItem piz : pizze) {
			menLog.info(piz.stampa());
		}
	}

	private void stampaTopping() {
		menLog.info("TOPPINGS                 Cal       PREZZO");
		for (MenuItem top : toppings) {
			menLog.info(top.stampa());
		}
	}

	private void stampaDrink() {
		menLog.info("DRINKS                   Cal       PREZZO");
		for (MenuItem dri : drinks) {
			menLog.info(dri.stampa());
		}
	}

	private void stampaFranchise() {
		menLog.info("FRANCHISE                          PREZZO");
		for (MenuItem fra : franchises) {
			menLog.info(fra.stampa());
		}
	}

	public void stampaMenu() {
		menLog.info("\t\t" + getName());
		stampaPizze();
		stampaTopping();
		stampaDrink();
		stampaFranchise();
	}
}
