package it.epicode.be;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.be.model.BasePizza;
import it.epicode.be.model.Drink;
import it.epicode.be.model.Menu;
import it.epicode.be.model.ConfigMenu;
import it.epicode.be.model.Pizza;
import it.epicode.be.model.Topping;
import it.epicode.be.model.topping.Cheese;
import it.epicode.be.model.topping.FamilySize;
import it.epicode.be.model.topping.Ham;
import it.epicode.be.model.topping.Pineapple;


@SuppressWarnings("unused")
public class GestioneMenu {
	public static void main(String[] args) {
		SpringApplication.run(GestioneMenu.class, args);
		
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigMenu.class);
		
//		Pizza a = (Pizza) context.getBean("margherita");
//		Pizza b = (Pizza) context.getBean("hawaian");
//		Pizza c = (Pizza) context.getBean("salamiPizza");
//		Topping ee = (Topping) context.getBean("cheese");
//		Topping ea = (Topping) context.getBean("maxi");
//		Topping eb = (Topping) context.getBean("ham");
//		Topping ec = (Topping) context.getBean("onions");
//		Topping ed = (Topping) context.getBean("pineapple");
//		Topping ef = (Topping) context.getBean("salami");
//
//		Pizza d  = new FamilySize(c);
//		Pizza e  = new Cheese(b);
//		Pizza f = new BasePizza();
//
//		Drink g = (Drink) context.getBean("lemonade");
//		Drink h = (Drink) context.getBean("water");
//		Drink i = (Drink) context.getBean("wine");
//
//		
//		System.out.println(a.stampa());
//		System.out.println(b.stampa());		
//		System.out.println(c.stampa());		
//		System.out.println(d.stampa());	
//		System.out.println(e.stampa());		
//		System.out.println(f.stampa());		
//		System.out.println(g.stampa());	
//		System.out.println(h.stampa());	
//		System.out.println(i.stampa());	
//		System.out.println(ee.stampa());	
//		System.out.println(ea.stampa());
//		System.out.println(eb.stampa());
//		System.out.println(ec.stampa());
//		System.out.println(ed.stampa());
//		System.out.println(ef.stampa());

		Menu godfather = (Menu)context.getBean("godfather");
		godfather.stampaMenu();
		
	}
}
