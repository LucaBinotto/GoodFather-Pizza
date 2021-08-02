package it.epicode.be.model;

public class BasePizza implements Pizza {

	private double price = 4.30;
	private String name = "Base pomodoro:\t";

	@Override
	public String getTopping() {
		return "tomato";
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public int getCalories() {
		return 1012;
	}

	@Override
	public String stampa() {
		return getName() + getCalories() + "\t" + getPrice() + "\t" + "(" + getTopping() + ")";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void setCalories(int calorie) {
		
	}

}
