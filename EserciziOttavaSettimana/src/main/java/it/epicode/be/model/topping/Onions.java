package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.ToppingDecorator;

public class Onions extends ToppingDecorator{

	public Onions(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping() + ", onions";
	}
	@Override
	public double getPrice() {
		return Math.round((tempPizza.getPrice() + 0.69)*100)/100.0;
	}
	@Override
	public int getCalories() {
		return tempPizza.getCalories() + 22;
	}

}
