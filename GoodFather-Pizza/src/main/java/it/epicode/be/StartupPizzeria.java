package it.epicode.be;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.config.ConfigMenu;
import it.epicode.be.model.BasePizza;
import it.epicode.be.model.Ordine;
import it.epicode.be.model.Drink;
import it.epicode.be.model.Franchise;
import it.epicode.be.model.Menu;
import it.epicode.be.model.MenuItem;
import it.epicode.be.model.Pizza;
import it.epicode.be.model.RegistroOrdini;
import it.epicode.be.model.Tavolo;
import it.epicode.be.model.Ordine.Stato;
import it.epicode.be.model.topping.Cheese;
import it.epicode.be.model.topping.FamilySize;
import it.epicode.be.model.topping.Ham;
import it.epicode.be.model.topping.Onions;
import it.epicode.be.model.topping.Pineapple;
import it.epicode.be.model.topping.Salami;

@SuppressWarnings("unused")
@Component
public class StartupPizzeria implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	@Autowired
	private Menu godfather;
	private Ordine f4;
	@Autowired
	private RegistroOrdini reg;

	@Override
	public void run(String... args) throws Exception {
		godfather.stampaMenu();
		System.out.println();

		f4 = (Ordine) context.getBean("solito");
		f4.setCoperti(3);
		f4.stampa();
		Ordine giorgio = (Ordine) context.getBean("solito");
		giorgio.setCoperti(4);
		giorgio.setData(LocalDate.of(2021, 8, 3));
		giorgio.setOra(LocalTime.of(13, 26));
		giorgio.add(new Onions((Pizza) context.getBean("hawaian")));
		giorgio.stampa();

		Ordine ezio = (Ordine) context.getBean("ordine");
		ezio.setTavolo((Tavolo) context.getBean("f1"));
		ezio.setCoperti(5);
		ezio.setStato(Stato.Pronto);
		for (int i = 0; i < 5; i++)
			ezio.add((Pizza) context.getBean("hawaian"));
		for (int i = 0; i < 5; i++)
			ezio.add((Drink) context.getBean("water"));
		ezio.setOra(LocalTime.of(20, 15));
		ezio.setData(LocalDate.of(2021, 8, 4));
		ezio.stampa();
		reg.add(f4);
		reg.add(giorgio);
		reg.add(ezio);
		
		
//		Pizza marghe = (Pizza) context.getBean("margherita");
//		
//		marghe.setName("Cacca");
//		
//		Pizza marghe1 = (Pizza) context.getBean("margherita");
//		
//		System.out.println(marghe.getName());
//		System.out.println(marghe1.getName());

	}

}
