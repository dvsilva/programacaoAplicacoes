package regra2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

public class Janela extends Frame {
	// Atributos da Classe
	private Button btOk;
	private Button btCancela;
	private Button btAjuda;

	// Construtor
	public Janela(String titulo) {
		// Chamada ao construtor de Frame
		super(titulo);
		// Instancio um objeto da classe Font, declaro a vari‡vel
		// local fontePadrao e fa?o com que esta vari‡vel aponte
		// para o novo objeto Font criado
		Font fontePadrao = new Font("TimesRoman", Font.BOLD, 14);
		// determino o padr‹o de fonte para a janela
		this.setFont(fontePadrao);
		// Determino a cor de fundo da janela
		this.setBackground(Color.WHITE);
		// Instancio um novo objeto Button e fa?o com que o atributo Ok
		// da janela aponte para este novo Button
		this.btOk = new Button("Ok");
		// Instancio um novo objeto Button e fa?o com que o atributo
		// Cancela da janela aponte para este novo Button
		this.btCancela = new Button("Cancela");
		// Instancio um novo objeto Button e fa?o com que o atributo
		// Ajuda da janela aponte para este novo Button
		this.btAjuda = new Button("Ajuda");
		// Adiciono o bot‹o Ok ˆ Janela na regi‹o OESTE
		this.add(this.btOk, BorderLayout.WEST);
		// Adiciono o bot‹o Cancela ˆ Janela na regi‹o CENTRO
		this.add(this.btCancela, BorderLayout.CENTER);
		// Adiciono o bot‹o Ajuda ˆ Janela na regi‹o LESTE
		this.add(this.btAjuda, BorderLayout.EAST);
		// Redimensiono o tamanho da Janela
		this.setSize(300, 100);
		// Torno a janela Vis’vel
		this.setVisible(true);
	}
}
