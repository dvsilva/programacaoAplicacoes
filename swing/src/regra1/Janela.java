package regra1;

import java.awt.Frame;

public class Janela extends Frame {
	// Construtor da classe Janela
	public Janela(String titulo, int posX, int posY) {
		// Chamada ao construtor definido na classe Frame
		super(titulo);
		// determino que a janela nao poderá ser redimensionada
		this.setResizable(false);
		// determino o tamanho da janela
		this.setSize(100, 100);
		// determino a posicao da janela
		this.setLocation(posX, posY);
		// torno a janela visível
		this.setVisible(true);

	}
}
