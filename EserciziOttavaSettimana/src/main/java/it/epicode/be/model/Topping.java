package it.epicode.be.model;

import lombok.Getter;
import lombok.Setter;

@Setter
public abstract class Topping implements Pizza {

	protected String topping;
	protected Pizza tempPizza;
	protected double price = 0;
	protected String name = "";
	protected int calories = 0;
	@Getter
	protected String nota = "";

	public Topping(Pizza pizza) {
		tempPizza = pizza;
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping();
	}

	@Override
	public double getPrice() {
		if (price == 0) {
			return tempPizza.getPrice();
		} else {
			return price;
		}
	}

	@Override
	public int getCalories() {
		if (calories == 0) {
			calories = tempPizza.getCalories();
		}
		return calories;

	}

	@Override
	public String stampa() {
		if (!getTopping().contains("fake")) {
			return getName() + getCaloriesSt() + "\u20ac" + getPrice() + "\t" + "(" + getTopping() + ")";
		} else {
			if (getCalories() == -1) {
				return getName() + "x 1.95    " + "\u20ac" + getPrice() + "\t";

			} else {
				return getName() + getCaloriesSt() + "\u20ac" + getPrice() + "\t";
			}
		}
	}

	@Override
	public String getName() {
		if (name.equals("")) {
			name = "Personalizzata";
		}
		int a = name.length();
		int diff = NAME_LENGTH - a;
		for (int i = 0; i < diff; i++) {
			name += " ";
		}
		return name;
	}
	
	public void setNota(String nota) {
		this.nota="\tNota: "+nota;
	}
}