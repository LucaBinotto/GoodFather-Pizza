package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.ToppingDecorator;

public class FamilySize extends ToppingDecorator{

	public FamilySize(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getTopping() {
		return tempPizza.getTopping() + "";
	}
	@Override
	public double getPrice() {
		if (price == 0) {
			return Math.round((tempPizza.getPrice() + 4.15)*100)/100.0;
		} else {
			return price;
		}
	}
	@Override
	public int getCalories() {
		return (int)Math.round((tempPizza.getCalories() * 1.95));
	}

}