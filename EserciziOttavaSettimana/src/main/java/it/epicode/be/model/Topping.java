package it.epicode.be.model;

public abstract class Topping implements Pizza {
	
	protected String topping;
	protected Pizza tempPizza;
	protected double price = 0;
	protected String name = "";
	protected int calorie = 0;

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
	public void setCalories(int calorie) {
		this.calorie = calorie;
	}

	@Override
	public int getCalories() {
		if (calorie == 0) {
			calorie = tempPizza.getCalories();
		} 
			return calorie;
		

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

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
