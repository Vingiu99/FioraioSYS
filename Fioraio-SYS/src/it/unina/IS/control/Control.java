package it.unina.IS.control;

import java.util.Iterator;
import java.util.LinkedList;

import it.unina.IS.entity.Prodotti;

public class Control {

	private LinkedList <Prodotti> prodotti= new LinkedList<Prodotti>(); 
	
	
	
	
	
	public LinkedList<Prodotti> getProdotti() {
		return prodotti;
	}





	public void setProdotti(LinkedList<Prodotti> prodotti) {
		this.prodotti = prodotti;
	}


	public void addProdotto(Prodotti p) {
		
		this.prodotti.add(p);
		
	}

	public void deleteProdotto(Prodotti p) {
		this.prodotti.remove(p);
	}

	public int decrementaDisponibilit‡Prodotto(String nome , Integer quantita) {
		int help = 0;
		if(this.prodotti.size()==0) {
			
			System.out.println("Errore nessun prodotto Ë presente nel database");
			return 1;
			
			
		}else if(nome==null || quantita==null || quantita<0 ) {
			
			System.out.println("Errore dati inseriti non corretti, ripetere l'inserimento");
			return 1;
			
		}else {
		
		for (Iterator<Prodotti> i = prodotti.iterator(); i.hasNext();) {
			Prodotti copy = (Prodotti) i.next();
			
			
			if(copy.getNome().equals(nome)) {
				
				int residuo = copy.getQuantita() - quantita;
				
				if(residuo==0) {
					System.out.println("Le scorte sono esaurite \n");
				
					
				}else if(residuo<0) {
					
					System.out.println("Le scorte non sono sufficienti per completare l'ordine \n");
					
					return 1;
					
				}else if(residuo<10 && residuo >0) {
					
					System.out.println("Le scorte sono prossime ad essere esaurite \n");
					
				}
				
				
				copy.setQuantita(residuo);
					help++;
					System.out.println("Le scorte residue per il prodotto '" + copy.getNome()+"' risultano essere : "+ copy.getQuantita()+"\n");
				
				return 0;
				
			}
			
			
		}
		
			if(help==0) {
				System.out.println("Il prodotto ricercato non Ë presente nel negozio");
				return 2;
			}
			
			
		}
		return 0;
				
		
		
		
	}

}
