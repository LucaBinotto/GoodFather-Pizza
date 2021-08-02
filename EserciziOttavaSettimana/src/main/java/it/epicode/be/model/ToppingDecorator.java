package it.epicode.be.model;

public abstract class ToppingDecorator implements Pizza{

	protected Pizza tempPizza;
	
	public ToppingDecorator(Pizza pizza) {
		tempPizza = pizza;
		
	}
	
	public String getTopping() {
		return tempPizza.getTopping();
	}
	
	public double getPrice() {
		return tempPizza.getPrice();
	}
	
	public int getCalories() {
		return tempPizza.getCalories();
	}
	
}
