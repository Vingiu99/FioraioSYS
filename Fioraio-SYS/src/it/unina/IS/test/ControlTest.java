package it.unina.IS.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unina.IS.control.Control;
import it.unina.IS.entity.Fiori;
import it.unina.IS.entity.Piante;
import it.unina.IS.entity.Tipologia;

public class ControlTest {

	
	private Control control= new Control();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void nomeNull() {
	
		Fiori f1 = new Fiori("Rosa", "Napoli", 3 , 5, "Rossa");
		control.addProdotto(f1);
		int res = control.decrementaDisponibilit‡Prodotto(null, 2);
		
		assertEquals(1, res);
	}

	@Test
	public void nomeNonValido() {
	
		Fiori f1 = new Fiori("Rosa", "Napoli", 3 , 5, "Rossa");
		control.addProdotto(f1);
		int res = control.decrementaDisponibilit‡Prodotto("Peppe", 2);
		
		assertEquals(2, res);
	}

	@Test
	public void quantitaNull() {
	
		Fiori f1 = new Fiori("Rosa", "Napoli", 3 , 5, "Rossa");
		control.addProdotto(f1);
		int res = control.decrementaDisponibilit‡Prodotto("Rosa", null);
		
		assertEquals(1, res);
	
	}

	@Test
	public void quantitaNegativa() {
	
		Fiori f1 = new Fiori("Rosa", "Napoli", 3 , 5, "Rossa");
		control.addProdotto(f1);
		int res = control.decrementaDisponibilit‡Prodotto("Rosa", -2);
		
		assertEquals(1, res);
	
	}

	@Test
	public void NoDBelement() {
	
		int res = control.decrementaDisponibilit‡Prodotto(null, 2);
		
		assertEquals(1, res);
	}
	
	@Test
	public void ParametriValidiUnProdottoQnt‡Disp() {
	
		Fiori f1 = new Fiori("Rosa", "Napoli", 3 , 5, "Rossa");
		control.addProdotto(f1);
		int res = control.decrementaDisponibilit‡Prodotto("Rosa", 2);
		
		assertEquals(0, res);
	}

	@Test
	public void ParametriValidiUnProdottoQnt‡NonDisp() {
	
		Fiori f1 = new Fiori("Rosa", "Napoli", 3 , 5, "Rossa");
		control.addProdotto(f1);
		int res = control.decrementaDisponibilit‡Prodotto("Rosa", 6);
		
		assertEquals(1, res);
	}

	@Test
	public void ParametriValidiPi˘ProdottiQnt‡NonDisp() {
	
		Piante p1 = new Piante("Cactus", "Egitto", 3, 5, Tipologia.INTERNO);
		Fiori f1 = new Fiori("Rosa", "Napoli", 3 , 5, "Rossa");
		control.addProdotto(f1);
		control.addProdotto(p1);
		int res = control.decrementaDisponibilit‡Prodotto("Cactus", 6);
		
		assertEquals(1, res);
	}

	@Test
	public void ParametriValidiPi˘ProdottiQnt‡Disp() {
	
		Piante p1 = new Piante("Cactus", "Egitto", 3, 5, Tipologia.INTERNO);
		Fiori f1 = new Fiori("Rosa", "Napoli", 3 , 5, "Rossa");
		control.addProdotto(f1);
		control.addProdotto(p1);
		int res = control.decrementaDisponibilit‡Prodotto("Cactus", 2);
		
		assertEquals(0, res);
	}

		
}
