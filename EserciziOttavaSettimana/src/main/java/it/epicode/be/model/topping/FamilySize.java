package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.Topping;

public class FamilySize extends Topping {

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
			return Math.round((tempPizza.getPrice() + 4.15) * 100) / 100.0;
		} else {
			return price;
		}
	}

	@Override
	public int getCalories() {
		if (tempPizza.getCalories() != 0) {
			return (int) Math.round((tempPizza.getCalories() * 1.95));
		} else {
			return -1;
		}
	}

}