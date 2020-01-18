package it.unina.IS.entity;

public class Fiori extends Prodotti{

	private String colore;

	public Fiori() {
		super();
	}

	@Override
	public String toString() {
		return super.toString()+"Fiori [colore=" + colore + "]";
	}

	public Fiori(String nome, String origineGeografica, Integer prezzo, Integer quantita, String colore) {
		super(nome, origineGeografica, prezzo, quantita);
		this.colore=colore;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}
	
	
	
}
