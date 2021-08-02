package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.Topping;

public class Onions extends Topping{

	public Onions(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping() + ", onions";
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
		return tempPizza.getCalories() + 22;
	}

}
