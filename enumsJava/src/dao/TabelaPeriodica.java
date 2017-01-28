package dao;

public enum TabelaPeriodica {

	// Declaração das constantes
	H(1, 1.00794, "Hidrogênio"), HE(2, 4.002602, "Hélio"), O(8, 15.9994, "Oxigênio");

	// Definição das constantes
	private final int numero;
	private final double massa;
	private final String nome;

	private int numero() {
		return this.numero;
	}

	private double massa() {
		return this.massa;
	}

	private String nome() {
		return this.nome;
	}

	// método que define as constantes
	private TabelaPeriodica(int numero, double massa, String nome) {
		this.numero = numero;
		this.massa = massa;
		this.nome = nome;
	}

	public static void main(String args[]) {
		System.out.println("Dados do elemento químico H:");
		System.out.println("\nNúmero: " + TabelaPeriodica.H.numero() + "\nMassa: " + TabelaPeriodica.H.massa()
				+ "\nElemento: " + TabelaPeriodica.H.nome());
	}

}
