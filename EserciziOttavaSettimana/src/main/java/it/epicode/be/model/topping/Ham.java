package it.epicode.be.model.topping;

import it.epicode.be.model.Pizza;
import it.epicode.be.model.Topping;

public class Ham extends Topping {

	public Ham(Pizza pizza) {
		super(pizza);
	}
	
	@Override
	public String getTopping() {
		return tempPizza.getTopping() + ", ham";
	}

	@Override
	public double getPrice() {
		if (price == 0) {
			return Math.round((tempPizza.getPrice() + 0.99) * 100) / 100.0;
		} else {
			return price;
		}
	}
	@Override
	public int getCalories() {
		if (calories == 0) {
			return tempPizza.getCalories() + 35;
		} else {
			return calories;
		}
	}

}
