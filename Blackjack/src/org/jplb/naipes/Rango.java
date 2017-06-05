package org.jplb.naipes;

public enum Rango {
	AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, DIEZ, JOTA, REINA, REY;
	
	@Override
	public String toString(){
		switch (this){
			case AS: return "A";
			case JOTA: return "J";
			case REINA: return "Q";
			case REY: return "K";
			default: return Integer.toString(ordinal() + 1);
		}
	}
	
	public boolean esFigura() {
		return (this == JOTA || this == REINA || this == REY);
	}
}