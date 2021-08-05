package it.epicode.be.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
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
		tav.setPosti(20);
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
		List<MenuItem> a = ord.getPizze();
		assertTrue(a.contains(piz));
	}

	@Test
	void testAddPizzaString() {
		ord.add(piz, "prova");
		List<MenuItem> a = ord.getPizze();
		assertTrue(a.contains(piz));
		assertEquals("\tNota: "+"prova", piz.getNota());
	}

	@Test
	void testAddDrink() {
		ord.add(dri);
		List<MenuItem> a = ord.getDrinks();
		assertTrue(a.contains(dri));
	}

	@Test
	void testAddDrinkString() {
		ord.add(dri, "prova");
		List<MenuItem> a = ord.getDrinks();
		assertTrue(a.contains(dri));
		assertEquals("\tNota: "+"prova", dri.getNota());
	}

	@Test
	void testAddFranchise() {
		ord.add(fra);
		List<MenuItem> a = ord.getFranchises();
		assertTrue(a.contains(fra));
	}

	@Test
	void testAddFranchiseString() {
		ord.add(fra, "prova");
		List<MenuItem> a = ord.getFranchises();
		assertTrue(a.contains(fra));
		assertEquals("\tNota: "+"prova", fra.getNota());
	}

	@Test
	void testStampa() {
		 // get Logback Logger 
        Logger testLogger = (Logger) LoggerFactory.getLogger(Ordine.class);

        // create and start a ListAppender
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();

        // add the appender to the logger
        // addAppender is outdated now
        testLogger.addAppender(listAppender);

        // call method under test


        // JUnit assertions
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("#######################################################################################################################################################", logsList.get(0)
                                      .getMessage());
        assertEquals(Level.INFO, logsList.get(0)
                                         .getLevel());
  
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
	void testSetCoperti() throws MassaZenteException {
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
