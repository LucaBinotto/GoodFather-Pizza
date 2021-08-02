package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.ToppingDecorator;

public class Pineapple extends ToppingDecorator{

	public Pineapple(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping() + ", pineapple";
	}
	@Override
	public double getPrice() {
		return Math.round((tempPizza.getPrice() + 0.79)*100)/100.0;
	}
	@Override
	public int getCalories() {
		return tempPizza.getCalories() + 24;
	}

}
