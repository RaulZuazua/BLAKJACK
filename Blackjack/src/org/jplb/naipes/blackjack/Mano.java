package org.jplb.naipes.blackjack;

import java.util.Iterator;

import org.jplb.naipes.Baraja;
import org.jplb.naipes.Naipe;
import org.jplb.naipes.Rango;


public class Mano extends Baraja{
	
	public static enum Estado {
		ENJUEGO, CERRADA;
	}
	
	Estado estado = Estado.ENJUEGO;
	private int valor = 0;
	
	public String toString() {
		Naipe naipe; 
		StringBuilder s = new StringBuilder();
		Iterator<Naipe> iterator = naipes.iterator();
		while (iterator.hasNext()) {
			naipe = iterator.next();
			s.append(naipe);
			s.append("(");
			s.append(naipe.getValor());
			s.append(")");
			s.append(iterator.hasNext() ? " - " : " = ");
		}
		s.append(blackjack() ? "BLACKJACK" : valor);
		return s.toString();
	}
		
	public void add(Naipe naipe){
		super.add(naipe);
		valor += naipe.getValor();
		if (valor > 21) {
			// corrige el valor contabilizando los ases que sea necesario con valor uno para evitar pasarse
			Iterator<Naipe> iterator = naipes.iterator();
			while (iterator.hasNext() && valor > 21){
				naipe = iterator.next();
				if (naipe.getRango() == Rango.AS && naipe.getValor() == 11) {
					naipe.setValor(1);
					valor -= 10;
				}
			}
		}
	}
	
	public int getValor() {
		return valor;
	}
	
	public Naipe getNaipe(int posicion) {
		try {
			return naipes.get(posicion);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public Iterator<Naipe> getNaipes() {
		return naipes.iterator();
	}
	
	public int getNumNaipes() {
		return naipes.size();
	}
	
	public boolean blackjack() {
		return (naipes.size() == 2 && valor == 21);
	}
	
	public void reset(){
		valor = 0;
		naipes.clear();;
	}
	
}
