package it.epicode.be.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tavolo {
	private String codiceTavolo;
	private int posti;
	public enum Stato {occupato, libero};
	private Stato stato;
	
	public Tavolo() {
		posti=1;
	}
}
