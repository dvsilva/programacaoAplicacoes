package dao;

public enum TabelaPeriodica {

	// Declara��o das constantes
	H(1, 1.00794, "Hidrog�nio"), HE(2, 4.002602, "H�lio"), O(8, 15.9994, "Oxig�nio");

	// Defini��o das constantes
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

	// m�todo que define as constantes
	private TabelaPeriodica(int numero, double massa, String nome) {
		this.numero = numero;
		this.massa = massa;
		this.nome = nome;
	}

	public static void main(String args[]) {
		System.out.println("Dados do elemento qu�mico H:");
		System.out.println("\nN�mero: " + TabelaPeriodica.H.numero() + "\nMassa: " + TabelaPeriodica.H.massa()
				+ "\nElemento: " + TabelaPeriodica.H.nome());
	}

}
