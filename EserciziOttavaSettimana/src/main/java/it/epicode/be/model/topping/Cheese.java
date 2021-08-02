package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.Topping;

public class Cheese extends Topping {

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
			return Math.round((tempPizza.getPrice() + 0.69) * 100) / 100.0;
		} else {
			return price;
		}

	}

	@Override
	public int getCalories() {
		if (calorie == 0) {
			return tempPizza.getCalories() + 92;
		} else {
			return calorie;
		}
	}

}
