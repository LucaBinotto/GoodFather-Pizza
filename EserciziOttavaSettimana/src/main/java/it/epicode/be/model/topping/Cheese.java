package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.ToppingDecorator;

public class Cheese extends ToppingDecorator{

	public Cheese(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping() + ", cheese";
	}
	@Override
	public double getPrice() {
		if (price == 0) {
			return Math.round((tempPizza.getPrice() + 0.69)*100)/100.0;
		} else {
			return price;
		}
	
	}
	@Override
	public int getCalories() {
		return tempPizza.getCalories() + 92;
	}

	
	

}
