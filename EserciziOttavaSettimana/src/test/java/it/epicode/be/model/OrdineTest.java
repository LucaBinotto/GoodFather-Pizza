package it.epicode.be.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

class OrdineTest {
	@Autowired
	ApplicationContext con;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testOrdine() {
		assertEquals(Ordine.class, new Ordine((Tavolo)con.getBean("t1")));
	}

	@Test
	void testGetCodiceTavolo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddPizza() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddPizzaString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddDrink() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddDrinkString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddFranchise() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddFranchiseString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testStampa() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetStato() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetStato() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetCoperti() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetCoperti() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetOra() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetOra() {
		fail("Not yet implemented"); // TODO
	}

}
