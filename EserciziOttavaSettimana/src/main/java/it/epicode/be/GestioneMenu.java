package it.epicode.be;

import it.epicode.be.model.BasePizza;
import it.epicode.be.model.Pizza;
import it.epicode.be.model.topping.Cheese;
import it.epicode.be.model.topping.Ham;
import it.epicode.be.model.topping.Pineapple;

public class GestioneMenu {
	public static void main(String[] args) {
		Pizza margherita = new Cheese( new BasePizza());
		Pizza hawaianPizza = new Pineapple(new Ham(margherita));
		
		System.out.println(margherita.getTopping());
		System.out.println(margherita.getPrice());
		System.out.println(margherita.getCalories());
		System.out.println();
		System.out.println(hawaianPizza.getTopping());
		System.out.println(hawaianPizza.getPrice());
		System.out.println(hawaianPizza.getCalories());


	}
}
