package it.unina.IS.entity;

public abstract class Prodotti {

	@Override
	public String toString() {
		return "Prodotti [nome=" + nome + ", origineGeografica=" + origineGeografica + ", prezzo=" + prezzo
				+ ", quantita=" + quantita + "]";
	}
	private String nome;
	private String origineGeografica;
	private Integer prezzo;
	private Integer quantita;
	
	
	public Prodotti() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Prodotti(String nome, String origineGeografica, Integer prezzo, Integer quantita) {
		super();
		this.nome = nome;
		this.origineGeografica = origineGeografica;
		this.prezzo = prezzo;
		this.quantita = quantita;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOrigineGeografica() {
		return origineGeografica;
	}
	public void setOrigineGeografica(String origineGeografica) {
		this.origineGeografica = origineGeografica;
	}
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	
	
	
}
