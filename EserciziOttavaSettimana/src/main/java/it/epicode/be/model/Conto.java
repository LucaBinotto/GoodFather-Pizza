package it.epicode.be.model;

import java.util.ArrayList;
import java.util.List;

public class Conto {
	private String codiceTavolo;
	List<Pizza> pizze = new ArrayList<>();
	List<Drink> drinks = new ArrayList<>();
	List<Franchise> franchises = new ArrayList<>();
	
	public Conto(String codiceTavolo) {
		this.codiceTavolo = codiceTavolo;
	}
	
	public String getCodiceTavolo() {
		return codiceTavolo;
	}

	public void add(Pizza pizza) {
		pizze.add(pizza);
	}

	public void add(Drink drink) {
		drinks.add(drink);
	}

	public void add(Franchise franchise) {
		franchises.add(franchise);
	}
	
	private double getTotalePizze() {
		double totale = 0;
		for (Pizza piz : pizze) {
			totale += piz.getPrice();
		}
		return totale;
	}
	private double getTotaleDrinks() {
		double totale = 0;
		for (Drink dri : drinks) {
			totale += dri.getPrice();
		}
		return totale;
	}
	private double getTotaleFranchises() {
		double totale = 0;
		for (Franchise fra : franchises) {
			totale += fra.getPrice();
		}
		return totale;
	}
	private double getTotale() {
		return Math.round((getTotalePizze() +getTotaleDrinks()+getTotaleFranchises())*100)/100.0;
	}
	
	public void stampaPizze() {
		System.out.println("PIZZE\t\tCal\tPREZZO\tINGREDIENTI");
		for (Pizza piz : pizze) {
			System.out.println(piz.stampa());
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
	
	public void stampa() {
		System.out.println("Codice Tavolo:\t" + getCodiceTavolo());
		stampaPizze();
		stampaDrink();
		stampaFranchise();
		System.out.println("TOTALE:\t\t\t" + getTotale());
	}
	
}
