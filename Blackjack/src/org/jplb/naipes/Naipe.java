package org.jplb.naipes;

public class Naipe {
	
	private Palo palo;
	private Rango rango;
	private int valor;
	
	public Naipe(Palo palo, Rango rango){
		this.palo = palo;
		this.rango = rango;
		valor = rango.ordinal() + 1;
	}
	
	public Naipe(Palo palo, Rango rango, int valor) {
		this.palo = palo;
		this.rango = rango;
		this.valor = valor;
	}
	
	public String toString() {
		return rango.toString() + palo.getSymbol();
	}

	public Palo getPalo() {
		return palo;
	}

	public Rango getRango() {
		return rango;
	}

	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
