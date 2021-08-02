package it.epicode.be.model;

public abstract class ToppingDecorator implements Pizza {

	protected Pizza tempPizza;
	protected double price = 0;
	protected String name ="";

	public ToppingDecorator(Pizza pizza) {
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
		return getName() + getCalories() + "\t" + getPrice() + "\t" + "(" + getTopping() + ")";
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
