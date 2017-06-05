package org.jplb.naipes;

public enum Palo {
	
	CORAZONES, PICAS, DIAMANTES, TRÉBOLES;
	
	private char [] symbol = {'♥', '♠', '♦', '♣'};
	
	public char getSymbol(){
		return symbol[ordinal()];
	}
	
}
