package it.epicode.be.model;

public abstract class Topping implements Pizza {
	protected String topping;
	protected Pizza tempPizza;
	protected double price = 0;
	protected String name = "";

	public Topping(Pizza pizza) {
		tempPizza = pizza;

	}

	public String getTopping() {

		return tempPizza.getTopping();
	}

	public double getPrice() {
		if (price == 0) {
			return tempPizza.getPrice();
		} else {
			return price;
		}
	}

	public int getCalories() {
		return tempPizza.getCalories();
	}

	@Override
	public String stampa() {
		if (!getTopping().contains("fake")) {
			return getName() + getCalories() + "\t" + getPrice() + "\t" + "(" + getTopping() + ")";
		} else {
			if (getCalories()==-1) {
				return getName() + "x 1.95" + "\t" + getPrice() + "\t";

			}else {
				return getName() + getCalories() + "\t" + getPrice() + "\t";

			}

		}
	}

	@Override
	public String getName() {
		if (name.equals("")) {
			return "Personalizzata: ";
		} else {
			return name;
		}
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
