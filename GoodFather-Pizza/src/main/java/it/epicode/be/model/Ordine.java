package it.epicode.be.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Component
public class Ordine {
	Logger ordLog = LoggerFactory.getLogger(Ordine.class);
	
	private long numeroOrdine;
	private static long ordCounter;
	public enum Stato {Aperto, Pronto, Servito};
	@Setter
	private Stato stato;
	@Setter
	private Tavolo tavolo;
	private int coperti;
	@Setter
	private LocalTime ora;
	@Setter
	private LocalDate data;
	@Value("${prezzi.costoCoperto}")
	@Setter
	private double costoCoperto;
	List<MenuItem> pizze = new ArrayList<>();
	List<MenuItem> drinks = new ArrayList<>();
	List<MenuItem> franchises = new ArrayList<>();

	public Ordine() {
		this.tavolo = new Tavolo();
		numeroOrdine = ++ordCounter;
		stato=Stato.Aperto;
		coperti=1;
		ora = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
		data = LocalDate.now();
		
	}
	
	protected Ordine(Tavolo tavolo) {
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
		pizze.add(pizza);
	}
	public void add(Pizza pizza, String nota) {
		pizza.setNota(nota);
		pizze.add(pizza);
	}
	public void add(Drink drink) {
		drinks.add(drink);
	}
	public void add(Drink drink, String nota) {
		drink.setNota(nota);
		drinks.add(drink);
	}
	public void add(Franchise franchise) {
		franchises.add(franchise);
	}
	public void add(Franchise franchise, String nota) {
		franchise.setNota(nota);
		franchises.add(franchise);
	}

	private double getTotalePizze() {
		return pizze.stream().collect(Collectors.summingDouble(MenuItem::getPrice));
	}

	private double getTotaleDrinks() {
		return drinks.stream().collect(Collectors.summingDouble(MenuItem::getPrice));
	}

	private double getTotaleFranchises() {
		return franchises.stream().collect(Collectors.summingDouble(MenuItem::getPrice));
	}

	public double getTotale() {
		return Math.round(((getTotalePizze() + getTotaleDrinks() + getTotaleFranchises())+coperti*costoCoperto) * 100) / 100.0;
	}
	
	private void stampaPizze() {
		if (!pizze.isEmpty()) {
			ordLog.info("PIZZE                    Cal       PREZZO    INGREDIENTI");
			pizze.stream().forEach(e -> ordLog.info(e.stampa()+e.getNota()));
		}
	}
	
	private void stampaDrink() {
		if (!drinks.isEmpty()) {
			ordLog.info("DRINKS                   Cal       PREZZO");
			drinks.stream().forEach(e -> ordLog.info(e.stampa()+e.getNota()));
			
		}
	}

	private void stampaFranchise() {
		if (!franchises.isEmpty()) {
			ordLog.info("FRANCHISE                          PREZZO");
			franchises.stream().forEach(e -> ordLog.info(e.stampa()+e.getNota()));

		}
	}
	public void stampa() {
		ordLog.info("#######################################################################################################################################################");
		ordLog.info("\tORDINE nr " + getNumeroOrdine() +"\tCodice Tavolo:" + getCodiceTavolo() +"\t"+getStato());
		ordLog.info("\tOra-"+getOra());
		stampaPizze();
		stampaDrink();
		stampaFranchise();
		ordLog.info("Coperto x"+coperti+"                         \u20ac" + costoCoperto);
		ordLog.info("TOTALE:                            " + "\u20ac"+getTotale());
	}

	public void setCoperti(int coperti) throws MassaZenteException {
		if(tavolo.getPosti()<coperti) {
			throw new MassaZenteException("Troppe persone"+coperti +" "+ tavolo.getPosti() );
		}
		
		this.coperti = coperti;
	}
	
}
