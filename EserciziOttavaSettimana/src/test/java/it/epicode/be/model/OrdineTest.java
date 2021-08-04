package it.epicode.be.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.epicode.be.model.Ordine.Stato;
import it.epicode.be.model.topping.Cheese;

class OrdineTest {
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	Ordine ord;
	Tavolo tav;
	Pizza piz;
	Drink dri;
	Franchise fra;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	    System.setOut(new PrintStream(outputStreamCaptor));
		tav = new Tavolo();
		ord = new Ordine(tav);
		piz = new Cheese(new BasePizza());
		dri = new Drink();
		fra = new Franchise();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testOrdine() {
		assertEquals(Ordine.class, (ord.getClass()));
	}

	@Test
	void testGetCodiceTavolo() {
		tav.setCodiceTavolo("ABC");
		assertEquals("ABC", tav.getCodiceTavolo());
	}

	@Test
	void testAddPizza() {
		ord.add(piz);
		Map<MenuItem, String> a = ord.getPizze();
		assertTrue(a.containsKey(piz));
	}

	@Test
	void testAddPizzaString() {
		ord.add(piz, "prova");
		Map<MenuItem, String> a = ord.getPizze();
		assertTrue(a.containsKey(piz));
		assertEquals("prova", a.get(piz));
	}

	@Test
	void testAddDrink() {
		ord.add(dri);
		Map<MenuItem, String> a = ord.getDrinks();
		assertTrue(a.containsKey(dri));
	}

	@Test
	void testAddDrinkString() {
		ord.add(dri, "prova");
		Map<MenuItem, String> a = ord.getDrinks();
		assertTrue(a.containsKey(dri));
		assertEquals("prova", a.get(dri));
	}

	@Test
	void testAddFranchise() {
		ord.add(fra);
		Map<MenuItem, String> a = ord.getFranchises();
		assertTrue(a.containsKey(fra));
	}

	@Test
	void testAddFranchiseString() {
		ord.add(fra, "prova");
		Map<MenuItem, String> a = ord.getFranchises();
		assertTrue(a.containsKey(fra));
		assertEquals("prova", a.get(fra));
	}

	@Test
	void testStampa() {
		ord.stampa();
		Assertions.assertNotEquals("",outputStreamCaptor.toString().trim());
	}

	@Test
	void testGetStato() {
		assertEquals(Stato.Aperto, ord.getStato());
	}

	@Test
	void testSetStato() {
		ord.setStato(Stato.Servito);
		assertEquals(Stato.Servito, ord.getStato());

	}

	@Test
	void testGetCoperti() {
		assertEquals(1, ord.getCoperti());
	}

	@Test
	void testSetCoperti() {
		ord.setCoperti(17);
		assertEquals(17, ord.getCoperti());
	}

	@Test
	void testGetOra() {
		assertEquals(LocalTime.now().truncatedTo(ChronoUnit.MINUTES), ord.getOra());
	}

	@Test
	void testSetOra() {
		ord.setOra(LocalTime.of(15, 47));
		assertEquals(LocalTime.of(15, 47), ord.getOra());

	}

}
