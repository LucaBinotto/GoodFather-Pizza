package it.epicode.be.model;

public class Drink implements FoodItem{
	private double price;
	private String name;
	private int calories;
	private String description;

	@Override
	public double getPrice() {
		return price;
	}
	@Override
	public void setPrice(double prezzo) {
		this.price = prezzo;
	}
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
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int getCalories() {
		return calories;
	}
	@Override
	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String stampa() {
		return getName() + getCaloriesSt() + "\u20ac"+getPrice() + "\t" + getDescription();
	}
}
