package org.jplb.naipes.blackjack;

import java.util.Iterator;

import org.jplb.naipes.Naipe;

public class Partida {

	private Mazo		mazo;
	private Mano		dealer;
	private Mano		jugador;
	private boolean		finalizada;
	
	
	public Partida(int numBarajas) {
		mazo = new Mazo(numBarajas);
		dealer = new Mano();
		jugador = new Mano();
		finalizada = false;
	}
	
	public boolean repartir() {
		finalizada = false;
		jugador.reset();
		dealer.reset();
		jugador.add(mazo.retirarNaipe());
		dealer.add(mazo.retirarNaipe());
		jugador.add(mazo.retirarNaipe());
		finalizada =  jugador.getValor() == 21;
		dealer.add(mazo.retirarNaipe());
		return finalizada;
	}
	
	public int pedir() {
		jugador.add(mazo.retirarNaipe());
		int v = jugador.getValor();
		finalizada = v >= 21;
		if (v == 21) jugarDealer();
		return v;
	}
	
	public void plantarse() {
		finalizada = true;
		jugarDealer();
	}
	
	private void jugarDealer() {
		while (dealer.getValor() < 17) dealer.add(mazo.retirarNaipe());
	}
	
	public String toString(){
		StringBuilder aux = new StringBuilder();
		if (finalizada) {
			int resultadoJ = jugador.getValor();
			int resultadoB = dealer.getValor();
			aux.append("FIN DE LA PARTIDA: ");
			if (resultadoJ > 21) {
				aux.append("TE HAS PASADO");
				aux.append(System.getProperty("line.separator"));
				aux.append(jugador);
			}
			else if (jugador.blackjack()) {
				aux.append("HAS GANADO");
				aux.append(System.getProperty("line.separator"));
				aux.append(jugador);
			}
			else {
				if (dealer.blackjack() || (resultadoB <= 21 && resultadoB > resultadoJ))
					aux.append("HAS PERDIDO");
				else if (resultadoB > 21 || resultadoB < resultadoJ)
					aux.append("HAS GANADO");
				else
					aux.append("EMPATE");
				aux.append(System.getProperty("line.separator"));
				aux.append("BANCA:   ");
				aux.append(dealer);
				if (dealer.blackjack()) aux.append(" BLACKJACK");
				aux.append(System.getProperty("line.separator"));
				aux.append("JUGADOR: ");
				aux.append(jugador);
				aux.append(System.getProperty("line.separator"));
			}
		}
		else {
			aux.append("BANCA:   ");
			aux.append(dealer.getNaipe(0));
			aux.append(System.getProperty("line.separator"));
			aux.append("JUGADOR: ");
			aux.append(jugador);
		}
		return aux.toString();
	}
	
	public Iterator<Naipe> getNaipesJugador() {
		return jugador.getNaipes();
	}
	
	public Iterator<Naipe> getNaipesDealer() {
		return dealer.getNaipes();
	}
	
	public boolean finalizada() {
		return finalizada;
	}
	
	public void reset(int numBarajas){
		jugador.reset();
		dealer.reset();
		mazo.reset(numBarajas);
		finalizada = false;
	}
	
}