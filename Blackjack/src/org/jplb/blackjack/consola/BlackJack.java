package org.jplb.blackjack.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jplb.naipes.blackjack.Partida;


public class BlackJack {
	private static final BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String op;
		Partida partida = new Partida(6);
		
		System.out.println("Repartir (r) - Abandonar(a)");
		op = teclado.readLine();
		while (op.toLowerCase().equals("r")) {
			partida.repartir();
			while (!partida.finalizada()){
				System.out.println(partida);
				System.out.println("Hit (h) - Stand (s)");
				op = teclado.readLine();
				if (op.toLowerCase().equals("h"))
					partida.pedir();
				else if (op.toLowerCase().equals("s"))
					partida.plantarse();
			}
			System.out.println(partida);
			System.out.println("\nRepartir (r) - Abandonar(a)");
			op = teclado.readLine();
		}
	}
	
}