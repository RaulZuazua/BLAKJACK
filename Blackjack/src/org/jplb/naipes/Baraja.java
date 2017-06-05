package org.jplb.naipes;
import java.util.ArrayList;
import java.util.Random;


public class Baraja {
	
	protected ArrayList<Naipe> naipes;
	
	public Baraja() {
		naipes = new ArrayList<Naipe>();
	}
	
	public Baraja(boolean mezclar) {
		this();
		for (Palo p: Palo.values())
			for (Rango r: Rango.values())
				naipes.add(new Naipe(p, r));
		if (mezclar)
			mezclar();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Naipe naipe: naipes){
			s.append(naipe);
			s.append("\n");
		}
		return s.toString();
	}
	
	public void add(Naipe naipe){
		naipes.add(naipe);
	}
	
	public void mezclar() {
		Random r = new Random(System.currentTimeMillis());
		for (int i=0, i1, i2; i<1000; i++){
			i1 = r.nextInt(naipes.size());
			i2 = r.nextInt(naipes.size());
			if (i1 != i2){
				Naipe aux = naipes.get(i1);
				naipes.set(i1, naipes.get(i2));
				naipes.set(i2, aux);
			}
		}
	}
	
	public Naipe retirarNaipe() {
		return naipes.remove(naipes.size() - 1);
	}
	
	public Naipe retirarNaipe(int posicion) {
		return naipes.remove(posicion);
	}
	
	public Naipe getNaipe(int posicion) {
		return naipes.get(posicion);
	}
	
	public int getNumNaipes() {
		return naipes.size();
	}
	
	public void reset(boolean mezclar) {
		naipes.clear();
		for (Palo p: Palo.values())
			for (Rango r: Rango.values())
				naipes.add(new Naipe(p, r));
		if (mezclar)
			mezclar();
	}
}
