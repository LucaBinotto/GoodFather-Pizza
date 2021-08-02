package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.Topping;

public class Pineapple extends Topping{

	public Pineapple(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping() + ", pineapple";
	}
	@Override
	public double getPrice() {
		if (price == 0) {
			return Math.round((tempPizza.getPrice() + 0.79)*100)/100.0;
		} else {
			return price;
		}
	}
	@Override
	public int getCalories() {
		return tempPizza.getCalories() + 24;
	}
	
}
