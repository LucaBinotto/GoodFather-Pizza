package it.epicode.be.model;

public class Drink {
	private double price;
	private String name;
	private int calories;
	private String description;

	public double getPrice() {
		return price;
	}

	public void setPrice(double prezzo) {
		this.price = prezzo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String stampa() {
		return getName() + "\t" + getCalories() + "\t" + "\u20ac"+getPrice() + "\t" + getDescription();
	}
}
