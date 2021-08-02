package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.ToppingDecorator;

public class Salami extends ToppingDecorator{

	public Salami(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping() + ", salami";
	}
	@Override
	public double getPrice() {
		return tempPizza.getPrice() + 0.99;
	}
	@Override
	public int getCalories() {
		return tempPizza.getCalories() + 86;
	}

}
