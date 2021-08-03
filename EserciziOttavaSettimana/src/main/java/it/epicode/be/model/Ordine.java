package it.epicode.be.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ordine {
	Logger ordLog = LoggerFactory.getLogger(Ordine.class);
	
	
	private Tavolo tavolo;
	Map<Pizza,String> pizze = new HashMap<>();
	Map<Drink,String> drinks = new HashMap<>();
	Map<Franchise,String> franchises = new HashMap<>();

	public Ordine(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public String getCodiceTavolo() {
		return tavolo.getCodiceTavolo();
	}
	public void add(Pizza pizza) {
		pizze.put(pizza,null);
	}
	public void add(Pizza pizza, String nota) {
		pizze.put(pizza,nota);
	}
	public void add(Drink drink) {
		drinks.put(drink,null);
	}
	public void add(Drink drink, String nota) {
		drinks.put(drink,nota);
	}
	public void add(Franchise franchise) {
		franchises.put(franchise,null);
	}
	public void add(Franchise franchise, String nota) {
		franchises.put(franchise,nota);
	}

	private double getTotalePizze() {
		return pizze.keySet().stream().collect(Collectors.summingDouble(Pizza::getPrice));
	}

	private double getTotaleDrinks() {
		return drinks.keySet().stream().collect(Collectors.summingDouble(Drink::getPrice));
	}

	private double getTotaleFranchises() {
		return franchises.keySet().stream().collect(Collectors.summingDouble(Franchise::getPrice));
	}

	private double getTotale() {
		return Math.round((getTotalePizze() + getTotaleDrinks() + getTotaleFranchises()) * 100) / 100.0;
	}

	private String contain(Entry<Pizza, String> e) {
		if(e.getValue()==null) {
			return "";
		}
		else return " Note: " + e.getValue();
	}
	
	private void stampaPizze() {
		if (!pizze.isEmpty()) {
			ordLog.info("PIZZE\t\tCal\tPREZZO\tINGREDIENTI");
			pizze.entrySet().stream().forEach(e -> ordLog.info(e.getKey().stampa()+contain(e)));
		}
	}

//	private void stampaDrink() {
//		if (!drinks.isEmpty()) {
//			System.out.println("\nDRINKS\t\tCal\tPREZZO\t");
//			for (Drink dri : drinks) {
//				System.out.println(dri.stampa());
//			}
//		}
//	}
//
//	private void stampaFranchise() {
//		if (!franchises.isEmpty()) {
//			System.out.println("\nFRANCHISE\t\tPREZZO");
//			for (Franchise fra : franchises) {
//				System.out.println(fra.stampa());
//			}
//		}
//	}
	public void stampa() {
		ordLog.info("\tORDINE\t\tCodice Tavolo:\t" + getCodiceTavolo());
		stampaPizze();
//		stampaDrink();
//		stampaFranchise();
		ordLog.info("TOTALE:\t\t\t" + "\u20ac"+getTotale());
	}

}
