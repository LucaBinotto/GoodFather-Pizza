package it.epicode.be.model;

public class BasePizza implements Pizza {

	@Override
	public String getTopping() {
		return "tomato";
	}

	@Override
	public double getPrice() {
		return 4.30;
	}

	@Override
	public int getCalories() {
		return 1012;
	}
	

}
