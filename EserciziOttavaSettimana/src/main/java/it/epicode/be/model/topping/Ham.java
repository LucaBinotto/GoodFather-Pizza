package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.ToppingDecorator;

public class Ham extends ToppingDecorator{

	public Ham(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping() + ", ham";
	}
	@Override
	public double getPrice() {
		return Math.round((tempPizza.getPrice() + 0.99)*100)/100.0;
	}
	@Override
	public int getCalories() {
		return tempPizza.getCalories() + 35;
	}


}
