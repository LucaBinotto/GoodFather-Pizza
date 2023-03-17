package it.epicode.be.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Franchise implements MenuItem {

	private static final int NAME_LENGTH_PLUS = 35;
	private String name;
	private double price;
	private String nota = "";

	@Override
	public String getName() {
		int a = name.length();
		int diff = NAME_LENGTH_PLUS - a;
		for (int i = 0; i < diff; i++) {
			name += " ";
		}
		return name;
	}

	@Override
	public String stampa() {
		return getName() + "\u20ac" + getPrice();
	}

	public void setNota(String nota) {
		this.nota="\tNota: "+nota;
	}
}
