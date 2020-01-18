package it.unina.IS.entity;

public class Piante extends Prodotti{

	private Tipologia tipo;

	public Piante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Piante(String nome, String origineGeografica, Integer prezzo, Integer quantita, Tipologia tipo) {
		super(nome, origineGeografica, prezzo, quantita);
		this.tipo=tipo;
	}

	public Tipologia getTipo() {
		return tipo;
	}

	public void setTipo(Tipologia tipo) {
		this.tipo = tipo;
	}
	
	
}
