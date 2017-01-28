package control;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Programa {

	public static void main(String[] args) {

		try {
			String num = null;
			while (num == null || num.equals("")) {
				num = JOptionPane.showInputDialog("Digite um n�mero:", "Digite um n�mero aqui.");
				
				if (num == null || num.equals("") || num.equals("Digite um n�mero aqui.")) {
					JOptionPane.showMessageDialog(null, "Voc� n�o respondeu a pergunta.");
					return;
				}
			}
			
			double valor = Double.parseDouble(num);
			DecimalFormat df = new DecimalFormat("#,###.00");
			df.format(valor);

			JOptionPane.showMessageDialog(null, "A Raiz de " + valor + " �: " + Exemplo.raizQuadrada(valor));
		} 
		catch (RaizQuadradaException e) {
			JOptionPane.showMessageDialog(null, "Problema: " + e.getMessage());
		}

	}
}
