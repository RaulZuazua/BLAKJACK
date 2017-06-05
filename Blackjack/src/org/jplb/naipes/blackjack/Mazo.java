package org.jplb.naipes.blackjack;

import java.util.NoSuchElementException;

import org.jplb.naipes.Baraja;
import org.jplb.naipes.Naipe;
import org.jplb.naipes.Palo;
import org.jplb.naipes.Rango;


public class Mazo extends Baraja {
	
	int numBarajas;
	
	public Mazo(int numBarajas){
		this.numBarajas = numBarajas;
		crearMazo();
	}
	
	private void crearMazo(){
		for (int i=0; i<numBarajas; i++)
			for (Palo p: Palo.values()) 
				for (Rango r: Rango.values())
					add(new Naipe(p, r, (r == Rango.JOTA || r == Rango.REINA || r == Rango.REY) ? 10 : (r == Rango.AS ? 11 : r.ordinal()+1)));
		mezclar();
	}
	
	public void reset(int numBarajas) {
		naipes.clear();
		this.numBarajas = numBarajas;
		crearMazo();
	}
	
	@Override
	public Naipe retirarNaipe() {
		try {
			return super.retirarNaipe();
		}
		catch (NoSuchElementException e) {
			crearMazo();
			return super.retirarNaipe();
		}
	}
	
}
