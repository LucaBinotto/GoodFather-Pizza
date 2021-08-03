package it.epicode.be.model;

public class Tavolo {
	private String codiceTavolo;
	private int posti;
	public enum Stato {
		occupato, libero
	};

	private Stato stato;

	public String getCodiceTavolo() {
		return codiceTavolo;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public void setCodiceTavolo(String codiceTavolo) {
		this.codiceTavolo = codiceTavolo;
	}

}
