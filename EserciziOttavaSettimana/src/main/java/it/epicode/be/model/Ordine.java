package it.epicode.be.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.be.config.ConfigMenu;

public class Ordine {
	Logger ordLog = LoggerFactory.getLogger(Ordine.class);
	
	private long numeroOrdine;
	private static long ordCounter;
	public enum Stato {Aperto, Pronto, Servito};
	private Stato stato;
	private Tavolo tavolo;
	private int coperti;
	private LocalTime ora;
	Map<MenuItem,String> pizze = new HashMap<>();
	Map<MenuItem,String> drinks = new HashMap<>();
	Map<MenuItem,String> franchises = new HashMap<>();

	public Ordine(Tavolo tavolo) {
		this.tavolo = tavolo;
		numeroOrdine = ++ordCounter;
		stato=Stato.Aperto;
		coperti=1;
		ora = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
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
		return pizze.keySet().stream().collect(Collectors.summingDouble(MenuItem::getPrice));
	}

	private double getTotaleDrinks() {
		return drinks.keySet().stream().collect(Collectors.summingDouble(MenuItem::getPrice));
	}

	private double getTotaleFranchises() {
		return franchises.keySet().stream().collect(Collectors.summingDouble(MenuItem::getPrice));
	}

	private double getTotale() {
		return Math.round(((getTotalePizze() + getTotaleDrinks() + getTotaleFranchises())+coperti*ConfigMenu.COSTO_COPERTO) * 100) / 100.0;
	}

	private String contain(Entry<MenuItem, String> e) {
		if(e.getValue()==null) {
			return "";
		}
		else return "\tNota: " + e.getValue();
	}
	
	private void stampaPizze() {
		if (!pizze.isEmpty()) {
			ordLog.info("PIZZE                    Cal       PREZZO    INGREDIENTI");
			pizze.entrySet().stream().forEach(e -> ordLog.info(e.getKey().stampa()+contain(e)));
		}
	}
	
	private void stampaDrink() {
		if (!drinks.isEmpty()) {
			ordLog.info("DRINKS                   Cal       PREZZO");
			drinks.entrySet().stream().forEach(e -> ordLog.info(e.getKey().stampa()+contain(e)));
			
		}
	}

	private void stampaFranchise() {
		if (!franchises.isEmpty()) {
			ordLog.info("FRANCHISE                          PREZZO");
			franchises.entrySet().stream().forEach(e -> ordLog.info(e.getKey().stampa()+contain(e)));

		}
	}
	public void stampa() {
		ordLog.info("\tORDINE nr " + getNumeroOrdine() +"\tCodice Tavolo:\t" + getCodiceTavolo() +" "+getStato());
		ordLog.info("\tOra-"+getOra());
		stampaPizze();
		stampaDrink();
		stampaFranchise();
		ordLog.info("Coperto x"+coperti+"                         \u20ac" + ConfigMenu.COSTO_COPERTO);
		ordLog.info("TOTALE:                            " + "\u20ac"+getTotale());
	}

	private long getNumeroOrdine() {
		return numeroOrdine;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	protected Map<MenuItem, String> getPizze() {
		return pizze;
	}

	protected Map<MenuItem, String> getDrinks() {
		return drinks;
	}

	protected Map<MenuItem, String> getFranchises() {
		return franchises;
	}

	
	
}
