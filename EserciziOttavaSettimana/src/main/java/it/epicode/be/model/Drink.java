package it.epicode.be.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Drink implements FoodItem{
	private double price;
	private String name;
	private int calories;
	private String description;
	private String nota ="";

	@Override
	public String getName() {
		int a = name.length();
		int diff = NAME_LENGTH - a;
		for (int i = 0; i < diff; i++) {
			name += " ";
		}
		return name;
	}

	@Override
	public String stampa() {
		return getName() + getCaloriesSt() + "\u20ac"+getPrice() + "\t" + getDescription();
	}
	
	public void setNota(String nota) {
		this.nota="\tNota: "+nota;
	}
}