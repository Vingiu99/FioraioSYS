package it.unina.IS.main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import it.unina.IS.control.Control;
import it.unina.IS.dao.FioriDAO;
import it.unina.IS.entity.Fiori;
import it.unina.IS.entity.Piante;
import it.unina.IS.entity.Tipologia;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Control control = new Control();
		
		
		Fiori f1 = new Fiori("Rosa", "Terra dei fuochi", 3 , 20, "Rossa");
		Piante p1 = new Piante("Cactus", "Egitto", 5, 14, Tipologia.INTERNO);
		Fiori f2 = new Fiori("Orchidea", "Zambia", 2, 5, "Bianca");
		Piante p2 = new Piante("Melo", "Giugliano", 10, 3, Tipologia.ESTERNO);
		control.addProdotto(f1);
		control.addProdotto(p1);
		control.addProdotto(f2);
		control.addProdotto(p2);
		control.decrementaDisponibilit‡Prodotto("Melo", 4);
		control.decrementaDisponibilit‡Prodotto("Rosa", 14);
		control.decrementaDisponibilit‡Prodotto("Cactus", 7);
		control.decrementaDisponibilit‡Prodotto("Orchidea", 5);
		control.decrementaDisponibilit‡Prodotto("Peppe", 0);
		
		FioriDAO dao = new FioriDAO();
		LinkedList<Fiori> fiori = new LinkedList<Fiori>();
		
		dao.createTable();
		dao.createFiore(f1);
		dao.createFiore(f2);
		fiori= dao.readAll();
		for (Iterator<Fiori> i = fiori.iterator(); i.hasNext();) {
			Fiori copy = (Fiori) i.next();
			System.out.println(copy.toString());
		}
		dao.deleteFiori(f1);
		fiori=(LinkedList<Fiori>) dao.readAll();
		for (Iterator<Fiori> i = fiori.iterator(); i.hasNext();) {
			Fiori copy = (Fiori) i.next();
			System.out.println(copy.toString());
		}
		
		dao.createFiore(f1);
		f1.setOrigineGeografica("Birmania");
		dao.updateFiori(f1);
		fiori=(LinkedList<Fiori>) dao.readAll();
		for (Iterator<Fiori> i = fiori.iterator(); i.hasNext();) {
			Fiori copy = (Fiori) i.next();
			System.out.println(copy.toString());
		}
		dao.dropTable();
		
	}

}
