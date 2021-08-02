package it.epicode.be;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.be.model.BasePizza;
import it.epicode.be.model.MenuPizza;
import it.epicode.be.model.Pizza;
import it.epicode.be.model.topping.Cheese;
import it.epicode.be.model.topping.FamilySize;
import it.epicode.be.model.topping.Ham;
import it.epicode.be.model.topping.Pineapple;


public class GestioneMenu {
	public static void main(String[] args) {
//		Pizza margherita = new Cheese( new BasePizza());
//		Pizza hawaianPizza = new Pineapple(new Ham(new Cheese( new BasePizza())));
//		Pizza doublehawaianPizza = new Pineapple(hawaianPizza);
//		Pizza base = new BasePizza();
//		margherita.setPrice(10);
//		Pizza family = new FamilySize(margherita);
//		
//		System.out.println(margherita.stampa());
//		System.out.println(hawaianPizza.stampa());
//		System.out.println(doublehawaianPizza.stampa());
//		System.out.println(base.stampa());
//		System.out.println(family.stampa());
		SpringApplication.run(GestioneMenu.class, args);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(MenuPizza.class);
		
		//Automobile a = context.getBean(Automobile.class);
		Pizza a = (Pizza) context.getBean("margherita");
		Pizza b = (Pizza) context.getBean("hawaian");
		Pizza c = (Pizza) context.getBean("salami");
		Pizza d  = new FamilySize(c);
		Pizza e  = new Cheese(b);


		System.out.println(a.stampa());
		System.out.println(b.stampa());		
		System.out.println(c.stampa());		
		System.out.println(d.stampa());	
		System.out.println(e.stampa());		


	}
}
